-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: community
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `permanent_address`
--

DROP TABLE IF EXISTS `permanent_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permanent_address` (
  `id` int NOT NULL AUTO_INCREMENT,
  `district` varchar(255) DEFAULT NULL,
  `house_no_name_plot_no` varchar(255) DEFAULT NULL,
  `mandal_area` varchar(255) DEFAULT NULL,
  `phone no` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `street_landmark` varchar(255) DEFAULT NULL,
  `village` varchar(255) DEFAULT NULL,
  `base_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8w3mdl40jbc32roevoa8dcjav` (`base_id`),
  CONSTRAINT `FK8w3mdl40jbc32roevoa8dcjav` FOREIGN KEY (`base_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permanent_address`
--

LOCK TABLES `permanent_address` WRITE;
/*!40000 ALTER TABLE `permanent_address` DISABLE KEYS */;
INSERT INTO `permanent_address` VALUES (1,'ccc','6-9-23','mandal','99999','relangana','landmark','2222',1);
/*!40000 ALTER TABLE `permanent_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `present_address`
--

DROP TABLE IF EXISTS `present_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `present_address` (
  `id` int NOT NULL AUTO_INCREMENT,
  `district` varchar(255) DEFAULT NULL,
  `house_no_name_plot_no` varchar(255) DEFAULT NULL,
  `mandal_area` varchar(255) DEFAULT NULL,
  `phone no` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `street_landmark` varchar(255) DEFAULT NULL,
  `village` varchar(255) DEFAULT NULL,
  `base_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKd128vhngvlnwtu4ymchwtbnca` (`base_id`),
  CONSTRAINT `FKd128vhngvlnwtu4ymchwtbnca` FOREIGN KEY (`base_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `present_address`
--

LOCK TABLES `present_address` WRITE;
/*!40000 ALTER TABLE `present_address` DISABLE KEYS */;
INSERT INTO `present_address` VALUES (1,'xxx','7-0-89','area','66666','telangana','88888','village',1);
/*!40000 ALTER TABLE `present_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `professional_details`
--

DROP TABLE IF EXISTS `professional_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `professional_details` (
  `id` int NOT NULL AUTO_INCREMENT,
  `company_name` varchar(255) DEFAULT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `district` varchar(255) DEFAULT NULL,
  `house_no_name_plot_no` varchar(255) DEFAULT NULL,
  `job_business` varchar(255) DEFAULT NULL,
  `mandal_area` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `street_landmark` varchar(255) DEFAULT NULL,
  `village` varchar(255) DEFAULT NULL,
  `base_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKr6dobxs5bb8h5i4tbvw7fmhna` (`base_id`),
  CONSTRAINT `FKr6dobxs5bb8h5i4tbvw7fmhna` FOREIGN KEY (`base_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professional_details`
--

LOCK TABLES `professional_details` WRITE;
/*!40000 ALTER TABLE `professional_details` DISABLE KEYS */;
INSERT INTO `professional_details` VALUES (1,'favorite','lead','xxx','7-9-10','job','area','teangana','vvvv','ccc',1);
/*!40000 ALTER TABLE `professional_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `age` varchar(255) DEFAULT NULL,
  `assembly_constituency(vote)` varchar(255) DEFAULT NULL,
  `blood_gp` varchar(255) DEFAULT NULL,
  `date_of_birth` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `gotra(m)` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `ph_no1` varchar(255) DEFAULT NULL,
  `ph_no2` varchar(255) DEFAULT NULL,
  `s_o_or_d_o` varchar(255) DEFAULT NULL,
  `subcast` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `w_p_no` varchar(255) DEFAULT NULL,
  `son_of_or_daughter_of` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'20','lbnagar','o','5-10-2004','male','yyy','kiran','7777','99999','so','yy','iyer','yy',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-26 13:29:58
