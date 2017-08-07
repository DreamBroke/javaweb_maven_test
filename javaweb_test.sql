/*
Navicat MySQL Data Transfer

Source Server         : 192.168.1.145
Source Server Version : 50173
Source Host           : 192.168.1.145:20001
Source Database       : javaweb_test

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2017-08-07 11:33:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `commodity`
-- ----------------------------
DROP TABLE IF EXISTS `commodity`;
CREATE TABLE `commodity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `price` double(10,2) NOT NULL,
  `quantity` int(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of commodity
-- ----------------------------
