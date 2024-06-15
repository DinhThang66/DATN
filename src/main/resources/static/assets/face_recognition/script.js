const imageUpload = document.getElementById('imageUpload');

Promise.all([
    faceapi.nets.faceRecognitionNet.loadFromUri('http://localhost:8080/assets/face_recognition/models'),
    faceapi.nets.faceLandmark68Net.loadFromUri('http://localhost:8080/assets/face_recognition/models'),
    faceapi.nets.ssdMobilenetv1.loadFromUri('http://localhost:8080/assets/face_recognition/models')
]).then(()=>{
    start();
    saveLabeledImagesToFile();  // Lưu các mô tả khuôn mặt vào file

});

if ('serviceWorker' in navigator) {
    window.addEventListener('load', () => {
        navigator.serviceWorker.register('/assets/face_recognition/sw1.js').then(registration => {
            console.log('ServiceWorker registration successful with scope: ', registration.scope);
        }, err => {
            console.log('ServiceWorker registration failed: ', err);
        });
    });
}


async function start() {
    const container = document.getElementById('rightHalf');
    //const container = document.createElement('div');
    container.style.position = 'relative';
    //  document.body.append(container);
    const labeledFaceDescriptors = await loadLabeledImages();

    const faceMatcher = new faceapi.FaceMatcher(labeledFaceDescriptors, 0.45);
    let image;
    let canvas;
    document.body.append('Loaded');

    imageUpload.addEventListener('change', async () => {
        if (image) image.remove();
        if (canvas) canvas.remove();
        image = await faceapi.bufferToImage(imageUpload.files[0]);
        image.width = 480
        image.height = 360
        container.append(image);
        canvas = faceapi.createCanvasFromMedia(image);
        container.append(canvas);
        const displaySize = {width: image.width, height: image.height};
        faceapi.matchDimensions(canvas, displaySize);
        const detections = await faceapi.detectAllFaces(image).withFaceLandmarks().withFaceDescriptors();
        const resizedDetections = faceapi.resizeResults(detections, displaySize);
        const results = resizedDetections.map(d => faceMatcher.findBestMatch(d.descriptor));
        results.forEach((result, i) => {
            const box = resizedDetections[i].detection.box;
            const drawBox = new faceapi.draw.DrawBox(box, {label: result.toString()});
            drawBox.draw(canvas);
        });
    });
}

async function loadLabeledImages() {
    const labels = ['Black Widow', 'Captain America', 'Captain Marvel', 'Hawkeye', 'Jim Rhodes', 'Thor', 'Tony Stark', 'Dinh_Thang'];
    const descriptionsDiv = document.getElementById('descriptions');

    return Promise.all(
        labels.map(async label => {
            const descriptions = [];
            for (let i = 1; i <= 2; i++) {
                const img = await faceapi.fetchImage(`/assets/face_recognition/labeled_images/${label}/${i}.jpg`);
                const detections = await faceapi.detectSingleFace(img).withFaceLandmarks().withFaceDescriptor();
                descriptions.push(detections.descriptor);

                // Tạo một phần tử paragraph và thêm descriptor vào đó
                //const p = document.createElement('p');
                //p.textContent = `Descriptor for ${label} image ${i}: ${detections.descriptor}`;
                //descriptionsDiv.appendChild(p);
            }


            return new faceapi.LabeledFaceDescriptors(label, descriptions);
        })
    );
}

async function saveLabeledImagesToFile() {
    const labeledFaceDescriptors = await loadLabeledImages();

    // Chuyển đổi các LabeledFaceDescriptors thành một đối tượng thuần túy
    const data = labeledFaceDescriptors.map(descriptor => ({
        label: descriptor.label,
        descriptors: descriptor.descriptors.map(desc => Array.from(desc))
    }));

    // Chuyển đổi đối tượng thành chuỗi JSON
    const json = JSON.stringify(data);

    // Gửi yêu cầu POST đến backend với dữ liệu JSON
    try {
        const response = await fetch('/saveLabeledImages', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: json
        });

        if (response.ok) {
            console.log('File JSON đã được lưu trữ thành công.');
        } else {
            console.error('Có lỗi xảy ra khi lưu trữ file JSON.');
        }
    } catch (error) {
        console.error('Có lỗi xảy ra khi gửi yêu cầu:', error);
    }

    // Tạo và tải file JSON xuống
    //const blob = new Blob([json], { type: 'application/json' });
    //const url = URL.createObjectURL(blob);
    //const a = document.createElement('a');
    //a.href = url;
    //a.download = 'labeledFaceDescriptors.json';
    //document.body.appendChild(a);
    //a.click();
    //document.body.removeChild(a);
}
