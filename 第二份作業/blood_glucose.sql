CREATE DATABASE  IF NOT EXISTS `blood_glucose` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `blood_glucose`;
-- MySQL dump 10.13  Distrib 8.0.44, for Win64 (x86_64)
--
-- Host: localhost    Database: blood_glucose
-- ------------------------------------------------------
-- Server version	8.0.44

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
-- Table structure for table `健康紀錄表`
--

DROP TABLE IF EXISTS `健康紀錄表`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `健康紀錄表` (
  `id` int NOT NULL AUTO_INCREMENT,
  `週ID` varchar(45) DEFAULT NULL,
  `日期` varchar(45) DEFAULT NULL,
  `血糖值` int DEFAULT NULL,
  `收縮壓` int DEFAULT NULL,
  `舒張壓` int DEFAULT NULL,
  `脈搏` int DEFAULT NULL,
  `體重` double DEFAULT NULL,
  `用戶id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `健康紀錄表`
--

LOCK TABLES `健康紀錄表` WRITE;
/*!40000 ALTER TABLE `健康紀錄表` DISABLE KEYS */;
INSERT INTO `健康紀錄表` VALUES (12,'w000','2026-02-01',102,200,500,20,60,'u003');
/*!40000 ALTER TABLE `健康紀錄表` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `全大表1`
--

DROP TABLE IF EXISTS `全大表1`;
/*!50001 DROP VIEW IF EXISTS `全大表1`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `全大表1` AS SELECT 
 1 AS `用戶id`,
 1 AS `週ID`,
 1 AS `日期`,
 1 AS `血糖值`,
 1 AS `收縮壓`,
 1 AS `舒張壓`,
 1 AS `脈搏`,
 1 AS `體重`,
 1 AS `運動名稱`,
 1 AS `單位`,
 1 AS `時間`,
 1 AS `食物名稱`,
 1 AS `GI值`,
 1 AS `好吃度`,
 1 AS `次數`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `用戶`
--

DROP TABLE IF EXISTS `用戶`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `用戶` (
  `id` int NOT NULL AUTO_INCREMENT,
  `用戶id` varchar(45) DEFAULT NULL,
  `用戶名稱` varchar(45) DEFAULT NULL,
  `帳號` varchar(45) DEFAULT NULL,
  `密碼` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `用戶`
--

LOCK TABLES `用戶` WRITE;
/*!40000 ALTER TABLE `用戶` DISABLE KEYS */;
INSERT INTO `用戶` VALUES (1,'u001','笨蛋阿公','阿公','哈哈'),(2,'u002','456','789','123'),(3,'u003','1234','1234','1234');
/*!40000 ALTER TABLE `用戶` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `睡眠時間`
--

DROP TABLE IF EXISTS `睡眠時間`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `睡眠時間` (
  `id` int NOT NULL AUTO_INCREMENT,
  `日期` date DEFAULT NULL,
  `開始睡覺時間` time DEFAULT NULL,
  `起床時間` time DEFAULT NULL,
  `總睡眠時數` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `睡眠時間`
--

LOCK TABLES `睡眠時間` WRITE;
/*!40000 ALTER TABLE `睡眠時間` DISABLE KEYS */;
/*!40000 ALTER TABLE `睡眠時間` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `運動`
--

DROP TABLE IF EXISTS `運動`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `運動` (
  `id` int NOT NULL AUTO_INCREMENT,
  `運動代號` varchar(45) DEFAULT NULL,
  `運動名稱` varchar(45) DEFAULT NULL,
  `運動單位` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `運動`
--

LOCK TABLES `運動` WRITE;
/*!40000 ALTER TABLE `運動` DISABLE KEYS */;
INSERT INTO `運動` VALUES (1,'e001','跳舞','卡路里'),(2,'e002','走路','公里'),(3,'e003','動腦','次數'),(4,'e004','自殘','次數');
/*!40000 ALTER TABLE `運動` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `運動連接表`
--

DROP TABLE IF EXISTS `運動連接表`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `運動連接表` (
  `id` int NOT NULL AUTO_INCREMENT,
  `UID` varchar(45) DEFAULT NULL,
  `週ID` varchar(45) DEFAULT NULL,
  `運動ID` varchar(45) DEFAULT NULL,
  `單位` double DEFAULT NULL,
  `時間` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `運動連接表`
--

LOCK TABLES `運動連接表` WRITE;
/*!40000 ALTER TABLE `運動連接表` DISABLE KEYS */;
INSERT INTO `運動連接表` VALUES (4,'u003','w000','e001',20,10),(5,'u003','w000','e003',20,10),(6,'u003','w000','e002',30,10);
/*!40000 ALTER TABLE `運動連接表` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `食物`
--

DROP TABLE IF EXISTS `食物`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `食物` (
  `id` int NOT NULL AUTO_INCREMENT,
  `食物代號` varchar(45) DEFAULT NULL,
  `食物名稱` varchar(45) DEFAULT NULL,
  `GI值` int DEFAULT NULL,
  `好吃度` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `食物`
--

LOCK TABLES `食物` WRITE;
/*!40000 ALTER TABLE `食物` DISABLE KEYS */;
INSERT INTO `食物` VALUES (1,'f001','地瓜半顆',25,10),(2,'f002','芭樂半顆',NULL,8),(3,'f003','雞胸肉100克',NULL,6);
/*!40000 ALTER TABLE `食物` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `食物連接表`
--

DROP TABLE IF EXISTS `食物連接表`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `食物連接表` (
  `id` int NOT NULL AUTO_INCREMENT,
  `UID` varchar(45) DEFAULT NULL,
  `週ID` varchar(45) DEFAULT NULL,
  `食物ID` varchar(45) DEFAULT NULL,
  `次數` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `食物連接表`
--

LOCK TABLES `食物連接表` WRITE;
/*!40000 ALTER TABLE `食物連接表` DISABLE KEYS */;
INSERT INTO `食物連接表` VALUES (17,'u003','w000','f002',2),(18,'u003','w000','f001',3);
/*!40000 ALTER TABLE `食物連接表` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `全大表1`
--

/*!50001 DROP VIEW IF EXISTS `全大表1`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `全大表1` AS select `健康紀錄表`.`用戶id` AS `用戶id`,`健康紀錄表`.`週ID` AS `週ID`,`健康紀錄表`.`日期` AS `日期`,`健康紀錄表`.`血糖值` AS `血糖值`,`健康紀錄表`.`收縮壓` AS `收縮壓`,`健康紀錄表`.`舒張壓` AS `舒張壓`,`健康紀錄表`.`脈搏` AS `脈搏`,`健康紀錄表`.`體重` AS `體重`,`運動`.`運動名稱` AS `運動名稱`,`運動連接表`.`單位` AS `單位`,`運動連接表`.`時間` AS `時間`,`食物`.`食物名稱` AS `食物名稱`,`食物`.`GI值` AS `GI值`,`食物`.`好吃度` AS `好吃度`,`食物連接表`.`次數` AS `次數` from ((((`健康紀錄表` left join `運動連接表` on((`健康紀錄表`.`週ID` = `運動連接表`.`週ID`))) left join `運動` on((`運動連接表`.`運動ID` = `運動`.`運動代號`))) left join `食物連接表` on((`健康紀錄表`.`週ID` = `食物連接表`.`週ID`))) left join `食物` on((`食物連接表`.`食物ID` = `食物`.`食物代號`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-02-09 10:01:24
