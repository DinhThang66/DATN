const CACHE_NAME = 'face-recognition-cache-v1';
const urlsToCache = [
    'http://localhost:8080/assets/face_recognition/models/face_landmark_68_model-shard1',
    'http://localhost:8080/assets/face_recognition/models/face_landmark_68_model-weights_manifest.json',
    'http://localhost:8080/assets/face_recognition/models/face_recognition_model-shard1',
    'http://localhost:8080/assets/face_recognition/models/face_recognition_model-shard2',
    'http://localhost:8080/assets/face_recognition/models/face_recognition_model-weights_manifest.json',
    'http://localhost:8080/assets/face_recognition/models/mtcnn_model-shard1',
    'http://localhost:8080/assets/face_recognition/models/mtcnn_model-weights_manifest.json',
    'http://localhost:8080/assets/face_recognition/models/ssd_mobilenetv1_model-shard1',
    'http://localhost:8080/assets/face_recognition/models/ssd_mobilenetv1_model-shard2',
    'http://localhost:8080/assets/face_recognition/models/ssd_mobilenetv1_model-weights_manifest.json',
    'http://localhost:8080/assets/face_recognition/models/tiny_face_detector_model-shard1',
    'http://localhost:8080/assets/face_recognition/models/tiny_face_detector_model-weights_manifest.json',


    // Thêm các tài nguyên khác nếu cần
];

self.addEventListener('install', event => {
    event.waitUntil(
        caches.open(CACHE_NAME)
            .then(cache => {
                console.log('Opened cache');
                return cache.addAll(urlsToCache);
            })
    );
});

self.addEventListener('fetch', event => {
    event.respondWith(
        caches.match(event.request)
            .then(response => {
                if (response) {
                    return response;
                }
                return fetch(event.request);
            })
    );
});