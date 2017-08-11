/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50173
Source Host           : 127.0.0.1:20001
Source Database       : javaweb_test

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2017-08-07 16:50:26
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
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of commodity
-- ----------------------------
INSERT INTO `commodity` VALUES ('1', 'A', '1.00', '100');
INSERT INTO `commodity` VALUES ('2', 'B', '2.50', '50');
INSERT INTO `commodity` VALUES ('3', 'C', '5.00', '16');
INSERT INTO `commodity` VALUES ('4', 'D', '3.00', '32');
