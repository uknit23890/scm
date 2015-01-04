/*
SQLyog Community Edition- MySQL GUI v8.12 
MySQL - 5.0.67-community-nt : Database - ajaxcall
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`ajaxcall` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `ajaxcall`;

/*Table structure for table `article` */

DROP TABLE IF EXISTS `article`;

CREATE TABLE `article` (
  `id` int(11) NOT NULL auto_increment,
  `title` varchar(250) default NULL,
  `content` longtext,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `article` */

insert  into `article`(`id`,`title`,`content`) values (1,'jgjg','ghjghj'),(2,'kaka ','jiii'),(3,'hkh','hkhk'),(4,'dsf','dfds'),(5,'sada','dsa');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
