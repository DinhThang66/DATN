-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: demo
-- ------------------------------------------------------
-- Server version	8.0.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `fullname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `department_id` bigint DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `year_of_admission` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`),
  KEY `FKfi832e3qv89fq376fuh8920y4` (`department_id`),
  CONSTRAINT `FKfi832e3qv89fq376fuh8920y4` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=334 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'test@gmail.com','Admin','$2a$10$Eqp/nIEob5KSykdCX7wSj.toftfGV1ubSBJDwOTfSyYt18moGMm6K','ADMIN',NULL,'1234567890',NULL,NULL),(2,'vudinhtruongan02@gmail.com','Đinh Văn Thắng','$2a$10$Eqp/nIEob5KSykdCX7wSj.toftfGV1ubSBJDwOTfSyYt18moGMm6K','student',16,'1234567890','2020','0'),(222,'giang.222@gmail.com','Trần Thủy Giang','$2a$10$DoyLUfGU5CpBuHVZdzwm8eAs.6Z8d7nw64z5LhfjdMe8RTvfw3Y/m','student',16,'','2020','0'),(223,'nam.223@gmail.com','Bùi Phương Nam','$2a$10$9Ti412SR4/XaylVMcHZy..CGg05rLp6ITj9DXVJoBGiwVDL5/3JBq','student',16,'','','0'),(226,'dung.226@gmail.com','Bùi Trung Dũng','$2a$10$t8e7U/GYy4lLPFNdVjgFIuBjIi1kmJARiv/6UqzoR4q02w8y2/jsS','lecturer',23,'','','0'),(227,'nam.227@gmail.com','Bùi Phương Nam','$2a$10$7BUWqJ2PZmpkwk2wfJn4Guti3MlCZKC9e61lpBVm0VIiRJsv6oeZW','lecturer',25,'','','-1'),(228,'test5@gmail.com','thang','$2a$10$5/Z2GHXXzSqIcKfDJl6eh.JNrBXbR4W6XNL3ZQO6kgbcSd.EE1qdC','ADMIN',NULL,NULL,NULL,NULL),(229,'anh.229@gmail.com','Lê Đức Anh','$2a$10$LBoExfmTnM7stmVJV6UraudbhsfnqAMXibs.rTqTtL.3ZvUM9zktm','lecturer',16,'','','-1'),(230,'chi.230@gmail.com','Nguyễn Quỳnh Chi','$2a$10$JirnF9BRZLogcBULQOHPIurboMQCFGIL/UkIUIm.IOtSFv8j8VFv6','lecturer',16,'','',''),(231,'cuong.231@gmail.com','Nguyễn Mạnh Cường','$2a$10$NlIHj341EAJ3LStL/a8qeeIxOdJqwo8e6wxOKtW5fQUmg3bJfQzn2','lecturer',16,'','',''),(232,'đat.232@gmail.com','Nguyễn Tiến Đạt','$2a$10$XcsT3YXKSYoeuiOu.YSBCuD03A7.Zfwfdhd4e9uC/O2s74VRN9b1m','lecturer',16,'','',''),(233,'duan.233@gmail.com','Nguyễn Văn Duẫn','$2a$10$GrQYHcDMTMNPzEL4DXYTfuYBedOezNbPJW68r7wpzHHyp97894rqy','lecturer',16,'','',''),(234,'dung.234@gmail.com','Nguyễn Việt Dũng','$2a$10$kBwy7HtFQsqzbNhs2FvaOeIn6IBPJrq8DyI2KlfnhS6MNLpqGimHi','lecturer',16,'','','-1'),(235,'hai.235@gmail.com','Vũ Đức Hải','$2a$10$DAUOc8QwUttOup5Q2/9TJ.5qRyDZrHSHh6XnGCA4ezFes4a4tg/z2','lecturer',16,'','','-1'),(236,'giang.236@gmail.com','Lê Hoàng Hà Giang','$2a$10$q8zaxc5/USZRY/hctrfxQut/nEfgrvxtsZGpuUDCz.ojOPlROtQqe','lecturer',16,'','','-1'),(237,'hai.237@gmail.com','Lê Vũ Hải','$2a$10$CCD9xmQrbxpdWyJbetgFn.JUlcLS4Zt.oOS6SncS.tA5zUQhdZnOm','lecturer',16,'','','-1'),(241,'kiet.241@gmail.com','Phạm Tuấn Kiệt','$2a$10$4Vrd7YEzRUkyjy05d.RPOOOY7ZfMBBKSBUQNSoXnurDVi2VyflX7e','lecturer',23,'','','-1'),(242,'lich.242@gmail.com','Nguyễn Phúc Lịch','$2a$10$TXFHnsgXIiNqT69bXG8xyOIS6LonR81BZ.i.6SqXrswiaMg072wYC','lecturer',23,'','','-1'),(243,'duyen.243@gmail.com','Bùi Thị Mỹ Duyên','$2a$10$Bg8Egt7D02z6oD.BVL741uFEDgU6va3ViKPqK0lBiyX8KZq42fuBy','student',16,'','','1'),(244,'ngoc.244@gmail.com','Phạm Hồng Ngọc','$2a$10$Paw8WjWgsGp8wTDIrAKt/eC6.scU/g0Pj2G1hmpOaFg3Ps7GHjl8i','student',16,'','','1'),(311,'anh.311@gmail.com','Nguyễn Ngọc Hoàng Anh','$2a$10$fZvR6AXT1oyDAU5P0nRRkOJbNbJPmqGdsm2QPpZAVMaZnUcNm73dm','student',16,'','2020','1'),(312,'an.312@gmail.com','Vũ Trường An','$2a$10$SUblzpBTJP1CG8h/DKG/Z.Azsi2EPpsHfEXtklc2Y4bEr3WboGRJe','student',16,'','2020','0'),(313,'đat.313@gmail.com','Trần Văn Đạt','$2a$10$82N/t5WKRWM4YkwNiHa0qedULsTELDZ5YPbgwqPQsx44KqNhS/Qtu','student',16,'','2020','0'),(314,'stark.314@gmail.com','Tony Stark','$2a$10$GKjl.3Ta71R2PwAsOrPnduUVMNoKzsi/dBrIzCSxgfv1a9AaJKBde','student',16,'','2020','0'),(315,'thor.315@gmail.com','Thor','$2a$10$cFIsQillGL1zNvsL/KyfY.sVe1zfUFkLIdCzIoSPX7h9hMKmKFPXi','student',16,'','','0'),(316,'america.316@gmail.com','Captain America','$2a$10$FAXMuVEGF0UpO3qQjDb5Q.Fep3jjZvEwyAhmMoDulrh6PNkZM5RCK','student',16,'','','0'),(317,'marvel.317@gmail.com','Captain Marvel','$2a$10$6wNOlPFN21jYELDBSWEcl.9YX4auiKpAzOJX506bm0SfuM2nDwWhK','student',16,'','','0'),(318,'tung.318@gmail.com','Sơn Tùng','$2a$10$FZjqaIz5ilPcb4pE6xO4jO4buIMsKX5XZs3R/USXM8zylKqrlEtTy','student',16,'','','0'),(319,'tu.319@gmail.com','Hải tú','$2a$10$129oRjV3HfafuvPxqlPvGuin0Pg5FZMv2uXBaWKm7qouNm1m4srwK','student',16,'','','0'),(322,'thanh.322@gmail.com','Phạm Tiến Thành','$2a$10$WGJ/h9VYESoa6wUT7didbOlsKZodLNM.4zRThAdYd.RKUKyrHtDyC','student',23,'','2020','0'),(326,'thang1.326@gmail.com','Đinh Văn Thắng1','$2a$10$6wRVI5nP3DnvEvrHDZ2Dye8OSJ3r/PiO9PpDtfu73hp4/a9iJMUga','student',NULL,'','21','0'),(327,'thang1.327@gmail.com','Trấn thành','$2a$10$A9OEj39uMHM7MyDeasTAXu8VXZ0F10jkEJLZAXbA9oajkqadXB4uW','student',16,'','12','0'),(328,'won.328@gmail.com','Hari won','$2a$10$.mSqGzwL0XKHn06ZR78xq.An0k3.dJVLJCLawJnE0X2VnxcxUQPoi','student',16,'','2020','0'),(329,'halland.329@gmail.com','Tom Halland','$2a$10$7w0bNWUF7VBuTw72RVIzluAQ6pAfr1PJfYvX1j4MNesZ1WhZYstle','student',23,'','2020','0'),(330,'maguire.330@gmail.com','Tobey Maguire','$2a$10$Lrdcvi9HOBVRwUBANPxNQ.iiMiVJB9/et7p4721rdgQrC8YLrWKT2','student',23,'','','0'),(331,'garfield.331@gmail.com','Andrew Garfield','$2a$10$E64mmwYymFspBD/qIN6MUuptRAArEcg834salqDHW28rGml70Aq52','student',23,'','','0');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-07 20:48:25
