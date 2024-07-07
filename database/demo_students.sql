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
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students` (
  `user_id` bigint NOT NULL,
  `class_name` varchar(255) DEFAULT NULL,
  `education_level` varchar(255) DEFAULT NULL,
  `education_program` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (2,'Điện tử 07','0','Kỹ thuật điện tử viễn thông'),(222,'Điện 01','0','Kỹ thuật điện'),(223,'Điện tử 01','0','Kỹ thuật điện tử viễn thông'),(243,'Điện tử 05','0','Kỹ thuật điện tử viễn thông'),(244,'Điện tử 07','0','Kỹ thuật điện tử viễn thông'),(256,'','0',''),(267,NULL,'0',''),(268,'','0',''),(269,'','0',''),(270,'','0',''),(271,NULL,'0',''),(272,NULL,'0',''),(276,NULL,'0',''),(277,NULL,'0',''),(311,'Điện tử 07','0','Kỹ thuật điện tử viễn thông'),(312,'Điện tử 01','0','Kỹ thuật điện tử viễn thông'),(313,'Điện tử 10','0','Kỹ thuật điện tử viễn thông'),(314,'','0',''),(315,'','0',''),(316,'','0',''),(317,'','0',''),(318,'','0',''),(319,'','0',''),(322,NULL,'0','Toán'),(326,NULL,'0',''),(327,'','0',''),(328,'','0',''),(329,'Toán 01','0','Toán tin'),(330,'Toán 01','0','Toán tin'),(331,'Toán 01','0','Toán tin');
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-07 20:48:24
