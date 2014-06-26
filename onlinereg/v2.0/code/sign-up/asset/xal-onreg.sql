/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50511
Source Host           : 127.0.0.1:3306
Source Database       : xal-onreg

Target Server Type    : MYSQL
Target Server Version : 50511
File Encoding         : 65001

Date: 2014-06-26 14:29:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `s_mgr`
-- ----------------------------
DROP TABLE IF EXISTS `s_mgr`;
CREATE TABLE `s_mgr` (
  `username` varchar(255) NOT NULL DEFAULT '',
  `userpass` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_mgr
-- ----------------------------
INSERT INTO `s_mgr` VALUES ('admin', 'xal123');

-- ----------------------------
-- Table structure for `s_user`
-- ----------------------------
DROP TABLE IF EXISTS `s_user`;
CREATE TABLE `s_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `userpass` varchar(255) DEFAULT NULL,
  `realname` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `idcard` varchar(255) DEFAULT NULL,
  `zzmm` varchar(255) DEFAULT NULL,
  `mz` varchar(255) DEFAULT NULL,
  `jg` varchar(255) DEFAULT NULL,
  `byyx` varchar(255) DEFAULT NULL,
  `bysj` date DEFAULT NULL,
  `xl` varchar(255) DEFAULT NULL,
  `zy` varchar(255) DEFAULT NULL,
  `gzdw` varchar(255) DEFAULT NULL,
  `szbm` varchar(255) DEFAULT NULL,
  `cszy` varchar(255) DEFAULT NULL,
  `zw` varchar(255) DEFAULT NULL,
  `zc` varchar(255) DEFAULT NULL,
  `lxdh` varchar(255) DEFAULT NULL,
  `lxdz` varchar(255) DEFAULT NULL,
  `regtime` datetime DEFAULT NULL,
  `costitem` varchar(255) DEFAULT NULL COMMENT '费用项，逗号分割',
  `isPass` int(11) DEFAULT NULL,
  `zgzs` varchar(2048) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_user
-- ----------------------------
INSERT INTO `s_user` VALUES ('1', 'haha', '11', '张三', '男', 'sdds', '民革党员', '壮族', '湖北', 'null', '2011-01-20', '博士', 'null', 'null', 'null', 'null', 'null', 'null', 'null', 'null', null, '1,2', '1', '21');
INSERT INTO `s_user` VALUES ('2', 'haha1', '121', '姓名', '男', '身份证号', '中共党员', '汉族', '北京', '毕业院校', '2014-06-07', '大专', '专业', '工作单位', '所在部门', '从事专业', '职位', '职称', '联系电话', '联系地址', '2014-06-24 10:19:05', null, '1', ' ');
INSERT INTO `s_user` VALUES ('3', 'haha2', '111', '姓名', '男', '身份证号', '中共党员', '汉族', '北京', '毕业院校', '2014-06-07', '大专', '专业', '工作单位', '所在部门', '从事专业', '职位', '职称', '联系电话', '联系地址', '2014-06-24 10:23:20', null, '2', ' ');
INSERT INTO `s_user` VALUES ('4', 'haha3', '1212', '姓名', '男', '身份证号', '中共党员', '汉族', '北京', '毕业院校', '2014-06-07', '大专', '专业', '工作单位', '所在部门', '从事专业', '职位', '职称', '联系电话', '联系地址', '2014-06-24 10:30:19', null, '1', ' ');
INSERT INTO `s_user` VALUES ('5', 'haha4', '1', '姓名', '男', '身份证号', '中共党员', '汉族', '北京', '毕业院校', '2014-06-07', '大专', '专业', '工作单位', '所在部门', '从事专业', '职位', '职称', '联系电话', '联系地址', '2014-06-24 10:31:06', '1,2,3', '2', ' ');
INSERT INTO `s_user` VALUES ('6', 'sdsd', '1212', '', '男', '', '中共党员', '汉族', '河南', '', null, '本科', '', '', '', '', '', '', '', '', '2014-06-24 17:44:50', '', '1', ' ');
INSERT INTO `s_user` VALUES ('7', 'asdf', '1', '', '男', '', '中共党员', '汉族', '河南', '', null, '本科', '', '', '', '', '', '', '', '', '2014-06-25 09:07:18', '', '0', ' ');
INSERT INTO `s_user` VALUES ('8', 'fasd', '1', 'dsf', '男', 'sdf', '中共党员', '汉族', '河南', 'sdf', '2014-06-14', '本科', 'sdf', 'fsd', 'sdf', 'sdf', '', 'sdf', 'dsf', '', '2014-06-25 09:08:45', '1,3,6', '2', '  ');
INSERT INTO `s_user` VALUES ('9', 'sdfds', '1', 'a', '男', 'sd', '中共党员', '汉族', '河南', 's', null, '本科', 's', 's', 's', 's', '', 's', 's', '', '2014-06-25 09:17:43', '', '2', ' ');
INSERT INTO `s_user` VALUES ('12', 'dsds', '11', '1', '男', '1', '中共党员', '汉族', '河南', '11', '2014-05-29', '本科', '11', '1', '1', '1', '', '1', 's', '', '2014-06-25 15:24:02', '', '0', 'dsfsdf');
INSERT INTO `s_user` VALUES ('13', 'das', '1', 'asdfsd', '男', 'sd', '中共党员', '汉族', '河南', 'sd', '2014-06-04', '本科', 'ds', 'sd', 'ds', 'ds', '', 'ds', 'ds', '', '2014-06-25 15:29:11', '1', '1', 'dsds');
INSERT INTO `s_user` VALUES ('14', 'sdf', '11', '1', '男', '1', '中共党员', '汉族', '河南', '1', '2014-06-04', '本科', '1', '1', '1', '1', '', '1', '1', '', '2014-06-25 16:00:53', '1', '0', '1');

-- ----------------------------
-- Table structure for `t_costitem`
-- ----------------------------
DROP TABLE IF EXISTS `t_costitem`;
CREATE TABLE `t_costitem` (
  `id` int(11) NOT NULL,
  `itemname` varchar(255) DEFAULT NULL,
  `daynum` varchar(255) DEFAULT NULL,
  `cost` varchar(255) DEFAULT NULL,
  `costunit` varchar(255) DEFAULT NULL COMMENT '价格单位',
  `comment` varchar(255) DEFAULT NULL,
  `comment2` varchar(2048) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_costitem
-- ----------------------------
INSERT INTO `t_costitem` VALUES ('1', '安全评价从入门到精通培训（实习课程）', '1个月', '3000', '元', '安全评价从入门到精通培训（实习课程）', '实用——手把手解读教您写报告，解读法律法规，熟悉要求，助你熟悉行业禁忌。&#10;实战——数十年专业经验的专家，送你一双火眼金睛，教你熟悉8大行业和危化的工艺、流程，划分评价单元，辨识危险有害因素，报告结论出具。&#10;实练——一个月一对二专业教练辅导演练，将知识溶为能力。');
INSERT INTO `t_costitem` VALUES ('2', '安全评价从入门到精通培训（面授课程）', '3', '2980', '元/人', '安全评价从入门到精通培训（面授课程）', '1.入门与展望。&#10;2.手把手教写报告。&#10;3.火眼金睛找隐患。');
INSERT INTO `t_costitem` VALUES ('3', '住宿（单间）', '-', '120', '元/间•天', '住宿（单间）', '由于宾馆房间有限，请参加培训人员在网上报名时选定预定的房间情况（合住、单住），以便会务组统一安排与调整。');
INSERT INTO `t_costitem` VALUES ('4', '住宿（二人间）', '-', '176', '元/间•天', '住宿（二人间）', '由于宾馆房间有限，请参加培训人员在网上报名时选定预定的房间情况（合住、单住），以便会务组统一安排与调整。');
INSERT INTO `t_costitem` VALUES ('5', '住宿（三人间）', '-', '200', '元/间•天', '住宿（三人间）', '由于宾馆房间有限，请参加培训人员在网上报名时选定预定的房间情况（合住、单住），以便会务组统一安排与调整。');
INSERT INTO `t_costitem` VALUES ('6', '自助餐', '-', '80', '元/人•天', '自助餐', '');

-- ----------------------------
-- Table structure for `t_lesson`
-- ----------------------------
DROP TABLE IF EXISTS `t_lesson`;
CREATE TABLE `t_lesson` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_lesson
-- ----------------------------
