/*
Navicat MySQL Data Transfer

Source Server         : shangyanfei
Source Server Version : 50521
Source Host           : localhost:3306
Source Database       : newsdb

Target Server Type    : MYSQL
Target Server Version : 50521
File Encoding         : 65001

Date: 2014-11-25 15:53:42
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `newsId` int(11) DEFAULT NULL,
  `content` varchar(500) DEFAULT NULL,
  `writeTime` date DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '1', '啊实打实', '2014-11-25', '0', '30');
INSERT INTO `comment` VALUES ('3', '16', '啊实打实大', '2014-11-25', '0', '55');

-- ----------------------------
-- Table structure for `news`
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `typeId` int(11) DEFAULT NULL,
  `publishTime` date DEFAULT NULL,
  `topper` varchar(1) DEFAULT NULL,
  `bold` varchar(1) DEFAULT NULL,
  `color` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('6', '持续雾霾', '<p>持续雾霾导致出行困难</p>\r\n', '49', '8', '2014-11-18', '1', '0', '3');
INSERT INTO `news` VALUES ('7', '中央关于雾霾治理的通知', '<p>治理雾霾<br />\r\n&nbsp;</p>\r\n', '49', '8', '2014-11-01', '0', '0', '0');
INSERT INTO `news` VALUES ('9', '习大大关于中国领土争端', '<p>解决争端</p>\r\n', '49', '2', '2014-11-14', '0', '1', '0');
INSERT INTO `news` VALUES ('10', '故宫吉祥物', '<p>故宫吉祥物是啥</p>\r\n', '30', '11', '2014-11-18', '0', '0', '0');
INSERT INTO `news` VALUES ('11', '全面开放网吧审批', '<p>文化部、工商部、公安部、工信部近日发布联合通知，全面开放网吧审批。</p>\r\n', '30', '4', '2014-11-01', '1', '0', '3');
INSERT INTO `news` VALUES ('14', '中国钓鱼岛问题', '<p>爱上大声地</p>\r\n', '30', '2', '2014-11-18', '0', '0', '0');
INSERT INTO `news` VALUES ('15', '孙杨吃违禁药', '<p>撒大师大师</p>\r\n', '30', '17', '2014-11-18', '0', '0', '0');
INSERT INTO `news` VALUES ('16', '啊实打实', '<p>是事实上</p>\r\n', '55', '2', '2014-11-18', '1', '0', '0');

-- ----------------------------
-- Table structure for `newstype`
-- ----------------------------
DROP TABLE IF EXISTS `newstype`;
CREATE TABLE `newstype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typeName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of newstype
-- ----------------------------
INSERT INTO `newstype` VALUES ('2', '军事');
INSERT INTO `newstype` VALUES ('4', '娱乐');
INSERT INTO `newstype` VALUES ('5', '八卦');
INSERT INTO `newstype` VALUES ('8', '杂志');
INSERT INTO `newstype` VALUES ('9', '农业');
INSERT INTO `newstype` VALUES ('10', '科技');
INSERT INTO `newstype` VALUES ('11', '奇闻');
INSERT INTO `newstype` VALUES ('13', '亲子');
INSERT INTO `newstype` VALUES ('14', '旅游');
INSERT INTO `newstype` VALUES ('15', '国际');
INSERT INTO `newstype` VALUES ('17', '体育');
INSERT INTO `newstype` VALUES ('18', '奇闻异事');

-- ----------------------------
-- Table structure for `userdetail`
-- ----------------------------
DROP TABLE IF EXISTS `userdetail`;
CREATE TABLE `userdetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) DEFAULT NULL COMMENT '户名用',
  `userPwd` varchar(20) DEFAULT NULL COMMENT '户密码用',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话号码',
  `power` int(11) DEFAULT NULL COMMENT '限权',
  `status` int(11) DEFAULT NULL COMMENT '态状',
  `registerTime` date DEFAULT NULL COMMENT '册时间注',
  `loginNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userdetail
-- ----------------------------
INSERT INTO `userdetail` VALUES ('16', '123213', null, '', '3', '1', '2014-09-30', '0');
INSERT INTO `userdetail` VALUES ('17', '123123', null, '', '3', '1', '2014-09-30', '0');
INSERT INTO `userdetail` VALUES ('18', '123123', null, '', '3', '1', '2014-09-30', '0');
INSERT INTO `userdetail` VALUES ('19', '12', null, '', '3', '1', '2014-09-30', '0');
INSERT INTO `userdetail` VALUES ('21', '12', null, '', '3', '1', '2014-09-30', '0');
INSERT INTO `userdetail` VALUES ('23', '1', null, '', '3', '1', '2014-09-30', '0');
INSERT INTO `userdetail` VALUES ('24', '11', null, '', '3', '1', '2014-09-30', '0');
INSERT INTO `userdetail` VALUES ('25', '123123', null, '', '3', '1', '2014-09-30', '0');
INSERT INTO `userdetail` VALUES ('26', '123123', null, '11', '3', '1', '2014-09-30', '0');
INSERT INTO `userdetail` VALUES ('27', '张起灵', '111111', '1111', '3', '1', '2014-09-30', '0');
INSERT INTO `userdetail` VALUES ('28', '张起灵', '111111', '1111', '3', '1', '2014-09-30', '0');
INSERT INTO `userdetail` VALUES ('29', '123123123', '121212', '12', '3', '1', '2014-09-30', '0');
INSERT INTO `userdetail` VALUES ('30', 'tom', '123123', '1111111', '3', '1', '2014-10-14', '0');
INSERT INTO `userdetail` VALUES ('31', 'tom', '123123', '1111111', '3', '1', '2014-10-14', '0');
INSERT INTO `userdetail` VALUES ('33', 'tom', '123123', '1111111', '3', '1', '2014-10-14', '0');
INSERT INTO `userdetail` VALUES ('34', 'tom', '123123', '1111111', '3', '1', '2014-10-14', '0');
INSERT INTO `userdetail` VALUES ('35', 'tom', '123123', '1111111', '3', '1', '2014-10-14', '0');
INSERT INTO `userdetail` VALUES ('36', 'tom', '123123', '1111111', '3', '1', '2014-10-14', '0');
INSERT INTO `userdetail` VALUES ('37', 'tom', '123123', '1111111', '3', '1', '2014-10-14', '0');
INSERT INTO `userdetail` VALUES ('38', 'tom', '123123', '1111111', '3', '1', '2014-10-14', '0');
INSERT INTO `userdetail` VALUES ('44', '123213', '123123', '110110', '3', '0', '2014-10-14', '1');
INSERT INTO `userdetail` VALUES ('45', '赵国', '123123', '123123', '2', '1', '2014-10-07', '4');
INSERT INTO `userdetail` VALUES ('46', '赵贤', '123123', '123123', '3', '1', '2014-10-21', '0');
INSERT INTO `userdetail` VALUES ('48', '12312312', '123123', '123123', '3', '1', '2014-10-28', '0');
INSERT INTO `userdetail` VALUES ('49', 'Jack', '123123', '123123', '3', '1', '2014-11-18', '0');
INSERT INTO `userdetail` VALUES ('50', 'Jack', '123123', '123123', '3', '1', '2014-11-18', '0');
INSERT INTO `userdetail` VALUES ('51', 'Tom', '123123', '123123', '3', '0', '2014-11-25', '0');
INSERT INTO `userdetail` VALUES ('52', '而且为', '123', '123', '3', '1', '2014-11-03', '0');
INSERT INTO `userdetail` VALUES ('53', '张起灵', '123123', '123123', '3', '1', '2014-11-25', '0');
INSERT INTO `userdetail` VALUES ('54', 'Jack', '123123', '123123', '3', '1', '2014-11-05', '0');
INSERT INTO `userdetail` VALUES ('55', 'Tom2', '123123', '123123', '1', '1', '2014-11-03', '0');
INSERT INTO `userdetail` VALUES ('56', '请输入用户名', '', '', '3', '1', '2014-11-25', '0');
INSERT INTO `userdetail` VALUES ('57', 'Tom', '123123', '123', '1', '1', '2014-11-03', '0');
INSERT INTO `userdetail` VALUES ('58', 'Tom2', '123123', '123123', '3', '1', '2014-11-25', '0');
INSERT INTO `userdetail` VALUES ('59', 'Tom2', '123123', '123123', '1', '1', '2014-11-03', '0');
INSERT INTO `userdetail` VALUES ('60', 'Tom3', '123123', '123123', '3', '1', '2014-11-04', '0');
