/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50511
Source Host           : localhost:3306
Source Database       : registration

Target Server Type    : MYSQL
Target Server Version : 50511
File Encoding         : 65001

Date: 2014-06-19 10:53:30
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `ids` varchar(32) DEFAULT NULL,
  `politicsStatus` varchar(10) DEFAULT NULL,
  `nation` varchar(20) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `graduation` varchar(50) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `education` varchar(50) DEFAULT NULL,
  `specialty` varchar(50) DEFAULT NULL,
  `unit` varchar(50) DEFAULT NULL,
  `department` varchar(25) DEFAULT NULL,
  `workoccupation` varchar(50) DEFAULT NULL,
  `job` varchar(20) DEFAULT NULL,
  `professional` varchar(50) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `contactaddress` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=146 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('0000000127', '张俊芳', '男', '123456789012345', '中共党员', '汉族', '地址', '西北大学', '2014-06-25', '本科', '计算机', '鑫安利', '信息部', '软件开发', 'job', '', '132', '范德萨');
INSERT INTO `user` VALUES ('0000000140', '张俊', '男', '1234567890123451', '中共党员', '侗族', '141', '西北大学', null, '10', '', '', '', '', '', '', '', '');
INSERT INTO `user` VALUES ('0000000141', '张否', '男', '123456789012345', '中共党员', '彝族', '141', '西北大学', '2014-06-09', '4', '', '', '', '', '', '', '', '');
INSERT INTO `user` VALUES ('0000000142', '张个', '男', '12345678901234512', '中共党员', '蒙古族', '141', '西北大学', null, '4', '', '', '', '', '', '', '', '');
INSERT INTO `user` VALUES ('0000000143', '历史', '男', '123456789012345', '中共党员', '汉族', '141', '西北大学', null, '4', '', '', '', '', '', '', '', '');
INSERT INTO `user` VALUES ('0000000144', '发电', '男', '123456789012345323', '中共党员', '彝族', '141', '西北大学', null, '4', '', '', '', '', '', '', '', '');
INSERT INTO `user` VALUES ('0000000145', '历史', '男', '1234567890123454', '中共党员', '汉族', '141', '首都师大', null, '4', '', '', '', '', '', '', '', '');
