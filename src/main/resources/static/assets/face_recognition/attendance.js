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

  let labeledFaceDescriptors;
  try {
    const response = await fetch('/getDescriptor', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
    });
    const data = await response.json();
    labeledFaceDescriptors = data.map(ld => new faceapi.LabeledFaceDescriptors(
        ld.userId.toString(), // Chuyển đổi userId thành chuỗi để làm label
        [new Float32Array(ld.descriptor)] // Đảm bảo descriptor là một mảng Float32Array
    ));
    console.log({labeledFaceDescriptors})
  } catch (error) {
    console.error(`Lỗi khi lấy thông tin người dùng cho MSSV `, error);
  }
  const examClass_id = document.getElementById('examClass_id').textContent
  console.log(examClass_id)


  const faceMatcher = new faceapi.FaceMatcher(labeledFaceDescriptors, 0.6)
  let image = new Image()
  let canvas
  document.body.append('Loaded')

  const captureButton = document.getElementById('captureButton');
  captureButton.addEventListener('click', async () => {
    const img_capture = document.getElementById('img_capture')
    if (img_capture)
      img_capture.remove()
    else
      console.log("ko ton tai")
  // Kiểm tra xem có tệp nào đã được thêm chưa
    if (imageUpload.files.length > 0) {
      // Xóa tệp đã chọn
      imageUpload.value = '';
      console.log('File đã bị xóa');
    } else {
      console.log('Không có file nào được chọn');
    }


    if (image) image.remove()
    if (canvas) canvas.remove()
    image = img_capture;

    image.width = 720
    image.height = 480
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


    for (const result of results) {
      const i = results.indexOf(result);
      const box = resizedDetections[i].detection.box

      // Gửi yêu cầu AJAX riêng biệt cho từng result
      const userId = result.label;
      try {
        const response = await fetch('/getUserInfo_attendance=' + examClass_id, {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify({ userId })
        });
        const data = await response.json();
        console.log(`Thông tin người dùng cho MSSV ${userId}:`, data);
        const drawBox = new faceapi.draw.DrawBox(box, { label: data.name +  ", MSSV: " + result.toString()})
        drawBox.draw(canvas)
      } catch (error) {
        console.error(`Lỗi khi lấy thông tin người dùng cho MSSV ${userId}:`, error);
      }


    }
  })


  imageUpload.addEventListener('change', async () => {
    const img_capture = document.getElementById('img_capture')
    if (img_capture)
      img_capture.remove()
    else
      console.log("ko ton tai")

    if (image) image.remove()
    if (canvas) canvas.remove()
    image = await faceapi.bufferToImage(imageUpload.files[0])

    console.log(image);
    image.width = 720
    image.height = 480
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


    for (const result of results) {

      if (result.label ==="unknown")
        continue;

      const i = results.indexOf(result);
      const box = resizedDetections[i].detection.box

      // Gửi yêu cầu AJAX riêng biệt cho từng result
      const userId = result.label;
      try {
        const response = await fetch('/getUserInfo_attendance=' + examClass_id, {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify({ userId })
        });
        const data = await response.json();
        console.log(`Thông tin người dùng cho MSSV ${userId}:`, data);
        const drawBox = new faceapi.draw.DrawBox(box, { label: data.name +  ", MSSV: " + result.toString() })
        drawBox.draw(canvas)
      } catch (error) {
        console.error(`Lỗi khi lấy thông tin người dùng cho MSSV ${userId}:`, error);
      }


    }
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
        ld.userId.toString(), // Chuyển đổi userId thành chuỗi để làm label
        [new Float32Array(ld.descriptor)] // Đảm bảo descriptor là một mảng Float32Array
    ));

    console.timeEnd('loadLabeledFaceDescriptorsFromFile'); // Kết thúc đo thời gian
    return labeledFaceDescriptors;
  } catch (error) {
    console.error('Failed to load labeled face descriptors:', error);
    return null; // Hoặc xử lý lỗi theo cách thích hợp trong ứng dụng của bạn
  }
}
 */