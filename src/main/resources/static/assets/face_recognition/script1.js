const imageUpload = document.getElementById('imageUpload')

Promise.all([
  faceapi.nets.faceRecognitionNet.loadFromUri('http://localhost:8080/assets/face_recognition/models'),
  faceapi.nets.faceLandmark68Net.loadFromUri('http://localhost:8080/assets/face_recognition/models'),
  faceapi.nets.ssdMobilenetv1.loadFromUri('http://localhost:8080/assets/face_recognition/models')
]).then(start)

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
  container.style.position = 'relative'
  labeledFaceDescriptors = await loadLabeledFaceDescriptorsFromFile1('/assets/face_recognition/data.json');

  console.log({labeledFaceDescriptors})

  const faceMatcher = new faceapi.FaceMatcher(labeledFaceDescriptors, 0.6)
  let image
  let canvas
  document.body.append('Loaded')

  imageUpload.addEventListener('change', async () => {
    if (image) image.remove()
    if (canvas) canvas.remove()
    image = await faceapi.bufferToImage(imageUpload.files[0])
    image.width = 480
    image.height = 360
    container.append(image)
    canvas = faceapi.createCanvasFromMedia(image)
    container.append(canvas)
    const displaySize = { width: image.width, height: image.height }
    faceapi.matchDimensions(canvas, displaySize)
    console.log('oke')


    const detections = await faceapi.detectAllFaces(image).withFaceLandmarks().withFaceDescriptors()
    const resizedDetections = faceapi.resizeResults(detections, displaySize)
    const results = resizedDetections.map(d => faceMatcher.findBestMatch(d.descriptor))
    console.log(results)

    results.forEach((result, i) => {
      const box = resizedDetections[i].detection.box
      const drawBox = new faceapi.draw.DrawBox(box, { label: result.toString() })
      drawBox.draw(canvas)
    })
  })
}

/*
function loadLabeledImages() {
  const labels = ['Black Widow', 'Captain America', 'Captain Marvel', 'Hawkeye', 'Jim Rhodes', 'Thor', 'Tony Stark']
  return Promise.all(
    labels.map(async label => {
      const descriptions = []
      for (let i = 1; i <= 2; i++) {
        const img = await faceapi.fetchImage(`https://raw.githubusercontent.com/WebDevSimplified/Face-Recognition-JavaScript/master/labeled_images/${label}/${i}.jpg`)
        const detections = await faceapi.detectSingleFace(img).withFaceLandmarks().withFaceDescriptor()
        descriptions.push(detections.descriptor)
      }

      return new faceapi.LabeledFaceDescriptors(label, descriptions)
    })
  )
}
 */

async function loadLabeledFaceDescriptorsFromFile(file) {
  try {
    console.time('loadLabeledFaceDescriptorsFromFile'); // Bắt đầu đo thời gian

    // Đọc file JSON từ máy khách
    const response = await fetch(file);
    const data = await response.json();

    const labeledFaceDescriptors = data.map(ld => new faceapi.LabeledFaceDescriptors(
      ld.label,
      ld.descriptors.map(descriptor => new Float32Array(descriptor))
    ));

    console.timeEnd('loadLabeledFaceDescriptorsFromFile'); // Kết thúc đo thời gian
    return labeledFaceDescriptors;
  } catch (error) {
    console.error('Failed to load labeled face descriptors:', error);
    return null; // Hoặc xử lý lỗi theo cách thích hợp trong ứng dụng của bạn
  }
}


async function loadLabeledFaceDescriptorsFromFile1(file) {
  try {
    console.time('loadLabeledFaceDescriptorsFromFile'); // Bắt đầu đo thời gian
    console.log("dddd")

    // Đọc file JSON từ máy khách
    const response = await fetch(file);
    const data = await response.json();

    // Giả sử dữ liệu là một mảng các đối tượng có thuộc tính userId và descriptor
    const labeledFaceDescriptors = data.map(ld => new faceapi.LabeledFaceDescriptors(
        "MSSV: " + ld.userId.toString(), // Chuyển đổi userId thành chuỗi để làm label
        [new Float32Array(ld.descriptor)] // Đảm bảo descriptor là một mảng Float32Array
    ));

    console.timeEnd('loadLabeledFaceDescriptorsFromFile'); // Kết thúc đo thời gian
    return labeledFaceDescriptors;
  } catch (error) {
    console.error('Failed to load labeled face descriptors:', error);
    return null; // Hoặc xử lý lỗi theo cách thích hợp trong ứng dụng của bạn
  }
}
