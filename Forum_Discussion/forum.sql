/*
SQLyog Community Edition- MySQL GUI v8.12 
MySQL - 5.0.67-community-nt : Database - forum
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`forum` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `forum`;

/*Table structure for table `comment` */

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `id` int(11) default NULL,
  `topicid` int(11) default NULL,
  `userid` varchar(50) default NULL,
  `comment` longtext,
  `time` datetime default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `comment` */

insert  into `comment`(`id`,`topicid`,`userid`,`comment`,`time`) values (NULL,1,'vinay.purpleleap@gmail.com','hi this is good ','2015-01-04 23:16:31'),(NULL,1,'vinay.purpleleap@gmail.com','hi jjj','2015-01-04 23:18:36'),(NULL,1,'vinay.purpleleap@gmail.com','fdsfds','2015-01-04 23:50:12'),(NULL,1,'vinay.purpleleap@gmail.com','this my comment','2015-01-05 00:46:07'),(NULL,1,'vinay.purpleleap@gmail.com','kaha  hjhh','2015-01-05 00:50:25'),(NULL,1,'vinay.purpleleap@gmail.com','hiiii','2015-01-05 00:52:01'),(NULL,1,'vinay.purpleleap@gmail.com','hii jjjj','2015-01-05 00:52:16'),(NULL,1,'vinay.purpleleap@gmail.com','e=very good','2015-01-05 00:58:14'),(NULL,1,'vinay.purpleleap@gmail.com','great','2015-01-05 00:59:04'),(NULL,1,'vinay.purpleleap@gmail.com','dsds','2015-01-05 00:59:23');

/*Table structure for table `topics` */

DROP TABLE IF EXISTS `topics`;

CREATE TABLE `topics` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(50) default NULL,
  `comment` longtext,
  `userid` varchar(50) default NULL,
  `time` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `topics` */

insert  into `topics`(`id`,`name`,`comment`,`userid`,`time`) values (1,'Java','java is good','vinay.purpleleap@gmail.com','2015-01-04 23:14:50');

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `userid` varchar(50) NOT NULL,
  `password` varchar(50) default NULL,
  `name` varchar(50) default NULL,
  `gender` char(1) default NULL,
  `age` int(11) default NULL,
  `city` varchar(50) default NULL,
  PRIMARY KEY  (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `users` */

insert  into `users`(`userid`,`password`,`name`,`gender`,`age`,`city`) values ('vinay.purpleleap@gmail.com','123','Vinay Singh Rawat','M',30,'Lucknow');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
