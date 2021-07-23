/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50732
Source Host           : localhost:3306
Source Database       : jwt

Target Server Type    : MYSQL
Target Server Version : 50732
File Encoding         : 65001

Date: 2021-07-23 17:30:44
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
-- Table structure for filesmanage
-- ----------------------------
DROP TABLE IF EXISTS `filesmanage`;
CREATE TABLE `filesmanage` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `filename` varchar(255) DEFAULT NULL COMMENT '文件名',
  `savename` varchar(255) DEFAULT NULL COMMENT '文件存储名称',
  `filepath` varchar(255) DEFAULT NULL COMMENT '文件存储路径',
  `creater` varchar(255) DEFAULT NULL COMMENT '创建人',
  `createime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of filesmanage
-- ----------------------------
INSERT INTO `filesmanage` VALUES ('1', '测试', null, null, null, null);

-- ----------------------------
-- Table structure for sys_task
-- ----------------------------
DROP TABLE IF EXISTS `sys_task`;
CREATE TABLE `sys_task` (
  `id` varchar(100) NOT NULL,
  `job_name` varchar(255) DEFAULT NULL COMMENT '任务名',
  `description` varchar(255) DEFAULT NULL COMMENT '任务描述',
  `cron_expression` varchar(255) DEFAULT NULL COMMENT 'cron表达式',
  `bean_class` varchar(255) DEFAULT NULL COMMENT '任务执行时调用哪个类的方法 包名+类名',
  `job_status` varchar(255) DEFAULT NULL COMMENT '任务状态',
  `job_group` varchar(255) DEFAULT NULL COMMENT '任务分组',
  `create_user` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_task
-- ----------------------------
INSERT INTO `sys_task` VALUES ('1', 'QuertzTask1', 'Quertz定时器测试一', '0/10 * * * * ?', 'com.example.demo.Quertz.TestQuertzTask', '1', 'group', null, null, null, null);

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
