/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50737
 Source Host           : localhost:3306
 Source Schema         : daka

 Target Server Type    : MySQL
 Target Server Version : 50737
 File Encoding         : 65001

 Date: 10/02/2023 17:36:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager`  (
  `id` char(36) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '主键',
  `account` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '账号',
  `password` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '密码',
  `name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '账号名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('0', 'string', 'string', 'string');

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record`  (
  `id` char(36) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '主键',
  `id_number` varchar(18) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '身份证号',
  `time` date NOT NULL COMMENT '打卡时间',
  `geo` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '地理位置范围',
  `face` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '人脸信息',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES ('111111', 'string1', '2023-02-10', 'string', 'string');
INSERT INTO `record` VALUES ('111112', 'string3', '2023-02-10', 'string', 'string');
INSERT INTO `record` VALUES ('12345678', 'string3', '2023-02-09', 'string', 'string');
INSERT INTO `record` VALUES ('222222', 'string3', '2023-02-11', 'string', 'string');

-- ----------------------------
-- Table structure for rule
-- ----------------------------
DROP TABLE IF EXISTS `rule`;
CREATE TABLE `rule`  (
  `id` char(36) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '主键唯一',
  `name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '姓名',
  `status` int(1) NOT NULL COMMENT '身份标识',
  `id_number` varchar(18) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '身份证号',
  `phone` varchar(11) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '手机号码',
  `cycle` char(10) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '打卡频次',
  `start_time` date NULL DEFAULT NULL COMMENT '打卡开始时间',
  `end_time` date NULL DEFAULT NULL COMMENT '打卡结束时间',
  `geo` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '地理位置范围',
  `face` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '人脸信息',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '录入信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rule
-- ----------------------------
INSERT INTO `rule` VALUES ('121222', 'string', 0, 'string1', 'string', 'month', '2023-02-10', '2023-03-10', 'string', 'string');
INSERT INTO `rule` VALUES ('333333', 'string', 0, 'string3', 'string3', 'week', '2023-02-09', '2023-02-10', 'string', 'string');
INSERT INTO `rule` VALUES ('67ed97df-8076-4399-bbf0-f47bea19ca6b', 'string', 0, 'string2', 'string', 'string', '2023-02-10', '2023-02-10', 'string', 'string');

SET FOREIGN_KEY_CHECKS = 1;
