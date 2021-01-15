/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : localhost:3306
 Source Schema         : apolloportaldb

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 13/08/2020 19:58:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for app
-- ----------------------------
DROP TABLE IF EXISTS `app`;
CREATE TABLE `app`  (
  `Id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `AppId` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'default' COMMENT 'AppID',
  `Name` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'default' COMMENT '应用名',
  `OrgId` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'default' COMMENT '部门Id',
  `OrgName` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'default' COMMENT '部门名字',
  `OwnerName` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'default' COMMENT 'ownerName',
  `OwnerEmail` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'default' COMMENT 'ownerEmail',
  `IsDeleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '1: deleted, 0: normal',
  `DataChange_CreatedBy` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'default' COMMENT '创建人邮箱前缀',
  `DataChange_CreatedTime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `DataChange_LastModifiedBy` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后修改人邮箱前缀',
  `DataChange_LastTime` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改时间',
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `AppId`(`AppId`(191)) USING BTREE,
  INDEX `DataChange_LastTime`(`DataChange_LastTime`) USING BTREE,
  INDEX `IX_Name`(`Name`(191)) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '应用表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of app
-- ----------------------------
INSERT INTO `app` VALUES (1, 'SampleApp', 'Sample App', 'TEST1', '样例部门1', 'apollo', 'apollo@acme.com', b'0', 'default', '2019-12-23 16:50:05', '', '2019-12-23 16:50:05');
INSERT INTO `app` VALUES (2, 'app-bee-weixin', 'app-bee-weixin', 'TEST1', '样例部门1', 'apollo', 'apollo@acme.com', b'1', 'apollo', '2019-12-24 13:25:05', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `app` VALUES (3, 'app-bee-zuul', 'app-zuul-server', 'TEST1', '样例部门1', 'apollo', 'apollo@acme.com', b'1', 'apollo', '2019-12-24 15:32:23', 'apollo', '2019-12-31 13:53:05');
INSERT INTO `app` VALUES (4, 'app-bee-member', 'app-bee-member', 'TEST2', '样例部门2', 'apollo', 'apollo@acme.com', b'1', 'apollo', '2019-12-25 16:19:43', 'apollo', '2019-12-31 13:53:40');
INSERT INTO `app` VALUES (5, 'app--zuul-server', 'app-zuul-server', 'TEST1', '样例部门1', 'apollo', 'apollo@acme.com', b'1', 'apollo', '2019-12-31 13:43:47', 'apollo', '2019-12-31 14:58:36');
INSERT INTO `app` VALUES (6, 'h2hf-app-weixin', 'h2hf-app-weixin', 'TEST1', '样例部门1', 'apollo', 'apollo@acme.com', b'0', 'apollo', '2019-12-31 13:56:21', 'apollo', '2019-12-31 13:56:21');
INSERT INTO `app` VALUES (7, 'app-zuul-serve', 'app-zuul-serve', 'TEST1', '样例部门1', 'apollo', 'apollo@acme.com', b'0', 'apollo', '2019-12-31 14:59:01', 'apollo', '2019-12-31 14:59:01');
INSERT INTO `app` VALUES (8, 'h2hf-app-member', 'h2hf-app-member', 'TEST1', '样例部门1', 'apollo', 'apollo@acme.com', b'0', 'apollo', '2019-12-31 15:56:28', 'apollo', '2019-12-31 15:56:28');
INSERT INTO `app` VALUES (9, 'h2hf-app-auth', 'h2hf-app-auth', 'TEST2', '样例部门2', 'apollo', 'apollo@acme.com', b'0', 'apollo', '2020-01-02 14:49:33', 'apollo', '2020-01-02 14:49:33');
INSERT INTO `app` VALUES (10, 'gateway-server', 'gateway-server', 'TEST1', '样例部门1', 'apollo', 'apollo@acme.com', b'0', 'apollo', '2020-01-04 18:18:13', 'apollo', '2020-01-04 18:18:13');
INSERT INTO `app` VALUES (11, 'member-server', 'member-server', 'TEST1', '样例部门1', 'apollo', 'apollo@acme.com', b'0', 'apollo', '2020-01-04 19:08:15', 'apollo', '2020-01-04 19:08:15');
INSERT INTO `app` VALUES (12, 'auth-server', 'auth-server', 'TEST1', '样例部门1', 'apollo', 'apollo@acme.com', b'0', 'apollo', '2020-01-07 15:07:40', 'apollo', '2020-01-07 15:07:40');
INSERT INTO `app` VALUES (13, 'saas-server', 'saas-server', 'TEST1', '样例部门1', 'apollo', 'apollo@acme.com', b'0', 'apollo', '2020-02-02 23:23:20', 'apollo', '2020-02-02 23:23:20');
INSERT INTO `app` VALUES (14, 'system-server', 'system-server', 'TEST1', '样例部门1', 'apollo', 'apollo@acme.com', b'0', 'apollo', '2020-02-06 21:30:15', 'apollo', '2020-02-06 21:30:15');
INSERT INTO `app` VALUES (15, 'shop-server', 'shop-server', 'TEST1', '样例部门1', 'apollo', 'apollo@acme.com', b'0', 'apollo', '2020-02-20 15:13:17', 'apollo', '2020-02-20 15:13:17');

-- ----------------------------
-- Table structure for appnamespace
-- ----------------------------
DROP TABLE IF EXISTS `appnamespace`;
CREATE TABLE `appnamespace`  (
  `Id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `Name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT 'namespace名字，注意，需要全局唯一',
  `AppId` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT 'app id',
  `Format` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'properties' COMMENT 'namespace的format类型',
  `IsPublic` bit(1) NOT NULL DEFAULT b'0' COMMENT 'namespace是否为公共',
  `Comment` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '注释',
  `IsDeleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '1: deleted, 0: normal',
  `DataChange_CreatedBy` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '创建人邮箱前缀',
  `DataChange_CreatedTime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `DataChange_LastModifiedBy` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后修改人邮箱前缀',
  `DataChange_LastTime` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改时间',
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `IX_AppId`(`AppId`) USING BTREE,
  INDEX `Name_AppId`(`Name`, `AppId`) USING BTREE,
  INDEX `DataChange_LastTime`(`DataChange_LastTime`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 39 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '应用namespace定义' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of appnamespace
-- ----------------------------
INSERT INTO `appnamespace` VALUES (1, 'application', 'SampleApp', 'properties', b'0', 'default app namespace', b'0', '', '2019-12-23 16:50:05', '', '2019-12-23 16:50:05');
INSERT INTO `appnamespace` VALUES (2, 'application', 'app-bee-weixin', 'properties', b'0', 'default app namespace', b'1', 'apollo', '2019-12-24 13:25:05', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `appnamespace` VALUES (3, 'application', 'app-bee-zuul', 'properties', b'0', 'default app namespace', b'1', 'apollo', '2019-12-24 15:32:23', 'apollo', '2019-12-31 13:53:05');
INSERT INTO `appnamespace` VALUES (4, 'application', 'app-bee-member', 'properties', b'0', 'default app namespace', b'1', 'apollo', '2019-12-25 16:19:43', 'apollo', '2019-12-31 13:53:40');
INSERT INTO `appnamespace` VALUES (5, 'weixin-config', 'app-bee-weixin', 'properties', b'0', '', b'1', 'apollo', '2019-12-26 10:59:07', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `appnamespace` VALUES (6, 'TEST1.redis-config', 'app-bee-weixin', 'properties', b'1', 'redis配置', b'1', 'apollo', '2019-12-26 11:13:25', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `appnamespace` VALUES (7, 'redis-config', 'app-bee-weixin', 'properties', b'0', 'Redis 配置', b'1', 'apollo', '2019-12-26 11:15:26', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `appnamespace` VALUES (8, 'mysql_redis_config', 'app-bee-weixin', 'properties', b'0', '数据库Redis连接配置', b'1', 'apollo', '2019-12-27 14:52:22', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `appnamespace` VALUES (9, 'mysql_redis_config', 'app-bee-member', 'properties', b'0', '数据库Redis连接配置', b'1', 'apollo', '2019-12-27 14:54:08', 'apollo', '2019-12-31 13:53:40');
INSERT INTO `appnamespace` VALUES (10, 'application', 'app--zuul-server', 'properties', b'0', 'default app namespace', b'1', 'apollo', '2019-12-31 13:43:47', 'apollo', '2019-12-31 14:58:36');
INSERT INTO `appnamespace` VALUES (11, 'application', 'h2hf-app-weixin', 'properties', b'0', 'default app namespace', b'0', 'apollo', '2019-12-31 13:56:21', 'apollo', '2019-12-31 13:56:21');
INSERT INTO `appnamespace` VALUES (12, 'weixin-config', 'h2hf-app-weixin', 'properties', b'0', '微信配置', b'0', 'apollo', '2019-12-31 14:04:16', 'apollo', '2019-12-31 14:04:16');
INSERT INTO `appnamespace` VALUES (13, 'mysql_redis_config', 'h2hf-app-weixin', 'properties', b'0', '数据库和Redis配置', b'0', 'apollo', '2019-12-31 14:06:27', 'apollo', '2019-12-31 14:06:27');
INSERT INTO `appnamespace` VALUES (14, 'application', 'app-zuul-serve', 'properties', b'0', 'default app namespace', b'0', 'apollo', '2019-12-31 14:59:02', 'apollo', '2019-12-31 14:59:02');
INSERT INTO `appnamespace` VALUES (15, 'application', 'h2hf-app-member', 'properties', b'0', 'default app namespace', b'0', 'apollo', '2019-12-31 15:56:28', 'apollo', '2019-12-31 15:56:28');
INSERT INTO `appnamespace` VALUES (16, 'mysql_redis_config', 'h2hf-app-member', 'properties', b'0', 'MySQL-Redis配置', b'1', 'apollo', '2019-12-31 17:13:06', 'apollo', '2020-01-03 10:58:26');
INSERT INTO `appnamespace` VALUES (17, 'weixin_mysql_redis_config', 'h2hf-app-weixin', 'properties', b'0', '', b'0', 'apollo', '2020-01-02 10:58:03', 'apollo', '2020-01-02 10:58:03');
INSERT INTO `appnamespace` VALUES (18, 'application', 'h2hf-app-auth', 'properties', b'0', 'default app namespace', b'0', 'apollo', '2020-01-02 14:49:33', 'apollo', '2020-01-02 14:49:33');
INSERT INTO `appnamespace` VALUES (19, 'auth_mysql_redis_config', 'h2hf-app-auth', 'properties', b'0', '用户授权数据库Redis连接', b'0', 'apollo', '2020-01-02 14:52:15', 'apollo', '2020-01-02 14:52:15');
INSERT INTO `appnamespace` VALUES (20, 'user_auth_config', 'h2hf-app-auth', 'properties', b'0', '用户授权秘钥配置', b'0', 'apollo', '2020-01-02 14:54:38', 'apollo', '2020-01-02 14:54:38');
INSERT INTO `appnamespace` VALUES (21, 'memeber_mysql_redis_config', 'h2hf-app-member', 'properties', b'0', '会员数据库Redis', b'0', 'apollo', '2020-01-03 10:59:11', 'apollo', '2020-01-03 10:59:11');
INSERT INTO `appnamespace` VALUES (22, 'member_mysql_redis_config', 'h2hf-app-member', 'properties', b'0', '会员数据库Redis', b'0', 'apollo', '2020-01-03 11:15:47', 'apollo', '2020-01-03 11:15:47');
INSERT INTO `appnamespace` VALUES (23, 'application', 'gateway-server', 'properties', b'0', 'default app namespace', b'0', 'apollo', '2020-01-04 18:18:13', 'apollo', '2020-01-04 18:18:13');
INSERT INTO `appnamespace` VALUES (24, 'application', 'member-server', 'properties', b'0', 'default app namespace', b'0', 'apollo', '2020-01-04 19:08:15', 'apollo', '2020-01-04 19:08:15');
INSERT INTO `appnamespace` VALUES (25, 'member_swagger_config', 'member-server', 'properties', b'0', '会员swagger配置', b'1', 'apollo', '2020-01-04 19:11:06', 'apollo', '2020-01-05 14:38:10');
INSERT INTO `appnamespace` VALUES (26, 'member-redis-mysql-config', 'member-server', 'properties', b'0', '', b'0', 'apollo', '2020-01-04 19:13:57', 'apollo', '2020-01-04 19:13:57');
INSERT INTO `appnamespace` VALUES (27, 'application', 'auth-server', 'properties', b'0', 'default app namespace', b'0', 'apollo', '2020-01-07 15:07:40', 'apollo', '2020-01-07 15:07:40');
INSERT INTO `appnamespace` VALUES (28, 'auth_config', 'auth-server', 'properties', b'0', '认证相关配置', b'0', 'apollo', '2020-01-07 15:11:08', 'apollo', '2020-01-07 15:11:08');
INSERT INTO `appnamespace` VALUES (29, 'auth_swagger_config', 'auth-server', 'properties', b'0', '认证授权swagger配置', b'0', 'apollo', '2020-01-07 15:15:01', 'apollo', '2020-01-07 15:15:01');
INSERT INTO `appnamespace` VALUES (30, 'auth_mysql_redis_config', 'auth-server', 'properties', b'0', '', b'0', 'apollo', '2020-01-08 09:07:48', 'apollo', '2020-01-08 09:07:48');
INSERT INTO `appnamespace` VALUES (31, 'application', 'saas-server', 'properties', b'0', 'default app namespace', b'0', 'apollo', '2020-02-02 23:23:21', 'apollo', '2020-02-02 23:23:21');
INSERT INTO `appnamespace` VALUES (32, 'saas-redis-mysql-config', 'saas-server', 'properties', b'0', 'SaaS', b'0', 'apollo', '2020-02-02 23:25:05', 'apollo', '2020-02-02 23:25:05');
INSERT INTO `appnamespace` VALUES (33, 'gateway_mysql_redis_config', 'gateway-server', 'properties', b'0', '', b'1', 'apollo', '2020-02-03 23:00:57', 'apollo', '2020-02-03 23:20:41');
INSERT INTO `appnamespace` VALUES (34, 'application', 'system-server', 'properties', b'0', 'default app namespace', b'0', 'apollo', '2020-02-06 21:30:15', 'apollo', '2020-02-06 21:30:15');
INSERT INTO `appnamespace` VALUES (35, 'system-redis-mysql-config', 'system-server', 'properties', b'0', '', b'0', 'apollo', '2020-02-06 21:32:16', 'apollo', '2020-02-06 21:32:16');
INSERT INTO `appnamespace` VALUES (36, 'application', 'shop-server', 'properties', b'0', 'default app namespace', b'0', 'apollo', '2020-02-20 15:13:17', 'apollo', '2020-02-20 15:13:17');
INSERT INTO `appnamespace` VALUES (37, 'shop-redis-mysql-config', 'shop-server', 'properties', b'0', '商品', b'0', 'apollo', '2020-02-20 15:15:22', 'apollo', '2020-02-20 15:15:22');
INSERT INTO `appnamespace` VALUES (38, 'upload_config', 'system-server', 'properties', b'0', '', b'0', 'apollo', '2020-02-23 01:27:15', 'apollo', '2020-02-23 01:27:15');

-- ----------------------------
-- Table structure for authorities
-- ----------------------------
DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities`  (
  `Id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增Id',
  `Username` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Authority` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of authorities
-- ----------------------------
INSERT INTO `authorities` VALUES (1, 'apollo', 'ROLE_user');
INSERT INTO `authorities` VALUES (2, 'root', 'ROLE_user');

-- ----------------------------
-- Table structure for consumer
-- ----------------------------
DROP TABLE IF EXISTS `consumer`;
CREATE TABLE `consumer`  (
  `Id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增Id',
  `AppId` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'default' COMMENT 'AppID',
  `Name` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'default' COMMENT '应用名',
  `OrgId` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'default' COMMENT '部门Id',
  `OrgName` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'default' COMMENT '部门名字',
  `OwnerName` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'default' COMMENT 'ownerName',
  `OwnerEmail` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'default' COMMENT 'ownerEmail',
  `IsDeleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '1: deleted, 0: normal',
  `DataChange_CreatedBy` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'default' COMMENT '创建人邮箱前缀',
  `DataChange_CreatedTime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `DataChange_LastModifiedBy` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后修改人邮箱前缀',
  `DataChange_LastTime` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改时间',
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `AppId`(`AppId`(191)) USING BTREE,
  INDEX `DataChange_LastTime`(`DataChange_LastTime`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '开放API消费者' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of consumer
-- ----------------------------

-- ----------------------------
-- Table structure for consumeraudit
-- ----------------------------
DROP TABLE IF EXISTS `consumeraudit`;
CREATE TABLE `consumeraudit`  (
  `Id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增Id',
  `ConsumerId` int(11) UNSIGNED NULL DEFAULT NULL COMMENT 'Consumer Id',
  `Uri` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '访问的Uri',
  `Method` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '访问的Method',
  `DataChange_CreatedTime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `DataChange_LastTime` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改时间',
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `IX_DataChange_LastTime`(`DataChange_LastTime`) USING BTREE,
  INDEX `IX_ConsumerId`(`ConsumerId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = 'consumer审计表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of consumeraudit
-- ----------------------------

-- ----------------------------
-- Table structure for consumerrole
-- ----------------------------
DROP TABLE IF EXISTS `consumerrole`;
CREATE TABLE `consumerrole`  (
  `Id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增Id',
  `ConsumerId` int(11) UNSIGNED NULL DEFAULT NULL COMMENT 'Consumer Id',
  `RoleId` int(10) UNSIGNED NULL DEFAULT NULL COMMENT 'Role Id',
  `IsDeleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '1: deleted, 0: normal',
  `DataChange_CreatedBy` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建人邮箱前缀',
  `DataChange_CreatedTime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `DataChange_LastModifiedBy` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后修改人邮箱前缀',
  `DataChange_LastTime` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改时间',
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `IX_DataChange_LastTime`(`DataChange_LastTime`) USING BTREE,
  INDEX `IX_RoleId`(`RoleId`) USING BTREE,
  INDEX `IX_ConsumerId_RoleId`(`ConsumerId`, `RoleId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = 'consumer和role的绑定表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of consumerrole
-- ----------------------------

-- ----------------------------
-- Table structure for consumertoken
-- ----------------------------
DROP TABLE IF EXISTS `consumertoken`;
CREATE TABLE `consumertoken`  (
  `Id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增Id',
  `ConsumerId` int(11) UNSIGNED NULL DEFAULT NULL COMMENT 'ConsumerId',
  `Token` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT 'token',
  `Expires` datetime(0) NOT NULL DEFAULT '2099-01-01 00:00:00' COMMENT 'token失效时间',
  `IsDeleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '1: deleted, 0: normal',
  `DataChange_CreatedBy` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'default' COMMENT '创建人邮箱前缀',
  `DataChange_CreatedTime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `DataChange_LastModifiedBy` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后修改人邮箱前缀',
  `DataChange_LastTime` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改时间',
  PRIMARY KEY (`Id`) USING BTREE,
  UNIQUE INDEX `IX_Token`(`Token`) USING BTREE,
  INDEX `DataChange_LastTime`(`DataChange_LastTime`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = 'consumer token表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of consumertoken
-- ----------------------------

-- ----------------------------
-- Table structure for favorite
-- ----------------------------
DROP TABLE IF EXISTS `favorite`;
CREATE TABLE `favorite`  (
  `Id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `UserId` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'default' COMMENT '收藏的用户',
  `AppId` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'default' COMMENT 'AppID',
  `Position` int(32) NOT NULL DEFAULT 10000 COMMENT '收藏顺序',
  `IsDeleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '1: deleted, 0: normal',
  `DataChange_CreatedBy` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'default' COMMENT '创建人邮箱前缀',
  `DataChange_CreatedTime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `DataChange_LastModifiedBy` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后修改人邮箱前缀',
  `DataChange_LastTime` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改时间',
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `AppId`(`AppId`(191)) USING BTREE,
  INDEX `IX_UserId`(`UserId`) USING BTREE,
  INDEX `DataChange_LastTime`(`DataChange_LastTime`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '应用收藏表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of favorite
-- ----------------------------

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `Id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增Id',
  `PermissionType` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '权限类型',
  `TargetId` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '权限对象类型',
  `IsDeleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '1: deleted, 0: normal',
  `DataChange_CreatedBy` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '创建人邮箱前缀',
  `DataChange_CreatedTime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `DataChange_LastModifiedBy` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后修改人邮箱前缀',
  `DataChange_LastTime` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改时间',
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `IX_TargetId_PermissionType`(`TargetId`(191), `PermissionType`) USING BTREE,
  INDEX `IX_DataChange_LastTime`(`DataChange_LastTime`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 196 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = 'permission表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES (1, 'CreateCluster', 'SampleApp', b'0', '', '2019-12-23 16:50:05', '', '2019-12-23 16:50:05');
INSERT INTO `permission` VALUES (2, 'CreateNamespace', 'SampleApp', b'0', '', '2019-12-23 16:50:05', '', '2019-12-23 16:50:05');
INSERT INTO `permission` VALUES (3, 'AssignRole', 'SampleApp', b'0', '', '2019-12-23 16:50:05', '', '2019-12-23 16:50:05');
INSERT INTO `permission` VALUES (4, 'ModifyNamespace', 'SampleApp+application', b'0', '', '2019-12-23 16:50:05', '', '2019-12-23 16:50:05');
INSERT INTO `permission` VALUES (5, 'ReleaseNamespace', 'SampleApp+application', b'0', '', '2019-12-23 16:50:05', '', '2019-12-23 16:50:05');
INSERT INTO `permission` VALUES (6, 'CreateCluster', 'app-bee-weixin', b'1', 'apollo', '2019-12-24 13:25:05', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `permission` VALUES (7, 'CreateNamespace', 'app-bee-weixin', b'1', 'apollo', '2019-12-24 13:25:05', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `permission` VALUES (8, 'AssignRole', 'app-bee-weixin', b'1', 'apollo', '2019-12-24 13:25:05', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `permission` VALUES (9, 'ModifyNamespace', 'app-bee-weixin+application', b'1', 'apollo', '2019-12-24 13:25:05', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `permission` VALUES (10, 'ReleaseNamespace', 'app-bee-weixin+application', b'1', 'apollo', '2019-12-24 13:25:05', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `permission` VALUES (11, 'ModifyNamespace', 'app-bee-weixin+application+DEV', b'1', 'apollo', '2019-12-24 13:25:05', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `permission` VALUES (12, 'ReleaseNamespace', 'app-bee-weixin+application+DEV', b'1', 'apollo', '2019-12-24 13:25:05', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `permission` VALUES (13, 'CreateCluster', 'app-bee-zuul', b'1', 'apollo', '2019-12-24 15:32:23', 'apollo', '2019-12-31 13:53:05');
INSERT INTO `permission` VALUES (14, 'CreateNamespace', 'app-bee-zuul', b'1', 'apollo', '2019-12-24 15:32:23', 'apollo', '2019-12-31 13:53:05');
INSERT INTO `permission` VALUES (15, 'AssignRole', 'app-bee-zuul', b'1', 'apollo', '2019-12-24 15:32:23', 'apollo', '2019-12-31 13:53:05');
INSERT INTO `permission` VALUES (16, 'ModifyNamespace', 'app-bee-zuul+application', b'1', 'apollo', '2019-12-24 15:32:23', 'apollo', '2019-12-31 13:53:05');
INSERT INTO `permission` VALUES (17, 'ReleaseNamespace', 'app-bee-zuul+application', b'1', 'apollo', '2019-12-24 15:32:23', 'apollo', '2019-12-31 13:53:05');
INSERT INTO `permission` VALUES (18, 'ModifyNamespace', 'app-bee-zuul+application+DEV', b'1', 'apollo', '2019-12-24 15:32:23', 'apollo', '2019-12-31 13:53:05');
INSERT INTO `permission` VALUES (19, 'ReleaseNamespace', 'app-bee-zuul+application+DEV', b'1', 'apollo', '2019-12-24 15:32:23', 'apollo', '2019-12-31 13:53:05');
INSERT INTO `permission` VALUES (20, 'CreateCluster', 'app-bee-member', b'1', 'apollo', '2019-12-25 16:19:43', 'apollo', '2019-12-31 13:53:40');
INSERT INTO `permission` VALUES (21, 'CreateNamespace', 'app-bee-member', b'1', 'apollo', '2019-12-25 16:19:43', 'apollo', '2019-12-31 13:53:40');
INSERT INTO `permission` VALUES (22, 'AssignRole', 'app-bee-member', b'1', 'apollo', '2019-12-25 16:19:43', 'apollo', '2019-12-31 13:53:40');
INSERT INTO `permission` VALUES (23, 'ModifyNamespace', 'app-bee-member+application', b'1', 'apollo', '2019-12-25 16:19:43', 'apollo', '2019-12-31 13:53:40');
INSERT INTO `permission` VALUES (24, 'ReleaseNamespace', 'app-bee-member+application', b'1', 'apollo', '2019-12-25 16:19:44', 'apollo', '2019-12-31 13:53:40');
INSERT INTO `permission` VALUES (25, 'ModifyNamespace', 'app-bee-member+application+DEV', b'1', 'apollo', '2019-12-25 16:19:44', 'apollo', '2019-12-31 13:53:40');
INSERT INTO `permission` VALUES (26, 'ReleaseNamespace', 'app-bee-member+application+DEV', b'1', 'apollo', '2019-12-25 16:19:44', 'apollo', '2019-12-31 13:53:40');
INSERT INTO `permission` VALUES (27, 'ModifyNamespace', 'app-bee-weixin+weixin-config', b'1', 'apollo', '2019-12-26 10:59:08', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `permission` VALUES (28, 'ReleaseNamespace', 'app-bee-weixin+weixin-config', b'1', 'apollo', '2019-12-26 10:59:08', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `permission` VALUES (29, 'ModifyNamespace', 'app-bee-weixin+weixin-config+DEV', b'1', 'apollo', '2019-12-26 10:59:08', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `permission` VALUES (30, 'ReleaseNamespace', 'app-bee-weixin+weixin-config+DEV', b'1', 'apollo', '2019-12-26 10:59:08', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `permission` VALUES (31, 'ModifyNamespace', 'app-bee-weixin+TEST1.redis-config', b'1', 'apollo', '2019-12-26 11:13:25', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `permission` VALUES (32, 'ReleaseNamespace', 'app-bee-weixin+TEST1.redis-config', b'1', 'apollo', '2019-12-26 11:13:26', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `permission` VALUES (33, 'ModifyNamespace', 'app-bee-weixin+TEST1.redis-config+DEV', b'1', 'apollo', '2019-12-26 11:13:26', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `permission` VALUES (34, 'ReleaseNamespace', 'app-bee-weixin+TEST1.redis-config+DEV', b'1', 'apollo', '2019-12-26 11:13:26', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `permission` VALUES (35, 'ModifyNamespace', 'app-bee-weixin+redis-config', b'1', 'apollo', '2019-12-26 11:15:26', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `permission` VALUES (36, 'ReleaseNamespace', 'app-bee-weixin+redis-config', b'1', 'apollo', '2019-12-26 11:15:26', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `permission` VALUES (37, 'ModifyNamespace', 'app-bee-weixin+redis-config+DEV', b'1', 'apollo', '2019-12-26 11:15:26', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `permission` VALUES (38, 'ReleaseNamespace', 'app-bee-weixin+redis-config+DEV', b'1', 'apollo', '2019-12-26 11:15:26', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `permission` VALUES (39, 'ModifyNamespace', 'app-bee-weixin+mysql_redis_config', b'1', 'apollo', '2019-12-27 14:52:22', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `permission` VALUES (40, 'ReleaseNamespace', 'app-bee-weixin+mysql_redis_config', b'1', 'apollo', '2019-12-27 14:52:22', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `permission` VALUES (41, 'ModifyNamespace', 'app-bee-weixin+mysql_redis_config+DEV', b'1', 'apollo', '2019-12-27 14:52:22', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `permission` VALUES (42, 'ReleaseNamespace', 'app-bee-weixin+mysql_redis_config+DEV', b'1', 'apollo', '2019-12-27 14:52:22', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `permission` VALUES (43, 'ModifyNamespace', 'app-bee-member+mysql_redis_config', b'1', 'apollo', '2019-12-27 14:54:08', 'apollo', '2019-12-31 13:53:40');
INSERT INTO `permission` VALUES (44, 'ReleaseNamespace', 'app-bee-member+mysql_redis_config', b'1', 'apollo', '2019-12-27 14:54:08', 'apollo', '2019-12-31 13:53:40');
INSERT INTO `permission` VALUES (45, 'ModifyNamespace', 'app-bee-member+mysql_redis_config+DEV', b'1', 'apollo', '2019-12-27 14:54:08', 'apollo', '2019-12-31 13:53:40');
INSERT INTO `permission` VALUES (46, 'ReleaseNamespace', 'app-bee-member+mysql_redis_config+DEV', b'1', 'apollo', '2019-12-27 14:54:08', 'apollo', '2019-12-31 13:53:40');
INSERT INTO `permission` VALUES (47, 'CreateCluster', 'app--zuul-server', b'1', 'apollo', '2019-12-31 13:43:47', 'apollo', '2019-12-31 14:58:36');
INSERT INTO `permission` VALUES (48, 'CreateNamespace', 'app--zuul-server', b'1', 'apollo', '2019-12-31 13:43:47', 'apollo', '2019-12-31 14:58:36');
INSERT INTO `permission` VALUES (49, 'AssignRole', 'app--zuul-server', b'1', 'apollo', '2019-12-31 13:43:47', 'apollo', '2019-12-31 14:58:36');
INSERT INTO `permission` VALUES (50, 'ModifyNamespace', 'app--zuul-server+application', b'1', 'apollo', '2019-12-31 13:43:47', 'apollo', '2019-12-31 14:58:36');
INSERT INTO `permission` VALUES (51, 'ReleaseNamespace', 'app--zuul-server+application', b'1', 'apollo', '2019-12-31 13:43:47', 'apollo', '2019-12-31 14:58:36');
INSERT INTO `permission` VALUES (52, 'ModifyNamespace', 'app--zuul-server+application+DEV', b'1', 'apollo', '2019-12-31 13:43:47', 'apollo', '2019-12-31 14:58:36');
INSERT INTO `permission` VALUES (53, 'ReleaseNamespace', 'app--zuul-server+application+DEV', b'1', 'apollo', '2019-12-31 13:43:47', 'apollo', '2019-12-31 14:58:36');
INSERT INTO `permission` VALUES (54, 'CreateCluster', 'h2hf-app-weixin', b'0', 'apollo', '2019-12-31 13:56:21', 'apollo', '2019-12-31 13:56:21');
INSERT INTO `permission` VALUES (55, 'CreateNamespace', 'h2hf-app-weixin', b'0', 'apollo', '2019-12-31 13:56:21', 'apollo', '2019-12-31 13:56:21');
INSERT INTO `permission` VALUES (56, 'AssignRole', 'h2hf-app-weixin', b'0', 'apollo', '2019-12-31 13:56:21', 'apollo', '2019-12-31 13:56:21');
INSERT INTO `permission` VALUES (57, 'ModifyNamespace', 'h2hf-app-weixin+application', b'0', 'apollo', '2019-12-31 13:56:21', 'apollo', '2019-12-31 13:56:21');
INSERT INTO `permission` VALUES (58, 'ReleaseNamespace', 'h2hf-app-weixin+application', b'0', 'apollo', '2019-12-31 13:56:21', 'apollo', '2019-12-31 13:56:21');
INSERT INTO `permission` VALUES (59, 'ModifyNamespace', 'h2hf-app-weixin+application+DEV', b'0', 'apollo', '2019-12-31 13:56:21', 'apollo', '2019-12-31 13:56:21');
INSERT INTO `permission` VALUES (60, 'ReleaseNamespace', 'h2hf-app-weixin+application+DEV', b'0', 'apollo', '2019-12-31 13:56:21', 'apollo', '2019-12-31 13:56:21');
INSERT INTO `permission` VALUES (61, 'ModifyNamespace', 'h2hf-app-weixin+weixin-config', b'0', 'apollo', '2019-12-31 14:04:16', 'apollo', '2019-12-31 14:04:16');
INSERT INTO `permission` VALUES (62, 'ReleaseNamespace', 'h2hf-app-weixin+weixin-config', b'0', 'apollo', '2019-12-31 14:04:16', 'apollo', '2019-12-31 14:04:16');
INSERT INTO `permission` VALUES (63, 'ModifyNamespace', 'h2hf-app-weixin+weixin-config+DEV', b'0', 'apollo', '2019-12-31 14:04:17', 'apollo', '2019-12-31 14:04:17');
INSERT INTO `permission` VALUES (64, 'ReleaseNamespace', 'h2hf-app-weixin+weixin-config+DEV', b'0', 'apollo', '2019-12-31 14:04:17', 'apollo', '2019-12-31 14:04:17');
INSERT INTO `permission` VALUES (65, 'ModifyNamespace', 'h2hf-app-weixin+mysql_redis_config', b'0', 'apollo', '2019-12-31 14:06:27', 'apollo', '2019-12-31 14:06:27');
INSERT INTO `permission` VALUES (66, 'ReleaseNamespace', 'h2hf-app-weixin+mysql_redis_config', b'0', 'apollo', '2019-12-31 14:06:27', 'apollo', '2019-12-31 14:06:27');
INSERT INTO `permission` VALUES (67, 'ModifyNamespace', 'h2hf-app-weixin+mysql_redis_config+DEV', b'0', 'apollo', '2019-12-31 14:06:27', 'apollo', '2019-12-31 14:06:27');
INSERT INTO `permission` VALUES (68, 'ReleaseNamespace', 'h2hf-app-weixin+mysql_redis_config+DEV', b'0', 'apollo', '2019-12-31 14:06:27', 'apollo', '2019-12-31 14:06:27');
INSERT INTO `permission` VALUES (69, 'CreateCluster', 'app-zuul-serve', b'0', 'apollo', '2019-12-31 14:59:02', 'apollo', '2019-12-31 14:59:02');
INSERT INTO `permission` VALUES (70, 'CreateNamespace', 'app-zuul-serve', b'0', 'apollo', '2019-12-31 14:59:02', 'apollo', '2019-12-31 14:59:02');
INSERT INTO `permission` VALUES (71, 'AssignRole', 'app-zuul-serve', b'0', 'apollo', '2019-12-31 14:59:02', 'apollo', '2019-12-31 14:59:02');
INSERT INTO `permission` VALUES (72, 'ModifyNamespace', 'app-zuul-serve+application', b'0', 'apollo', '2019-12-31 14:59:02', 'apollo', '2019-12-31 14:59:02');
INSERT INTO `permission` VALUES (73, 'ReleaseNamespace', 'app-zuul-serve+application', b'0', 'apollo', '2019-12-31 14:59:02', 'apollo', '2019-12-31 14:59:02');
INSERT INTO `permission` VALUES (74, 'ModifyNamespace', 'app-zuul-serve+application+DEV', b'0', 'apollo', '2019-12-31 14:59:02', 'apollo', '2019-12-31 14:59:02');
INSERT INTO `permission` VALUES (75, 'ReleaseNamespace', 'app-zuul-serve+application+DEV', b'0', 'apollo', '2019-12-31 14:59:02', 'apollo', '2019-12-31 14:59:02');
INSERT INTO `permission` VALUES (76, 'CreateCluster', 'h2hf-app-member', b'0', 'apollo', '2019-12-31 15:56:28', 'apollo', '2019-12-31 15:56:28');
INSERT INTO `permission` VALUES (77, 'CreateNamespace', 'h2hf-app-member', b'0', 'apollo', '2019-12-31 15:56:28', 'apollo', '2019-12-31 15:56:28');
INSERT INTO `permission` VALUES (78, 'AssignRole', 'h2hf-app-member', b'0', 'apollo', '2019-12-31 15:56:28', 'apollo', '2019-12-31 15:56:28');
INSERT INTO `permission` VALUES (79, 'ModifyNamespace', 'h2hf-app-member+application', b'0', 'apollo', '2019-12-31 15:56:28', 'apollo', '2019-12-31 15:56:28');
INSERT INTO `permission` VALUES (80, 'ReleaseNamespace', 'h2hf-app-member+application', b'0', 'apollo', '2019-12-31 15:56:28', 'apollo', '2019-12-31 15:56:28');
INSERT INTO `permission` VALUES (81, 'ModifyNamespace', 'h2hf-app-member+application+DEV', b'0', 'apollo', '2019-12-31 15:56:28', 'apollo', '2019-12-31 15:56:28');
INSERT INTO `permission` VALUES (82, 'ReleaseNamespace', 'h2hf-app-member+application+DEV', b'0', 'apollo', '2019-12-31 15:56:28', 'apollo', '2019-12-31 15:56:28');
INSERT INTO `permission` VALUES (83, 'ModifyNamespace', 'h2hf-app-member+mysql_redis_config', b'1', 'apollo', '2019-12-31 17:13:06', 'apollo', '2020-01-03 10:58:26');
INSERT INTO `permission` VALUES (84, 'ReleaseNamespace', 'h2hf-app-member+mysql_redis_config', b'1', 'apollo', '2019-12-31 17:13:06', 'apollo', '2020-01-03 10:58:26');
INSERT INTO `permission` VALUES (85, 'ModifyNamespace', 'h2hf-app-member+mysql_redis_config+DEV', b'0', 'apollo', '2019-12-31 17:13:06', 'apollo', '2019-12-31 17:13:06');
INSERT INTO `permission` VALUES (86, 'ReleaseNamespace', 'h2hf-app-member+mysql_redis_config+DEV', b'0', 'apollo', '2019-12-31 17:13:06', 'apollo', '2019-12-31 17:13:06');
INSERT INTO `permission` VALUES (87, 'ModifyNamespace', 'h2hf-app-weixin+weixin_mysql_redis_config', b'0', 'apollo', '2020-01-02 10:58:03', 'apollo', '2020-01-02 10:58:03');
INSERT INTO `permission` VALUES (88, 'ReleaseNamespace', 'h2hf-app-weixin+weixin_mysql_redis_config', b'0', 'apollo', '2020-01-02 10:58:03', 'apollo', '2020-01-02 10:58:03');
INSERT INTO `permission` VALUES (89, 'ModifyNamespace', 'h2hf-app-weixin+weixin_mysql_redis_config+DEV', b'0', 'apollo', '2020-01-02 10:58:03', 'apollo', '2020-01-02 10:58:03');
INSERT INTO `permission` VALUES (90, 'ReleaseNamespace', 'h2hf-app-weixin+weixin_mysql_redis_config+DEV', b'0', 'apollo', '2020-01-02 10:58:03', 'apollo', '2020-01-02 10:58:03');
INSERT INTO `permission` VALUES (91, 'CreateCluster', 'h2hf-app-auth', b'0', 'apollo', '2020-01-02 14:49:33', 'apollo', '2020-01-02 14:49:33');
INSERT INTO `permission` VALUES (92, 'CreateNamespace', 'h2hf-app-auth', b'0', 'apollo', '2020-01-02 14:49:33', 'apollo', '2020-01-02 14:49:33');
INSERT INTO `permission` VALUES (93, 'AssignRole', 'h2hf-app-auth', b'0', 'apollo', '2020-01-02 14:49:33', 'apollo', '2020-01-02 14:49:33');
INSERT INTO `permission` VALUES (94, 'ModifyNamespace', 'h2hf-app-auth+application', b'0', 'apollo', '2020-01-02 14:49:33', 'apollo', '2020-01-02 14:49:33');
INSERT INTO `permission` VALUES (95, 'ReleaseNamespace', 'h2hf-app-auth+application', b'0', 'apollo', '2020-01-02 14:49:33', 'apollo', '2020-01-02 14:49:33');
INSERT INTO `permission` VALUES (96, 'ModifyNamespace', 'h2hf-app-auth+application+DEV', b'0', 'apollo', '2020-01-02 14:49:33', 'apollo', '2020-01-02 14:49:33');
INSERT INTO `permission` VALUES (97, 'ReleaseNamespace', 'h2hf-app-auth+application+DEV', b'0', 'apollo', '2020-01-02 14:49:33', 'apollo', '2020-01-02 14:49:33');
INSERT INTO `permission` VALUES (98, 'ModifyNamespace', 'h2hf-app-auth+auth_mysql_redis_config', b'0', 'apollo', '2020-01-02 14:52:15', 'apollo', '2020-01-02 14:52:15');
INSERT INTO `permission` VALUES (99, 'ReleaseNamespace', 'h2hf-app-auth+auth_mysql_redis_config', b'0', 'apollo', '2020-01-02 14:52:16', 'apollo', '2020-01-02 14:52:16');
INSERT INTO `permission` VALUES (100, 'ModifyNamespace', 'h2hf-app-auth+auth_mysql_redis_config+DEV', b'0', 'apollo', '2020-01-02 14:52:16', 'apollo', '2020-01-02 14:52:16');
INSERT INTO `permission` VALUES (101, 'ReleaseNamespace', 'h2hf-app-auth+auth_mysql_redis_config+DEV', b'0', 'apollo', '2020-01-02 14:52:16', 'apollo', '2020-01-02 14:52:16');
INSERT INTO `permission` VALUES (102, 'ModifyNamespace', 'h2hf-app-auth+user_auth_config', b'0', 'apollo', '2020-01-02 14:54:38', 'apollo', '2020-01-02 14:54:38');
INSERT INTO `permission` VALUES (103, 'ReleaseNamespace', 'h2hf-app-auth+user_auth_config', b'0', 'apollo', '2020-01-02 14:54:38', 'apollo', '2020-01-02 14:54:38');
INSERT INTO `permission` VALUES (104, 'ModifyNamespace', 'h2hf-app-auth+user_auth_config+DEV', b'0', 'apollo', '2020-01-02 14:54:38', 'apollo', '2020-01-02 14:54:38');
INSERT INTO `permission` VALUES (105, 'ReleaseNamespace', 'h2hf-app-auth+user_auth_config+DEV', b'0', 'apollo', '2020-01-02 14:54:38', 'apollo', '2020-01-02 14:54:38');
INSERT INTO `permission` VALUES (106, 'ModifyNamespace', 'h2hf-app-member+memeber_mysql_redis_config', b'0', 'apollo', '2020-01-03 10:59:11', 'apollo', '2020-01-03 10:59:11');
INSERT INTO `permission` VALUES (107, 'ReleaseNamespace', 'h2hf-app-member+memeber_mysql_redis_config', b'0', 'apollo', '2020-01-03 10:59:11', 'apollo', '2020-01-03 10:59:11');
INSERT INTO `permission` VALUES (108, 'ModifyNamespace', 'h2hf-app-member+memeber_mysql_redis_config+DEV', b'0', 'apollo', '2020-01-03 10:59:11', 'apollo', '2020-01-03 10:59:11');
INSERT INTO `permission` VALUES (109, 'ReleaseNamespace', 'h2hf-app-member+memeber_mysql_redis_config+DEV', b'0', 'apollo', '2020-01-03 10:59:11', 'apollo', '2020-01-03 10:59:11');
INSERT INTO `permission` VALUES (110, 'ModifyNamespace', 'h2hf-app-member+member_mysql_redis_config', b'0', 'apollo', '2020-01-03 11:15:47', 'apollo', '2020-01-03 11:15:47');
INSERT INTO `permission` VALUES (111, 'ReleaseNamespace', 'h2hf-app-member+member_mysql_redis_config', b'0', 'apollo', '2020-01-03 11:15:47', 'apollo', '2020-01-03 11:15:47');
INSERT INTO `permission` VALUES (112, 'ModifyNamespace', 'h2hf-app-member+member_mysql_redis_config+DEV', b'0', 'apollo', '2020-01-03 11:15:47', 'apollo', '2020-01-03 11:15:47');
INSERT INTO `permission` VALUES (113, 'ReleaseNamespace', 'h2hf-app-member+member_mysql_redis_config+DEV', b'0', 'apollo', '2020-01-03 11:15:47', 'apollo', '2020-01-03 11:15:47');
INSERT INTO `permission` VALUES (114, 'CreateCluster', 'gateway-server', b'0', 'apollo', '2020-01-04 18:18:13', 'apollo', '2020-01-04 18:18:13');
INSERT INTO `permission` VALUES (115, 'CreateNamespace', 'gateway-server', b'0', 'apollo', '2020-01-04 18:18:13', 'apollo', '2020-01-04 18:18:13');
INSERT INTO `permission` VALUES (116, 'AssignRole', 'gateway-server', b'0', 'apollo', '2020-01-04 18:18:13', 'apollo', '2020-01-04 18:18:13');
INSERT INTO `permission` VALUES (117, 'ModifyNamespace', 'gateway-server+application', b'0', 'apollo', '2020-01-04 18:18:13', 'apollo', '2020-01-04 18:18:13');
INSERT INTO `permission` VALUES (118, 'ReleaseNamespace', 'gateway-server+application', b'0', 'apollo', '2020-01-04 18:18:13', 'apollo', '2020-01-04 18:18:13');
INSERT INTO `permission` VALUES (119, 'ModifyNamespace', 'gateway-server+application+DEV', b'0', 'apollo', '2020-01-04 18:18:13', 'apollo', '2020-01-04 18:18:13');
INSERT INTO `permission` VALUES (120, 'ReleaseNamespace', 'gateway-server+application+DEV', b'0', 'apollo', '2020-01-04 18:18:13', 'apollo', '2020-01-04 18:18:13');
INSERT INTO `permission` VALUES (121, 'CreateCluster', 'member-server', b'0', 'apollo', '2020-01-04 19:08:15', 'apollo', '2020-01-04 19:08:15');
INSERT INTO `permission` VALUES (122, 'CreateNamespace', 'member-server', b'0', 'apollo', '2020-01-04 19:08:15', 'apollo', '2020-01-04 19:08:15');
INSERT INTO `permission` VALUES (123, 'AssignRole', 'member-server', b'0', 'apollo', '2020-01-04 19:08:15', 'apollo', '2020-01-04 19:08:15');
INSERT INTO `permission` VALUES (124, 'ModifyNamespace', 'member-server+application', b'0', 'apollo', '2020-01-04 19:08:15', 'apollo', '2020-01-04 19:08:15');
INSERT INTO `permission` VALUES (125, 'ReleaseNamespace', 'member-server+application', b'0', 'apollo', '2020-01-04 19:08:15', 'apollo', '2020-01-04 19:08:15');
INSERT INTO `permission` VALUES (126, 'ModifyNamespace', 'member-server+application+DEV', b'0', 'apollo', '2020-01-04 19:08:15', 'apollo', '2020-01-04 19:08:15');
INSERT INTO `permission` VALUES (127, 'ReleaseNamespace', 'member-server+application+DEV', b'0', 'apollo', '2020-01-04 19:08:15', 'apollo', '2020-01-04 19:08:15');
INSERT INTO `permission` VALUES (128, 'ModifyNamespace', 'member-server+member_swagger_config', b'1', 'apollo', '2020-01-04 19:11:06', 'apollo', '2020-01-05 14:38:10');
INSERT INTO `permission` VALUES (129, 'ReleaseNamespace', 'member-server+member_swagger_config', b'1', 'apollo', '2020-01-04 19:11:06', 'apollo', '2020-01-05 14:38:10');
INSERT INTO `permission` VALUES (130, 'ModifyNamespace', 'member-server+member_swagger_config+DEV', b'0', 'apollo', '2020-01-04 19:11:06', 'apollo', '2020-01-04 19:11:06');
INSERT INTO `permission` VALUES (131, 'ReleaseNamespace', 'member-server+member_swagger_config+DEV', b'0', 'apollo', '2020-01-04 19:11:06', 'apollo', '2020-01-04 19:11:06');
INSERT INTO `permission` VALUES (132, 'ModifyNamespace', 'member-server+member-redis-mysql-config', b'0', 'apollo', '2020-01-04 19:13:57', 'apollo', '2020-01-04 19:13:57');
INSERT INTO `permission` VALUES (133, 'ReleaseNamespace', 'member-server+member-redis-mysql-config', b'0', 'apollo', '2020-01-04 19:13:57', 'apollo', '2020-01-04 19:13:57');
INSERT INTO `permission` VALUES (134, 'ModifyNamespace', 'member-server+member-redis-mysql-config+DEV', b'0', 'apollo', '2020-01-04 19:13:57', 'apollo', '2020-01-04 19:13:57');
INSERT INTO `permission` VALUES (135, 'ReleaseNamespace', 'member-server+member-redis-mysql-config+DEV', b'0', 'apollo', '2020-01-04 19:13:57', 'apollo', '2020-01-04 19:13:57');
INSERT INTO `permission` VALUES (136, 'CreateCluster', 'auth-server', b'0', 'apollo', '2020-01-07 15:07:40', 'apollo', '2020-01-07 15:07:40');
INSERT INTO `permission` VALUES (137, 'CreateNamespace', 'auth-server', b'0', 'apollo', '2020-01-07 15:07:40', 'apollo', '2020-01-07 15:07:40');
INSERT INTO `permission` VALUES (138, 'AssignRole', 'auth-server', b'0', 'apollo', '2020-01-07 15:07:40', 'apollo', '2020-01-07 15:07:40');
INSERT INTO `permission` VALUES (139, 'ModifyNamespace', 'auth-server+application', b'0', 'apollo', '2020-01-07 15:07:40', 'apollo', '2020-01-07 15:07:40');
INSERT INTO `permission` VALUES (140, 'ReleaseNamespace', 'auth-server+application', b'0', 'apollo', '2020-01-07 15:07:40', 'apollo', '2020-01-07 15:07:40');
INSERT INTO `permission` VALUES (141, 'ModifyNamespace', 'auth-server+application+DEV', b'0', 'apollo', '2020-01-07 15:07:40', 'apollo', '2020-01-07 15:07:40');
INSERT INTO `permission` VALUES (142, 'ReleaseNamespace', 'auth-server+application+DEV', b'0', 'apollo', '2020-01-07 15:07:40', 'apollo', '2020-01-07 15:07:40');
INSERT INTO `permission` VALUES (143, 'ModifyNamespace', 'auth-server+auth_config', b'0', 'apollo', '2020-01-07 15:11:08', 'apollo', '2020-01-07 15:11:08');
INSERT INTO `permission` VALUES (144, 'ReleaseNamespace', 'auth-server+auth_config', b'0', 'apollo', '2020-01-07 15:11:08', 'apollo', '2020-01-07 15:11:08');
INSERT INTO `permission` VALUES (145, 'ModifyNamespace', 'auth-server+auth_config+DEV', b'0', 'apollo', '2020-01-07 15:11:08', 'apollo', '2020-01-07 15:11:08');
INSERT INTO `permission` VALUES (146, 'ReleaseNamespace', 'auth-server+auth_config+DEV', b'0', 'apollo', '2020-01-07 15:11:08', 'apollo', '2020-01-07 15:11:08');
INSERT INTO `permission` VALUES (147, 'ModifyNamespace', 'auth-server+auth_swagger_config', b'0', 'apollo', '2020-01-07 15:15:01', 'apollo', '2020-01-07 15:15:01');
INSERT INTO `permission` VALUES (148, 'ReleaseNamespace', 'auth-server+auth_swagger_config', b'0', 'apollo', '2020-01-07 15:15:01', 'apollo', '2020-01-07 15:15:01');
INSERT INTO `permission` VALUES (149, 'ModifyNamespace', 'auth-server+auth_swagger_config+DEV', b'0', 'apollo', '2020-01-07 15:15:01', 'apollo', '2020-01-07 15:15:01');
INSERT INTO `permission` VALUES (150, 'ReleaseNamespace', 'auth-server+auth_swagger_config+DEV', b'0', 'apollo', '2020-01-07 15:15:01', 'apollo', '2020-01-07 15:15:01');
INSERT INTO `permission` VALUES (151, 'ModifyNamespace', 'auth-server+auth_mysql_redis_config', b'0', 'apollo', '2020-01-08 09:07:48', 'apollo', '2020-01-08 09:07:48');
INSERT INTO `permission` VALUES (152, 'ReleaseNamespace', 'auth-server+auth_mysql_redis_config', b'0', 'apollo', '2020-01-08 09:07:48', 'apollo', '2020-01-08 09:07:48');
INSERT INTO `permission` VALUES (153, 'ModifyNamespace', 'auth-server+auth_mysql_redis_config+DEV', b'0', 'apollo', '2020-01-08 09:07:48', 'apollo', '2020-01-08 09:07:48');
INSERT INTO `permission` VALUES (154, 'ReleaseNamespace', 'auth-server+auth_mysql_redis_config+DEV', b'0', 'apollo', '2020-01-08 09:07:48', 'apollo', '2020-01-08 09:07:48');
INSERT INTO `permission` VALUES (155, 'CreateCluster', 'saas-server', b'0', 'apollo', '2020-02-02 23:23:21', 'apollo', '2020-02-02 23:23:21');
INSERT INTO `permission` VALUES (156, 'CreateNamespace', 'saas-server', b'0', 'apollo', '2020-02-02 23:23:21', 'apollo', '2020-02-02 23:23:21');
INSERT INTO `permission` VALUES (157, 'AssignRole', 'saas-server', b'0', 'apollo', '2020-02-02 23:23:21', 'apollo', '2020-02-02 23:23:21');
INSERT INTO `permission` VALUES (158, 'ModifyNamespace', 'saas-server+application', b'0', 'apollo', '2020-02-02 23:23:21', 'apollo', '2020-02-02 23:23:21');
INSERT INTO `permission` VALUES (159, 'ReleaseNamespace', 'saas-server+application', b'0', 'apollo', '2020-02-02 23:23:21', 'apollo', '2020-02-02 23:23:21');
INSERT INTO `permission` VALUES (160, 'ModifyNamespace', 'saas-server+application+DEV', b'0', 'apollo', '2020-02-02 23:23:21', 'apollo', '2020-02-02 23:23:21');
INSERT INTO `permission` VALUES (161, 'ReleaseNamespace', 'saas-server+application+DEV', b'0', 'apollo', '2020-02-02 23:23:21', 'apollo', '2020-02-02 23:23:21');
INSERT INTO `permission` VALUES (162, 'ModifyNamespace', 'saas-server+saas-redis-mysql-config', b'0', 'apollo', '2020-02-02 23:25:05', 'apollo', '2020-02-02 23:25:05');
INSERT INTO `permission` VALUES (163, 'ReleaseNamespace', 'saas-server+saas-redis-mysql-config', b'0', 'apollo', '2020-02-02 23:25:05', 'apollo', '2020-02-02 23:25:05');
INSERT INTO `permission` VALUES (164, 'ModifyNamespace', 'saas-server+saas-redis-mysql-config+DEV', b'0', 'apollo', '2020-02-02 23:25:05', 'apollo', '2020-02-02 23:25:05');
INSERT INTO `permission` VALUES (165, 'ReleaseNamespace', 'saas-server+saas-redis-mysql-config+DEV', b'0', 'apollo', '2020-02-02 23:25:05', 'apollo', '2020-02-02 23:25:05');
INSERT INTO `permission` VALUES (166, 'ModifyNamespace', 'gateway-server+gateway_mysql_redis_config', b'1', 'apollo', '2020-02-03 23:00:58', 'apollo', '2020-02-03 23:20:41');
INSERT INTO `permission` VALUES (167, 'ReleaseNamespace', 'gateway-server+gateway_mysql_redis_config', b'1', 'apollo', '2020-02-03 23:00:58', 'apollo', '2020-02-03 23:20:41');
INSERT INTO `permission` VALUES (168, 'ModifyNamespace', 'gateway-server+gateway_mysql_redis_config+DEV', b'0', 'apollo', '2020-02-03 23:00:58', 'apollo', '2020-02-03 23:00:58');
INSERT INTO `permission` VALUES (169, 'ReleaseNamespace', 'gateway-server+gateway_mysql_redis_config+DEV', b'0', 'apollo', '2020-02-03 23:00:58', 'apollo', '2020-02-03 23:00:58');
INSERT INTO `permission` VALUES (170, 'CreateCluster', 'system-server', b'0', 'apollo', '2020-02-06 21:30:15', 'apollo', '2020-02-06 21:30:15');
INSERT INTO `permission` VALUES (171, 'CreateNamespace', 'system-server', b'0', 'apollo', '2020-02-06 21:30:15', 'apollo', '2020-02-06 21:30:15');
INSERT INTO `permission` VALUES (172, 'AssignRole', 'system-server', b'0', 'apollo', '2020-02-06 21:30:15', 'apollo', '2020-02-06 21:30:15');
INSERT INTO `permission` VALUES (173, 'ModifyNamespace', 'system-server+application', b'0', 'apollo', '2020-02-06 21:30:15', 'apollo', '2020-02-06 21:30:15');
INSERT INTO `permission` VALUES (174, 'ReleaseNamespace', 'system-server+application', b'0', 'apollo', '2020-02-06 21:30:15', 'apollo', '2020-02-06 21:30:15');
INSERT INTO `permission` VALUES (175, 'ModifyNamespace', 'system-server+application+DEV', b'0', 'apollo', '2020-02-06 21:30:15', 'apollo', '2020-02-06 21:30:15');
INSERT INTO `permission` VALUES (176, 'ReleaseNamespace', 'system-server+application+DEV', b'0', 'apollo', '2020-02-06 21:30:15', 'apollo', '2020-02-06 21:30:15');
INSERT INTO `permission` VALUES (177, 'ModifyNamespace', 'system-server+system-redis-mysql-config', b'0', 'apollo', '2020-02-06 21:32:16', 'apollo', '2020-02-06 21:32:16');
INSERT INTO `permission` VALUES (178, 'ReleaseNamespace', 'system-server+system-redis-mysql-config', b'0', 'apollo', '2020-02-06 21:32:16', 'apollo', '2020-02-06 21:32:16');
INSERT INTO `permission` VALUES (179, 'ModifyNamespace', 'system-server+system-redis-mysql-config+DEV', b'0', 'apollo', '2020-02-06 21:32:16', 'apollo', '2020-02-06 21:32:16');
INSERT INTO `permission` VALUES (180, 'ReleaseNamespace', 'system-server+system-redis-mysql-config+DEV', b'0', 'apollo', '2020-02-06 21:32:16', 'apollo', '2020-02-06 21:32:16');
INSERT INTO `permission` VALUES (181, 'CreateCluster', 'shop-server', b'0', 'apollo', '2020-02-20 15:13:17', 'apollo', '2020-02-20 15:13:17');
INSERT INTO `permission` VALUES (182, 'CreateNamespace', 'shop-server', b'0', 'apollo', '2020-02-20 15:13:17', 'apollo', '2020-02-20 15:13:17');
INSERT INTO `permission` VALUES (183, 'AssignRole', 'shop-server', b'0', 'apollo', '2020-02-20 15:13:17', 'apollo', '2020-02-20 15:13:17');
INSERT INTO `permission` VALUES (184, 'ModifyNamespace', 'shop-server+application', b'0', 'apollo', '2020-02-20 15:13:17', 'apollo', '2020-02-20 15:13:17');
INSERT INTO `permission` VALUES (185, 'ReleaseNamespace', 'shop-server+application', b'0', 'apollo', '2020-02-20 15:13:17', 'apollo', '2020-02-20 15:13:17');
INSERT INTO `permission` VALUES (186, 'ModifyNamespace', 'shop-server+application+DEV', b'0', 'apollo', '2020-02-20 15:13:17', 'apollo', '2020-02-20 15:13:17');
INSERT INTO `permission` VALUES (187, 'ReleaseNamespace', 'shop-server+application+DEV', b'0', 'apollo', '2020-02-20 15:13:17', 'apollo', '2020-02-20 15:13:17');
INSERT INTO `permission` VALUES (188, 'ModifyNamespace', 'shop-server+shop-redis-mysql-config', b'0', 'apollo', '2020-02-20 15:15:22', 'apollo', '2020-02-20 15:15:22');
INSERT INTO `permission` VALUES (189, 'ReleaseNamespace', 'shop-server+shop-redis-mysql-config', b'0', 'apollo', '2020-02-20 15:15:22', 'apollo', '2020-02-20 15:15:22');
INSERT INTO `permission` VALUES (190, 'ModifyNamespace', 'shop-server+shop-redis-mysql-config+DEV', b'0', 'apollo', '2020-02-20 15:15:22', 'apollo', '2020-02-20 15:15:22');
INSERT INTO `permission` VALUES (191, 'ReleaseNamespace', 'shop-server+shop-redis-mysql-config+DEV', b'0', 'apollo', '2020-02-20 15:15:22', 'apollo', '2020-02-20 15:15:22');
INSERT INTO `permission` VALUES (192, 'ModifyNamespace', 'system-server+upload_config', b'0', 'apollo', '2020-02-23 01:27:16', 'apollo', '2020-02-23 01:27:16');
INSERT INTO `permission` VALUES (193, 'ReleaseNamespace', 'system-server+upload_config', b'0', 'apollo', '2020-02-23 01:27:16', 'apollo', '2020-02-23 01:27:16');
INSERT INTO `permission` VALUES (194, 'ModifyNamespace', 'system-server+upload_config+DEV', b'0', 'apollo', '2020-02-23 01:27:16', 'apollo', '2020-02-23 01:27:16');
INSERT INTO `permission` VALUES (195, 'ReleaseNamespace', 'system-server+upload_config+DEV', b'0', 'apollo', '2020-02-23 01:27:16', 'apollo', '2020-02-23 01:27:16');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `Id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增Id',
  `RoleName` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT 'Role name',
  `IsDeleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '1: deleted, 0: normal',
  `DataChange_CreatedBy` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'default' COMMENT '创建人邮箱前缀',
  `DataChange_CreatedTime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `DataChange_LastModifiedBy` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后修改人邮箱前缀',
  `DataChange_LastTime` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改时间',
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `IX_RoleName`(`RoleName`(191)) USING BTREE,
  INDEX `IX_DataChange_LastTime`(`DataChange_LastTime`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 166 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'Master+SampleApp', b'0', 'default', '2019-12-23 16:50:05', '', '2019-12-23 16:50:05');
INSERT INTO `role` VALUES (2, 'ModifyNamespace+SampleApp+application', b'0', 'default', '2019-12-23 16:50:05', '', '2019-12-23 16:50:05');
INSERT INTO `role` VALUES (3, 'ReleaseNamespace+SampleApp+application', b'0', 'default', '2019-12-23 16:50:05', '', '2019-12-23 16:50:05');
INSERT INTO `role` VALUES (4, 'Master+app-bee-weixin', b'1', 'apollo', '2019-12-24 13:25:05', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `role` VALUES (5, 'ModifyNamespace+app-bee-weixin+application', b'1', 'apollo', '2019-12-24 13:25:05', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `role` VALUES (6, 'ReleaseNamespace+app-bee-weixin+application', b'1', 'apollo', '2019-12-24 13:25:05', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `role` VALUES (7, 'ModifyNamespace+app-bee-weixin+application+DEV', b'1', 'apollo', '2019-12-24 13:25:05', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `role` VALUES (8, 'ReleaseNamespace+app-bee-weixin+application+DEV', b'1', 'apollo', '2019-12-24 13:25:05', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `role` VALUES (9, 'Master+app-bee-zuul', b'1', 'apollo', '2019-12-24 15:32:23', 'apollo', '2019-12-31 13:53:05');
INSERT INTO `role` VALUES (10, 'ModifyNamespace+app-bee-zuul+application', b'1', 'apollo', '2019-12-24 15:32:23', 'apollo', '2019-12-31 13:53:05');
INSERT INTO `role` VALUES (11, 'ReleaseNamespace+app-bee-zuul+application', b'1', 'apollo', '2019-12-24 15:32:23', 'apollo', '2019-12-31 13:53:05');
INSERT INTO `role` VALUES (12, 'ModifyNamespace+app-bee-zuul+application+DEV', b'1', 'apollo', '2019-12-24 15:32:23', 'apollo', '2019-12-31 13:53:05');
INSERT INTO `role` VALUES (13, 'ReleaseNamespace+app-bee-zuul+application+DEV', b'1', 'apollo', '2019-12-24 15:32:23', 'apollo', '2019-12-31 13:53:05');
INSERT INTO `role` VALUES (14, 'Master+app-bee-member', b'1', 'apollo', '2019-12-25 16:19:43', 'apollo', '2019-12-31 13:53:40');
INSERT INTO `role` VALUES (15, 'ModifyNamespace+app-bee-member+application', b'1', 'apollo', '2019-12-25 16:19:43', 'apollo', '2019-12-31 13:53:40');
INSERT INTO `role` VALUES (16, 'ReleaseNamespace+app-bee-member+application', b'1', 'apollo', '2019-12-25 16:19:44', 'apollo', '2019-12-31 13:53:40');
INSERT INTO `role` VALUES (17, 'ModifyNamespace+app-bee-member+application+DEV', b'1', 'apollo', '2019-12-25 16:19:44', 'apollo', '2019-12-31 13:53:40');
INSERT INTO `role` VALUES (18, 'ReleaseNamespace+app-bee-member+application+DEV', b'1', 'apollo', '2019-12-25 16:19:44', 'apollo', '2019-12-31 13:53:40');
INSERT INTO `role` VALUES (19, 'ModifyNamespace+app-bee-weixin+weixin-config', b'1', 'apollo', '2019-12-26 10:59:08', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `role` VALUES (20, 'ReleaseNamespace+app-bee-weixin+weixin-config', b'1', 'apollo', '2019-12-26 10:59:08', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `role` VALUES (21, 'ModifyNamespace+app-bee-weixin+weixin-config+DEV', b'1', 'apollo', '2019-12-26 10:59:08', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `role` VALUES (22, 'ReleaseNamespace+app-bee-weixin+weixin-config+DEV', b'1', 'apollo', '2019-12-26 10:59:08', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `role` VALUES (23, 'ModifyNamespace+app-bee-weixin+TEST1.redis-config', b'1', 'apollo', '2019-12-26 11:13:25', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `role` VALUES (24, 'ReleaseNamespace+app-bee-weixin+TEST1.redis-config', b'1', 'apollo', '2019-12-26 11:13:26', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `role` VALUES (25, 'ModifyNamespace+app-bee-weixin+TEST1.redis-config+DEV', b'1', 'apollo', '2019-12-26 11:13:26', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `role` VALUES (26, 'ReleaseNamespace+app-bee-weixin+TEST1.redis-config+DEV', b'1', 'apollo', '2019-12-26 11:13:26', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `role` VALUES (27, 'ModifyNamespace+app-bee-weixin+redis-config', b'1', 'apollo', '2019-12-26 11:15:26', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `role` VALUES (28, 'ReleaseNamespace+app-bee-weixin+redis-config', b'1', 'apollo', '2019-12-26 11:15:26', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `role` VALUES (29, 'ModifyNamespace+app-bee-weixin+redis-config+DEV', b'1', 'apollo', '2019-12-26 11:15:26', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `role` VALUES (30, 'ReleaseNamespace+app-bee-weixin+redis-config+DEV', b'1', 'apollo', '2019-12-26 11:15:26', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `role` VALUES (31, 'ModifyNamespace+app-bee-weixin+mysql_redis_config', b'1', 'apollo', '2019-12-27 14:52:22', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `role` VALUES (32, 'ReleaseNamespace+app-bee-weixin+mysql_redis_config', b'1', 'apollo', '2019-12-27 14:52:22', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `role` VALUES (33, 'ModifyNamespace+app-bee-weixin+mysql_redis_config+DEV', b'1', 'apollo', '2019-12-27 14:52:22', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `role` VALUES (34, 'ReleaseNamespace+app-bee-weixin+mysql_redis_config+DEV', b'1', 'apollo', '2019-12-27 14:52:22', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `role` VALUES (35, 'ModifyNamespace+app-bee-member+mysql_redis_config', b'1', 'apollo', '2019-12-27 14:54:08', 'apollo', '2019-12-31 13:53:40');
INSERT INTO `role` VALUES (36, 'ReleaseNamespace+app-bee-member+mysql_redis_config', b'1', 'apollo', '2019-12-27 14:54:08', 'apollo', '2019-12-31 13:53:40');
INSERT INTO `role` VALUES (37, 'ModifyNamespace+app-bee-member+mysql_redis_config+DEV', b'1', 'apollo', '2019-12-27 14:54:08', 'apollo', '2019-12-31 13:53:40');
INSERT INTO `role` VALUES (38, 'ReleaseNamespace+app-bee-member+mysql_redis_config+DEV', b'1', 'apollo', '2019-12-27 14:54:08', 'apollo', '2019-12-31 13:53:40');
INSERT INTO `role` VALUES (39, 'Master+app--zuul-server', b'1', 'apollo', '2019-12-31 13:43:47', 'apollo', '2019-12-31 14:58:36');
INSERT INTO `role` VALUES (40, 'ModifyNamespace+app--zuul-server+application', b'1', 'apollo', '2019-12-31 13:43:47', 'apollo', '2019-12-31 14:58:36');
INSERT INTO `role` VALUES (41, 'ReleaseNamespace+app--zuul-server+application', b'1', 'apollo', '2019-12-31 13:43:47', 'apollo', '2019-12-31 14:58:36');
INSERT INTO `role` VALUES (42, 'ModifyNamespace+app--zuul-server+application+DEV', b'1', 'apollo', '2019-12-31 13:43:47', 'apollo', '2019-12-31 14:58:36');
INSERT INTO `role` VALUES (43, 'ReleaseNamespace+app--zuul-server+application+DEV', b'1', 'apollo', '2019-12-31 13:43:47', 'apollo', '2019-12-31 14:58:36');
INSERT INTO `role` VALUES (44, 'Master+h2hf-app-weixin', b'0', 'apollo', '2019-12-31 13:56:21', 'apollo', '2019-12-31 13:56:21');
INSERT INTO `role` VALUES (45, 'ModifyNamespace+h2hf-app-weixin+application', b'0', 'apollo', '2019-12-31 13:56:21', 'apollo', '2019-12-31 13:56:21');
INSERT INTO `role` VALUES (46, 'ReleaseNamespace+h2hf-app-weixin+application', b'0', 'apollo', '2019-12-31 13:56:21', 'apollo', '2019-12-31 13:56:21');
INSERT INTO `role` VALUES (47, 'ModifyNamespace+h2hf-app-weixin+application+DEV', b'0', 'apollo', '2019-12-31 13:56:21', 'apollo', '2019-12-31 13:56:21');
INSERT INTO `role` VALUES (48, 'ReleaseNamespace+h2hf-app-weixin+application+DEV', b'0', 'apollo', '2019-12-31 13:56:21', 'apollo', '2019-12-31 13:56:21');
INSERT INTO `role` VALUES (49, 'ModifyNamespace+h2hf-app-weixin+weixin-config', b'0', 'apollo', '2019-12-31 14:04:16', 'apollo', '2019-12-31 14:04:16');
INSERT INTO `role` VALUES (50, 'ReleaseNamespace+h2hf-app-weixin+weixin-config', b'0', 'apollo', '2019-12-31 14:04:16', 'apollo', '2019-12-31 14:04:16');
INSERT INTO `role` VALUES (51, 'ModifyNamespace+h2hf-app-weixin+weixin-config+DEV', b'0', 'apollo', '2019-12-31 14:04:17', 'apollo', '2019-12-31 14:04:17');
INSERT INTO `role` VALUES (52, 'ReleaseNamespace+h2hf-app-weixin+weixin-config+DEV', b'0', 'apollo', '2019-12-31 14:04:17', 'apollo', '2019-12-31 14:04:17');
INSERT INTO `role` VALUES (53, 'ModifyNamespace+h2hf-app-weixin+mysql_redis_config', b'0', 'apollo', '2019-12-31 14:06:27', 'apollo', '2019-12-31 14:06:27');
INSERT INTO `role` VALUES (54, 'ReleaseNamespace+h2hf-app-weixin+mysql_redis_config', b'0', 'apollo', '2019-12-31 14:06:27', 'apollo', '2019-12-31 14:06:27');
INSERT INTO `role` VALUES (55, 'ModifyNamespace+h2hf-app-weixin+mysql_redis_config+DEV', b'0', 'apollo', '2019-12-31 14:06:27', 'apollo', '2019-12-31 14:06:27');
INSERT INTO `role` VALUES (56, 'ReleaseNamespace+h2hf-app-weixin+mysql_redis_config+DEV', b'0', 'apollo', '2019-12-31 14:06:27', 'apollo', '2019-12-31 14:06:27');
INSERT INTO `role` VALUES (57, 'Master+app-zuul-serve', b'0', 'apollo', '2019-12-31 14:59:02', 'apollo', '2019-12-31 14:59:02');
INSERT INTO `role` VALUES (58, 'ModifyNamespace+app-zuul-serve+application', b'0', 'apollo', '2019-12-31 14:59:02', 'apollo', '2019-12-31 14:59:02');
INSERT INTO `role` VALUES (59, 'ReleaseNamespace+app-zuul-serve+application', b'0', 'apollo', '2019-12-31 14:59:02', 'apollo', '2019-12-31 14:59:02');
INSERT INTO `role` VALUES (60, 'ModifyNamespace+app-zuul-serve+application+DEV', b'0', 'apollo', '2019-12-31 14:59:02', 'apollo', '2019-12-31 14:59:02');
INSERT INTO `role` VALUES (61, 'ReleaseNamespace+app-zuul-serve+application+DEV', b'0', 'apollo', '2019-12-31 14:59:02', 'apollo', '2019-12-31 14:59:02');
INSERT INTO `role` VALUES (62, 'Master+h2hf-app-member', b'0', 'apollo', '2019-12-31 15:56:28', 'apollo', '2019-12-31 15:56:28');
INSERT INTO `role` VALUES (63, 'ModifyNamespace+h2hf-app-member+application', b'0', 'apollo', '2019-12-31 15:56:28', 'apollo', '2019-12-31 15:56:28');
INSERT INTO `role` VALUES (64, 'ReleaseNamespace+h2hf-app-member+application', b'0', 'apollo', '2019-12-31 15:56:28', 'apollo', '2019-12-31 15:56:28');
INSERT INTO `role` VALUES (65, 'ModifyNamespace+h2hf-app-member+application+DEV', b'0', 'apollo', '2019-12-31 15:56:28', 'apollo', '2019-12-31 15:56:28');
INSERT INTO `role` VALUES (66, 'ReleaseNamespace+h2hf-app-member+application+DEV', b'0', 'apollo', '2019-12-31 15:56:28', 'apollo', '2019-12-31 15:56:28');
INSERT INTO `role` VALUES (67, 'ModifyNamespace+h2hf-app-member+mysql_redis_config', b'1', 'apollo', '2019-12-31 17:13:06', 'apollo', '2020-01-03 10:58:26');
INSERT INTO `role` VALUES (68, 'ReleaseNamespace+h2hf-app-member+mysql_redis_config', b'1', 'apollo', '2019-12-31 17:13:06', 'apollo', '2020-01-03 10:58:26');
INSERT INTO `role` VALUES (69, 'ModifyNamespace+h2hf-app-member+mysql_redis_config+DEV', b'0', 'apollo', '2019-12-31 17:13:06', 'apollo', '2019-12-31 17:13:06');
INSERT INTO `role` VALUES (70, 'ReleaseNamespace+h2hf-app-member+mysql_redis_config+DEV', b'0', 'apollo', '2019-12-31 17:13:07', 'apollo', '2019-12-31 17:13:07');
INSERT INTO `role` VALUES (71, 'ModifyNamespace+h2hf-app-weixin+weixin_mysql_redis_config', b'0', 'apollo', '2020-01-02 10:58:03', 'apollo', '2020-01-02 10:58:03');
INSERT INTO `role` VALUES (72, 'ReleaseNamespace+h2hf-app-weixin+weixin_mysql_redis_config', b'0', 'apollo', '2020-01-02 10:58:03', 'apollo', '2020-01-02 10:58:03');
INSERT INTO `role` VALUES (73, 'ModifyNamespace+h2hf-app-weixin+weixin_mysql_redis_config+DEV', b'0', 'apollo', '2020-01-02 10:58:03', 'apollo', '2020-01-02 10:58:03');
INSERT INTO `role` VALUES (74, 'ReleaseNamespace+h2hf-app-weixin+weixin_mysql_redis_config+DEV', b'0', 'apollo', '2020-01-02 10:58:03', 'apollo', '2020-01-02 10:58:03');
INSERT INTO `role` VALUES (75, 'Master+h2hf-app-auth', b'0', 'apollo', '2020-01-02 14:49:33', 'apollo', '2020-01-02 14:49:33');
INSERT INTO `role` VALUES (76, 'ModifyNamespace+h2hf-app-auth+application', b'0', 'apollo', '2020-01-02 14:49:33', 'apollo', '2020-01-02 14:49:33');
INSERT INTO `role` VALUES (77, 'ReleaseNamespace+h2hf-app-auth+application', b'0', 'apollo', '2020-01-02 14:49:33', 'apollo', '2020-01-02 14:49:33');
INSERT INTO `role` VALUES (78, 'ModifyNamespace+h2hf-app-auth+application+DEV', b'0', 'apollo', '2020-01-02 14:49:33', 'apollo', '2020-01-02 14:49:33');
INSERT INTO `role` VALUES (79, 'ReleaseNamespace+h2hf-app-auth+application+DEV', b'0', 'apollo', '2020-01-02 14:49:33', 'apollo', '2020-01-02 14:49:33');
INSERT INTO `role` VALUES (80, 'ModifyNamespace+h2hf-app-auth+auth_mysql_redis_config', b'0', 'apollo', '2020-01-02 14:52:16', 'apollo', '2020-01-02 14:52:16');
INSERT INTO `role` VALUES (81, 'ReleaseNamespace+h2hf-app-auth+auth_mysql_redis_config', b'0', 'apollo', '2020-01-02 14:52:16', 'apollo', '2020-01-02 14:52:16');
INSERT INTO `role` VALUES (82, 'ModifyNamespace+h2hf-app-auth+auth_mysql_redis_config+DEV', b'0', 'apollo', '2020-01-02 14:52:16', 'apollo', '2020-01-02 14:52:16');
INSERT INTO `role` VALUES (83, 'ReleaseNamespace+h2hf-app-auth+auth_mysql_redis_config+DEV', b'0', 'apollo', '2020-01-02 14:52:16', 'apollo', '2020-01-02 14:52:16');
INSERT INTO `role` VALUES (84, 'ModifyNamespace+h2hf-app-auth+user_auth_config', b'0', 'apollo', '2020-01-02 14:54:38', 'apollo', '2020-01-02 14:54:38');
INSERT INTO `role` VALUES (85, 'ReleaseNamespace+h2hf-app-auth+user_auth_config', b'0', 'apollo', '2020-01-02 14:54:38', 'apollo', '2020-01-02 14:54:38');
INSERT INTO `role` VALUES (86, 'ModifyNamespace+h2hf-app-auth+user_auth_config+DEV', b'0', 'apollo', '2020-01-02 14:54:38', 'apollo', '2020-01-02 14:54:38');
INSERT INTO `role` VALUES (87, 'ReleaseNamespace+h2hf-app-auth+user_auth_config+DEV', b'0', 'apollo', '2020-01-02 14:54:38', 'apollo', '2020-01-02 14:54:38');
INSERT INTO `role` VALUES (88, 'ModifyNamespace+h2hf-app-member+memeber_mysql_redis_config', b'0', 'apollo', '2020-01-03 10:59:11', 'apollo', '2020-01-03 10:59:11');
INSERT INTO `role` VALUES (89, 'ReleaseNamespace+h2hf-app-member+memeber_mysql_redis_config', b'0', 'apollo', '2020-01-03 10:59:11', 'apollo', '2020-01-03 10:59:11');
INSERT INTO `role` VALUES (90, 'ModifyNamespace+h2hf-app-member+memeber_mysql_redis_config+DEV', b'0', 'apollo', '2020-01-03 10:59:11', 'apollo', '2020-01-03 10:59:11');
INSERT INTO `role` VALUES (91, 'ReleaseNamespace+h2hf-app-member+memeber_mysql_redis_config+DEV', b'0', 'apollo', '2020-01-03 10:59:11', 'apollo', '2020-01-03 10:59:11');
INSERT INTO `role` VALUES (92, 'ModifyNamespace+h2hf-app-member+member_mysql_redis_config', b'0', 'apollo', '2020-01-03 11:15:47', 'apollo', '2020-01-03 11:15:47');
INSERT INTO `role` VALUES (93, 'ReleaseNamespace+h2hf-app-member+member_mysql_redis_config', b'0', 'apollo', '2020-01-03 11:15:47', 'apollo', '2020-01-03 11:15:47');
INSERT INTO `role` VALUES (94, 'ModifyNamespace+h2hf-app-member+member_mysql_redis_config+DEV', b'0', 'apollo', '2020-01-03 11:15:47', 'apollo', '2020-01-03 11:15:47');
INSERT INTO `role` VALUES (95, 'ReleaseNamespace+h2hf-app-member+member_mysql_redis_config+DEV', b'0', 'apollo', '2020-01-03 11:15:47', 'apollo', '2020-01-03 11:15:47');
INSERT INTO `role` VALUES (96, 'Master+gateway-server', b'0', 'apollo', '2020-01-04 18:18:13', 'apollo', '2020-01-04 18:18:13');
INSERT INTO `role` VALUES (97, 'ModifyNamespace+gateway-server+application', b'0', 'apollo', '2020-01-04 18:18:13', 'apollo', '2020-01-04 18:18:13');
INSERT INTO `role` VALUES (98, 'ReleaseNamespace+gateway-server+application', b'0', 'apollo', '2020-01-04 18:18:13', 'apollo', '2020-01-04 18:18:13');
INSERT INTO `role` VALUES (99, 'ModifyNamespace+gateway-server+application+DEV', b'0', 'apollo', '2020-01-04 18:18:13', 'apollo', '2020-01-04 18:18:13');
INSERT INTO `role` VALUES (100, 'ReleaseNamespace+gateway-server+application+DEV', b'0', 'apollo', '2020-01-04 18:18:13', 'apollo', '2020-01-04 18:18:13');
INSERT INTO `role` VALUES (101, 'Master+member-server', b'0', 'apollo', '2020-01-04 19:08:15', 'apollo', '2020-01-04 19:08:15');
INSERT INTO `role` VALUES (102, 'ModifyNamespace+member-server+application', b'0', 'apollo', '2020-01-04 19:08:15', 'apollo', '2020-01-04 19:08:15');
INSERT INTO `role` VALUES (103, 'ReleaseNamespace+member-server+application', b'0', 'apollo', '2020-01-04 19:08:15', 'apollo', '2020-01-04 19:08:15');
INSERT INTO `role` VALUES (104, 'ModifyNamespace+member-server+application+DEV', b'0', 'apollo', '2020-01-04 19:08:15', 'apollo', '2020-01-04 19:08:15');
INSERT INTO `role` VALUES (105, 'ReleaseNamespace+member-server+application+DEV', b'0', 'apollo', '2020-01-04 19:08:15', 'apollo', '2020-01-04 19:08:15');
INSERT INTO `role` VALUES (106, 'ModifyNamespace+member-server+member_swagger_config', b'1', 'apollo', '2020-01-04 19:11:06', 'apollo', '2020-01-05 14:38:10');
INSERT INTO `role` VALUES (107, 'ReleaseNamespace+member-server+member_swagger_config', b'1', 'apollo', '2020-01-04 19:11:06', 'apollo', '2020-01-05 14:38:10');
INSERT INTO `role` VALUES (108, 'ModifyNamespace+member-server+member_swagger_config+DEV', b'0', 'apollo', '2020-01-04 19:11:06', 'apollo', '2020-01-04 19:11:06');
INSERT INTO `role` VALUES (109, 'ReleaseNamespace+member-server+member_swagger_config+DEV', b'0', 'apollo', '2020-01-04 19:11:06', 'apollo', '2020-01-04 19:11:06');
INSERT INTO `role` VALUES (110, 'ModifyNamespace+member-server+member-redis-mysql-config', b'0', 'apollo', '2020-01-04 19:13:57', 'apollo', '2020-01-04 19:13:57');
INSERT INTO `role` VALUES (111, 'ReleaseNamespace+member-server+member-redis-mysql-config', b'0', 'apollo', '2020-01-04 19:13:57', 'apollo', '2020-01-04 19:13:57');
INSERT INTO `role` VALUES (112, 'ModifyNamespace+member-server+member-redis-mysql-config+DEV', b'0', 'apollo', '2020-01-04 19:13:57', 'apollo', '2020-01-04 19:13:57');
INSERT INTO `role` VALUES (113, 'ReleaseNamespace+member-server+member-redis-mysql-config+DEV', b'0', 'apollo', '2020-01-04 19:13:57', 'apollo', '2020-01-04 19:13:57');
INSERT INTO `role` VALUES (114, 'Master+auth-server', b'0', 'apollo', '2020-01-07 15:07:40', 'apollo', '2020-01-07 15:07:40');
INSERT INTO `role` VALUES (115, 'ModifyNamespace+auth-server+application', b'0', 'apollo', '2020-01-07 15:07:40', 'apollo', '2020-01-07 15:07:40');
INSERT INTO `role` VALUES (116, 'ReleaseNamespace+auth-server+application', b'0', 'apollo', '2020-01-07 15:07:40', 'apollo', '2020-01-07 15:07:40');
INSERT INTO `role` VALUES (117, 'ModifyNamespace+auth-server+application+DEV', b'0', 'apollo', '2020-01-07 15:07:40', 'apollo', '2020-01-07 15:07:40');
INSERT INTO `role` VALUES (118, 'ReleaseNamespace+auth-server+application+DEV', b'0', 'apollo', '2020-01-07 15:07:40', 'apollo', '2020-01-07 15:07:40');
INSERT INTO `role` VALUES (119, 'ModifyNamespace+auth-server+auth_config', b'0', 'apollo', '2020-01-07 15:11:08', 'apollo', '2020-01-07 15:11:08');
INSERT INTO `role` VALUES (120, 'ReleaseNamespace+auth-server+auth_config', b'0', 'apollo', '2020-01-07 15:11:08', 'apollo', '2020-01-07 15:11:08');
INSERT INTO `role` VALUES (121, 'ModifyNamespace+auth-server+auth_config+DEV', b'0', 'apollo', '2020-01-07 15:11:08', 'apollo', '2020-01-07 15:11:08');
INSERT INTO `role` VALUES (122, 'ReleaseNamespace+auth-server+auth_config+DEV', b'0', 'apollo', '2020-01-07 15:11:08', 'apollo', '2020-01-07 15:11:08');
INSERT INTO `role` VALUES (123, 'ModifyNamespace+auth-server+auth_swagger_config', b'0', 'apollo', '2020-01-07 15:15:01', 'apollo', '2020-01-07 15:15:01');
INSERT INTO `role` VALUES (124, 'ReleaseNamespace+auth-server+auth_swagger_config', b'0', 'apollo', '2020-01-07 15:15:01', 'apollo', '2020-01-07 15:15:01');
INSERT INTO `role` VALUES (125, 'ModifyNamespace+auth-server+auth_swagger_config+DEV', b'0', 'apollo', '2020-01-07 15:15:01', 'apollo', '2020-01-07 15:15:01');
INSERT INTO `role` VALUES (126, 'ReleaseNamespace+auth-server+auth_swagger_config+DEV', b'0', 'apollo', '2020-01-07 15:15:01', 'apollo', '2020-01-07 15:15:01');
INSERT INTO `role` VALUES (127, 'ModifyNamespace+auth-server+auth_mysql_redis_config', b'0', 'apollo', '2020-01-08 09:07:48', 'apollo', '2020-01-08 09:07:48');
INSERT INTO `role` VALUES (128, 'ReleaseNamespace+auth-server+auth_mysql_redis_config', b'0', 'apollo', '2020-01-08 09:07:48', 'apollo', '2020-01-08 09:07:48');
INSERT INTO `role` VALUES (129, 'ModifyNamespace+auth-server+auth_mysql_redis_config+DEV', b'0', 'apollo', '2020-01-08 09:07:48', 'apollo', '2020-01-08 09:07:48');
INSERT INTO `role` VALUES (130, 'ReleaseNamespace+auth-server+auth_mysql_redis_config+DEV', b'0', 'apollo', '2020-01-08 09:07:48', 'apollo', '2020-01-08 09:07:48');
INSERT INTO `role` VALUES (131, 'Master+saas-server', b'0', 'apollo', '2020-02-02 23:23:21', 'apollo', '2020-02-02 23:23:21');
INSERT INTO `role` VALUES (132, 'ModifyNamespace+saas-server+application', b'0', 'apollo', '2020-02-02 23:23:21', 'apollo', '2020-02-02 23:23:21');
INSERT INTO `role` VALUES (133, 'ReleaseNamespace+saas-server+application', b'0', 'apollo', '2020-02-02 23:23:21', 'apollo', '2020-02-02 23:23:21');
INSERT INTO `role` VALUES (134, 'ModifyNamespace+saas-server+application+DEV', b'0', 'apollo', '2020-02-02 23:23:21', 'apollo', '2020-02-02 23:23:21');
INSERT INTO `role` VALUES (135, 'ReleaseNamespace+saas-server+application+DEV', b'0', 'apollo', '2020-02-02 23:23:21', 'apollo', '2020-02-02 23:23:21');
INSERT INTO `role` VALUES (136, 'ModifyNamespace+saas-server+saas-redis-mysql-config', b'0', 'apollo', '2020-02-02 23:25:05', 'apollo', '2020-02-02 23:25:05');
INSERT INTO `role` VALUES (137, 'ReleaseNamespace+saas-server+saas-redis-mysql-config', b'0', 'apollo', '2020-02-02 23:25:05', 'apollo', '2020-02-02 23:25:05');
INSERT INTO `role` VALUES (138, 'ModifyNamespace+saas-server+saas-redis-mysql-config+DEV', b'0', 'apollo', '2020-02-02 23:25:05', 'apollo', '2020-02-02 23:25:05');
INSERT INTO `role` VALUES (139, 'ReleaseNamespace+saas-server+saas-redis-mysql-config+DEV', b'0', 'apollo', '2020-02-02 23:25:05', 'apollo', '2020-02-02 23:25:05');
INSERT INTO `role` VALUES (140, 'ModifyNamespace+gateway-server+gateway_mysql_redis_config', b'1', 'apollo', '2020-02-03 23:00:58', 'apollo', '2020-02-03 23:20:41');
INSERT INTO `role` VALUES (141, 'ReleaseNamespace+gateway-server+gateway_mysql_redis_config', b'1', 'apollo', '2020-02-03 23:00:58', 'apollo', '2020-02-03 23:20:41');
INSERT INTO `role` VALUES (142, 'ModifyNamespace+gateway-server+gateway_mysql_redis_config+DEV', b'0', 'apollo', '2020-02-03 23:00:58', 'apollo', '2020-02-03 23:00:58');
INSERT INTO `role` VALUES (143, 'ReleaseNamespace+gateway-server+gateway_mysql_redis_config+DEV', b'0', 'apollo', '2020-02-03 23:00:58', 'apollo', '2020-02-03 23:00:58');
INSERT INTO `role` VALUES (144, 'Master+system-server', b'0', 'apollo', '2020-02-06 21:30:15', 'apollo', '2020-02-06 21:30:15');
INSERT INTO `role` VALUES (145, 'ModifyNamespace+system-server+application', b'0', 'apollo', '2020-02-06 21:30:15', 'apollo', '2020-02-06 21:30:15');
INSERT INTO `role` VALUES (146, 'ReleaseNamespace+system-server+application', b'0', 'apollo', '2020-02-06 21:30:15', 'apollo', '2020-02-06 21:30:15');
INSERT INTO `role` VALUES (147, 'ModifyNamespace+system-server+application+DEV', b'0', 'apollo', '2020-02-06 21:30:15', 'apollo', '2020-02-06 21:30:15');
INSERT INTO `role` VALUES (148, 'ReleaseNamespace+system-server+application+DEV', b'0', 'apollo', '2020-02-06 21:30:15', 'apollo', '2020-02-06 21:30:15');
INSERT INTO `role` VALUES (149, 'ModifyNamespace+system-server+system-redis-mysql-config', b'0', 'apollo', '2020-02-06 21:32:16', 'apollo', '2020-02-06 21:32:16');
INSERT INTO `role` VALUES (150, 'ReleaseNamespace+system-server+system-redis-mysql-config', b'0', 'apollo', '2020-02-06 21:32:16', 'apollo', '2020-02-06 21:32:16');
INSERT INTO `role` VALUES (151, 'ModifyNamespace+system-server+system-redis-mysql-config+DEV', b'0', 'apollo', '2020-02-06 21:32:16', 'apollo', '2020-02-06 21:32:16');
INSERT INTO `role` VALUES (152, 'ReleaseNamespace+system-server+system-redis-mysql-config+DEV', b'0', 'apollo', '2020-02-06 21:32:16', 'apollo', '2020-02-06 21:32:16');
INSERT INTO `role` VALUES (153, 'Master+shop-server', b'0', 'apollo', '2020-02-20 15:13:17', 'apollo', '2020-02-20 15:13:17');
INSERT INTO `role` VALUES (154, 'ModifyNamespace+shop-server+application', b'0', 'apollo', '2020-02-20 15:13:17', 'apollo', '2020-02-20 15:13:17');
INSERT INTO `role` VALUES (155, 'ReleaseNamespace+shop-server+application', b'0', 'apollo', '2020-02-20 15:13:17', 'apollo', '2020-02-20 15:13:17');
INSERT INTO `role` VALUES (156, 'ModifyNamespace+shop-server+application+DEV', b'0', 'apollo', '2020-02-20 15:13:17', 'apollo', '2020-02-20 15:13:17');
INSERT INTO `role` VALUES (157, 'ReleaseNamespace+shop-server+application+DEV', b'0', 'apollo', '2020-02-20 15:13:17', 'apollo', '2020-02-20 15:13:17');
INSERT INTO `role` VALUES (158, 'ModifyNamespace+shop-server+shop-redis-mysql-config', b'0', 'apollo', '2020-02-20 15:15:22', 'apollo', '2020-02-20 15:15:22');
INSERT INTO `role` VALUES (159, 'ReleaseNamespace+shop-server+shop-redis-mysql-config', b'0', 'apollo', '2020-02-20 15:15:22', 'apollo', '2020-02-20 15:15:22');
INSERT INTO `role` VALUES (160, 'ModifyNamespace+shop-server+shop-redis-mysql-config+DEV', b'0', 'apollo', '2020-02-20 15:15:22', 'apollo', '2020-02-20 15:15:22');
INSERT INTO `role` VALUES (161, 'ReleaseNamespace+shop-server+shop-redis-mysql-config+DEV', b'0', 'apollo', '2020-02-20 15:15:22', 'apollo', '2020-02-20 15:15:22');
INSERT INTO `role` VALUES (162, 'ModifyNamespace+system-server+upload_config', b'0', 'apollo', '2020-02-23 01:27:16', 'apollo', '2020-02-23 01:27:16');
INSERT INTO `role` VALUES (163, 'ReleaseNamespace+system-server+upload_config', b'0', 'apollo', '2020-02-23 01:27:16', 'apollo', '2020-02-23 01:27:16');
INSERT INTO `role` VALUES (164, 'ModifyNamespace+system-server+upload_config+DEV', b'0', 'apollo', '2020-02-23 01:27:16', 'apollo', '2020-02-23 01:27:16');
INSERT INTO `role` VALUES (165, 'ReleaseNamespace+system-server+upload_config+DEV', b'0', 'apollo', '2020-02-23 01:27:16', 'apollo', '2020-02-23 01:27:16');

-- ----------------------------
-- Table structure for rolepermission
-- ----------------------------
DROP TABLE IF EXISTS `rolepermission`;
CREATE TABLE `rolepermission`  (
  `Id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增Id',
  `RoleId` int(10) UNSIGNED NULL DEFAULT NULL COMMENT 'Role Id',
  `PermissionId` int(10) UNSIGNED NULL DEFAULT NULL COMMENT 'Permission Id',
  `IsDeleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '1: deleted, 0: normal',
  `DataChange_CreatedBy` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建人邮箱前缀',
  `DataChange_CreatedTime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `DataChange_LastModifiedBy` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后修改人邮箱前缀',
  `DataChange_LastTime` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改时间',
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `IX_DataChange_LastTime`(`DataChange_LastTime`) USING BTREE,
  INDEX `IX_RoleId`(`RoleId`) USING BTREE,
  INDEX `IX_PermissionId`(`PermissionId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 196 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色和权限的绑定表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rolepermission
-- ----------------------------
INSERT INTO `rolepermission` VALUES (1, 1, 1, b'0', '', '2019-12-23 16:50:05', '', '2019-12-23 16:50:05');
INSERT INTO `rolepermission` VALUES (2, 1, 2, b'0', '', '2019-12-23 16:50:05', '', '2019-12-23 16:50:05');
INSERT INTO `rolepermission` VALUES (3, 1, 3, b'0', '', '2019-12-23 16:50:05', '', '2019-12-23 16:50:05');
INSERT INTO `rolepermission` VALUES (4, 2, 4, b'0', '', '2019-12-23 16:50:05', '', '2019-12-23 16:50:05');
INSERT INTO `rolepermission` VALUES (5, 3, 5, b'0', '', '2019-12-23 16:50:05', '', '2019-12-23 16:50:05');
INSERT INTO `rolepermission` VALUES (6, 4, 6, b'1', 'apollo', '2019-12-24 13:25:05', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `rolepermission` VALUES (7, 4, 7, b'1', 'apollo', '2019-12-24 13:25:05', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `rolepermission` VALUES (8, 4, 8, b'1', 'apollo', '2019-12-24 13:25:05', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `rolepermission` VALUES (9, 5, 9, b'1', 'apollo', '2019-12-24 13:25:05', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `rolepermission` VALUES (10, 6, 10, b'1', 'apollo', '2019-12-24 13:25:05', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `rolepermission` VALUES (11, 7, 11, b'1', 'apollo', '2019-12-24 13:25:05', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `rolepermission` VALUES (12, 8, 12, b'1', 'apollo', '2019-12-24 13:25:05', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `rolepermission` VALUES (13, 9, 13, b'1', 'apollo', '2019-12-24 15:32:23', 'apollo', '2019-12-31 13:53:05');
INSERT INTO `rolepermission` VALUES (14, 9, 14, b'1', 'apollo', '2019-12-24 15:32:23', 'apollo', '2019-12-31 13:53:05');
INSERT INTO `rolepermission` VALUES (15, 9, 15, b'1', 'apollo', '2019-12-24 15:32:23', 'apollo', '2019-12-31 13:53:05');
INSERT INTO `rolepermission` VALUES (16, 10, 16, b'1', 'apollo', '2019-12-24 15:32:23', 'apollo', '2019-12-31 13:53:05');
INSERT INTO `rolepermission` VALUES (17, 11, 17, b'1', 'apollo', '2019-12-24 15:32:23', 'apollo', '2019-12-31 13:53:05');
INSERT INTO `rolepermission` VALUES (18, 12, 18, b'1', 'apollo', '2019-12-24 15:32:23', 'apollo', '2019-12-31 13:53:05');
INSERT INTO `rolepermission` VALUES (19, 13, 19, b'1', 'apollo', '2019-12-24 15:32:23', 'apollo', '2019-12-31 13:53:05');
INSERT INTO `rolepermission` VALUES (20, 14, 20, b'1', 'apollo', '2019-12-25 16:19:43', 'apollo', '2019-12-31 13:53:40');
INSERT INTO `rolepermission` VALUES (21, 14, 21, b'1', 'apollo', '2019-12-25 16:19:43', 'apollo', '2019-12-31 13:53:40');
INSERT INTO `rolepermission` VALUES (22, 14, 22, b'1', 'apollo', '2019-12-25 16:19:43', 'apollo', '2019-12-31 13:53:40');
INSERT INTO `rolepermission` VALUES (23, 15, 23, b'1', 'apollo', '2019-12-25 16:19:43', 'apollo', '2019-12-31 13:53:40');
INSERT INTO `rolepermission` VALUES (24, 16, 24, b'1', 'apollo', '2019-12-25 16:19:44', 'apollo', '2019-12-31 13:53:40');
INSERT INTO `rolepermission` VALUES (25, 17, 25, b'1', 'apollo', '2019-12-25 16:19:44', 'apollo', '2019-12-31 13:53:40');
INSERT INTO `rolepermission` VALUES (26, 18, 26, b'1', 'apollo', '2019-12-25 16:19:44', 'apollo', '2019-12-31 13:53:40');
INSERT INTO `rolepermission` VALUES (27, 19, 27, b'1', 'apollo', '2019-12-26 10:59:08', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `rolepermission` VALUES (28, 20, 28, b'1', 'apollo', '2019-12-26 10:59:08', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `rolepermission` VALUES (29, 21, 29, b'1', 'apollo', '2019-12-26 10:59:08', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `rolepermission` VALUES (30, 22, 30, b'1', 'apollo', '2019-12-26 10:59:08', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `rolepermission` VALUES (31, 23, 31, b'1', 'apollo', '2019-12-26 11:13:25', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `rolepermission` VALUES (32, 24, 32, b'1', 'apollo', '2019-12-26 11:13:26', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `rolepermission` VALUES (33, 25, 33, b'1', 'apollo', '2019-12-26 11:13:26', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `rolepermission` VALUES (34, 26, 34, b'1', 'apollo', '2019-12-26 11:13:26', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `rolepermission` VALUES (35, 27, 35, b'1', 'apollo', '2019-12-26 11:15:26', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `rolepermission` VALUES (36, 28, 36, b'1', 'apollo', '2019-12-26 11:15:26', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `rolepermission` VALUES (37, 29, 37, b'1', 'apollo', '2019-12-26 11:15:26', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `rolepermission` VALUES (38, 30, 38, b'1', 'apollo', '2019-12-26 11:15:26', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `rolepermission` VALUES (39, 31, 39, b'1', 'apollo', '2019-12-27 14:52:22', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `rolepermission` VALUES (40, 32, 40, b'1', 'apollo', '2019-12-27 14:52:22', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `rolepermission` VALUES (41, 33, 41, b'1', 'apollo', '2019-12-27 14:52:22', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `rolepermission` VALUES (42, 34, 42, b'1', 'apollo', '2019-12-27 14:52:22', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `rolepermission` VALUES (43, 35, 43, b'1', 'apollo', '2019-12-27 14:54:08', 'apollo', '2019-12-31 13:53:40');
INSERT INTO `rolepermission` VALUES (44, 36, 44, b'1', 'apollo', '2019-12-27 14:54:08', 'apollo', '2019-12-31 13:53:40');
INSERT INTO `rolepermission` VALUES (45, 37, 45, b'1', 'apollo', '2019-12-27 14:54:08', 'apollo', '2019-12-31 13:53:40');
INSERT INTO `rolepermission` VALUES (46, 38, 46, b'1', 'apollo', '2019-12-27 14:54:08', 'apollo', '2019-12-31 13:53:40');
INSERT INTO `rolepermission` VALUES (47, 39, 47, b'1', 'apollo', '2019-12-31 13:43:47', 'apollo', '2019-12-31 14:58:36');
INSERT INTO `rolepermission` VALUES (48, 39, 48, b'1', 'apollo', '2019-12-31 13:43:47', 'apollo', '2019-12-31 14:58:36');
INSERT INTO `rolepermission` VALUES (49, 39, 49, b'1', 'apollo', '2019-12-31 13:43:47', 'apollo', '2019-12-31 14:58:36');
INSERT INTO `rolepermission` VALUES (50, 40, 50, b'1', 'apollo', '2019-12-31 13:43:47', 'apollo', '2019-12-31 14:58:36');
INSERT INTO `rolepermission` VALUES (51, 41, 51, b'1', 'apollo', '2019-12-31 13:43:47', 'apollo', '2019-12-31 14:58:36');
INSERT INTO `rolepermission` VALUES (52, 42, 52, b'1', 'apollo', '2019-12-31 13:43:47', 'apollo', '2019-12-31 14:58:36');
INSERT INTO `rolepermission` VALUES (53, 43, 53, b'1', 'apollo', '2019-12-31 13:43:47', 'apollo', '2019-12-31 14:58:36');
INSERT INTO `rolepermission` VALUES (54, 44, 54, b'0', 'apollo', '2019-12-31 13:56:21', 'apollo', '2019-12-31 13:56:21');
INSERT INTO `rolepermission` VALUES (55, 44, 55, b'0', 'apollo', '2019-12-31 13:56:21', 'apollo', '2019-12-31 13:56:21');
INSERT INTO `rolepermission` VALUES (56, 44, 56, b'0', 'apollo', '2019-12-31 13:56:21', 'apollo', '2019-12-31 13:56:21');
INSERT INTO `rolepermission` VALUES (57, 45, 57, b'0', 'apollo', '2019-12-31 13:56:21', 'apollo', '2019-12-31 13:56:21');
INSERT INTO `rolepermission` VALUES (58, 46, 58, b'0', 'apollo', '2019-12-31 13:56:21', 'apollo', '2019-12-31 13:56:21');
INSERT INTO `rolepermission` VALUES (59, 47, 59, b'0', 'apollo', '2019-12-31 13:56:21', 'apollo', '2019-12-31 13:56:21');
INSERT INTO `rolepermission` VALUES (60, 48, 60, b'0', 'apollo', '2019-12-31 13:56:21', 'apollo', '2019-12-31 13:56:21');
INSERT INTO `rolepermission` VALUES (61, 49, 61, b'0', 'apollo', '2019-12-31 14:04:16', 'apollo', '2019-12-31 14:04:16');
INSERT INTO `rolepermission` VALUES (62, 50, 62, b'0', 'apollo', '2019-12-31 14:04:16', 'apollo', '2019-12-31 14:04:16');
INSERT INTO `rolepermission` VALUES (63, 51, 63, b'0', 'apollo', '2019-12-31 14:04:17', 'apollo', '2019-12-31 14:04:17');
INSERT INTO `rolepermission` VALUES (64, 52, 64, b'0', 'apollo', '2019-12-31 14:04:17', 'apollo', '2019-12-31 14:04:17');
INSERT INTO `rolepermission` VALUES (65, 53, 65, b'0', 'apollo', '2019-12-31 14:06:27', 'apollo', '2019-12-31 14:06:27');
INSERT INTO `rolepermission` VALUES (66, 54, 66, b'0', 'apollo', '2019-12-31 14:06:27', 'apollo', '2019-12-31 14:06:27');
INSERT INTO `rolepermission` VALUES (67, 55, 67, b'0', 'apollo', '2019-12-31 14:06:27', 'apollo', '2019-12-31 14:06:27');
INSERT INTO `rolepermission` VALUES (68, 56, 68, b'0', 'apollo', '2019-12-31 14:06:27', 'apollo', '2019-12-31 14:06:27');
INSERT INTO `rolepermission` VALUES (69, 57, 69, b'0', 'apollo', '2019-12-31 14:59:02', 'apollo', '2019-12-31 14:59:02');
INSERT INTO `rolepermission` VALUES (70, 57, 70, b'0', 'apollo', '2019-12-31 14:59:02', 'apollo', '2019-12-31 14:59:02');
INSERT INTO `rolepermission` VALUES (71, 57, 71, b'0', 'apollo', '2019-12-31 14:59:02', 'apollo', '2019-12-31 14:59:02');
INSERT INTO `rolepermission` VALUES (72, 58, 72, b'0', 'apollo', '2019-12-31 14:59:02', 'apollo', '2019-12-31 14:59:02');
INSERT INTO `rolepermission` VALUES (73, 59, 73, b'0', 'apollo', '2019-12-31 14:59:02', 'apollo', '2019-12-31 14:59:02');
INSERT INTO `rolepermission` VALUES (74, 60, 74, b'0', 'apollo', '2019-12-31 14:59:02', 'apollo', '2019-12-31 14:59:02');
INSERT INTO `rolepermission` VALUES (75, 61, 75, b'0', 'apollo', '2019-12-31 14:59:02', 'apollo', '2019-12-31 14:59:02');
INSERT INTO `rolepermission` VALUES (76, 62, 76, b'0', 'apollo', '2019-12-31 15:56:28', 'apollo', '2019-12-31 15:56:28');
INSERT INTO `rolepermission` VALUES (77, 62, 77, b'0', 'apollo', '2019-12-31 15:56:28', 'apollo', '2019-12-31 15:56:28');
INSERT INTO `rolepermission` VALUES (78, 62, 78, b'0', 'apollo', '2019-12-31 15:56:28', 'apollo', '2019-12-31 15:56:28');
INSERT INTO `rolepermission` VALUES (79, 63, 79, b'0', 'apollo', '2019-12-31 15:56:28', 'apollo', '2019-12-31 15:56:28');
INSERT INTO `rolepermission` VALUES (80, 64, 80, b'0', 'apollo', '2019-12-31 15:56:28', 'apollo', '2019-12-31 15:56:28');
INSERT INTO `rolepermission` VALUES (81, 65, 81, b'0', 'apollo', '2019-12-31 15:56:28', 'apollo', '2019-12-31 15:56:28');
INSERT INTO `rolepermission` VALUES (82, 66, 82, b'0', 'apollo', '2019-12-31 15:56:28', 'apollo', '2019-12-31 15:56:28');
INSERT INTO `rolepermission` VALUES (83, 67, 83, b'1', 'apollo', '2019-12-31 17:13:06', 'apollo', '2020-01-03 10:58:26');
INSERT INTO `rolepermission` VALUES (84, 68, 84, b'1', 'apollo', '2019-12-31 17:13:06', 'apollo', '2020-01-03 10:58:26');
INSERT INTO `rolepermission` VALUES (85, 69, 85, b'0', 'apollo', '2019-12-31 17:13:06', 'apollo', '2019-12-31 17:13:06');
INSERT INTO `rolepermission` VALUES (86, 70, 86, b'0', 'apollo', '2019-12-31 17:13:07', 'apollo', '2019-12-31 17:13:07');
INSERT INTO `rolepermission` VALUES (87, 71, 87, b'0', 'apollo', '2020-01-02 10:58:03', 'apollo', '2020-01-02 10:58:03');
INSERT INTO `rolepermission` VALUES (88, 72, 88, b'0', 'apollo', '2020-01-02 10:58:03', 'apollo', '2020-01-02 10:58:03');
INSERT INTO `rolepermission` VALUES (89, 73, 89, b'0', 'apollo', '2020-01-02 10:58:03', 'apollo', '2020-01-02 10:58:03');
INSERT INTO `rolepermission` VALUES (90, 74, 90, b'0', 'apollo', '2020-01-02 10:58:03', 'apollo', '2020-01-02 10:58:03');
INSERT INTO `rolepermission` VALUES (91, 75, 91, b'0', 'apollo', '2020-01-02 14:49:33', 'apollo', '2020-01-02 14:49:33');
INSERT INTO `rolepermission` VALUES (92, 75, 92, b'0', 'apollo', '2020-01-02 14:49:33', 'apollo', '2020-01-02 14:49:33');
INSERT INTO `rolepermission` VALUES (93, 75, 93, b'0', 'apollo', '2020-01-02 14:49:33', 'apollo', '2020-01-02 14:49:33');
INSERT INTO `rolepermission` VALUES (94, 76, 94, b'0', 'apollo', '2020-01-02 14:49:33', 'apollo', '2020-01-02 14:49:33');
INSERT INTO `rolepermission` VALUES (95, 77, 95, b'0', 'apollo', '2020-01-02 14:49:33', 'apollo', '2020-01-02 14:49:33');
INSERT INTO `rolepermission` VALUES (96, 78, 96, b'0', 'apollo', '2020-01-02 14:49:33', 'apollo', '2020-01-02 14:49:33');
INSERT INTO `rolepermission` VALUES (97, 79, 97, b'0', 'apollo', '2020-01-02 14:49:33', 'apollo', '2020-01-02 14:49:33');
INSERT INTO `rolepermission` VALUES (98, 80, 98, b'0', 'apollo', '2020-01-02 14:52:16', 'apollo', '2020-01-02 14:52:16');
INSERT INTO `rolepermission` VALUES (99, 81, 99, b'0', 'apollo', '2020-01-02 14:52:16', 'apollo', '2020-01-02 14:52:16');
INSERT INTO `rolepermission` VALUES (100, 82, 100, b'0', 'apollo', '2020-01-02 14:52:16', 'apollo', '2020-01-02 14:52:16');
INSERT INTO `rolepermission` VALUES (101, 83, 101, b'0', 'apollo', '2020-01-02 14:52:16', 'apollo', '2020-01-02 14:52:16');
INSERT INTO `rolepermission` VALUES (102, 84, 102, b'0', 'apollo', '2020-01-02 14:54:38', 'apollo', '2020-01-02 14:54:38');
INSERT INTO `rolepermission` VALUES (103, 85, 103, b'0', 'apollo', '2020-01-02 14:54:38', 'apollo', '2020-01-02 14:54:38');
INSERT INTO `rolepermission` VALUES (104, 86, 104, b'0', 'apollo', '2020-01-02 14:54:38', 'apollo', '2020-01-02 14:54:38');
INSERT INTO `rolepermission` VALUES (105, 87, 105, b'0', 'apollo', '2020-01-02 14:54:38', 'apollo', '2020-01-02 14:54:38');
INSERT INTO `rolepermission` VALUES (106, 88, 106, b'0', 'apollo', '2020-01-03 10:59:11', 'apollo', '2020-01-03 10:59:11');
INSERT INTO `rolepermission` VALUES (107, 89, 107, b'0', 'apollo', '2020-01-03 10:59:11', 'apollo', '2020-01-03 10:59:11');
INSERT INTO `rolepermission` VALUES (108, 90, 108, b'0', 'apollo', '2020-01-03 10:59:11', 'apollo', '2020-01-03 10:59:11');
INSERT INTO `rolepermission` VALUES (109, 91, 109, b'0', 'apollo', '2020-01-03 10:59:11', 'apollo', '2020-01-03 10:59:11');
INSERT INTO `rolepermission` VALUES (110, 92, 110, b'0', 'apollo', '2020-01-03 11:15:47', 'apollo', '2020-01-03 11:15:47');
INSERT INTO `rolepermission` VALUES (111, 93, 111, b'0', 'apollo', '2020-01-03 11:15:47', 'apollo', '2020-01-03 11:15:47');
INSERT INTO `rolepermission` VALUES (112, 94, 112, b'0', 'apollo', '2020-01-03 11:15:47', 'apollo', '2020-01-03 11:15:47');
INSERT INTO `rolepermission` VALUES (113, 95, 113, b'0', 'apollo', '2020-01-03 11:15:47', 'apollo', '2020-01-03 11:15:47');
INSERT INTO `rolepermission` VALUES (114, 96, 114, b'0', 'apollo', '2020-01-04 18:18:13', 'apollo', '2020-01-04 18:18:13');
INSERT INTO `rolepermission` VALUES (115, 96, 115, b'0', 'apollo', '2020-01-04 18:18:13', 'apollo', '2020-01-04 18:18:13');
INSERT INTO `rolepermission` VALUES (116, 96, 116, b'0', 'apollo', '2020-01-04 18:18:13', 'apollo', '2020-01-04 18:18:13');
INSERT INTO `rolepermission` VALUES (117, 97, 117, b'0', 'apollo', '2020-01-04 18:18:13', 'apollo', '2020-01-04 18:18:13');
INSERT INTO `rolepermission` VALUES (118, 98, 118, b'0', 'apollo', '2020-01-04 18:18:13', 'apollo', '2020-01-04 18:18:13');
INSERT INTO `rolepermission` VALUES (119, 99, 119, b'0', 'apollo', '2020-01-04 18:18:13', 'apollo', '2020-01-04 18:18:13');
INSERT INTO `rolepermission` VALUES (120, 100, 120, b'0', 'apollo', '2020-01-04 18:18:13', 'apollo', '2020-01-04 18:18:13');
INSERT INTO `rolepermission` VALUES (121, 101, 121, b'0', 'apollo', '2020-01-04 19:08:15', 'apollo', '2020-01-04 19:08:15');
INSERT INTO `rolepermission` VALUES (122, 101, 122, b'0', 'apollo', '2020-01-04 19:08:15', 'apollo', '2020-01-04 19:08:15');
INSERT INTO `rolepermission` VALUES (123, 101, 123, b'0', 'apollo', '2020-01-04 19:08:15', 'apollo', '2020-01-04 19:08:15');
INSERT INTO `rolepermission` VALUES (124, 102, 124, b'0', 'apollo', '2020-01-04 19:08:15', 'apollo', '2020-01-04 19:08:15');
INSERT INTO `rolepermission` VALUES (125, 103, 125, b'0', 'apollo', '2020-01-04 19:08:15', 'apollo', '2020-01-04 19:08:15');
INSERT INTO `rolepermission` VALUES (126, 104, 126, b'0', 'apollo', '2020-01-04 19:08:15', 'apollo', '2020-01-04 19:08:15');
INSERT INTO `rolepermission` VALUES (127, 105, 127, b'0', 'apollo', '2020-01-04 19:08:15', 'apollo', '2020-01-04 19:08:15');
INSERT INTO `rolepermission` VALUES (128, 106, 128, b'1', 'apollo', '2020-01-04 19:11:06', 'apollo', '2020-01-05 14:38:10');
INSERT INTO `rolepermission` VALUES (129, 107, 129, b'1', 'apollo', '2020-01-04 19:11:06', 'apollo', '2020-01-05 14:38:10');
INSERT INTO `rolepermission` VALUES (130, 108, 130, b'0', 'apollo', '2020-01-04 19:11:06', 'apollo', '2020-01-04 19:11:06');
INSERT INTO `rolepermission` VALUES (131, 109, 131, b'0', 'apollo', '2020-01-04 19:11:06', 'apollo', '2020-01-04 19:11:06');
INSERT INTO `rolepermission` VALUES (132, 110, 132, b'0', 'apollo', '2020-01-04 19:13:57', 'apollo', '2020-01-04 19:13:57');
INSERT INTO `rolepermission` VALUES (133, 111, 133, b'0', 'apollo', '2020-01-04 19:13:57', 'apollo', '2020-01-04 19:13:57');
INSERT INTO `rolepermission` VALUES (134, 112, 134, b'0', 'apollo', '2020-01-04 19:13:57', 'apollo', '2020-01-04 19:13:57');
INSERT INTO `rolepermission` VALUES (135, 113, 135, b'0', 'apollo', '2020-01-04 19:13:57', 'apollo', '2020-01-04 19:13:57');
INSERT INTO `rolepermission` VALUES (136, 114, 136, b'0', 'apollo', '2020-01-07 15:07:40', 'apollo', '2020-01-07 15:07:40');
INSERT INTO `rolepermission` VALUES (137, 114, 137, b'0', 'apollo', '2020-01-07 15:07:40', 'apollo', '2020-01-07 15:07:40');
INSERT INTO `rolepermission` VALUES (138, 114, 138, b'0', 'apollo', '2020-01-07 15:07:40', 'apollo', '2020-01-07 15:07:40');
INSERT INTO `rolepermission` VALUES (139, 115, 139, b'0', 'apollo', '2020-01-07 15:07:40', 'apollo', '2020-01-07 15:07:40');
INSERT INTO `rolepermission` VALUES (140, 116, 140, b'0', 'apollo', '2020-01-07 15:07:40', 'apollo', '2020-01-07 15:07:40');
INSERT INTO `rolepermission` VALUES (141, 117, 141, b'0', 'apollo', '2020-01-07 15:07:40', 'apollo', '2020-01-07 15:07:40');
INSERT INTO `rolepermission` VALUES (142, 118, 142, b'0', 'apollo', '2020-01-07 15:07:40', 'apollo', '2020-01-07 15:07:40');
INSERT INTO `rolepermission` VALUES (143, 119, 143, b'0', 'apollo', '2020-01-07 15:11:08', 'apollo', '2020-01-07 15:11:08');
INSERT INTO `rolepermission` VALUES (144, 120, 144, b'0', 'apollo', '2020-01-07 15:11:08', 'apollo', '2020-01-07 15:11:08');
INSERT INTO `rolepermission` VALUES (145, 121, 145, b'0', 'apollo', '2020-01-07 15:11:08', 'apollo', '2020-01-07 15:11:08');
INSERT INTO `rolepermission` VALUES (146, 122, 146, b'0', 'apollo', '2020-01-07 15:11:08', 'apollo', '2020-01-07 15:11:08');
INSERT INTO `rolepermission` VALUES (147, 123, 147, b'0', 'apollo', '2020-01-07 15:15:01', 'apollo', '2020-01-07 15:15:01');
INSERT INTO `rolepermission` VALUES (148, 124, 148, b'0', 'apollo', '2020-01-07 15:15:01', 'apollo', '2020-01-07 15:15:01');
INSERT INTO `rolepermission` VALUES (149, 125, 149, b'0', 'apollo', '2020-01-07 15:15:01', 'apollo', '2020-01-07 15:15:01');
INSERT INTO `rolepermission` VALUES (150, 126, 150, b'0', 'apollo', '2020-01-07 15:15:01', 'apollo', '2020-01-07 15:15:01');
INSERT INTO `rolepermission` VALUES (151, 127, 151, b'0', 'apollo', '2020-01-08 09:07:48', 'apollo', '2020-01-08 09:07:48');
INSERT INTO `rolepermission` VALUES (152, 128, 152, b'0', 'apollo', '2020-01-08 09:07:48', 'apollo', '2020-01-08 09:07:48');
INSERT INTO `rolepermission` VALUES (153, 129, 153, b'0', 'apollo', '2020-01-08 09:07:48', 'apollo', '2020-01-08 09:07:48');
INSERT INTO `rolepermission` VALUES (154, 130, 154, b'0', 'apollo', '2020-01-08 09:07:48', 'apollo', '2020-01-08 09:07:48');
INSERT INTO `rolepermission` VALUES (155, 131, 155, b'0', 'apollo', '2020-02-02 23:23:21', 'apollo', '2020-02-02 23:23:21');
INSERT INTO `rolepermission` VALUES (156, 131, 156, b'0', 'apollo', '2020-02-02 23:23:21', 'apollo', '2020-02-02 23:23:21');
INSERT INTO `rolepermission` VALUES (157, 131, 157, b'0', 'apollo', '2020-02-02 23:23:21', 'apollo', '2020-02-02 23:23:21');
INSERT INTO `rolepermission` VALUES (158, 132, 158, b'0', 'apollo', '2020-02-02 23:23:21', 'apollo', '2020-02-02 23:23:21');
INSERT INTO `rolepermission` VALUES (159, 133, 159, b'0', 'apollo', '2020-02-02 23:23:21', 'apollo', '2020-02-02 23:23:21');
INSERT INTO `rolepermission` VALUES (160, 134, 160, b'0', 'apollo', '2020-02-02 23:23:21', 'apollo', '2020-02-02 23:23:21');
INSERT INTO `rolepermission` VALUES (161, 135, 161, b'0', 'apollo', '2020-02-02 23:23:21', 'apollo', '2020-02-02 23:23:21');
INSERT INTO `rolepermission` VALUES (162, 136, 162, b'0', 'apollo', '2020-02-02 23:25:05', 'apollo', '2020-02-02 23:25:05');
INSERT INTO `rolepermission` VALUES (163, 137, 163, b'0', 'apollo', '2020-02-02 23:25:05', 'apollo', '2020-02-02 23:25:05');
INSERT INTO `rolepermission` VALUES (164, 138, 164, b'0', 'apollo', '2020-02-02 23:25:05', 'apollo', '2020-02-02 23:25:05');
INSERT INTO `rolepermission` VALUES (165, 139, 165, b'0', 'apollo', '2020-02-02 23:25:05', 'apollo', '2020-02-02 23:25:05');
INSERT INTO `rolepermission` VALUES (166, 140, 166, b'1', 'apollo', '2020-02-03 23:00:58', 'apollo', '2020-02-03 23:20:41');
INSERT INTO `rolepermission` VALUES (167, 141, 167, b'1', 'apollo', '2020-02-03 23:00:58', 'apollo', '2020-02-03 23:20:41');
INSERT INTO `rolepermission` VALUES (168, 142, 168, b'0', 'apollo', '2020-02-03 23:00:58', 'apollo', '2020-02-03 23:00:58');
INSERT INTO `rolepermission` VALUES (169, 143, 169, b'0', 'apollo', '2020-02-03 23:00:58', 'apollo', '2020-02-03 23:00:58');
INSERT INTO `rolepermission` VALUES (170, 144, 170, b'0', 'apollo', '2020-02-06 21:30:15', 'apollo', '2020-02-06 21:30:15');
INSERT INTO `rolepermission` VALUES (171, 144, 171, b'0', 'apollo', '2020-02-06 21:30:15', 'apollo', '2020-02-06 21:30:15');
INSERT INTO `rolepermission` VALUES (172, 144, 172, b'0', 'apollo', '2020-02-06 21:30:15', 'apollo', '2020-02-06 21:30:15');
INSERT INTO `rolepermission` VALUES (173, 145, 173, b'0', 'apollo', '2020-02-06 21:30:15', 'apollo', '2020-02-06 21:30:15');
INSERT INTO `rolepermission` VALUES (174, 146, 174, b'0', 'apollo', '2020-02-06 21:30:15', 'apollo', '2020-02-06 21:30:15');
INSERT INTO `rolepermission` VALUES (175, 147, 175, b'0', 'apollo', '2020-02-06 21:30:15', 'apollo', '2020-02-06 21:30:15');
INSERT INTO `rolepermission` VALUES (176, 148, 176, b'0', 'apollo', '2020-02-06 21:30:15', 'apollo', '2020-02-06 21:30:15');
INSERT INTO `rolepermission` VALUES (177, 149, 177, b'0', 'apollo', '2020-02-06 21:32:16', 'apollo', '2020-02-06 21:32:16');
INSERT INTO `rolepermission` VALUES (178, 150, 178, b'0', 'apollo', '2020-02-06 21:32:16', 'apollo', '2020-02-06 21:32:16');
INSERT INTO `rolepermission` VALUES (179, 151, 179, b'0', 'apollo', '2020-02-06 21:32:16', 'apollo', '2020-02-06 21:32:16');
INSERT INTO `rolepermission` VALUES (180, 152, 180, b'0', 'apollo', '2020-02-06 21:32:16', 'apollo', '2020-02-06 21:32:16');
INSERT INTO `rolepermission` VALUES (181, 153, 181, b'0', 'apollo', '2020-02-20 15:13:17', 'apollo', '2020-02-20 15:13:17');
INSERT INTO `rolepermission` VALUES (182, 153, 182, b'0', 'apollo', '2020-02-20 15:13:17', 'apollo', '2020-02-20 15:13:17');
INSERT INTO `rolepermission` VALUES (183, 153, 183, b'0', 'apollo', '2020-02-20 15:13:17', 'apollo', '2020-02-20 15:13:17');
INSERT INTO `rolepermission` VALUES (184, 154, 184, b'0', 'apollo', '2020-02-20 15:13:17', 'apollo', '2020-02-20 15:13:17');
INSERT INTO `rolepermission` VALUES (185, 155, 185, b'0', 'apollo', '2020-02-20 15:13:17', 'apollo', '2020-02-20 15:13:17');
INSERT INTO `rolepermission` VALUES (186, 156, 186, b'0', 'apollo', '2020-02-20 15:13:17', 'apollo', '2020-02-20 15:13:17');
INSERT INTO `rolepermission` VALUES (187, 157, 187, b'0', 'apollo', '2020-02-20 15:13:17', 'apollo', '2020-02-20 15:13:17');
INSERT INTO `rolepermission` VALUES (188, 158, 188, b'0', 'apollo', '2020-02-20 15:15:22', 'apollo', '2020-02-20 15:15:22');
INSERT INTO `rolepermission` VALUES (189, 159, 189, b'0', 'apollo', '2020-02-20 15:15:22', 'apollo', '2020-02-20 15:15:22');
INSERT INTO `rolepermission` VALUES (190, 160, 190, b'0', 'apollo', '2020-02-20 15:15:22', 'apollo', '2020-02-20 15:15:22');
INSERT INTO `rolepermission` VALUES (191, 161, 191, b'0', 'apollo', '2020-02-20 15:15:22', 'apollo', '2020-02-20 15:15:22');
INSERT INTO `rolepermission` VALUES (192, 162, 192, b'0', 'apollo', '2020-02-23 01:27:16', 'apollo', '2020-02-23 01:27:16');
INSERT INTO `rolepermission` VALUES (193, 163, 193, b'0', 'apollo', '2020-02-23 01:27:16', 'apollo', '2020-02-23 01:27:16');
INSERT INTO `rolepermission` VALUES (194, 164, 194, b'0', 'apollo', '2020-02-23 01:27:16', 'apollo', '2020-02-23 01:27:16');
INSERT INTO `rolepermission` VALUES (195, 165, 195, b'0', 'apollo', '2020-02-23 01:27:16', 'apollo', '2020-02-23 01:27:16');

-- ----------------------------
-- Table structure for serverconfig
-- ----------------------------
DROP TABLE IF EXISTS `serverconfig`;
CREATE TABLE `serverconfig`  (
  `Id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增Id',
  `Key` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'default' COMMENT '配置项Key',
  `Value` varchar(2048) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'default' COMMENT '配置项值',
  `Comment` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '注释',
  `IsDeleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '1: deleted, 0: normal',
  `DataChange_CreatedBy` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'default' COMMENT '创建人邮箱前缀',
  `DataChange_CreatedTime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `DataChange_LastModifiedBy` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后修改人邮箱前缀',
  `DataChange_LastTime` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改时间',
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `IX_Key`(`Key`) USING BTREE,
  INDEX `DataChange_LastTime`(`DataChange_LastTime`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '配置服务自身配置' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of serverconfig
-- ----------------------------
INSERT INTO `serverconfig` VALUES (1, 'apollo.portal.envs', 'dev', '可支持的环境列表', b'0', 'default', '2019-12-23 16:50:05', '', '2019-12-23 16:50:05');
INSERT INTO `serverconfig` VALUES (2, 'organizations', '[{\"orgId\":\"TEST1\",\"orgName\":\"样例部门1\"},{\"orgId\":\"TEST2\",\"orgName\":\"样例部门2\"}]', '部门列表', b'0', 'default', '2019-12-23 16:50:05', '', '2019-12-23 16:50:05');
INSERT INTO `serverconfig` VALUES (3, 'superAdmin', 'apollo', 'Portal超级管理员', b'0', 'default', '2019-12-23 16:50:05', '', '2019-12-23 16:50:05');
INSERT INTO `serverconfig` VALUES (4, 'api.readTimeout', '10000', 'http接口read timeout', b'0', 'default', '2019-12-23 16:50:05', '', '2019-12-23 16:50:05');
INSERT INTO `serverconfig` VALUES (5, 'consumer.token.salt', 'someSalt', 'consumer token salt', b'0', 'default', '2019-12-23 16:50:05', '', '2019-12-23 16:50:05');
INSERT INTO `serverconfig` VALUES (6, 'admin.createPrivateNamespace.switch', 'true', '是否允许项目管理员创建私有namespace', b'0', 'default', '2019-12-23 16:50:05', '', '2019-12-23 16:50:05');
INSERT INTO `serverconfig` VALUES (7, 'configView.memberOnly.envs', 'dev', '只对项目成员显示配置信息的环境列表，多个env以英文逗号分隔', b'0', 'default', '2019-12-23 16:50:05', '', '2019-12-23 16:50:05');

-- ----------------------------
-- Table structure for userrole
-- ----------------------------
DROP TABLE IF EXISTS `userrole`;
CREATE TABLE `userrole`  (
  `Id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增Id',
  `UserId` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '用户身份标识',
  `RoleId` int(10) UNSIGNED NULL DEFAULT NULL COMMENT 'Role Id',
  `IsDeleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '1: deleted, 0: normal',
  `DataChange_CreatedBy` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建人邮箱前缀',
  `DataChange_CreatedTime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `DataChange_LastModifiedBy` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后修改人邮箱前缀',
  `DataChange_LastTime` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改时间',
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `IX_DataChange_LastTime`(`DataChange_LastTime`) USING BTREE,
  INDEX `IX_RoleId`(`RoleId`) USING BTREE,
  INDEX `IX_UserId_RoleId`(`UserId`, `RoleId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 92 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户和role的绑定表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of userrole
-- ----------------------------
INSERT INTO `userrole` VALUES (1, 'apollo', 1, b'0', '', '2019-12-23 16:50:05', '', '2019-12-23 16:50:05');
INSERT INTO `userrole` VALUES (2, 'apollo', 2, b'0', '', '2019-12-23 16:50:05', '', '2019-12-23 16:50:05');
INSERT INTO `userrole` VALUES (3, 'apollo', 3, b'0', '', '2019-12-23 16:50:05', '', '2019-12-23 16:50:05');
INSERT INTO `userrole` VALUES (4, 'apollo', 4, b'1', 'apollo', '2019-12-24 13:25:05', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `userrole` VALUES (5, 'apollo', 5, b'1', 'apollo', '2019-12-24 13:25:05', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `userrole` VALUES (6, 'apollo', 6, b'1', 'apollo', '2019-12-24 13:25:05', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `userrole` VALUES (7, 'apollo', 9, b'1', 'apollo', '2019-12-24 15:32:23', 'apollo', '2019-12-31 13:53:05');
INSERT INTO `userrole` VALUES (8, 'apollo', 10, b'1', 'apollo', '2019-12-24 15:32:23', 'apollo', '2019-12-31 13:53:05');
INSERT INTO `userrole` VALUES (9, 'apollo', 11, b'1', 'apollo', '2019-12-24 15:32:23', 'apollo', '2019-12-31 13:53:05');
INSERT INTO `userrole` VALUES (10, 'apollo', 14, b'1', 'apollo', '2019-12-25 16:19:43', 'apollo', '2019-12-31 13:53:40');
INSERT INTO `userrole` VALUES (11, 'apollo', 15, b'1', 'apollo', '2019-12-25 16:19:44', 'apollo', '2019-12-31 13:53:40');
INSERT INTO `userrole` VALUES (12, 'apollo', 16, b'1', 'apollo', '2019-12-25 16:19:44', 'apollo', '2019-12-31 13:53:40');
INSERT INTO `userrole` VALUES (13, 'apollo', 19, b'1', 'apollo', '2019-12-26 10:59:08', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `userrole` VALUES (14, 'apollo', 20, b'1', 'apollo', '2019-12-26 10:59:08', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `userrole` VALUES (15, 'apollo', 23, b'1', 'apollo', '2019-12-26 11:13:26', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `userrole` VALUES (16, 'apollo', 24, b'1', 'apollo', '2019-12-26 11:13:26', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `userrole` VALUES (17, 'apollo', 27, b'1', 'apollo', '2019-12-26 11:15:26', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `userrole` VALUES (18, 'apollo', 28, b'1', 'apollo', '2019-12-26 11:15:26', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `userrole` VALUES (19, 'apollo', 31, b'1', 'apollo', '2019-12-27 14:52:22', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `userrole` VALUES (20, 'apollo', 32, b'1', 'apollo', '2019-12-27 14:52:22', 'apollo', '2019-12-31 13:54:09');
INSERT INTO `userrole` VALUES (21, 'apollo', 35, b'1', 'apollo', '2019-12-27 14:54:08', 'apollo', '2019-12-31 13:53:40');
INSERT INTO `userrole` VALUES (22, 'apollo', 36, b'1', 'apollo', '2019-12-27 14:54:08', 'apollo', '2019-12-31 13:53:40');
INSERT INTO `userrole` VALUES (23, 'apollo', 39, b'1', 'apollo', '2019-12-31 13:43:47', 'apollo', '2019-12-31 14:58:36');
INSERT INTO `userrole` VALUES (24, 'apollo', 40, b'1', 'apollo', '2019-12-31 13:43:47', 'apollo', '2019-12-31 14:58:36');
INSERT INTO `userrole` VALUES (25, 'apollo', 41, b'1', 'apollo', '2019-12-31 13:43:47', 'apollo', '2019-12-31 14:58:36');
INSERT INTO `userrole` VALUES (26, 'apollo', 44, b'0', 'apollo', '2019-12-31 13:56:21', 'apollo', '2019-12-31 13:56:21');
INSERT INTO `userrole` VALUES (27, 'apollo', 45, b'0', 'apollo', '2019-12-31 13:56:21', 'apollo', '2019-12-31 13:56:21');
INSERT INTO `userrole` VALUES (28, 'apollo', 46, b'0', 'apollo', '2019-12-31 13:56:21', 'apollo', '2019-12-31 13:56:21');
INSERT INTO `userrole` VALUES (29, 'apollo', 49, b'0', 'apollo', '2019-12-31 14:04:17', 'apollo', '2019-12-31 14:04:17');
INSERT INTO `userrole` VALUES (30, 'apollo', 50, b'0', 'apollo', '2019-12-31 14:04:17', 'apollo', '2019-12-31 14:04:17');
INSERT INTO `userrole` VALUES (31, 'apollo', 53, b'0', 'apollo', '2019-12-31 14:06:27', 'apollo', '2019-12-31 14:06:27');
INSERT INTO `userrole` VALUES (32, 'apollo', 54, b'0', 'apollo', '2019-12-31 14:06:27', 'apollo', '2019-12-31 14:06:27');
INSERT INTO `userrole` VALUES (33, 'apollo', 57, b'0', 'apollo', '2019-12-31 14:59:02', 'apollo', '2019-12-31 14:59:02');
INSERT INTO `userrole` VALUES (34, 'apollo', 58, b'0', 'apollo', '2019-12-31 14:59:02', 'apollo', '2019-12-31 14:59:02');
INSERT INTO `userrole` VALUES (35, 'apollo', 59, b'0', 'apollo', '2019-12-31 14:59:02', 'apollo', '2019-12-31 14:59:02');
INSERT INTO `userrole` VALUES (36, 'apollo', 62, b'0', 'apollo', '2019-12-31 15:56:28', 'apollo', '2019-12-31 15:56:28');
INSERT INTO `userrole` VALUES (37, 'apollo', 63, b'0', 'apollo', '2019-12-31 15:56:28', 'apollo', '2019-12-31 15:56:28');
INSERT INTO `userrole` VALUES (38, 'apollo', 64, b'0', 'apollo', '2019-12-31 15:56:28', 'apollo', '2019-12-31 15:56:28');
INSERT INTO `userrole` VALUES (39, 'apollo', 67, b'1', 'apollo', '2019-12-31 17:13:07', 'apollo', '2020-01-03 10:58:26');
INSERT INTO `userrole` VALUES (40, 'apollo', 68, b'1', 'apollo', '2019-12-31 17:13:07', 'apollo', '2020-01-03 10:58:26');
INSERT INTO `userrole` VALUES (41, 'apollo', 71, b'0', 'apollo', '2020-01-02 10:58:03', 'apollo', '2020-01-02 10:58:03');
INSERT INTO `userrole` VALUES (42, 'apollo', 72, b'0', 'apollo', '2020-01-02 10:58:03', 'apollo', '2020-01-02 10:58:03');
INSERT INTO `userrole` VALUES (43, 'apollo', 75, b'0', 'apollo', '2020-01-02 14:49:33', 'apollo', '2020-01-02 14:49:33');
INSERT INTO `userrole` VALUES (44, 'apollo', 76, b'0', 'apollo', '2020-01-02 14:49:33', 'apollo', '2020-01-02 14:49:33');
INSERT INTO `userrole` VALUES (45, 'apollo', 77, b'0', 'apollo', '2020-01-02 14:49:33', 'apollo', '2020-01-02 14:49:33');
INSERT INTO `userrole` VALUES (46, 'apollo', 80, b'0', 'apollo', '2020-01-02 14:52:16', 'apollo', '2020-01-02 14:52:16');
INSERT INTO `userrole` VALUES (47, 'apollo', 81, b'0', 'apollo', '2020-01-02 14:52:16', 'apollo', '2020-01-02 14:52:16');
INSERT INTO `userrole` VALUES (48, 'apollo', 84, b'0', 'apollo', '2020-01-02 14:54:38', 'apollo', '2020-01-02 14:54:38');
INSERT INTO `userrole` VALUES (49, 'apollo', 85, b'0', 'apollo', '2020-01-02 14:54:38', 'apollo', '2020-01-02 14:54:38');
INSERT INTO `userrole` VALUES (50, 'apollo', 88, b'0', 'apollo', '2020-01-03 10:59:11', 'apollo', '2020-01-03 10:59:11');
INSERT INTO `userrole` VALUES (51, 'apollo', 89, b'0', 'apollo', '2020-01-03 10:59:11', 'apollo', '2020-01-03 10:59:11');
INSERT INTO `userrole` VALUES (52, 'apollo', 92, b'0', 'apollo', '2020-01-03 11:15:47', 'apollo', '2020-01-03 11:15:47');
INSERT INTO `userrole` VALUES (53, 'apollo', 93, b'0', 'apollo', '2020-01-03 11:15:47', 'apollo', '2020-01-03 11:15:47');
INSERT INTO `userrole` VALUES (54, 'apollo', 96, b'0', 'apollo', '2020-01-04 18:18:13', 'apollo', '2020-01-04 18:18:13');
INSERT INTO `userrole` VALUES (55, 'apollo', 97, b'0', 'apollo', '2020-01-04 18:18:13', 'apollo', '2020-01-04 18:18:13');
INSERT INTO `userrole` VALUES (56, 'apollo', 98, b'0', 'apollo', '2020-01-04 18:18:13', 'apollo', '2020-01-04 18:18:13');
INSERT INTO `userrole` VALUES (57, 'apollo', 101, b'0', 'apollo', '2020-01-04 19:08:15', 'apollo', '2020-01-04 19:08:15');
INSERT INTO `userrole` VALUES (58, 'apollo', 102, b'0', 'apollo', '2020-01-04 19:08:15', 'apollo', '2020-01-04 19:08:15');
INSERT INTO `userrole` VALUES (59, 'apollo', 103, b'0', 'apollo', '2020-01-04 19:08:15', 'apollo', '2020-01-04 19:08:15');
INSERT INTO `userrole` VALUES (60, 'apollo', 106, b'1', 'apollo', '2020-01-04 19:11:06', 'apollo', '2020-01-05 14:38:10');
INSERT INTO `userrole` VALUES (61, 'apollo', 107, b'1', 'apollo', '2020-01-04 19:11:06', 'apollo', '2020-01-05 14:38:10');
INSERT INTO `userrole` VALUES (62, 'apollo', 110, b'0', 'apollo', '2020-01-04 19:13:57', 'apollo', '2020-01-04 19:13:57');
INSERT INTO `userrole` VALUES (63, 'apollo', 111, b'0', 'apollo', '2020-01-04 19:13:57', 'apollo', '2020-01-04 19:13:57');
INSERT INTO `userrole` VALUES (64, 'apollo', 114, b'0', 'apollo', '2020-01-07 15:07:40', 'apollo', '2020-01-07 15:07:40');
INSERT INTO `userrole` VALUES (65, 'apollo', 115, b'0', 'apollo', '2020-01-07 15:07:40', 'apollo', '2020-01-07 15:07:40');
INSERT INTO `userrole` VALUES (66, 'apollo', 116, b'0', 'apollo', '2020-01-07 15:07:40', 'apollo', '2020-01-07 15:07:40');
INSERT INTO `userrole` VALUES (67, 'apollo', 119, b'0', 'apollo', '2020-01-07 15:11:08', 'apollo', '2020-01-07 15:11:08');
INSERT INTO `userrole` VALUES (68, 'apollo', 120, b'0', 'apollo', '2020-01-07 15:11:08', 'apollo', '2020-01-07 15:11:08');
INSERT INTO `userrole` VALUES (69, 'apollo', 123, b'0', 'apollo', '2020-01-07 15:15:01', 'apollo', '2020-01-07 15:15:01');
INSERT INTO `userrole` VALUES (70, 'apollo', 124, b'0', 'apollo', '2020-01-07 15:15:01', 'apollo', '2020-01-07 15:15:01');
INSERT INTO `userrole` VALUES (71, 'apollo', 127, b'0', 'apollo', '2020-01-08 09:07:48', 'apollo', '2020-01-08 09:07:48');
INSERT INTO `userrole` VALUES (72, 'apollo', 128, b'0', 'apollo', '2020-01-08 09:07:48', 'apollo', '2020-01-08 09:07:48');
INSERT INTO `userrole` VALUES (73, 'apollo', 131, b'0', 'apollo', '2020-02-02 23:23:21', 'apollo', '2020-02-02 23:23:21');
INSERT INTO `userrole` VALUES (74, 'apollo', 132, b'0', 'apollo', '2020-02-02 23:23:21', 'apollo', '2020-02-02 23:23:21');
INSERT INTO `userrole` VALUES (75, 'apollo', 133, b'0', 'apollo', '2020-02-02 23:23:21', 'apollo', '2020-02-02 23:23:21');
INSERT INTO `userrole` VALUES (76, 'apollo', 136, b'0', 'apollo', '2020-02-02 23:25:05', 'apollo', '2020-02-02 23:25:05');
INSERT INTO `userrole` VALUES (77, 'apollo', 137, b'0', 'apollo', '2020-02-02 23:25:05', 'apollo', '2020-02-02 23:25:05');
INSERT INTO `userrole` VALUES (78, 'apollo', 140, b'1', 'apollo', '2020-02-03 23:00:58', 'apollo', '2020-02-03 23:20:41');
INSERT INTO `userrole` VALUES (79, 'apollo', 141, b'1', 'apollo', '2020-02-03 23:00:58', 'apollo', '2020-02-03 23:20:41');
INSERT INTO `userrole` VALUES (80, 'apollo', 144, b'0', 'apollo', '2020-02-06 21:30:15', 'apollo', '2020-02-06 21:30:15');
INSERT INTO `userrole` VALUES (81, 'apollo', 145, b'0', 'apollo', '2020-02-06 21:30:15', 'apollo', '2020-02-06 21:30:15');
INSERT INTO `userrole` VALUES (82, 'apollo', 146, b'0', 'apollo', '2020-02-06 21:30:15', 'apollo', '2020-02-06 21:30:15');
INSERT INTO `userrole` VALUES (83, 'apollo', 149, b'0', 'apollo', '2020-02-06 21:32:16', 'apollo', '2020-02-06 21:32:16');
INSERT INTO `userrole` VALUES (84, 'apollo', 150, b'0', 'apollo', '2020-02-06 21:32:16', 'apollo', '2020-02-06 21:32:16');
INSERT INTO `userrole` VALUES (85, 'apollo', 153, b'0', 'apollo', '2020-02-20 15:13:17', 'apollo', '2020-02-20 15:13:17');
INSERT INTO `userrole` VALUES (86, 'apollo', 154, b'0', 'apollo', '2020-02-20 15:13:17', 'apollo', '2020-02-20 15:13:17');
INSERT INTO `userrole` VALUES (87, 'apollo', 155, b'0', 'apollo', '2020-02-20 15:13:17', 'apollo', '2020-02-20 15:13:17');
INSERT INTO `userrole` VALUES (88, 'apollo', 158, b'0', 'apollo', '2020-02-20 15:15:22', 'apollo', '2020-02-20 15:15:22');
INSERT INTO `userrole` VALUES (89, 'apollo', 159, b'0', 'apollo', '2020-02-20 15:15:22', 'apollo', '2020-02-20 15:15:22');
INSERT INTO `userrole` VALUES (90, 'apollo', 162, b'0', 'apollo', '2020-02-23 01:27:16', 'apollo', '2020-02-23 01:27:16');
INSERT INTO `userrole` VALUES (91, 'apollo', 163, b'0', 'apollo', '2020-02-23 01:27:16', 'apollo', '2020-02-23 01:27:16');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `Id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增Id',
  `Username` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'default' COMMENT '用户名',
  `Password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'default' COMMENT '密码',
  `Email` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'default' COMMENT '邮箱地址',
  `Enabled` tinyint(4) NULL DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'apollo', '$2a$10$7r20uS.BQ9uBpf3Baj3uQOZvMVvB1RN3PYoKE94gtz2.WAOuiiwXS', 'apollo@acme.com', 1);
INSERT INTO `users` VALUES (2, 'root', '$2a$10$DmXBk4fMiP6BBAqWU1Ie9.VPPmvCPeNaDNEAWCk/5JBJuJ7ZTQ.2y', '576033567@qq.com', 1);

SET FOREIGN_KEY_CHECKS = 1;
