- Ứng dụng spring boot; thay đổi datasource.url, datasource.usename, datasource.password trong application.properties.
- Chạy ứng dụng sẽ tự động tạo các bảng trong mysql, đăng ký một tài khoản từ giao diện, sau đó vào mysql workbench để thay đổi role = ADMIN
  hoặc export database và sử dụng tài khoản admin: tk: test@gmail.com, mk: 2002

- Để sử dụng chức năng điểm danh khuôn mặt cần thêm ảnh từ edit_student và chờ một lúc để có thể trích suất đặc trưng của người đó.
- Phần xếp lịch mặc định có 3 phòng học, để thêm phòng học thay đổi trong gaSchedule/model/Configuration.java trong hàm loadRooms().
  
- Lưu ý: Để thêm descriptor các điểm đặc trưng của khuôn mặt của một người dùng thì cần phải input ảnh trong edit_student(Vì chỉ check ảnh sinh viên),
  do việc tính toán description mất khá nhiều thời gian, nên tạo mới sinh viên mà thêm ảnh thì chưa tính description luôn.
