-- MySQL dump 10.13  Distrib 8.0.17, for Linux (x86_64)
--
-- Host: localhost    Database: test
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `sys_account`
--

DROP TABLE IF EXISTS `sys_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `state` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `phone_UNIQUE` (`phone`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_account`
--

LOCK TABLES `sys_account` WRITE;
/*!40000 ALTER TABLE `sys_account` DISABLE KEYS */;
INSERT INTO `sys_account` VALUES (1,'root','$2a$10$LXO5c1BRmq3qNdqOXhXfI.AGb7aSjfzgHDvYzhmIh.2bGzzPxpdu.','18682346841','1846427859@qq.com',1),(12,'zhangsan','$2a$10$VPLK5G8TsYlk/J9oA0O1/eapBtLHk1kEg9HIuAtwMDA9qxsJ2aEHi','1234','1234',1),(19,'zhaoliu','$2a$10$b/epuKsuqlgCcRIQmZiyWeskXscb0k5.RbKpx/JA5rTqWZO2VS01a','12345','12345',1),(20,'tianqi','$2a$10$t1uMeS.rTWeiHfwO8zdSa.vg72Y8qel7XjphreoFClXMb2MN6kS0.','tianqi','tianqi',1),(21,'wangba','$2a$10$Hs2j2Wij6HsmVfjR.vBBBOdv4yb.iykpmw.XjEvofdUaFo9eSics.','wangba','wangba',1);
/*!40000 ALTER TABLE `sys_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_account_authority`
--

DROP TABLE IF EXISTS `sys_account_authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_account_authority` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account_id` int(11) NOT NULL,
  `authority_id` int(11) NOT NULL,
  `type` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `account_id` (`account_id`),
  KEY `authority_id` (`authority_id`),
  CONSTRAINT `sys_account_authority_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `sys_account` (`id`),
  CONSTRAINT `sys_account_authority_ibfk_2` FOREIGN KEY (`authority_id`) REFERENCES `sys_authority` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_account_authority`
--

LOCK TABLES `sys_account_authority` WRITE;
/*!40000 ALTER TABLE `sys_account_authority` DISABLE KEYS */;
INSERT INTO `sys_account_authority` VALUES (9,1,1,0),(10,1,6,0),(11,19,4,0),(12,19,5,0),(13,19,23,0),(14,19,39,0),(15,19,5,0),(16,19,1,1),(17,20,1,0),(18,12,40,0),(19,19,40,0),(20,20,40,0),(21,21,40,0);
/*!40000 ALTER TABLE `sys_account_authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_account_group`
--

DROP TABLE IF EXISTS `sys_account_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_account_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account_id` int(11) NOT NULL,
  `group_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `account_id` (`account_id`),
  KEY `group_id` (`group_id`),
  CONSTRAINT `sys_account_group_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `sys_account` (`id`),
  CONSTRAINT `sys_account_group_ibfk_2` FOREIGN KEY (`group_id`) REFERENCES `sys_group` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_account_group`
--

LOCK TABLES `sys_account_group` WRITE;
/*!40000 ALTER TABLE `sys_account_group` DISABLE KEYS */;
INSERT INTO `sys_account_group` VALUES (7,1,1);
/*!40000 ALTER TABLE `sys_account_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_account_role`
--

DROP TABLE IF EXISTS `sys_account_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_account_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `account_id` (`account_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `sys_account_role_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `sys_account` (`id`),
  CONSTRAINT `sys_account_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_account_role`
--

LOCK TABLES `sys_account_role` WRITE;
/*!40000 ALTER TABLE `sys_account_role` DISABLE KEYS */;
INSERT INTO `sys_account_role` VALUES (5,1,1);
/*!40000 ALTER TABLE `sys_account_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_authority`
--

DROP TABLE IF EXISTS `sys_authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_authority` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_authority`
--

LOCK TABLES `sys_authority` WRITE;
/*!40000 ALTER TABLE `sys_authority` DISABLE KEYS */;
INSERT INTO `sys_authority` VALUES (1,0,'insertSysAccount','新增账号https://blog.csdn.net/hongchenghong/article/details/80194238'),(2,0,'deleteSysAccountById','账号'),(3,0,'updateSysAccountById','账号'),(4,0,'selectSysAccountById','账号'),(5,0,'selectSysAccount','账号'),(6,0,'insertSysAuthority','权限'),(7,0,'deleteSysAuthorityById','权限'),(8,0,'updateSysAuthorityById','权限'),(9,0,'selectSysAuthorityById','权限'),(10,0,'selectSysAuthority','权限'),(11,0,'insertSysGroup','权限组'),(12,0,'deleteSysGroupById','权限组'),(13,0,'updateSysGroupById','权限组'),(14,0,'selectSysGroupById','权限组'),(15,0,'selectSysGroup','权限组'),(16,0,'insertSysRole','角色'),(17,0,'deleteSysRoleById','角色'),(18,0,'updateSysRoleById','角色'),(19,0,'selectSysRoleById','角色'),(20,0,'selectSysRole','角色'),(21,0,'assignAuthorityToRole','授权'),(22,0,'assignAuthorityToGroup','授权'),(23,0,'assignAuthorityToAccount','授权'),(24,0,'assignRoleToGroup','授权'),(25,0,'assignRoleToAccount','授权'),(26,0,'assignGroupToAccount','授权'),(27,0,'recoveryAuthorityFromRole','授权'),(28,0,'recoveryAuthorityFromGroup','授权'),(29,0,'recoveryAuthorityFromAccount','授权'),(30,0,'recoveryRoleFromGroup','授权'),(31,0,'recoveryRoleFromAccount','授权'),(32,0,'recoveryGroupFromAccount','授权'),(33,0,'selectAuthorityFromRole','授权'),(34,0,'selectAuthorityFromGroup','授权'),(35,0,'selectAuthorityFromAccount','授权'),(36,0,'selectRoleFromAccount','授权'),(37,0,'selectRoleFromGroup','授权'),(38,0,'selectGroupFromAccount','授权'),(39,0,'selectCanAssignAuthority','授权'),(40,0,'selectOwnerAuthority','授权');
/*!40000 ALTER TABLE `sys_authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_group`
--

DROP TABLE IF EXISTS `sys_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `create_time` datetime NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_group`
--

LOCK TABLES `sys_group` WRITE;
/*!40000 ALTER TABLE `sys_group` DISABLE KEYS */;
INSERT INTO `sys_group` VALUES (1,0,'group1','2020-01-07 00:00:00','group1'),(5,0,'group2','2020-01-14 08:27:49','group2'),(6,0,'group3','2020-01-14 08:27:56','group3');
/*!40000 ALTER TABLE `sys_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_group_authority`
--

DROP TABLE IF EXISTS `sys_group_authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_group_authority` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_id` int(11) NOT NULL,
  `authority_id` int(11) NOT NULL,
  `type` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `group_id` (`group_id`),
  KEY `authority_id` (`authority_id`),
  CONSTRAINT `sys_group_authority_ibfk_1` FOREIGN KEY (`group_id`) REFERENCES `sys_group` (`id`),
  CONSTRAINT `sys_group_authority_ibfk_2` FOREIGN KEY (`authority_id`) REFERENCES `sys_authority` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_group_authority`
--

LOCK TABLES `sys_group_authority` WRITE;
/*!40000 ALTER TABLE `sys_group_authority` DISABLE KEYS */;
INSERT INTO `sys_group_authority` VALUES (10,1,3,0);
/*!40000 ALTER TABLE `sys_group_authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_group_role`
--

DROP TABLE IF EXISTS `sys_group_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_group_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `group_id` (`group_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `sys_group_role_ibfk_1` FOREIGN KEY (`group_id`) REFERENCES `sys_group` (`id`),
  CONSTRAINT `sys_group_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_group_role`
--

LOCK TABLES `sys_group_role` WRITE;
/*!40000 ALTER TABLE `sys_group_role` DISABLE KEYS */;
INSERT INTO `sys_group_role` VALUES (4,1,1);
/*!40000 ALTER TABLE `sys_group_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `create_time` datetime NOT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` VALUES (1,0,'root','2020-01-07 00:00:00','root'),(7,0,'角色2','2020-01-14 08:13:07','角色2');
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_authority`
--

DROP TABLE IF EXISTS `sys_role_authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_role_authority` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL,
  `authority_id` int(11) NOT NULL,
  `type` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`),
  KEY `authority_id` (`authority_id`),
  CONSTRAINT `sys_role_authority_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`),
  CONSTRAINT `sys_role_authority_ibfk_2` FOREIGN KEY (`authority_id`) REFERENCES `sys_authority` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_authority`
--

LOCK TABLES `sys_role_authority` WRITE;
/*!40000 ALTER TABLE `sys_role_authority` DISABLE KEYS */;
INSERT INTO `sys_role_authority` VALUES (14,1,2,0);
/*!40000 ALTER TABLE `sys_role_authority` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-18  0:25:13
