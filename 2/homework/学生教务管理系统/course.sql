/*
MySQL Data Transfer
Source Host: localhost
Source Database: mydb
Target Host: localhost
Target Database: mydb
Date: 2021/12/5 20:38:46
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for course
-- ----------------------------
CREATE TABLE `course` (
  `name` varchar(20) CHARACTER SET utf8 NOT NULL,
  `courseId` int(10) NOT NULL,
  `courseName` varchar(20) CHARACTER SET utf8 NOT NULL,
  `teacherName` varchar(20) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `course` VALUES ('tom', '1001', '高数', '李老师');
