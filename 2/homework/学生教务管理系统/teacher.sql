/*
MySQL Data Transfer
Source Host: localhost
Source Database: mydb
Target Host: localhost
Target Database: mydb
Date: 2021/12/5 20:39:05
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for teacher
-- ----------------------------
CREATE TABLE `teacher` (
  `teacherId` int(10) NOT NULL,
  `teacherName` varchar(20) COLLATE utf8_bin NOT NULL,
  `teacherPwd` varchar(20) COLLATE utf8_bin NOT NULL,
  `teacherSex` varchar(8) COLLATE utf8_bin NOT NULL,
  `teacherAge` int(5) NOT NULL,
  PRIMARY KEY (`teacherId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `teacher` VALUES ('201990123', '张老师', '1234', '女', '40');
