/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50515
Source Host           : localhost:3306
Source Database       : jwt

Target Server Type    : MYSQL
Target Server Version : 50515
File Encoding         : 65001

Date: 2020-05-24 01:52:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `id` varchar(32) NOT NULL,
  `pid` varchar(32) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `level` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('1', '0', '中国', '0');
INSERT INTO `dept` VALUES ('10', '1', '福建省', '1');
INSERT INTO `dept` VALUES ('11', '1', '江西省', '1');
INSERT INTO `dept` VALUES ('12', '1', '山东省', '1');
INSERT INTO `dept` VALUES ('13', '1', '河南省', '1');
INSERT INTO `dept` VALUES ('14', '1', '湖北省', '1');
INSERT INTO `dept` VALUES ('15', '1', '湖南省', '1');
INSERT INTO `dept` VALUES ('16', '1', '广东省', '1');
INSERT INTO `dept` VALUES ('17', '1', '海南省', '1');
INSERT INTO `dept` VALUES ('18', '1', '四川省', '1');
INSERT INTO `dept` VALUES ('19', '1', '贵州省', '1');
INSERT INTO `dept` VALUES ('2', '1', '河北省', '1');
INSERT INTO `dept` VALUES ('20', '1', '云南省', '1');
INSERT INTO `dept` VALUES ('21', '1', '陕西省', '1');
INSERT INTO `dept` VALUES ('22', '1', '甘肃省', '1');
INSERT INTO `dept` VALUES ('23', '1', '青海省', '1');
INSERT INTO `dept` VALUES ('24', '1', '台湾省', '1');
INSERT INTO `dept` VALUES ('25', '16', '广州市', '2');
INSERT INTO `dept` VALUES ('26', '16', '韶关市', '2');
INSERT INTO `dept` VALUES ('27', '16', '深圳市', '2');
INSERT INTO `dept` VALUES ('3', '1', '山西省', '1');
INSERT INTO `dept` VALUES ('4', '1', '辽宁省', '1');
INSERT INTO `dept` VALUES ('5', '1', '吉林省', '1');
INSERT INTO `dept` VALUES ('6', '1', '黑龙江省', '1');
INSERT INTO `dept` VALUES ('7', '1', '江苏省', '1');
INSERT INTO `dept` VALUES ('8', '1', '浙江省', '1');
INSERT INTO `dept` VALUES ('9', '1', '安徽省', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(45) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'admin');
