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
-- Table structure for table `student_attendance`
--

DROP TABLE IF EXISTS `student_attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_attendance` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `date` varchar(255) DEFAULT NULL,
  `is_attended` bit(1) DEFAULT NULL,
  `class_id` bigint DEFAULT NULL,
  `student_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsqgi3ddc21695nrjyloei2o67` (`class_id`),
  KEY `FKom8v4b1hh9n50u1fpx4xvw3oq` (`student_id`),
  CONSTRAINT `FKom8v4b1hh9n50u1fpx4xvw3oq` FOREIGN KEY (`student_id`) REFERENCES `students` (`user_id`),
  CONSTRAINT `FKsqgi3ddc21695nrjyloei2o67` FOREIGN KEY (`class_id`) REFERENCES `class` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_attendance`
--

LOCK TABLES `student_attendance` WRITE;
/*!40000 ALTER TABLE `student_attendance` DISABLE KEYS */;
INSERT INTO `student_attendance` VALUES (9,'2024-06-27-20:50',_binary '',11,2),(10,'2024-06-27-20:50',_binary '',11,222),(43,'2024-06-27-22:46',_binary '\0',11,2),(44,'2024-06-27-22:46',_binary '\0',11,222),(49,'2024-06-27-22:47',_binary '',11,222),(50,'2024-06-27-22:47',_binary '',11,2),(51,'2024-06-27-22:51',_binary '\0',11,222),(52,'2024-06-27-22:51',_binary '',11,2),(53,'2024-06-27-22:57',_binary '',11,222),(54,'2024-06-27-22:57',_binary '',11,2),(55,'2024-06-27-22:59',_binary '',11,222),(56,'2024-06-27-22:59',_binary '\0',11,2),(57,'2024-06-27-22:59',_binary '',11,2),(58,'2024-06-27-22:59',_binary '\0',11,222),(59,'2024-06-30-15:51',_binary '',11,222),(60,'2024-06-30-15:51',_binary '',11,2),(61,'2024-06-30-15:51',_binary '',11,223);
/*!40000 ALTER TABLE `student_attendance` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-07 20:48:23
