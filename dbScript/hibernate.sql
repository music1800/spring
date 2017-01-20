/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : hibernate

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2017-01-20 16:57:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `customer`
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `phone` int(11) DEFAULT NULL,
  `married` tinyint(1) DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  `description` longtext,
  `image` tinyblob,
  `timestamp` datetime DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('1', 'ligen', '0', '0', '', null, null, null, '1970-01-01');
INSERT INTO `customer` VALUES ('4', 'ect', '0', '0', '', null, null, null, null);

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `customer_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKC3DF62E5F2D5FD24` (`customer_id`),
  CONSTRAINT `FKC3DF62E5F2D5FD24` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', 'lg1', '1');
INSERT INTO `orders` VALUES ('2', 'lg2', '1');

-- ----------------------------
-- Table structure for `t_login_log`
-- ----------------------------
DROP TABLE IF EXISTS `t_login_log`;
CREATE TABLE `t_login_log` (
  `login_datetine` datetime DEFAULT NULL,
  `ip` varchar(30) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `log_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_login_log
-- ----------------------------
INSERT INTO `t_login_log` VALUES ('2017-01-20 10:58:55', '0:0:0:0:0:0:0:1', '1', '1');
INSERT INTO `t_login_log` VALUES ('2017-01-20 10:59:59', '0:0:0:0:0:0:0:1', '1', '2');
INSERT INTO `t_login_log` VALUES ('2017-01-20 16:52:42', '0:0:0:0:0:0:0:1', '1', '3');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `password` varchar(30) DEFAULT NULL,
  `credits` int(11) DEFAULT NULL,
  `user_name` varchar(30) DEFAULT NULL,
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `last_ip` varchar(30) DEFAULT NULL,
  `last_time` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('123', '25', 'admin', '1', '0:0:0:0:0:0:0:1', '2017-01-20 16:52:42');
