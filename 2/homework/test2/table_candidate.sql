/*
 Navicat Premium Data Transfer

 Source Server         : yixi
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : mydb

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 25/04/2023 20:27:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for table_candidate
-- ----------------------------
DROP TABLE IF EXISTS `table_candidate`;
CREATE TABLE `table_candidate`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `photoUrl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `votes` int(0) UNSIGNED NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of table_candidate
-- ----------------------------
INSERT INTO `table_candidate` VALUES (28, 'lola', '/test2_war_exploded/photo/1682424044870QQ图片20230409102756.png', 0);
INSERT INTO `table_candidate` VALUES (30, 'witch', '/test2_war_exploded/photo/1682424107229Fd_UF6iWYAA4yyi.jfif', 0);

SET FOREIGN_KEY_CHECKS = 1;
