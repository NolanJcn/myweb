/*
Navicat MySQL Data Transfer

Source Server         : myweb
Source Server Version : 50728
Source Host           : localhost:3306
Source Database       : myweb

Target Server Type    : MYSQL
Target Server Version : 50728
File Encoding         : 65001

Date: 2020-03-13 23:48:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `pic_details`
-- ----------------------------
DROP TABLE IF EXISTS `pic_details`;
CREATE TABLE `pic_details` (
  `pic_id` int(11) NOT NULL AUTO_INCREMENT,
  `pic_name` varchar(255) NOT NULL,
  `pic_url` varchar(255) NOT NULL,
  `type_id` int(11) NOT NULL,
  PRIMARY KEY (`pic_id`)
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pic_details
-- ----------------------------
INSERT INTO `pic_details` VALUES ('58', '城镇', '/img/home/asdasda.jpg', '4');
INSERT INTO `pic_details` VALUES ('59', '城镇', '/img/home/u=168411158,1732850018&fm=26&gp=0.jpg', '4');
INSERT INTO `pic_details` VALUES ('60', '城镇', '/img/home/u=1139789414,2790303984&fm=26&gp=0.jpg', '4');
INSERT INTO `pic_details` VALUES ('61', '城镇', '/img/home/u=1682965208,192664550&fm=26&gp=0.jpg', '4');
INSERT INTO `pic_details` VALUES ('62', '城镇', '/img/home/u=2623800273,3493040044&fm=26&gp=0.jpg', '4');
INSERT INTO `pic_details` VALUES ('63', '城镇', '/img/home/u=2661451952,2874100235&fm=15&gp=0.jpg', '4');
INSERT INTO `pic_details` VALUES ('64', '城镇', '/img/home/u=2730014990,3036019079&fm=26&gp=0.jpg', '4');
INSERT INTO `pic_details` VALUES ('65', '城镇', '/img/home/u=3838675622,2622130732&fm=26&gp=0.jpg', '4');
INSERT INTO `pic_details` VALUES ('68', '城镇', '/img/home/asfasfasfas.jpg', '4');
INSERT INTO `pic_details` VALUES ('69', '城镇', '/img/home/sgdgaeg.jpg', '4');
INSERT INTO `pic_details` VALUES ('70', '动画', '/img/home/agdhthaegr.jpg', '6');
INSERT INTO `pic_details` VALUES ('71', '动画', '/img/home/u=394437874,1347305436&fm=11&gp=0.jpg', '6');
INSERT INTO `pic_details` VALUES ('72', '动画', '/img/home/u=983883703,870195866&fm=11&gp=0.jpg', '6');
INSERT INTO `pic_details` VALUES ('73', '动画', '/img/home/u=1023741228,1419806227&fm=11&gp=0.jpg', '6');
INSERT INTO `pic_details` VALUES ('74', '动画', '/img/home/u=1624877405,1920283887&fm=11&gp=0.jpg', '6');
INSERT INTO `pic_details` VALUES ('75', '动画', '/img/home/u=2499811990,1607159042&fm=11&gp=0.jpg', '6');
INSERT INTO `pic_details` VALUES ('76', '动画', '/img/home/u=2569480829,1085243755&fm=11&gp=0.jpg', '6');
INSERT INTO `pic_details` VALUES ('77', '动画', '/img/home/u=2816590015,1244729293&fm=11&gp=0.jpg', '6');
INSERT INTO `pic_details` VALUES ('78', '动画', '/img/home/u=3616292134,3237083557&fm=11&gp=0.jpg', '6');
INSERT INTO `pic_details` VALUES ('79', '动画', '/img/home/u=3799187394,2499149653&fm=26&gp=0.jpg', '6');
INSERT INTO `pic_details` VALUES ('80', '动漫', '/img/home/u=9575462,2705436836&fm=11&gp=0.jpg', '5');
INSERT INTO `pic_details` VALUES ('81', '动漫', '/img/home/u=39838980,3008580887&fm=11&gp=0.jpg', '5');
INSERT INTO `pic_details` VALUES ('82', '动漫', '/img/home/u=2011820955,2050910102&fm=11&gp=0.jpg', '5');
INSERT INTO `pic_details` VALUES ('83', '动漫', '/img/home/u=2796894384,2104364434&fm=26&gp=0.jpg', '5');
INSERT INTO `pic_details` VALUES ('84', '动漫', '/img/home/u=3131359416,990149143&fm=11&gp=0.jpg', '5');
INSERT INTO `pic_details` VALUES ('85', '动漫', '/img/home/u=3502747340,1434195046&fm=26&gp=0.jpg', '5');
INSERT INTO `pic_details` VALUES ('86', '动漫', '/img/home/u=3573042867,1981443841&fm=26&gp=0.jpg', '5');
INSERT INTO `pic_details` VALUES ('87', '动漫', '/img/home/u=3799390026,3972016700&fm=26&gp=0.jpg', '5');
INSERT INTO `pic_details` VALUES ('88', '动漫', '/img/home/u=3876023743,3643640497&fm=26&gp=0.jpg', '5');
INSERT INTO `pic_details` VALUES ('89', '动漫', '/img/home/zzzzzz.jpg', '5');
INSERT INTO `pic_details` VALUES ('90', '科幻', '/img/home/adfadfdsfafa.jpg', '3');
INSERT INTO `pic_details` VALUES ('91', '科幻', '/img/home/afvmayfw515.jpg', '3');
INSERT INTO `pic_details` VALUES ('92', '科幻', '/img/home/amhs2a1ds.jpg', '3');
INSERT INTO `pic_details` VALUES ('93', '科幻', '/img/home/ghdg1f.jpg', '3');
INSERT INTO `pic_details` VALUES ('94', '科幻', '/img/home/jbsjagsfddsf5.jpg', '3');
INSERT INTO `pic_details` VALUES ('95', '科幻', '/img/home/u=102477721,3890441178&fm=11&gp=0.jpg', '3');
INSERT INTO `pic_details` VALUES ('96', '科幻', '/img/home/u=1798340474,3896150335&fm=11&gp=0.jpg', '3');
INSERT INTO `pic_details` VALUES ('97', '科幻', '/img/home/u=2546083231,1915518719&fm=26&gp=0.jpg', '3');
INSERT INTO `pic_details` VALUES ('98', '科幻', '/img/home/u=3534233670,1990543259&fm=26&gp=0.jpg', '3');
INSERT INTO `pic_details` VALUES ('99', '科幻', '/img/home/u=4130052287,586341339&fm=26&gp=0.jpg', '3');
INSERT INTO `pic_details` VALUES ('100', '唯美', '/img/home/mm1.jpg', '2');
INSERT INTO `pic_details` VALUES ('101', '唯美', '/img/home/mm2.jpg', '2');
INSERT INTO `pic_details` VALUES ('102', '唯美', '/img/home/mm3.jpg', '2');
INSERT INTO `pic_details` VALUES ('103', '唯美', '/img/home/mm4.jpg', '2');
INSERT INTO `pic_details` VALUES ('104', '唯美', '/img/home/mm5.jpg', '2');
INSERT INTO `pic_details` VALUES ('105', '唯美', '/img/home/mm6.jpg', '2');
INSERT INTO `pic_details` VALUES ('106', '唯美', '/img/home/mm7.jpg', '2');
INSERT INTO `pic_details` VALUES ('107', '唯美', '/img/home/mm8.jpg', '2');
INSERT INTO `pic_details` VALUES ('108', '唯美', '/img/home/mm9.jpg', '2');
INSERT INTO `pic_details` VALUES ('109', '唯美', '/img/home/mm10.jpg', '2');
INSERT INTO `pic_details` VALUES ('110', '游戏', '/img/home/u=306122448,1233674339&fm=26&gp=0.jpg', '7');
INSERT INTO `pic_details` VALUES ('111', '游戏', '/img/home/u=1052177530,194788665&fm=26&gp=0.jpg', '7');
INSERT INTO `pic_details` VALUES ('112', '游戏', '/img/home/u=1212717813,3889900517&fm=26&gp=0.jpg', '7');
INSERT INTO `pic_details` VALUES ('113', '游戏', '/img/home/u=1378482057,247465192&fm=11&gp=0.jpg', '7');
INSERT INTO `pic_details` VALUES ('114', '游戏', '/img/home/u=1870298974,2145214541&fm=26&gp=0.jpg', '7');
INSERT INTO `pic_details` VALUES ('115', '游戏', '/img/home/u=2297202679,2289208331&fm=26&gp=0.jpg', '7');
INSERT INTO `pic_details` VALUES ('116', '游戏', '/img/home/u=2715675918,3114856677&fm=26&gp=0.jpg', '7');
INSERT INTO `pic_details` VALUES ('117', '游戏', '/img/home/u=2913617019,1278109122&fm=26&gp=0.jpg', '7');
INSERT INTO `pic_details` VALUES ('118', '游戏', '/img/home/u=3137092447,2041054695&fm=26&gp=0.jpg', '7');
INSERT INTO `pic_details` VALUES ('119', '游戏', '/img/home/u=3923209180,339463846&fm=26&gp=0.jpg', '7');
INSERT INTO `pic_details` VALUES ('120', '百度去吧', '/img/home/e16fc503ly1g0yrxd0mr1j20b40b4gm1.jpg', '1');

-- ----------------------------
-- Table structure for `pic_sort`
-- ----------------------------
DROP TABLE IF EXISTS `pic_sort`;
CREATE TABLE `pic_sort` (
  `sort_id` int(11) NOT NULL,
  `sort_name` varchar(255) NOT NULL,
  PRIMARY KEY (`sort_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pic_sort
-- ----------------------------
INSERT INTO `pic_sort` VALUES ('1', '美女');
INSERT INTO `pic_sort` VALUES ('2', '风景');
INSERT INTO `pic_sort` VALUES ('3', '卡通');

-- ----------------------------
-- Table structure for `pic_type`
-- ----------------------------
DROP TABLE IF EXISTS `pic_type`;
CREATE TABLE `pic_type` (
  `type_id` int(11) NOT NULL,
  `type_name` varchar(255) NOT NULL,
  `sort_id` int(11) NOT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pic_type
-- ----------------------------
INSERT INTO `pic_type` VALUES ('1', '性感', '1');
INSERT INTO `pic_type` VALUES ('2', '唯美', '1');
INSERT INTO `pic_type` VALUES ('3', '科幻', '2');
INSERT INTO `pic_type` VALUES ('4', '城镇', '2');
INSERT INTO `pic_type` VALUES ('5', '动漫', '2');
INSERT INTO `pic_type` VALUES ('6', '动画', '3');
INSERT INTO `pic_type` VALUES ('7', '游戏', '3');

-- ----------------------------
-- Table structure for `t_myadmin`
-- ----------------------------
DROP TABLE IF EXISTS `t_myadmin`;
CREATE TABLE `t_myadmin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login_acct` varchar(255) NOT NULL,
  `login_pass` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `createtime` char(19) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_myadmin
-- ----------------------------
INSERT INTO `t_myadmin` VALUES ('1', 'jianzhu', '49e7ffb2182daca900e2d11069990d09', '剑主', '987639660@qq.com', '2020');
INSERT INTO `t_myadmin` VALUES ('24', '1', '695a0f71120287e64c1b6043be3fd3d1', '1', '1', '2020-02-27 14:29:43');
INSERT INTO `t_myadmin` VALUES ('25', '2', 'f7fc6751660a33b18596995554f4b20e', '2', '2', '2020-02-27 20:20:52');
INSERT INTO `t_myadmin` VALUES ('26', '666', '49e7ffb2182daca900e2d11069990d09', 'jianzhu666', '6', '2020-02-28 21:34:19');
INSERT INTO `t_myadmin` VALUES ('27', '888', '695a0f71120287e64c1b6043be3fd3d1', '1', '1', '2020-03-01 22:27:55');
INSERT INTO `t_myadmin` VALUES ('28', '369', '49e7ffb2182daca900e2d11069990d09', 'jianzhu', '1', '2020-03-01 23:00:37');
INSERT INTO `t_myadmin` VALUES ('29', '999', '49e7ffb2182daca900e2d11069990d09', 'jianzhu', '1', '2020-03-02 22:44:56');

-- ----------------------------
-- Table structure for `t_salt`
-- ----------------------------
DROP TABLE IF EXISTS `t_salt`;
CREATE TABLE `t_salt` (
  `salt` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_salt
-- ----------------------------
INSERT INTO `t_salt` VALUES ('woshijianzhu');
