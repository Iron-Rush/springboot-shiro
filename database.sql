/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 80020
Source Host           : localhost:3306
Source Database       : ssm

Target Server Type    : MYSQL
Target Server Version : 80020
File Encoding         : 65001

Date: 2020-06-01 16:52:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int unsigned NOT NULL AUTO_INCREMENT,
  `uname` varchar(255) NOT NULL,
  `upwd` varchar(255) NOT NULL,
  `usex` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `utext` varchar(255) DEFAULT NULL,
  `ucdate` varchar(30) NOT NULL,
  `uldate` varchar(30) NOT NULL,
  `perms` varchar(50) DEFAULT NULL,
  `role` varchar(50) DEFAULT NULL,
  `pid` int DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '猪', '123', '母', null, '20200521', '20200521', null, null, null);
INSERT INTO `user` VALUES ('2', 'carendule', '12', null, null, '2020-05-21 16:55:04', '2020-05-21 16:55:04', null, null, null);
INSERT INTO `user` VALUES ('6', 'carendule222', '12', null, null, '2020-05-25 10:08:15', '2020-05-25 10:08:15', null, null, null);
INSERT INTO `user` VALUES ('8', 'carendule12', 'ooo', null, null, '2020-05-25 17:59:42', '2020-05-25 17:59:42', null, null, null);
INSERT INTO `user` VALUES ('9', 'caren', 'qq123', null, null, '2020-05-26 10:04:12', '2020-05-26 10:04:12', null, null, null);
INSERT INTO `user` VALUES ('10', 'dudula', 'qq123', null, null, '2020-05-28 10:17:21', '2020-05-28 10:17:21', 'user:add', 'manager', '1');
INSERT INTO `user` VALUES ('11', 'jack', 'qq123', null, null, '2020-05-28 10:21:13', '2020-05-28 10:21:13', 'user:update', 'user', '12');
INSERT INTO `user` VALUES ('12', 'dudula2', 'rewq', null, null, '2020-05-28 10:29:38', '2020-05-28 10:29:38', null, null, null);
INSERT INTO `user` VALUES ('13', 'caren23', '12', null, null, '2020-05-28 11:50:17', '2020-05-28 11:50:17', null, null, null);
INSERT INTO `user` VALUES ('14', '老板', '66', null, null, '2020-05-29 13:40:53', '2020-05-29 13:40:53', null, null, null);

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user_power
-- ----------------------------
DROP TABLE IF EXISTS `user_power`;
CREATE TABLE `user_power` (
  `pid` int unsigned NOT NULL,
  `perm` varchar(50) NOT NULL,
  `pcontext` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_power
-- ----------------------------
INSERT INTO `user_power` VALUES ('1', 'user:add', '添加用户权限');
INSERT INTO `user_power` VALUES ('1', 'user:update', '更新用户权限');
INSERT INTO `user_power` VALUES ('1', 'user:delete', '删除用户权限');
INSERT INTO `user_power` VALUES ('1', 'user:select', '查询用户权限');
INSERT INTO `user_power` VALUES ('11', 'user:add', '添加用户权限');
INSERT INTO `user_power` VALUES ('12', 'user:update', '更新用户权限');
INSERT INTO `user_power` VALUES ('13', 'user:delete', '删除用户权限');
INSERT INTO `user_power` VALUES ('10', 'user:select', '查询用户权限');
INSERT INTO `user_power` VALUES ('11', 'user:select', '查询用户权限');
INSERT INTO `user_power` VALUES ('12', 'user:select', '查询用户权限');
INSERT INTO `user_power` VALUES ('13', 'user:select', '查询用户权限');
INSERT INTO `user_power` VALUES ('2', 'emp:add', '添加员工权限');
INSERT INTO `user_power` VALUES ('2', 'emp:update', '更新员工权限');
INSERT INTO `user_power` VALUES ('2', 'emp:delete', '删除员工权限');
INSERT INTO `user_power` VALUES ('2', 'emp:select', '查询员工权限');
INSERT INTO `user_power` VALUES ('20', 'emp:select', '查询员工权限');
INSERT INTO `user_power` VALUES ('21', 'emp:select', '查询员工权限');
INSERT INTO `user_power` VALUES ('21', 'emp:add', '添加员工权限');
INSERT INTO `user_power` VALUES ('22', 'emp:select', '查询员工权限');
INSERT INTO `user_power` VALUES ('22', 'emp:update', '更新员工权限');
INSERT INTO `user_power` VALUES ('23', 'emp:select', '查询员工权限');
INSERT INTO `user_power` VALUES ('23', 'emp:delete', '删除员工权限');

