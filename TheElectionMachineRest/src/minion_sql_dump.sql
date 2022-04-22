-- MySQL dump 10.13  Distrib 5.5.62, for Win32 (AMD64)
--
-- Host: localhost    Database: minion
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
-- Dropping database if exists 

drop database if exists minion; 

CREATE DATABASE MINION;

create user 'admin'@'localhost' identified by 'password';  

grant all privileges on minion.* to 'admin'@'localhost' with grant option; 

USE MINION;
--
-- Table structure for table `answers`
--

DROP TABLE IF EXISTS `answers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `answers` (
  `candidate_id` int NOT NULL,
  `question_id` int NOT NULL,
  `answer` int DEFAULT NULL,
  PRIMARY KEY (`candidate_id`,`question_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answers`
--

LOCK TABLES `answers` WRITE;
/*!40000 ALTER TABLE `answers` DISABLE KEYS */;
INSERT INTO `answers` VALUES (1,1,1),(1,2,1),(1,3,5),(1,4,3),(1,5,3),(1,6,1),(1,7,5),(1,8,1),(1,9,5),(1,10,3),(2,1,0),(2,2,0),(2,3,0),(2,4,0),(2,5,0),(2,6,0),(2,7,0),(2,8,0),(2,9,0),(2,10,0),(3,1,0),(3,2,0),(3,3,0),(3,4,0),(3,5,0),(3,6,0),(3,7,0),(3,8,0),(3,9,0),(3,10,0),(4,1,0),(4,2,0),(4,3,0),(4,4,0),(4,5,0),(4,6,0),(4,7,0),(4,8,0),(4,9,0),(4,10,0),(5,1,3),(5,2,3),(5,3,3),(5,4,3),(5,5,3),(5,6,3),(5,7,3),(5,8,3),(5,9,3),(5,10,3),(6,1,3),(6,2,3),(6,3,3),(6,4,3),(6,5,3),(6,6,3),(6,7,3),(6,8,3),(6,9,3),(6,10,3),(7,1,3),(7,2,3),(7,3,3),(7,4,3),(7,5,3),(7,6,5),(7,7,5),(7,8,5),(7,9,5),(7,10,5);
/*!40000 ALTER TABLE `answers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `candidates`
--

DROP TABLE IF EXISTS `candidates`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `candidates` (
  `candidate_id` int NOT NULL AUTO_INCREMENT,
  `lastname` varchar(25) NOT NULL,
  `firstname` varchar(25) NOT NULL,
  `picture` varchar(50) DEFAULT NULL,
  `party` varchar(50) NOT NULL,
  `municipality` varchar(25) NOT NULL,
  `age` varchar(50) DEFAULT NULL,
  `what_to_promote` varchar(2000) DEFAULT NULL,
  `profession` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`candidate_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `candidates`
--

LOCK TABLES `candidates` WRITE;
/*!40000 ALTER TABLE `candidates` DISABLE KEYS */;
INSERT INTO `candidates` VALUES (1,'Minion','Kevin','/pics/kevin2.png','Minion Party','Villain village','Unknown','I want to lead Minions to better life and find the best evil leader to follow!','Minion'),(2,'Minion','Stuart','/pics/stuart_small.png','Minion Party','Villain village','Unknown','I just want to play my ukulele and have fun.','Minion'),(3,'Minion','Bob','/pics/bob.png','Minion Party','Villain village','Unknown','Teddy bears for everyone!','Minion'),(4,'Gru','Felonious','/pics/gru2.png','Good Villain Party','Villain village','50','I want to be the best supervillain ever lived!','Supervillain'),(5,'Overkill','Scarlet','/pics/scarlett2.png','Villain Party','Villain village','41','I want to become the first supervillainess and Queen of England.','Supervillainess'),(6,'Nefario','Doctor','/pics/nefario2.png','Inventor Party','Villain village','71','I want to invent great machines.','Inventor'),(7,'Perkins','Vector','/pics/vector2.png','Villain Party','Villain village','17','I want to lead the whole world and spend some more of my papa\'s money to achieve that.','Supervillain');
/*!40000 ALTER TABLE `candidates` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questions`
--

DROP TABLE IF EXISTS `questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `questions` (
  `question_id` int NOT NULL AUTO_INCREMENT,
  `question` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` VALUES (1,'Bananas are the greatest fruits.'),(2,'Yellow is the best colour.'),(3,'Playing ukulele is the most reasonable way to spend time.'),(4,'I know who queen Elisabet is.'),(5,'It is okay to use kids to achieve goals.'),(6,'Taking over the world is acceptable.'),(7,'The Bank of Evil should admit unsecured loans.'),(8,'Minions should have own state.'),(9,'Everyone should be able to own a Jelly Gun.'),(10,'Minions should get Oscar.');
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-11 15:51:34
