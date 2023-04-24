/*
MySQL Data Transfer
Source Host: localhost
Source Database: mydb
Target Host: localhost
Target Database: mydb
Date: 2021/12/5 20:38:36
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for choose
-- ----------------------------
CREATE TABLE `choose` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) CHARACTER SET utf8 NOT NULL,
  `studentId` int(20) NOT NULL,
  `score` int(5) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `choose` VALUES ('1', 'tom', '201910121', '89');
