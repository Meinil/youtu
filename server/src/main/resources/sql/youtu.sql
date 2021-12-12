/*
 Navicat Premium Data Transfer

 Source Server         : wamp
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3308
 Source Schema         : youtu

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 23/06/2021 12:46:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for classify
-- ----------------------------
DROP TABLE IF EXISTS `classify`;
CREATE TABLE `classify`  (
  `id` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '分类名称',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id`(`id`) USING BTREE,
  UNIQUE INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of classify
-- ----------------------------
INSERT INTO `classify` VALUES ('fc0f2d7f67a34c65a31b9693b1b2d68c', '动漫');
INSERT INTO `classify` VALUES ('05c4eb30ca87481f8b60ce60487adc37', '生活');
INSERT INTO `classify` VALUES ('bca6499d4f2d4515bf7905a2d8cf0cf9', '风景');

-- ----------------------------
-- Table structure for picture
-- ----------------------------
DROP TABLE IF EXISTS `picture`;
CREATE TABLE `picture`  (
  `id` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键',
  `name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '图片名称',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `cid` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '外键',
  `is_show` bit(1) NULL DEFAULT NULL COMMENT '控制图片是否在主页显示 0不显示，1显示',
  `story` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '图片的简介信息',
  `owner` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '拥有者',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id`(`id`) USING BTREE,
  UNIQUE INDEX `name`(`name`) USING BTREE,
  INDEX `cid`(`cid`) USING BTREE,
  INDEX `uid`(`owner`) USING BTREE,
  CONSTRAINT `cid` FOREIGN KEY (`cid`) REFERENCES `classify` (`id`) ON DELETE SET NULL ON UPDATE RESTRICT,
  CONSTRAINT `uid` FOREIGN KEY (`owner`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of picture
-- ----------------------------
INSERT INTO `picture` VALUES ('08b2308fa49e467483366efb2410d401', '1de5159fb88f492a666a1976f5495f43.jpg', '2021-05-01 17:22:35', '05c4eb30ca87481f8b60ce60487adc37', b'0', '游戏女孩', '2b757a3d49eea0ca28dbceb8a279ff70');
INSERT INTO `picture` VALUES ('08b2308fa49e467483366efb2410d402', '4968cca6bfaa18910cd74bc440273e79.jpg', '2021-05-01 16:36:57', '05c4eb30ca87481f8b60ce60487adc37', b'1', '绝地求生', '2b757a3d49eea0ca28dbceb8a279ff70');
INSERT INTO `picture` VALUES ('08b2308fa49e467483366efb2410d404', '0591037c92211b509ec800efc5ac2095.jpg', '2021-05-01 17:23:05', 'bca6499d4f2d4515bf7905a2d8cf0cf9', b'1', '动漫女孩', '2b757a3d49eea0ca28dbceb8a279ff70');
INSERT INTO `picture` VALUES ('08b2308fa49e467483366efb2410d407', 'fc19677274d6825a70a786d2fd8f16c7.jpg', '2021-05-01 17:29:17', 'bca6499d4f2d4515bf7905a2d8cf0cf9', b'1', '啊啥地方', '2b757a3d49eea0ca28dbceb8a279ff70');
INSERT INTO `picture` VALUES ('08b2308fa49e467483366efb2410d410', '6a57e460209041e9b64605936c2ee0d7.jpg', '2021-05-01 17:29:56', '05c4eb30ca87481f8b60ce60487adc37', b'1', '啊啥地方as', '2b757a3d49eea0ca28dbceb8a279ff70');
INSERT INTO `picture` VALUES ('0a62a5419bd14786983a8798758cee54', '36e059a1760836c95c377d1366e5a22e.jpg', '2021-05-01 19:19:51', '05c4eb30ca87481f8b60ce60487adc37', b'0', 'sadf', '2b757a3d49eea0ca28dbceb8a279ff70');
INSERT INTO `picture` VALUES ('11c89095e45c428caf1e5d26e7ec2c15', 'a7dd0e10504fe582c97a74ea0a0fbea1.jpg', '2021-05-01 20:00:29', 'bca6499d4f2d4515bf7905a2d8cf0cf9', b'1', '11', '2b757a3d49eea0ca28dbceb8a279ff70');
INSERT INTO `picture` VALUES ('19c46b79ecbd4b61a45a0754d0fedcf5', '97b594cc5157ac57a65153a6ef1b0905.jpg', '2021-05-01 19:20:55', 'bca6499d4f2d4515bf7905a2d8cf0cf9', b'1', 'asdf', '2b757a3d49eea0ca28dbceb8a279ff70');
INSERT INTO `picture` VALUES ('3a9b98d92fc144ceae9d23c9e7427a55', 'e88f11cc6c574604b1d253affff54674.jpg', '2021-05-01 19:47:06', 'fc0f2d7f67a34c65a31b9693b1b2d68c', b'1', '111', '2b757a3d49eea0ca28dbceb8a279ff70');
INSERT INTO `picture` VALUES ('59263c7cafc44ea5929986b9aa6ac630', 'c8722cf28f514e233845e48724ded127.jpg', '2021-05-01 20:04:24', 'fc0f2d7f67a34c65a31b9693b1b2d68c', b'1', '11', '2b757a3d49eea0ca28dbceb8a279ff70');
INSERT INTO `picture` VALUES ('6228bfda8ad44641950f32a9f0e537e6', 'd0a93545671544a036256fe0068c452f.jpg', '2021-05-01 20:01:34', 'bca6499d4f2d4515bf7905a2d8cf0cf9', b'1', '11', '2b757a3d49eea0ca28dbceb8a279ff70');
INSERT INTO `picture` VALUES ('62b9648bc93c4f7182d3383f7489ad75', '77a4cb7748deb75fdb49a042278f20a5.jpg', '2021-05-01 20:05:44', '05c4eb30ca87481f8b60ce60487adc37', b'1', '11', '2b757a3d49eea0ca28dbceb8a279ff70');
INSERT INTO `picture` VALUES ('6730bf1ff0ea475d9f44efc50e7ab7ba', '53fac64143461590e975fe78cdaaac1b.jpg', '2021-05-01 19:56:48', 'bca6499d4f2d4515bf7905a2d8cf0cf9', b'1', '啊啥地方', '2b757a3d49eea0ca28dbceb8a279ff70');
INSERT INTO `picture` VALUES ('9d7e370c82b7432c8f32e8b49e98dca9', '4d6af66e3ca9288cdf8591d835103ab4.jpg', '2021-05-01 19:20:51', 'bca6499d4f2d4515bf7905a2d8cf0cf9', b'1', 'sdsdf', '2b757a3d49eea0ca28dbceb8a279ff70');
INSERT INTO `picture` VALUES ('a4d701f9271f4e9380d98f90a252493e', 'db52f80fa26a908cd8c9aa480d654ceb.jpg', '2021-05-01 19:59:26', 'bca6499d4f2d4515bf7905a2d8cf0cf9', b'1', '11', '2b757a3d49eea0ca28dbceb8a279ff70');
INSERT INTO `picture` VALUES ('c2100708425c4220bdf07121c040b5f5', '49631455c02eaf3111e608bc9f1c6a24.jpg', '2021-05-01 19:48:02', 'bca6499d4f2d4515bf7905a2d8cf0cf9', b'1', '11', '2b757a3d49eea0ca28dbceb8a279ff70');
INSERT INTO `picture` VALUES ('cc84b273de9f48ad92703b2ce9422e7e', '7eac63135698b80009cb7c73f1e58023.jpg', '2021-05-01 19:16:04', 'bca6499d4f2d4515bf7905a2d8cf0cf9', b'1', 'asdf', '2b757a3d49eea0ca28dbceb8a279ff70');
INSERT INTO `picture` VALUES ('d5dc9fbe1be0414b87c3d0f863d00287', '8c0f413658f8a45f679c8041b69c28b4.jpg', '2021-05-01 20:03:05', 'fc0f2d7f67a34c65a31b9693b1b2d68c', b'1', '11', '2b757a3d49eea0ca28dbceb8a279ff70');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键ID',
  `user_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '姓名',
  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `auth` int(2) NOT NULL COMMENT '权限',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `version` int(10) NOT NULL DEFAULT 1 COMMENT '并发控制',
  `avatar_url` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id`(`id`) USING BTREE,
  UNIQUE INDEX `user_name`(`user_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2b757a3d49eea0ca28dbceb8a279ff70', 'admin', '12345', 0, '2021-04-28 17:50:02', 1, NULL);
INSERT INTO `user` VALUES ('638e11c0fe0d0e3ad9e40acd8a745aee', '1', '123', 1, '2021-05-01 12:58:37', 1, NULL);
INSERT INTO `user` VALUES ('8ce64ac0d139c67bc8dc84d83478f4c2', '123456', '123456', 1, '2021-05-03 18:59:05', 1, NULL);

-- ----------------------------
-- Table structure for user_auths
-- ----------------------------
DROP TABLE IF EXISTS `user_auths`;
CREATE TABLE `user_auths`  (
  `id` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_id` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '关联的userid',
  `username` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '第三方登陆的账号名',
  `identity_type` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '关联的平台类型',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `user_auths_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_auths
-- ----------------------------
INSERT INTO `user_auths` VALUES ('48578546', NULL, 'SchrodingerSeeCat', 'github');

SET FOREIGN_KEY_CHECKS = 1;
