-- MySQL dump 10.13  Distrib 8.0.35, for Win64 (x86_64)
--
-- Host: localhost    Database: delicious-food-map
-- ------------------------------------------------------
-- Server version	8.0.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` varchar(100) NOT NULL COMMENT 'id',
  `name` varchar(200) DEFAULT NULL COMMENT '分类名称',
  `display_name` varchar(200) DEFAULT NULL COMMENT '显示名称',
  `color` varchar(7) DEFAULT NULL COMMENT '分类颜色色号 Hex',
  `icon` varchar(100) DEFAULT NULL COMMENT '分类图标类名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='分类';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES ('1','粤菜馆','粤菜馆','#dc2626','fas fa-utensils'),('2','早餐、小吃、肠粉、粥、面店','早餐小吃','#ea580c','fas fa-bread-slice');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `poi_data`
--

DROP TABLE IF EXISTS `poi_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `poi_data` (
  `id` varchar(100) NOT NULL,
  `name` varchar(200) DEFAULT NULL COMMENT '店名',
  `address` text COMMENT '地址',
  `description` text COMMENT '描述',
  `category` varchar(100) DEFAULT NULL COMMENT '分类',
  `longitude` bigint unsigned DEFAULT NULL COMMENT '经度',
  `latitude` bigint unsigned DEFAULT NULL COMMENT '纬度',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modified_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='美食地点数据';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `poi_data`
--

LOCK TABLES `poi_data` WRITE;
/*!40000 ALTER TABLE `poi_data` DISABLE KEYS */;
INSERT INTO `poi_data` VALUES ('1','广州酒家','广州市荔湾区文昌南路2号','百年老字号粤菜酒家，招牌白切鸡和烧鹅闻名','1',113,23,'2025-05-29 14:18:12','2025-05-29 14:18:34'),('2','陶陶居','广州市荔湾区第十甫路20号','创立于1880年的老字号茶楼，传统粤菜精品','1',113,23,'2025-05-29 14:21:13','2025-05-29 14:21:15');
/*!40000 ALTER TABLE `poi_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_user` (
  `id` bigint unsigned NOT NULL COMMENT 'ID',
  `nick_name` varchar(100) DEFAULT NULL COMMENT '昵称',
  `email` varchar(150) DEFAULT NULL COMMENT '邮箱',
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  `salt` varchar(32) DEFAULT NULL COMMENT '密码盐值',
  `sign` varchar(32) DEFAULT NULL COMMENT 'JWT Token 签名',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modified_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'delicious-food-map'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-29 17:28:47
