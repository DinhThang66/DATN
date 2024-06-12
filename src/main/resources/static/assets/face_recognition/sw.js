// sw.js

const CACHE_NAME = 'face_recognition_cache';
const urlsToCache = [
    '/assets/face_recognition/models/face_recognition_model-weights_manifest.json',
    '/assets/face_recognition/models/face_recognition_model-shard1of1',
    '/assets/face_recognition/models/face_landmark_68_model-weights_manifest.json',
    '/assets/face_recognition/models/face_landmark_68_model-shard1of1',
    '/assets/face_recognition/models/ssd_mobilenetv1_model-weights_manifest.json',
    '/assets/face_recognition/models/ssd_mobilenetv1_model-shard1of1',
    // Thêm các URL của các tệp tài nguyên khác mà bạn muốn lưu trữ ở đây
];

self.addEventListener('install', function(event) {
    // Perform install steps
    event.waitUntil(
        caches.open(CACHE_NAME)
            .then(function(cache) {
                console.log('Opened cache');
                return cache.addAll(urlsToCache);
            })
    );
});

self.addEventListener('fetch', function(event) {
    event.respondWith(
        caches.match(event.request)
            .then(function(response) {
                // Cache hit - return response
                if (response) {
                    return response;
                }
                return fetch(event.request);
            })
    );
});
