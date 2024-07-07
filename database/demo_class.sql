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
-- Table structure for table `class`
--

DROP TABLE IF EXISTS `class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `course_id` bigint DEFAULT NULL,
  `lecturer_id` bigint DEFAULT NULL,
  `room` varchar(255) DEFAULT NULL,
  `schedule` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlsxcyh4sq20727qj0clvah8dg` (`course_id`),
  KEY `FK7426kcgwh0nj767k9if4fmdq4` (`lecturer_id`),
  CONSTRAINT `FK7426kcgwh0nj767k9if4fmdq4` FOREIGN KEY (`lecturer_id`) REFERENCES `lecturer` (`user_id`),
  CONSTRAINT `FKlsxcyh4sq20727qj0clvah8dg` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class`
--

LOCK TABLES `class` WRITE;
/*!40000 ALTER TABLE `class` DISABLE KEYS */;
INSERT INTO `class` VALUES (1,2,235,'D5-101','Thứ 6 , 2 tiết, bắt đầu từ kíp 2'),(8,2,235,'D5-101','Thứ 2 , 2 tiết, bắt đầu từ kíp 10'),(9,1,235,'D5-101','Thứ 3 , 4 tiết, bắt đầu từ kíp 8'),(11,2,226,'D5-102','Thứ 3 , 2 tiết, bắt đầu từ kíp 7'),(12,4,230,'D5-101','Thứ 3 , 4 tiết, bắt đầu từ kíp 1'),(14,3,227,'D5-101','Thứ 4 , 4 tiết, bắt đầu từ kíp 8'),(15,6,227,'D5-103','Thứ 4 , 2 tiết, bắt đầu từ kíp 2'),(16,3,227,'D5-102','Thứ 2 , 4 tiết, bắt đầu từ kíp 3'),(17,6,227,'D5-103','Thứ 6 , 2 tiết, bắt đầu từ kíp 3'),(18,8,231,'D5-102','Thứ 5 , 2 tiết, bắt đầu từ kíp 10'),(31,8,231,'D5-102','Thứ 4 , 2 tiết, bắt đầu từ kíp 1'),(35,9,227,'D5-103','Thứ 5 , 3 tiết, bắt đầu từ kíp 9'),(39,18,232,'D5-102','Thứ 4 , 2 tiết, bắt đầu từ kíp 4'),(40,17,232,'D5-101','Thứ 5 , 3 tiết, bắt đầu từ kíp 8'),(41,16,242,'D5-102','Thứ 5 , 3 tiết, bắt đầu từ kíp 1'),(42,16,242,'D5-103','Thứ 2 , 3 tiết, bắt đầu từ kíp 2'),(43,5,241,'D5-101','Thứ 3 , 1 tiết, bắt đầu từ kíp 7');
/*!40000 ALTER TABLE `class` ENABLE KEYS */;
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
