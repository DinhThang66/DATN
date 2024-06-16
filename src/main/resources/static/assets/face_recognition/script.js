const imageUpload = document.getElementById('imagePath');

Promise.all([
    faceapi.nets.faceRecognitionNet.loadFromUri('/assets/face_recognition/models'),
    faceapi.nets.faceLandmark68Net.loadFromUri('/assets/face_recognition/models'),
    faceapi.nets.ssdMobilenetv1.loadFromUri('/assets/face_recognition/models')
]).then(()=>{
    start();

});



async function start() {
    loadLabeledImages()
}
function loadLabeledImages() {
    const idInput = document.getElementById('idInput');
    const idValue = idInput.value;
    console.log(idValue)

    imageUpload.addEventListener('change', async (e)=>{
        const file = imageUpload.files[0];
        const image = await faceapi.bufferToImage(file)
        const detections = await faceapi.detectSingleFace(image).withFaceLandmarks().withFaceDescriptor()
        console.log(detections.descriptor)


        if (detections) {

            const descriptor = detections.descriptor;
            const response = await fetch('/upload', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    descriptor: Array.from(descriptor),
                    userId: idValue
                })
            });

            if (response.ok) {
                console.log('Descriptor saved successfully');
            } else {
                console.error('Failed to save descriptor');
            }
        }
    })

}

