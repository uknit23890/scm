/*
SQLyog Community Edition- MySQL GUI v8.12 
MySQL - 5.0.67-community-nt : Database - webspringbasic
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`webspringbasic` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `webspringbasic`;

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(250) default NULL,
  `email` varchar(50) default NULL,
  `password` varchar(50) default NULL,
  `gender` varchar(10) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `users` */

insert  into `users`(`id`,`name`,`email`,`password`,`gender`) values (1,'vinay','vinay.purpleleap@gmail.com','123','M'),(2,'fsdf','df','23213','M'),(3,'hk','jkhkjh','jhjkhkj','M'),(4,'wdsad','sdsa','sdsaf','M'),(5,'eds','dsf','ds','M');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
