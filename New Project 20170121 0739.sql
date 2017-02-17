-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.6.21-log


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema ypeb
--

CREATE DATABASE IF NOT EXISTS ypeb;
USE ypeb;

--
-- Definition of table `address`
--

DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userID` int(10) unsigned NOT NULL COMMENT '用户ID',
  `address` varchar(60) NOT NULL COMMENT '收货地址',
  `name` varchar(20) NOT NULL COMMENT '收货人',
  `telephone` varchar(11) NOT NULL COMMENT '电话',
  `isDelete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除状态',
  PRIMARY KEY (`id`),
  KEY `FK_address_user` (`userID`),
  CONSTRAINT `FK_address_user` FOREIGN KEY (`userID`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='收货地址表';

--
-- Dumping data for table `address`
--

/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` (`id`,`userID`,`address`,`name`,`telephone`,`isDelete`) VALUES 
 (1,1,'临沂市兰山区金谷大酒店','赛捷收','14234343434',0),
 (3,2,'临沂市兰山区金谷大酒店','赛捷收','14234343434',0),
 (4,1,'某某地址','某某人','23232323232',1),
 (5,1,'特瓦飞洒发','小明','3234242432',1);
/*!40000 ALTER TABLE `address` ENABLE KEYS */;


--
-- Definition of table `advertisement`
--

DROP TABLE IF EXISTS `advertisement`;
CREATE TABLE `advertisement` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL COMMENT '标题，名称',
  `descripe` varchar(45) NOT NULL COMMENT '描述',
  `url` varchar(45) NOT NULL COMMENT '广告图片地址',
  `type` int(10) unsigned NOT NULL COMMENT '广告类型，0为首页广告，1为其他页面左侧广告',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='广告表';

--
-- Dumping data for table `advertisement`
--

/*!40000 ALTER TABLE `advertisement` DISABLE KEYS */;
INSERT INTO `advertisement` (`id`,`name`,`descripe`,`url`,`type`) VALUES 
 (1,'test1','test1','ad1.png',0),
 (2,'test2','test2','ad2.png',0),
 (4,'test','tweetewterewqrewqr','1484531181345activity.jpg',1),
 (5,'test2','weqrewq','1484531658017activity.jpg',1);
/*!40000 ALTER TABLE `advertisement` ENABLE KEYS */;


--
-- Definition of table `announcement`
--

DROP TABLE IF EXISTS `announcement`;
CREATE TABLE `announcement` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL COMMENT '公告标题',
  `content` text NOT NULL COMMENT '公告内容',
  `time` datetime NOT NULL COMMENT '发布日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='公告';

--
-- Dumping data for table `announcement`
--

/*!40000 ALTER TABLE `announcement` DISABLE KEYS */;
INSERT INTO `announcement` (`id`,`title`,`content`,`time`) VALUES 
 (1,'test1','test','2016-09-08 12:00:00'),
 (2,'title','mini(迷你)湿哒哒','2017-01-16 01:52:06');
/*!40000 ALTER TABLE `announcement` ENABLE KEYS */;


--
-- Definition of table `award`
--

DROP TABLE IF EXISTS `award`;
CREATE TABLE `award` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `getAwardID` int(10) unsigned NOT NULL COMMENT '获得奖励的ID',
  `level` smallint(5) unsigned NOT NULL COMMENT '推荐奖类型，1为直返积分，2为一级团队奖，3为2级团队奖',
  `time` datetime NOT NULL COMMENT '奖励时间',
  `num` decimal(10,2) NOT NULL COMMENT '奖励数量',
  `sourceID` int(10) unsigned NOT NULL COMMENT '奖励来源ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='推荐积分奖励表';

--
-- Dumping data for table `award`
--

/*!40000 ALTER TABLE `award` DISABLE KEYS */;
/*!40000 ALTER TABLE `award` ENABLE KEYS */;


--
-- Definition of table `bankcard`
--

DROP TABLE IF EXISTS `bankcard`;
CREATE TABLE `bankcard` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userID` int(10) unsigned NOT NULL COMMENT '用户ID',
  `cardNum` varchar(30) NOT NULL COMMENT '卡号',
  `bankName` varchar(45) NOT NULL COMMENT '开户银行',
  `name` varchar(45) NOT NULL COMMENT '开户人名称',
  `isDelete` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_bankCard_user` (`userID`),
  CONSTRAINT `FK_bankCard_user` FOREIGN KEY (`userID`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='银行卡信息';

--
-- Dumping data for table `bankcard`
--

/*!40000 ALTER TABLE `bankcard` DISABLE KEYS */;
/*!40000 ALTER TABLE `bankcard` ENABLE KEYS */;


--
-- Definition of table `cash`
--

DROP TABLE IF EXISTS `cash`;
CREATE TABLE `cash` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userID` int(10) unsigned NOT NULL COMMENT '用户ID',
  `num` decimal(10,2) NOT NULL COMMENT '数额',
  `time` datetime NOT NULL COMMENT '操作时间',
  `operator` int(10) unsigned NOT NULL COMMENT '操作员',
  `operate` tinyint(1) NOT NULL COMMENT '操作，1充值，0提现',
  `state` smallint(5) unsigned NOT NULL COMMENT '操作进度，1为申请中，2为完成，3为失效',
  `webChat` varchar(45) DEFAULT NULL COMMENT '微信号',
  `rate` double DEFAULT NULL COMMENT '手续费率',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='现金账户操作记录表';

--
-- Dumping data for table `cash`
--

/*!40000 ALTER TABLE `cash` DISABLE KEYS */;
INSERT INTO `cash` (`id`,`userID`,`num`,`time`,`operator`,`operate`,`state`,`webChat`,`rate`) VALUES 
 (1,1,'1000.00','2017-01-16 16:51:03',1,1,3,'',0),
 (2,1,'1000.00','2017-01-16 16:51:03',1,1,2,'',0),
 (3,1,'1000.00','2017-01-16 16:51:03',1,1,1,'',0),
 (4,1,'1000.00','2017-01-16 16:51:03',1,0,2,'',0.1),
 (5,1,'1000.00','2017-01-16 16:51:03',1,1,2,NULL,0),
 (6,1,'1000.00','2017-01-16 16:51:03',1,0,1,NULL,0.1),
 (7,1,'1000.00','2017-01-16 16:51:03',1,0,3,NULL,0.1),
 (8,1,'1000.00','2017-01-16 16:51:03',1,0,2,NULL,0.1);
/*!40000 ALTER TABLE `cash` ENABLE KEYS */;


--
-- Definition of table `goods`
--

DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL COMMENT '商品名称',
  `specification` text COMMENT '商品规格',
  `description` text COMMENT '商品描述',
  `imageUrl1` varchar(45) DEFAULT NULL COMMENT '产品图片地址',
  `price` decimal(11,2) NOT NULL COMMENT '销售价格',
  `givePoints` double NOT NULL COMMENT '赠送积分',
  `discountPrice` decimal(11,2) NOT NULL COMMENT '商城会员价格',
  `category1` int(10) unsigned NOT NULL COMMENT '商品一级栏目',
  `isShow` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否在首页展示',
  `purchacePrice` decimal(11,2) NOT NULL COMMENT '进货价格',
  `attribute` varchar(10) NOT NULL COMMENT '商品属性',
  `imageUrl2` varchar(45) DEFAULT NULL COMMENT '商品图片2',
  `imageUrl3` varchar(45) DEFAULT NULL COMMENT '图片3',
  `imageUrl4` varchar(45) DEFAULT NULL COMMENT '图片4',
  `imageUrl5` varchar(45) DEFAULT NULL COMMENT '图片5',
  `code` varchar(45) NOT NULL COMMENT '商品编码',
  `secondCateg` int(10) unsigned DEFAULT NULL COMMENT '二级栏目',
  `thirdCateg` int(10) unsigned DEFAULT NULL COMMENT '三级栏目',
  `category2` int(10) unsigned DEFAULT NULL COMMENT '商品2级栏目',
  `timeMark` varchar(45) DEFAULT NULL COMMENT '时间戳',
  `telephone` varchar(12) DEFAULT NULL COMMENT '处理人电话',
  `linkMan` varchar(20) DEFAULT NULL COMMENT '联系人',
  `webChat` varchar(45) DEFAULT NULL COMMENT '微信号',
  `isDelete` tinyint(1) NOT NULL DEFAULT '0',
  `category2Name` varchar(45) DEFAULT NULL COMMENT '二级栏目名',
  PRIMARY KEY (`id`),
  KEY `FK_goods_goodscategory` (`category1`) USING BTREE,
  CONSTRAINT `FK_goods_category` FOREIGN KEY (`category1`) REFERENCES `goodscategory` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COMMENT='商品表';

--
-- Dumping data for table `goods`
--

/*!40000 ALTER TABLE `goods` DISABLE KEYS */;
INSERT INTO `goods` (`id`,`name`,`specification`,`description`,`imageUrl1`,`price`,`givePoints`,`discountPrice`,`category1`,`isShow`,`purchacePrice`,`attribute`,`imageUrl2`,`imageUrl3`,`imageUrl4`,`imageUrl5`,`code`,`secondCateg`,`thirdCateg`,`category2`,`timeMark`,`telephone`,`linkMan`,`webChat`,`isDelete`,`category2Name`) VALUES 
 (1,'test1','1','1','shoe_4.png','1.00',1,'1.00',1,1,'1.00','123232','shoe_4.png','shoe_4.png','shoe_4.png','shoe_4.png','43254325432543',1,NULL,2,'',NULL,NULL,NULL,0,NULL),
 (3,'1','1','<img src=\"/../upload/image/goods/1484494784979/1484495556139appliance_1.png\" alt=\"\" />如果内容编辑器中上传过图片<img src=\"/../upload/image/goods/1484494784979/1484495564171appliance_5.png\" alt=\"\" />，但想取消编辑或，请不要直接点击取消，先点击保存，再删除该记录','1484495586955appliance_1.png','1.00',1,'1.00',3,1,'1.00','1',NULL,NULL,NULL,NULL,'1',1,NULL,2,'1484494784979',NULL,NULL,NULL,1,NULL),
 (4,'1','1','<img src=\"/../upload/image/goods/1484496932951/1484496999847appliance_1.png\" alt=\"\" />如果内容编辑器中上传过图片，但想取消编辑或，请不要直接点击取消，先点击保存，再删除该记录','1484497004535appliance_1.png','1.00',1,'1.00',2,1,'1.00','1',NULL,NULL,NULL,NULL,'1',1,NULL,2,'1484496932951',NULL,NULL,NULL,1,NULL),
 (7,'1','1','如果内容编辑器中上传过图片，但想取消编辑或，请不要直接点击取消，先点击保存，再删除该记录','1484497255438appliance_1.png','1.00',1,'1.00',1,0,'1.00','1',NULL,NULL,NULL,NULL,'1',NULL,NULL,2,'1484496932951',NULL,NULL,NULL,0,NULL),
 (8,'1','1','<img src=\"/../upload/image/goods/1484497275541/1484497281000appliance_1.png\" alt=\"\" />如果内容编辑器中上传过图片，但想取消编辑或，请不要直接点击取消，先点击保存，再删除该记录','1484497302606appliance_1.png','1.00',1,'1.00',1,0,'1.00','1',NULL,NULL,NULL,NULL,'1',NULL,NULL,2,'1484497275541',NULL,NULL,NULL,0,NULL),
 (9,'1','1','<img src=\"/../upload/image/goods/1484497468724/1484497476527appliance_1.png\" alt=\"\" />如果内容编辑器中上传过图片，但想取消编辑或，请不要直接点击取消，先点击保存，再删除该记录','1484497478516appliance_1.png','1.00',1,'1.00',1,0,'1.00','1',NULL,NULL,NULL,NULL,'1',NULL,NULL,2,'1484497468724',NULL,NULL,NULL,1,NULL),
 (10,'1','1','<img src=\"/../upload/image/goods/1484497546191/1484497551850appliance_1.png\" alt=\"\" />如果内容编辑器中上传过图片，但想取消编辑或，请不要直接点击取消，先点击保存，再删除该记录','1484497553500appliance_1.png','1.00',1,'1.00',1,0,'1.00','1',NULL,NULL,NULL,NULL,'1',NULL,NULL,2,'1484497546191',NULL,NULL,NULL,0,NULL),
 (11,'1','1','<img src=\"/../upload/image/goods/1484497710325/1484497714879appliance_1.png\" alt=\"\" />如果内容编辑器中上传过图片，但想取消编辑或，请不要直接点击取消，先点击保存，再删除该记录','1484497717189appliance_1.png','1.00',1,'1.00',1,0,'1.00','1',NULL,NULL,NULL,NULL,'1',NULL,NULL,2,'1484497710325',NULL,NULL,NULL,1,NULL),
 (12,'1','1','如果内容编辑器中上传过图片，但想取消编辑或，请不要直接点击取消，先<img src=\"..\\upload\\image\\goods\\1484508633637\\1484508633638appliance_1.png\" alt=\"\" />点击保存，再删除该记录','1484508644193appliance_1.png','1.00',1,'1.00',1,1,'1.00','1',NULL,NULL,NULL,NULL,'1',1,NULL,2,'1484508633637',NULL,NULL,NULL,1,NULL),
 (13,'1','1','<img src=\"..\\upload\\image\\goods\\1484508761050\\1484508761051appliance_1.png\" alt=\"\" />如果内容编辑器中上传过图片，但想取消编辑或，请不要直接点击取消，先点击保存，再删除该记录','1484508845260appliance_1.png','1.00',1,'1.00',1,1,'1.00','1',NULL,NULL,NULL,NULL,'1',1,NULL,2,'1484508761050',NULL,NULL,NULL,1,NULL),
 (14,'test','1','<img src=\"..\\..\\upload\\image\\goods\\1484508957685\\1484508957687appliance_1.png\" alt=\"\" />如果内容编辑器中上传过图片，但想取消编辑或，请不要直接点击取消，先点击保存，再删除该记录','1484508992641appliance_5.png','1.00',1,'1.00',1,0,'1.00','1',NULL,NULL,NULL,NULL,'1',1,NULL,2,'1484508957685',NULL,NULL,NULL,1,NULL),
 (15,'test','1','<base href=\"http://localhost:8080/YPEB/\" /><img src=\"upload\\image\\goods\\1484509242287\\1484509658698appliance_1.png\" alt=\"\" />如果内容编辑器中上传过图片，但想取消编辑或，请不要直接点击取消，先点击保存，再删除该记录','1484509684899appliance_3.png','1.00',1,'1.00',1,1,'1.00','1',NULL,NULL,NULL,NULL,'1',1,NULL,2,'1484509242287',NULL,NULL,NULL,0,NULL),
 (17,'1','1','<base href=\"http://localhost:8080/YPEB/\" /><img src=\"upload\\image\\goods\\1484509784615\\1484509784616clothes_5.png\" alt=\"\" />如果内容编辑器中上传过图片，但想取消编辑或，请不要直接点击取消，先点击保存，再删除该记录','1484509787041appliance_8.png','1.00',1,'1.00',1,1,'1.00','1',NULL,NULL,NULL,NULL,'1',1,NULL,2,'1484509784615',NULL,NULL,NULL,1,NULL),
 (18,'test2','12333333333333333333333333333333534就是大发送到方式发送到放士大夫打方式安抚士大夫十大发送到安抚士大夫都是发送到 发生大发生大放十大发送到安抚十大发送到安抚十大发送','<base href=\"http://localhost:8080/YPEB/\" /><img src=\"upload\\image\\goods\\1484554458728\\1484554458729appliance_1.png\" alt=\"\" />如果内容编辑器中上传过图片，但想取消编辑或，请不要直接点击取消<img src=\"upload\\image\\goods\\1484554458728\\1484554473336appliance_1.png\" alt=\"\" />，先点击保存，再删除该记录士大夫打三是是发生大都是盛世嫡妃多萨夫索达夫索多副三阿斯顿发生朵夫所到阿萨所得税法撒旦士大夫萨芬撒地方的萨芬士大夫打三士大夫摄氏度的手法分手大师 撒帅帅哒范德萨发的所发生的范德萨范德萨十大wqew撒是是第三方三方法十大放SSD涉及到是撒的风景','1484554519124appliance_3.png','1.00',1,'1.00',1,1,'1.00','1',NULL,NULL,NULL,NULL,'1',1,NULL,2,'1484554458728','15612552931','32额外','dsdw',0,NULL),
 (19,'12','121','<base href=\"http://localhost:8080/YPEB/\" />如果内容编辑器中上传过图片，但想取消编辑或，请不要直接点击取消，先点击保存，再删除该记录<img src=\"upload\\image\\goods\\1484758228976\\1484758228979appliance_1.png\" alt=\"\" />','1484758259565appliance_1.png','12.00',21,'12.00',1,0,'1.00','1',NULL,NULL,NULL,NULL,'212',1,NULL,2,NULL,'15621553921','2121','211',0,NULL),
 (20,'323','34','<base href=\"http://localhost:8080/YPEB/\" />如果内容编辑器中上传过图片，但想取消编辑或，请不要直接点击取消，先点击保存，再删除该记录','1484758299127appliance_1.png','232.00',23,'32.00',1,0,'3.00','3',NULL,NULL,NULL,NULL,'23',1,NULL,2,NULL,'15621773821','23','232',0,NULL),
 (21,'23','32','<base href=\"http://localhost:8080/YPEB/\" />如果内容编辑器中上传过图片，但想取消编辑或，请不要直接点击取消，先点击保存，再删除该记录','1484758323156appliance_1.png','32.00',32,'32.00',1,0,'32.00','323',NULL,NULL,NULL,NULL,'232',1,NULL,2,NULL,'15621773821','2','33',0,NULL),
 (22,'12','12','<base href=\"http://localhost:8080/YPEB/\" />如果内容编辑器中上传过图片，但想取消编辑或，请不要直接点击取消，先点击保存，再删除该记录','1484758427064appliance_1.png','2.00',21,'21.00',1,0,'21.00','221',NULL,NULL,NULL,NULL,'2',1,NULL,2,NULL,'15621773821','32','211',0,NULL),
 (23,'1','23','<base href=\"http://localhost:8080/YPEB/\" />如果内容编辑器中上传过图片，但想取消编辑或，请不要直接点击取消，先点击保存，再删除该记录','1484758474095appliance_1.png','32.00',32,'32.00',1,0,'32.00','32',NULL,NULL,NULL,NULL,'32',1,NULL,2,NULL,'15621773821','23','23',0,NULL),
 (24,'323','23','<base href=\"http://localhost:8080/YPEB/\" />如果内容编辑器中上传过图片，但想取消编辑或，请不要直接点击取消，先点击保存，再删除该记录','1484758551335appliance_1.png','1.00',32,'122.00',1,0,'3.00','32',NULL,NULL,NULL,NULL,'3',1,NULL,2,NULL,'15621773821','32','23',0,NULL),
 (25,'testwew','ssa','<base href=\"http://localhost:8080/YPEB/\" />如果内容编辑器中上传过图片，但想取消编辑或，请不要直接点击取消，先点击保存，再删除该记录','1484768367681appliance_1.png','2.00',322,'3.00',1,0,'23.00','32',NULL,NULL,NULL,NULL,'32',1,NULL,13,NULL,'3272774832','wwe','we',0,NULL),
 (26,'2','32','<base href=\"http://localhost:8080/YPEB/\" />如果内容编辑器中上传过图片，但想取消编辑或，请不要直接点击取消，先点击保存，再删除该记录','1484769079336appliance_1.png','232.00',223,'32.00',1,0,'323.00','32',NULL,NULL,NULL,NULL,'323',1,NULL,15,NULL,'232332323','23','23',0,'test1.6'),
 (30,'完整测试','规格说明','<base href=\"http://localhost:8080/YPEB/\" /><img src=\"upload\\image\\goods\\1484801393433\\1484801393434appliance_1.png\" alt=\"\" />如果内容编辑器中上传过图片，但想取消编辑或，请不要直接点击取消，先点击保存，再删除该记录','appliance_2.png','23.00',2,'22.50',1,1,'20.00','属性','appliance_3.png','',NULL,NULL,'323232',1,NULL,14,'1484801393433','2323233233','某某人','ewe232',0,'test1.5'),
 (31,'完整测试2','规格说明11','<base href=\"http://localhost:8080/YPEB/\" /><base href=\"http://localhost:8080/YPEB/\" /><base href=\"http://localhost:8080/YPEB/\" /><base href=\"http://localhost:8080/YPEB/\" /><base href=\"http://localhost:8080/YPEB/\" /><base href=\"http://localhost:8080/YPEB/\" /><p><img src=\"upload\\image\\goods\\1484801597784\\1484801597785appliance_1.png\" alt=\"\" />如果内容编辑</p><p>器中上传<img src=\"upload\\image\\goods\\1484895801162\\1484895801197appliance_5.png\" alt=\"\" />过图片，但想取消<strong>编辑或，请不要直接点击取消，</strong>先点击保存，再删除该记录</p>','1484900044155appliance_4.png','23.00',2,'22.50',1,1,'20.00','2','1484900044157appliance_5.png',NULL,NULL,NULL,'232323',1,NULL,15,NULL,'2332233223','某某人','sad',0,'test1.6');
/*!40000 ALTER TABLE `goods` ENABLE KEYS */;


--
-- Definition of table `goodscategory`
--

DROP TABLE IF EXISTS `goodscategory`;
CREATE TABLE `goodscategory` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL COMMENT '类别名称',
  `isFloor` tinyint(1) NOT NULL COMMENT '是否成首页楼层',
  `level` smallint(5) unsigned NOT NULL COMMENT '几级栏目分类',
  `superID` int(10) unsigned DEFAULT NULL COMMENT '上级栏目',
  `url` varchar(45) DEFAULT NULL COMMENT '图片地址',
  `isDelete` tinyint(1) NOT NULL DEFAULT '0',
  `superName` varchar(45) DEFAULT NULL COMMENT '上级栏目名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COMMENT='商品类别';

--
-- Dumping data for table `goodscategory`
--

/*!40000 ALTER TABLE `goodscategory` DISABLE KEYS */;
INSERT INTO `goodscategory` (`id`,`name`,`isFloor`,`level`,`superID`,`url`,`isDelete`,`superName`) VALUES 
 (1,'家具用品',1,1,NULL,'14847017092831F.png',0,NULL),
 (2,'test1.1',0,2,1,'1484701759827ad1.png',0,NULL),
 (3,'test2',1,1,NULL,'1484467655781floor_3_AD.png',0,NULL),
 (4,'test2.1',0,2,3,'floor_1_ad.png',0,NULL),
 (7,'test3',0,1,NULL,'floor_1_ad.png',0,NULL),
 (10,'test1.2',0,2,1,'floor_1_ad.png',0,NULL),
 (13,'test1.4',0,2,1,'floor_1_ad.png',0,NULL),
 (14,'test1.5',0,2,1,'floor_1_ad.png',0,NULL),
 (15,'test1.6',0,2,1,'floor_1_ad.png',0,NULL),
 (22,'up2',1,1,NULL,'1484467430318floor_2_AD.png',0,NULL),
 (23,'test',1,1,NULL,'1484383906920floor_3_AD.png',0,NULL),
 (28,'up2',1,1,NULL,'1484382877591floor_5_AD.png',0,NULL);
/*!40000 ALTER TABLE `goodscategory` ENABLE KEYS */;


--
-- Definition of table `log`
--

DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `time` datetime NOT NULL COMMENT '操作时间',
  `operator` int(10) unsigned NOT NULL COMMENT '操作员ID',
  `operate` varchar(45) NOT NULL COMMENT '操作',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理员操作日志';

--
-- Dumping data for table `log`
--

/*!40000 ALTER TABLE `log` DISABLE KEYS */;
/*!40000 ALTER TABLE `log` ENABLE KEYS */;


--
-- Definition of table `manager`
--

DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL COMMENT '用户名',
  `role` int(10) unsigned NOT NULL COMMENT '角色ID',
  `realName` varchar(45) NOT NULL COMMENT '真实姓名',
  `telephone` varchar(20) NOT NULL COMMENT '联系方式',
  `isDelete` varchar(45) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `manager_role` (`role`),
  CONSTRAINT `manager_role` FOREIGN KEY (`role`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='管理员表';

--
-- Dumping data for table `manager`
--

/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
INSERT INTO `manager` (`id`,`name`,`role`,`realName`,`telephone`,`isDelete`) VALUES 
 (2,'superManager',1,'test','15621553921','0');
/*!40000 ALTER TABLE `manager` ENABLE KEYS */;


--
-- Definition of table `message`
--

DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userID` int(10) unsigned NOT NULL COMMENT '用户ID',
  `content` text NOT NULL COMMENT '内容',
  `time` datetime NOT NULL COMMENT '提交时间',
  `reply` text COMMENT '回复内容',
  `replyTime` datetime DEFAULT NULL COMMENT '回复时间',
  `isReply` tinyint(1) NOT NULL COMMENT '是否已回复',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='留言表';

--
-- Dumping data for table `message`
--

/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` (`id`,`userID`,`content`,`time`,`reply`,`replyTime`,`isReply`) VALUES 
 (1,1,'留言','2017-01-16 16:51:59','回复','2017-01-16 16:51:59',1),
 (2,1,'刘亚','2017-01-16 16:51:59','回复','2017-01-20 23:48:48',1),
 (3,1,'留言','2017-01-16 16:51:59',NULL,'2017-01-16 16:51:59',0);
/*!40000 ALTER TABLE `message` ENABLE KEYS */;


--
-- Definition of table `order`
--

DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userID` int(10) unsigned NOT NULL COMMENT '用户ID',
  `goodsID` int(10) unsigned DEFAULT NULL COMMENT '商品ID',
  `unit_price` decimal(11,2) DEFAULT NULL COMMENT '单价',
  `num` smallint(5) unsigned DEFAULT NULL COMMENT '赠送积分数量',
  `state` smallint(5) unsigned NOT NULL COMMENT '订单状态,0表示待支付1表示待发货，2表示已发货，3表示完成',
  `totalprice` decimal(12,2) NOT NULL COMMENT '总价',
  `address` int(10) unsigned NOT NULL COMMENT '订单地址ID',
  `style` tinyint(1) NOT NULL DEFAULT '0' COMMENT '订单类型，0为普通会员订单1为商城会员订单。',
  `orderCode` varchar(45) NOT NULL COMMENT '订单号',
  `time` datetime DEFAULT NULL COMMENT '时间',
  `releaseStae` tinyint(1) NOT NULL DEFAULT '0' COMMENT '赠送积分是否释放完毕',
  `releaseState` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='商品订单';

--
-- Dumping data for table `order`
--

/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` (`id`,`userID`,`goodsID`,`unit_price`,`num`,`state`,`totalprice`,`address`,`style`,`orderCode`,`time`,`releaseStae`,`releaseState`) VALUES 
 (1,1,1,'1.00',1,0,'1.00',1,0,'','2016-09-08 12:00:00',0,1),
 (2,1,1,'1.00',1,2,'1.00',1,0,'','2016-09-08 12:00:00',0,1),
 (4,1,1,'1.00',1,2,'1.00',1,0,'','2016-09-08 12:00:00',0,1),
 (5,2,1,'1.00',1,1,'1.00',1,0,'','2016-09-09 12:00:00',0,1),
 (6,1,1,'1.00',1,1,'1.00',1,0,'','2016-09-08 12:00:00',0,1),
 (7,1,1,'1.00',1,2,'1.00',1,0,'','2016-09-08 12:00:00',0,1),
 (8,1,1,'1.00',1,1,'1.00',1,0,'','2016-09-08 12:00:00',0,1),
 (9,1,1,'1.00',1,1,'1.00',1,0,'','2016-09-08 12:00:00',0,1),
 (10,1,1,'1.00',1,1,'1.00',1,0,'','2016-09-08 12:00:00',0,1),
 (11,1,1,'1.00',1,1,'1.00',1,0,'','2016-09-08 12:00:00',0,1),
 (12,1,1,'1.00',1,1,'1.00',1,0,'','2016-09-08 12:00:00',0,1);
/*!40000 ALTER TABLE `order` ENABLE KEYS */;


--
-- Definition of table `ordergoods`
--

DROP TABLE IF EXISTS `ordergoods`;
CREATE TABLE `ordergoods` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `goodsID` int(10) unsigned DEFAULT NULL COMMENT '商品ID',
  `goodsName` varchar(60) DEFAULT NULL COMMENT '商品名',
  `num` int(10) unsigned DEFAULT NULL COMMENT '数量',
  `unitPrice` decimal(10,2) DEFAULT NULL COMMENT '单价',
  `totalPrice` decimal(11,2) DEFAULT NULL COMMENT '总价',
  `orderID` int(10) unsigned NOT NULL COMMENT '订单ID',
  `goodsImage` varchar(60) DEFAULT NULL COMMENT '商品图片',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='订单货物详情表';

--
-- Dumping data for table `ordergoods`
--

/*!40000 ALTER TABLE `ordergoods` DISABLE KEYS */;
INSERT INTO `ordergoods` (`id`,`goodsID`,`goodsName`,`num`,`unitPrice`,`totalPrice`,`orderID`,`goodsImage`) VALUES 
 (1,1,'test1',1,'1.00','1.00',5,NULL);
/*!40000 ALTER TABLE `ordergoods` ENABLE KEYS */;


--
-- Definition of table `points`
--

DROP TABLE IF EXISTS `points`;
CREATE TABLE `points` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userID` int(10) unsigned NOT NULL COMMENT '账户ID',
  `pointNum` decimal(11,2) NOT NULL COMMENT '购买数量',
  `time` datetime NOT NULL COMMENT '购买时间',
  `publishID` int(10) unsigned NOT NULL COMMENT '本次发行编号',
  `state` tinyint(1) NOT NULL COMMENT '是否释放完毕',
  `isDelete` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_points_publishID` (`publishID`),
  CONSTRAINT `FK_points_publishID` FOREIGN KEY (`publishID`) REFERENCES `pointspublish` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户购买发行的积分记录表';

--
-- Dumping data for table `points`
--

/*!40000 ALTER TABLE `points` DISABLE KEYS */;
INSERT INTO `points` (`id`,`userID`,`pointNum`,`time`,`publishID`,`state`,`isDelete`) VALUES 
 (1,1,'1000.00','2017-01-16 16:51:03',1,0,0);
/*!40000 ALTER TABLE `points` ENABLE KEYS */;


--
-- Definition of table `pointsbuy`
--

DROP TABLE IF EXISTS `pointsbuy`;
CREATE TABLE `pointsbuy` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `buyID` int(10) unsigned NOT NULL COMMENT '申请购买者ID',
  `time` datetime NOT NULL COMMENT '申请时间',
  `price` decimal(5,2) NOT NULL COMMENT '单价',
  `num` decimal(11,2) NOT NULL COMMENT '数量',
  `allPrice` decimal(12,2) NOT NULL COMMENT '总价',
  `state` smallint(5) unsigned NOT NULL COMMENT '申请状态，0为未买够，1为已买够，2为取消申请，3为未购买过',
  `residue` double NOT NULL COMMENT '剩余数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='积分系统购买申请';

--
-- Dumping data for table `pointsbuy`
--

/*!40000 ALTER TABLE `pointsbuy` DISABLE KEYS */;
/*!40000 ALTER TABLE `pointsbuy` ENABLE KEYS */;


--
-- Definition of table `pointschange`
--

DROP TABLE IF EXISTS `pointschange`;
CREATE TABLE `pointschange` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `buyID` varchar(45) NOT NULL COMMENT '购买人ID',
  `time` datetime NOT NULL COMMENT '购买时间',
  `num` int(10) unsigned NOT NULL COMMENT '购买数量',
  `pointsID` int(10) unsigned NOT NULL COMMENT '积分编次',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='发行积分变化表';

--
-- Dumping data for table `pointschange`
--

/*!40000 ALTER TABLE `pointschange` DISABLE KEYS */;
/*!40000 ALTER TABLE `pointschange` ENABLE KEYS */;


--
-- Definition of table `pointspublish`
--

DROP TABLE IF EXISTS `pointspublish`;
CREATE TABLE `pointspublish` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `operator` int(10) unsigned NOT NULL COMMENT '操作员ID',
  `time` datetime NOT NULL COMMENT '发行时间',
  `totalNum` decimal(11,2) NOT NULL COMMENT '本次发行总量',
  `residue` decimal(11,2) NOT NULL COMMENT '剩余积分',
  `releaseTime` int(10) unsigned NOT NULL COMMENT '释放次数',
  `state` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否售卖完毕',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='发行积分记录表';

--
-- Dumping data for table `pointspublish`
--

/*!40000 ALTER TABLE `pointspublish` DISABLE KEYS */;
INSERT INTO `pointspublish` (`id`,`operator`,`time`,`totalNum`,`residue`,`releaseTime`,`state`) VALUES 
 (1,1,'2017-01-16 16:51:03','10000.00','9000.00',1,0),
 (2,1,'2017-01-16 16:51:59','10000.00','10000.00',2,0);
/*!40000 ALTER TABLE `pointspublish` ENABLE KEYS */;


--
-- Definition of table `pointsrelease`
--

DROP TABLE IF EXISTS `pointsrelease`;
CREATE TABLE `pointsrelease` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userID` int(10) unsigned NOT NULL COMMENT '用户账号ID',
  `pointsNum` decimal(11,2) NOT NULL COMMENT '待释放总量',
  `releaseTime` smallint(5) unsigned NOT NULL COMMENT '释放需要时间',
  `beginTime` date NOT NULL COMMENT '释放开始日期',
  `source` smallint(5) unsigned NOT NULL COMMENT '积分来源,1为赠送积分，2为消费积分转交易积分，3为现金转消费',
  `releasedT` smallint(5) unsigned NOT NULL COMMENT '已释放次数',
  `isFinish` tinyint(1) NOT NULL COMMENT '是否释放完成',
  `residue` varchar(45) NOT NULL COMMENT '剩余释放额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='积分释放记录表，用户登录时检测该表';

--
-- Dumping data for table `pointsrelease`
--

/*!40000 ALTER TABLE `pointsrelease` DISABLE KEYS */;
/*!40000 ALTER TABLE `pointsrelease` ENABLE KEYS */;


--
-- Definition of table `pointssale`
--

DROP TABLE IF EXISTS `pointssale`;
CREATE TABLE `pointssale` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `saleID` int(10) unsigned NOT NULL COMMENT '申请售卖者ID',
  `time` datetime NOT NULL COMMENT '申请时间',
  `num` decimal(11,2) NOT NULL COMMENT '数量',
  `price` decimal(11,2) NOT NULL COMMENT '单价',
  `allPrice` decimal(11,2) NOT NULL COMMENT '总价',
  `state` smallint(5) unsigned NOT NULL DEFAULT '3' COMMENT '状态，0为未售完，1为售卖完毕，2为取消售卖，3为未售出',
  `residue` smallint(5) unsigned NOT NULL DEFAULT '0' COMMENT '未卖出数量',
  `selectAll` tinyint(1) NOT NULL DEFAULT '1' COMMENT '全部为1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='积分系统售卖申请';

--
-- Dumping data for table `pointssale`
--

/*!40000 ALTER TABLE `pointssale` DISABLE KEYS */;
INSERT INTO `pointssale` (`id`,`saleID`,`time`,`num`,`price`,`allPrice`,`state`,`residue`,`selectAll`) VALUES 
 (1,1,'2016-09-08 12:00:00','2.00','2.00','4.00',3,1,1),
 (2,2,'2016-09-08 12:00:00','100.00','1.00','100.00',0,60,1),
 (3,1,'2016-09-08 12:10:00','3.00','3.00','9.00',3,2,1),
 (4,1,'2016-09-07 12:10:00','80.00','2.00','160.00',3,50,1);
/*!40000 ALTER TABLE `pointssale` ENABLE KEYS */;


--
-- Definition of table `pointtrade`
--

DROP TABLE IF EXISTS `pointtrade`;
CREATE TABLE `pointtrade` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `saleID` int(10) unsigned NOT NULL COMMENT '挂卖者ID',
  `buyID` int(10) unsigned NOT NULL COMMENT '购买者ID',
  `num` decimal(11,2) NOT NULL COMMENT '购买积分数量',
  `price` decimal(11,2) NOT NULL COMMENT '单价（RMB）',
  `allprice` decimal(12,2) NOT NULL COMMENT '总价（RMB）',
  `time` datetime NOT NULL COMMENT '交易时间',
  `iceTime` smallint(5) unsigned NOT NULL COMMENT '冻结期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户交易系统记录表';

--
-- Dumping data for table `pointtrade`
--

/*!40000 ALTER TABLE `pointtrade` DISABLE KEYS */;
/*!40000 ALTER TABLE `pointtrade` ENABLE KEYS */;


--
-- Definition of table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL COMMENT '角色名',
  `super` tinyint(1) NOT NULL DEFAULT '0' COMMENT '超级管理员权限',
  `shopWeb` tinyint(1) NOT NULL DEFAULT '0' COMMENT '商城管理权限',
  `points` tinyint(1) NOT NULL DEFAULT '0' COMMENT '积分系统权限',
  `member` tinyint(1) NOT NULL DEFAULT '0' COMMENT '会员管理权限',
  `order` tinyint(1) NOT NULL DEFAULT '0' COMMENT '订单管理权限',
  `message` tinyint(1) NOT NULL DEFAULT '0' COMMENT '留言管理权限',
  `seeting` tinyint(1) NOT NULL DEFAULT '0' COMMENT '系统设置',
  `trade` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '交易所管理权限',
  `isDelete` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='角色权限表';

--
-- Dumping data for table `role`
--

/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`id`,`name`,`super`,`shopWeb`,`points`,`member`,`order`,`message`,`seeting`,`trade`,`isDelete`) VALUES 
 (1,'super',1,1,1,1,1,1,1,1,0);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;


--
-- Definition of table `roll`
--

DROP TABLE IF EXISTS `roll`;
CREATE TABLE `roll` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `url` varchar(45) NOT NULL COMMENT '图片地址',
  `goodsID` int(10) unsigned NOT NULL COMMENT '商品ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='轮播广告';

--
-- Dumping data for table `roll`
--

/*!40000 ALTER TABLE `roll` DISABLE KEYS */;
INSERT INTO `roll` (`id`,`name`,`url`,`goodsID`) VALUES 
 (1,'test1','banner1.png',1),
 (2,'test2','banner2.png',1),
 (3,'test3','banner3.png',1),
 (4,'test4','banner4.png',1),
 (7,'test','1484399094027banner4.png',1);
/*!40000 ALTER TABLE `roll` ENABLE KEYS */;


--
-- Definition of table `setting`
--

DROP TABLE IF EXISTS `setting`;
CREATE TABLE `setting` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `price` double NOT NULL COMMENT '当前1积分对应RMB价格',
  `month` smallint(5) unsigned NOT NULL COMMENT '现金转积分释放月份',
  `giveDays` smallint(5) unsigned NOT NULL COMMENT '赠送积分解冻天数',
  `consumeDays` smallint(5) unsigned NOT NULL COMMENT '消费积分转交易解冻天数',
  `withdrawRate` double NOT NULL COMMENT '提现手续费比率',
  `firstAward` double NOT NULL COMMENT '一级团队奖励比例',
  `secondAward` double NOT NULL COMMENT '二级团队奖励比例',
  `maxPoints` int(10) unsigned NOT NULL COMMENT '每个会员购买的积分上限',
  `feedbackAward` double NOT NULL COMMENT '直返积分设置',
  `isUsing` tinyint(1) DEFAULT '0' COMMENT '是否启用',
  `isDelete` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统设置表';

--
-- Dumping data for table `setting`
--

/*!40000 ALTER TABLE `setting` DISABLE KEYS */;
INSERT INTO `setting` (`id`,`price`,`month`,`giveDays`,`consumeDays`,`withdrawRate`,`firstAward`,`secondAward`,`maxPoints`,`feedbackAward`,`isUsing`,`isDelete`) VALUES 
 (1,1,1,1,1,1,0.23,0.1,1000,1,1,0);
/*!40000 ALTER TABLE `setting` ENABLE KEYS */;


--
-- Definition of table `shoppingcar`
--

DROP TABLE IF EXISTS `shoppingcar`;
CREATE TABLE `shoppingcar` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userID` int(10) unsigned NOT NULL COMMENT '用户ID',
  `time` datetime DEFAULT NULL COMMENT '加入购物车时间',
  `goodsID` int(10) unsigned NOT NULL COMMENT '商品ID',
  `num` int(10) unsigned DEFAULT NULL COMMENT '商品数量',
  `price` decimal(11,2) DEFAULT NULL COMMENT '单价',
  `allPrice` decimal(12,2) DEFAULT NULL COMMENT '总价',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='购物车';

--
-- Dumping data for table `shoppingcar`
--

/*!40000 ALTER TABLE `shoppingcar` DISABLE KEYS */;
INSERT INTO `shoppingcar` (`id`,`userID`,`time`,`goodsID`,`num`,`price`,`allPrice`) VALUES 
 (1,1,'2016-09-08 12:00:00',1,1,'1.00','1.00'),
 (2,1,NULL,3,1,'1.00','1.00'),
 (3,1,NULL,1,1,'1.00','1.00'),
 (4,1,NULL,1,1,'1.00','1.00'),
 (5,1,NULL,1,1,'1.00','1.00'),
 (6,1,NULL,15,1,NULL,NULL),
 (7,1,NULL,31,1,NULL,NULL);
/*!40000 ALTER TABLE `shoppingcar` ENABLE KEYS */;


--
-- Definition of table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `password` varchar(40) NOT NULL COMMENT '账号密码',
  `payPassword` varchar(40) NOT NULL COMMENT '支付密码',
  `telephone` varchar(11) NOT NULL COMMENT '手机号（登录使用）',
  `name` varchar(45) NOT NULL COMMENT '账户名',
  `province` varchar(10) NOT NULL COMMENT '省',
  `city` varchar(20) NOT NULL COMMENT '市',
  `country` varchar(30) NOT NULL COMMENT '县',
  `IDcard` varchar(20) DEFAULT NULL COMMENT '身份证号',
  `level` smallint(5) unsigned NOT NULL DEFAULT '1' COMMENT '会员级别1为银卡，2为金卡，3为铂金',
  `refferrer` int(10) unsigned DEFAULT NULL COMMENT '推荐人ID',
  `cash` decimal(12,2) DEFAULT '0.00' COMMENT '现金账户金额',
  `usingPoints` decimal(12,2) DEFAULT '0.00' COMMENT '可用积分余额',
  `inforIsFull` tinyint(1) NOT NULL COMMENT '信息是否已经完善，1为完善。',
  `imageURL` varchar(45) DEFAULT NULL COMMENT '头像地址',
  `style` int(10) unsigned NOT NULL COMMENT '会员类型，1为普通会员，2为商城会员',
  `icePoints` decimal(12,2) DEFAULT '0.00' COMMENT '冻结积分余额',
  `tradePoints` decimal(12,2) DEFAULT '0.00' COMMENT '交易积分余额',
  `bankCard` varchar(45) DEFAULT NULL COMMENT '银行卡ID',
  `isDelete` tinyint(1) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`),
  KEY `FK_user_referrerUser` (`refferrer`),
  CONSTRAINT `FK_user_referrerUser` FOREIGN KEY (`refferrer`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户表';

--
-- Dumping data for table `user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`,`password`,`payPassword`,`telephone`,`name`,`province`,`city`,`country`,`IDcard`,`level`,`refferrer`,`cash`,`usingPoints`,`inforIsFull`,`imageURL`,`style`,`icePoints`,`tradePoints`,`bankCard`,`isDelete`) VALUES 
 (1,'e10adc3949ba59abbe56e057f20f883e','123456','18763897759','test1','山东','临沂','临沭','375628990495839011',2,NULL,'1000.00','0.00',0,NULL,1,'0.00','0.00','',0),
 (2,'e10adc3949ba59abbe56e057f20f883e','123456','15621553921','TEST','ä¸æµ·å¸','å¾æ±åº','','32232323232323',2,1,'0.00','1.00',1,NULL,2,'0.00','0.00',NULL,0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
