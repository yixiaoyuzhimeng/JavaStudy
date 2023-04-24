/*
MySQL Data Transfer
Source Host: localhost
Source Database: mydb
Target Host: localhost
Target Database: mydb
Date: 2021/12/5 20:38:53
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for student
-- ----------------------------
CREATE TABLE `student` (
  `studentId` int(10) NOT NULL,
  `studentName` varchar(20) COLLATE utf8_bin NOT NULL,
  `studentPwd` varchar(20) COLLATE utf8_bin NOT NULL,
  `studentSex` varchar(8) COLLATE utf8_bin NOT NULL,
  `studentAge` int(5) NOT NULL,
  PRIMARY KEY (`studentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `student` VALUES ('201910121', 'tom', '1234', '男', '20');
