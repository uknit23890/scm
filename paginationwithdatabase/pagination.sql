/*
SQLyog Community Edition- MySQL GUI v8.12 
MySQL - 5.0.67-community-nt : Database - pagination
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`pagination` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `pagination`;

/*Table structure for table `article` */

DROP TABLE IF EXISTS `article`;

CREATE TABLE `article` (
  `id` int(11) NOT NULL auto_increment,
  `title` varchar(250) default NULL,
  `content` longtext,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

/*Data for the table `article` */

insert  into `article`(`id`,`title`,`content`) values (1,'Paid Notice: Deaths  BLUMENTHAL, MARTIN','BLUMENTHAL--Martin. A New York business man and philanthropist, died last Saturday in Manhattan after a long illness. He was 90. Mr. Blumenthal was born in Frankfurt, Germany and immigrated to New York City in 1935. He was President of A.J. Hollander and Company, a commodities trading firm. After retirement he devoted himself to philanthropic activities. He was a trustee of the YMHA and served as chairman of Bezalel, a charitable organization that supports the arts in Israel. He was also active in Human Rights Watch. Mr. Blumenthal is survived by his wife, Sallie Blumenthal, his children Richard of Greenwich and David of Boston, six grandchildren, his brother Fred and his sister, Edith Levisohn. His first wife Jane died in 1969. Funeral will take place at Riverside Chapel at 11:30am, Tuesday January 2nd. $(6$)BLUMENTHAL--Martin. Park Avenue Synagogue mourns the passing of a devoted congregant. We extend to his wife Sally and the entire family our heartfelt sympathy. May his memory remain for a blessing. David H. Lincoln, Sr. Rabbi Amy AB Bressman, Chairman of the Board Menachem Z. Rosensaft, President'),(2,'Paid Notice: Deaths   BRADLEY, CAROL L.','BRADLEY--Carol L., 84, of Tinton Falls, NJ died peacefully at Seabrook Village on December 27. Beloved wife of Floyd (Pete) Bradley, Jr.; loving mother of Steven, Floyd and Lynette Bradley; adored grandmother of Victoria Kent and Camilla, William and Melissa Bradley; caring stepgrandmother of Matthew and Charlton Field.'),(3,'Paid Notice: Deaths   CRAWFORD, PERRY JR.','CRAWFORD--Perry Jr., died at 89 on December 13th, 2006 after a brief illness. Beloved husband of the late Marguerite (Peggy) Murtagh, beloved father of Perry III, Betsey, Susan, Connie, and Ann. A founding member of the computer industry, his \'\'fearless and imaginative jumps into the future\'\' established the foundations for digital computing in 1942, contributed to Project Whirlwind, designed the SABRE System for American Airlines , foresaw danger as the industry deviated from \'\'accounting and engineering principles,\'\' and envisioned \'\'a whole new way of understanding\'\' for us all. Memorial services in Milwaukee in January (for family), and for friends and family in Croton-on-Hudson in the spring.'),(4,'Paid Notice: Deaths   FLOOD, ROBERT FRANCIS','FLOOD--Robert Francis, husband of the late Catherine Byrnes Flood, died on December 28, 2006 at his residence, Meadow Lakes in Hightstown, New Jersey. He lived in Larchmont, NY and Boynton Beach, FL. He was 94 years old. Mr. Flood was a graduate of the Iona School in New Rochelle, NY. He graduated from Massachusetts Institute of Technology in 1935. He joined the Union Carbide Corporation in 1935 and became President of the Linde Division in 1962. He retired in 1977 from Union Carbide as a Corporate Vice President. He served on boards and advisory committees for many institutions including Rosemont College, the University of Notre Dame, the Massachusetts Institute of Technology, and Trinity Missions. He was a member of Pine Valley and Winged Foot Golf Clubs, Larchmont Yacht Club and the University Club of New York. He was the son of the late Julia and Maurice Flood of New Rochelle, NY. He is survived by his seven children, their spouses, 17 grandchildren and eight greatgrandchildren. Donations may be made in his memory to Catholic Charities.'),(5,'Paid Notice: Deaths   GEISLER, ENID (FRIEDMAN)','GEISLER--Enid (Friedman), on December 29, 2006. Beloved wife, devoted mother, grandmother and sister-inlaw. She is survived by her husband Mortimer Geisler and children, Iris Horowitz, Daniel Friedman, Steven, Warren, Edward and Jayne Geisler, son and daughters-inlaw, Steven Horowitz, Holly Friedman, Carla, Beverly, and Kathi Geisler, 11 grandchildren, Lee and Pamela Horowitz, Lindsay, Amanda and Paul L. Friedman, Seth, Joshua, Sarah, Julia, Andrew and Michelle Geisler, nieces, nephews, grandnieces and nephews and sister-in-law Harriet Ansell. She is also predeceased by her husband Lawrence Friedman, son Paul Richard Friedman and brother Leonard Ansell. Funeral on Wednesday, January 3, at 11:00am at Gutterman\'s, Woodbury, NY.'),(6,'Paid Notice: Deaths   GIUDICE, EMILY','GIUDICE--Emily, 94 of Ridgewood, NJ died December 31, 2006. She is survived by her husband Dr. Vincent Giudice and her sons Chris, Cliff and Russ Jacobs. Services C.C. Van Emburgh Funeral Home, Ridgewood, NJ.'),(7,'Paid Notice: Deaths   HIRSCH, TRUDE','HIRSCH--Trude, born in Vienna, Austria. Beloved wife of 64 years of Charles. Beacon of strength to her sons Howard and Kenneth. Adored grandmother of Brian and Douglas. High spirited friend of many. December 25, she will be sorely missed by all.');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
