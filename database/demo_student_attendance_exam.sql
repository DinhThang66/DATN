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
-- Table structure for table `student_attendance_exam`
--

DROP TABLE IF EXISTS `student_attendance_exam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_attendance_exam` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `is_attended` bit(1) DEFAULT NULL,
  `class_id` bigint DEFAULT NULL,
  `student_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcwtdqlcsyl6gj638ofnmimv9b` (`class_id`),
  KEY `FKb204rw42fx2nqddusk0tjuaua` (`student_id`),
  CONSTRAINT `FKb204rw42fx2nqddusk0tjuaua` FOREIGN KEY (`student_id`) REFERENCES `students` (`user_id`),
  CONSTRAINT `FKcwtdqlcsyl6gj638ofnmimv9b` FOREIGN KEY (`class_id`) REFERENCES `exam_class` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_attendance_exam`
--

LOCK TABLES `student_attendance_exam` WRITE;
/*!40000 ALTER TABLE `student_attendance_exam` DISABLE KEYS */;
INSERT INTO `student_attendance_exam` VALUES (14,_binary '\0',4,223),(15,_binary '\0',4,222),(16,_binary '',4,2),(17,_binary '',2,2),(18,_binary '',5,2),(19,_binary '\0',5,222),(20,_binary '\0',4,243),(21,_binary '\0',1,316),(22,_binary '\0',1,317),(23,_binary '\0',1,314),(24,_binary '\0',1,315),(25,_binary '',1,319),(26,_binary '\0',1,318),(27,_binary '',1,327),(35,_binary '\0',3,2),(36,_binary '\0',1,328),(37,_binary '\0',1,2);
/*!40000 ALTER TABLE `student_attendance_exam` ENABLE KEYS */;
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
