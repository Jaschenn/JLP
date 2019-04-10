/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost
 Source Database       : JLP

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : utf-8

 Date: 04/10/2019 16:51:33 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `data_bk`
-- ----------------------------
DROP TABLE IF EXISTS `data_bk`;
CREATE TABLE `data_bk` (
  `pian` varchar(255) DEFAULT NULL,
  `zhang` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `content` longtext,
  `keyword` varchar(255) DEFAULT NULL,
  `Similar` varchar(255) DEFAULT NULL,
  `uuid` int(255) NOT NULL AUTO_INCREMENT,
  `summarg` varchar(255) DEFAULT NULL,
  `baidu_comp` text,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=256 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
