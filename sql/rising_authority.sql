/*
 Navicat Premium Data Transfer

 Source Server         : 阿里云主节点
 Source Server Type    : MySQL
 Source Server Version : 50733
 Source Host           : 120.24.43.129:3306
 Source Schema         : rising_authority

 Target Server Type    : MySQL
 Target Server Version : 50733
 File Encoding         : 65001

 Date: 09/03/2021 12:09:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
BEGIN;
INSERT INTO `hibernate_sequence` VALUES (185);
INSERT INTO `hibernate_sequence` VALUES (185);
INSERT INTO `hibernate_sequence` VALUES (185);
INSERT INTO `hibernate_sequence` VALUES (185);
INSERT INTO `hibernate_sequence` VALUES (185);
INSERT INTO `hibernate_sequence` VALUES (185);
INSERT INTO `hibernate_sequence` VALUES (185);
COMMIT;

-- ----------------------------
-- Table structure for oauth_access_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_access_token`;
CREATE TABLE `oauth_access_token` (
  `token_id` varchar(256) DEFAULT NULL,
  `token` blob,
  `authentication_id` varchar(48) NOT NULL,
  `user_name` varchar(256) DEFAULT NULL,
  `client_id` varchar(256) DEFAULT NULL,
  `authentication` blob,
  `refresh_token` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`authentication_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth_access_token
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for oauth_client_details
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details` (
  `client_id` varchar(48) NOT NULL,
  `resource_ids` varchar(256) DEFAULT NULL,
  `client_secret` varchar(256) DEFAULT NULL,
  `scope` varchar(256) DEFAULT NULL,
  `authorized_grant_types` varchar(256) DEFAULT NULL,
  `web_server_redirect_uri` varchar(256) DEFAULT NULL,
  `authorities` varchar(256) DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT NULL,
  `refresh_token_validity` int(11) DEFAULT NULL,
  `additional_information` varchar(4096) DEFAULT NULL,
  `autoapprove` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`client_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth_client_details
-- ----------------------------
BEGIN;
INSERT INTO `oauth_client_details` VALUES ('admin', NULL, '$2a$10$5g9xkfiGalK3qwZGnvu0Euwvi53ps/oiVpi34CHw2hhBKgj26/t4W', 'app', 'authorization_code,password,refresh_token,client_credentials,custom', NULL, NULL, 36000, 2592000, NULL, NULL);
INSERT INTO `oauth_client_details` VALUES ('filesystem-service', NULL, '$2a$10$YnoHEI6GGCwBRHaSFfIUHuBsuQ0J7MGMAxk6oo5ApQ3jBLAqnh.kK', 'all,test,read', 'authorization_code,password,refresh_token,client_credentials,custom', NULL, NULL, 36000, 2592000, NULL, NULL);
INSERT INTO `oauth_client_details` VALUES ('freight-service', NULL, '$2a$10$YnoHEI6GGCwBRHaSFfIUHuBsuQ0J7MGMAxk6oo5ApQ3jBLAqnh.kK', 'all,test,read', 'authorization_code,password,refresh_token,client_credentials,custom', NULL, NULL, 36000, 2592000, NULL, NULL);
INSERT INTO `oauth_client_details` VALUES ('gateway-server', NULL, '$2a$10$YnoHEI6GGCwBRHaSFfIUHuBsuQ0J7MGMAxk6oo5ApQ3jBLAqnh.kK', 'app', 'authorization_code,password,refresh_token,client_credentials', NULL, NULL, 3600, 2592000, NULL, NULL);
INSERT INTO `oauth_client_details` VALUES ('order-service', NULL, '$2a$10$YnoHEI6GGCwBRHaSFfIUHuBsuQ0J7MGMAxk6oo5ApQ3jBLAqnh.kK', 'all,test,read', 'authorization_code,password,refresh_token,client_credentials', NULL, NULL, 3600, 2592000, NULL, NULL);
INSERT INTO `oauth_client_details` VALUES ('pay-service', NULL, '$2a$10$YnoHEI6GGCwBRHaSFfIUHuBsuQ0J7MGMAxk6oo5ApQ3jBLAqnh.kK', 'all,test,read', 'authorization_code,password,refresh_token,client_credentials', NULL, NULL, 3600, 2592000, NULL, NULL);
INSERT INTO `oauth_client_details` VALUES ('price-service', NULL, '$2a$10$YnoHEI6GGCwBRHaSFfIUHuBsuQ0J7MGMAxk6oo5ApQ3jBLAqnh.kK', 'all,test,read', 'authorization_code,password,refresh_token,client_credentials', NULL, NULL, 3600, 2592000, NULL, NULL);
INSERT INTO `oauth_client_details` VALUES ('rising', '', '$2a$10$YnoHEI6GGCwBRHaSFfIUHuBsuQ0J7MGMAxk6oo5ApQ3jBLAqnh.kK', 'all,test,read', 'authorization_code,password,refresh_token,client_credentials,custom', 'http://www.example.com', NULL, 36000, 2592000, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for oauth_client_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_token`;
CREATE TABLE `oauth_client_token` (
  `token_id` varchar(256) DEFAULT NULL,
  `token` blob,
  `authentication_id` varchar(48) NOT NULL,
  `user_name` varchar(256) DEFAULT NULL,
  `client_id` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`authentication_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth_client_token
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for oauth_code
-- ----------------------------
DROP TABLE IF EXISTS `oauth_code`;
CREATE TABLE `oauth_code` (
  `code` varchar(256) DEFAULT NULL,
  `authentication` blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth_code
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for oauth_refresh_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_refresh_token`;
CREATE TABLE `oauth_refresh_token` (
  `token_id` varchar(256) DEFAULT NULL,
  `token` blob,
  `authentication` blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth_refresh_token
-- ----------------------------
BEGIN;
INSERT INTO `oauth_refresh_token` VALUES ('b96e057b4e1c4920428e833db48d4c15', 0xEFBFBDEFBFBD00057372004C6F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744578706972696E674F417574683252656672657368546F6B656E2FEFBFBD4763EFBFBDEFBFBDC9B70200014C000A65787069726174696F6E7400104C6A6176612F7574696C2F446174653B787200446F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744F417574683252656672657368546F6B656E73EFBFBD0E0A6354EFBFBD5E0200014C000576616C75657400124C6A6176612F6C616E672F537472696E673B787074002462303132643438372D613930382D343361662D613865662D3533633533393963386264367372000E6A6176612E7574696C2E44617465686AEFBFBD014B59741903000078707708000001613B74C98E78, 0xEFBFBDEFBFBD0005737200416F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E4F417574683241757468656E7469636174696F6EEFBFBD400B02166252130200024C000D73746F7265645265717565737474003C4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F70726F76696465722F4F4175746832526571756573743B4C00127573657241757468656E7469636174696F6E7400324C6F72672F737072696E676672616D65776F726B2F73656375726974792F636F72652F41757468656E7469636174696F6E3B787200476F72672E737072696E676672616D65776F726B2E73656375726974792E61757468656E7469636174696F6E2E416273747261637441757468656E7469636174696F6E546F6B656ED3AA287E6E47640E0200035A000D61757468656E746963617465644C000B617574686F7269746965737400164C6A6176612F7574696C2F436F6C6C656374696F6E3B4C000764657461696C737400124C6A6176612F6C616E672F4F626A6563743B787000737200266A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C654C697374EFBFBD0F2531EFBFBDEFBFBD100200014C00046C6973747400104C6A6176612F7574696C2F4C6973743B7872002C6A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65436F6C6C656374696F6E194200EFBFBDEFBFBD5EEFBFBD1E0200014C00016371007E00047870737200136A6176612E7574696C2E41727261794C69737478EFBFBDEFBFBD1DEFBFBDEFBFBD61EFBFBD03000149000473697A65787000000009770400000009737200426F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E617574686F726974792E53696D706C654772616E746564417574686F7269747900000000000001EFBFBD0200014C0004726F6C657400124C6A6176612F6C616E672F537472696E673B787074000A524F4C455F61646D696E7371007E000D740006617069646F637371007E000D74000C64617461626173652F6C6F677371007E000D74000673797374656D7371007E000D740008757365722F6164647371007E000D74000B757365722F64656C6574657371007E000D740009757365722F656469747371007E000D740009757365722F766965777371007E000D740008757365724C6973747871007E000C707372003A6F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E4F41757468325265717565737400000000000000010200075A0008617070726F7665644C000B617574686F72697469657371007E00044C000A657874656E73696F6E7374000F4C6A6176612F7574696C2F4D61703B4C000B726564697265637455726971007E000E4C00077265667265736874003B4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F70726F76696465722F546F6B656E526571756573743B4C000B7265736F7572636549647374000F4C6A6176612F7574696C2F5365743B4C000D726573706F6E7365547970657371007E0024787200386F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E426173655265717565737436287A3EEFBFBD7169EFBFBD0200034C0008636C69656E74496471007E000E4C001172657175657374506172616D657465727371007E00224C000573636F706571007E00247870740006776562417070737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C654D6170EFBFBDEFBFBD74EFBFBD07420200014C00016D71007E00227870737200116A6176612E7574696C2E486173684D61700507EFBFBDEFBFBDEFBFBD1660EFBFBD03000246000A6C6F6164466163746F724900097468726573686F6C6478703F400000000000037708000000040000000274000A6772616E745F7479706574000870617373776F7264740008757365726E616D6574000561646D696E78737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65536574EFBFBD1DEFBFBDD18FEFBFBDEFBFBD550200007871007E0009737200176A6176612E7574696C2E4C696E6B656448617368536574EFBFBD6CEFBFBD5AEFBFBDEFBFBD2A1E020000787200116A6176612E7574696C2E48617368536574EFBFBD44EFBFBDEFBFBDEFBFBDEFBFBDEFBFBD340300007870770C000000103F4000000000000174000361707078017371007E0033770C000000103F40000000000000787371007E002A3F40000000000000770800000010000000007870707371007E0033770C000000103F40000000000000787371007E0033770C000000103F40000000000000787372004F6F72672E737072696E676672616D65776F726B2E73656375726974792E61757468656E7469636174696F6E2E557365726E616D6550617373776F726441757468656E7469636174696F6E546F6B656E00000000000001EFBFBD0200024C000B63726564656E7469616C7371007E00054C00097072696E636970616C71007E00057871007E0003017371007E00077371007E000B0000000977040000000971007E000F71007E001171007E001371007E001571007E001771007E001971007E001B71007E001D71007E001F7871007E003D737200176A6176612E7574696C2E4C696E6B6564486173684D617034EFBFBD4E5C106CEFBFBDEFBFBD0200015A000B6163636573734F726465727871007E002A3F400000000000067708000000080000000271007E002C71007E002D71007E002E71007E002F780070737200326F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E7573657264657461696C732E5573657200000000000001EFBFBD0200075A00116163636F756E744E6F6E457870697265645A00106163636F756E744E6F6E4C6F636B65645A001563726564656E7469616C734E6F6E457870697265645A0007656E61626C65644C000B617574686F72697469657371007E00244C000870617373776F726471007E000E4C0008757365726E616D6571007E000E7870010101017371007E0030737200116A6176612E7574696C2E54726565536574DD9850EFBFBDEFBFBDEFBFBD5B0300007870737200466F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E7573657264657461696C732E5573657224417574686F72697479436F6D70617261746F7200000000000001EFBFBD020000787077040000000971007E000F71007E001171007E001371007E001571007E001771007E001971007E001B71007E001D71007E001F787074000561646D696E);
COMMIT;

-- ----------------------------
-- Table structure for persistent_logins
-- ----------------------------
DROP TABLE IF EXISTS `persistent_logins`;
CREATE TABLE `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of persistent_logins
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for rising_userconnection
-- ----------------------------
DROP TABLE IF EXISTS `rising_userconnection`;
CREATE TABLE `rising_userconnection` (
  `userId` varchar(255) CHARACTER SET utf8mb4 NOT NULL,
  `providerId` varchar(255) CHARACTER SET utf8mb4 NOT NULL,
  `providerUserId` varchar(255) CHARACTER SET utf8mb4 NOT NULL,
  `rank` int(11) NOT NULL,
  `displayName` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `profileUrl` varchar(512) CHARACTER SET utf8mb4 DEFAULT NULL,
  `imageUrl` varchar(512) CHARACTER SET utf8mb4 DEFAULT NULL,
  `accessToken` varchar(512) CHARACTER SET utf8mb4 NOT NULL,
  `secret` varchar(512) CHARACTER SET utf8mb4 DEFAULT NULL,
  `refreshToken` varchar(512) CHARACTER SET utf8mb4 DEFAULT NULL,
  `expireTime` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`userId`,`providerId`,`providerUserId`) USING BTREE,
  UNIQUE KEY `UserConnectionRank` (`userId`,`providerId`,`rank`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rising_userconnection
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for spring_session
-- ----------------------------
DROP TABLE IF EXISTS `spring_session`;
CREATE TABLE `spring_session` (
  `PRIMARY_ID` char(36) NOT NULL,
  `SESSION_ID` char(36) NOT NULL,
  `CREATION_TIME` bigint(20) NOT NULL,
  `LAST_ACCESS_TIME` bigint(20) NOT NULL,
  `MAX_INACTIVE_INTERVAL` int(11) NOT NULL,
  `EXPIRY_TIME` bigint(20) NOT NULL,
  `PRINCIPAL_NAME` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`PRIMARY_ID`) USING BTREE,
  UNIQUE KEY `SPRING_SESSION_IX1` (`SESSION_ID`) USING BTREE,
  KEY `SPRING_SESSION_IX2` (`EXPIRY_TIME`) USING BTREE,
  KEY `SPRING_SESSION_IX3` (`PRINCIPAL_NAME`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of spring_session
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for spring_session_attributes
-- ----------------------------
DROP TABLE IF EXISTS `spring_session_attributes`;
CREATE TABLE `spring_session_attributes` (
  `SESSION_PRIMARY_ID` char(36) NOT NULL,
  `ATTRIBUTE_NAME` varchar(200) NOT NULL,
  `ATTRIBUTE_BYTES` blob NOT NULL,
  PRIMARY KEY (`SESSION_PRIMARY_ID`,`ATTRIBUTE_NAME`) USING BTREE,
  KEY `SPRING_SESSION_ATTRIBUTES_IX1` (`SESSION_PRIMARY_ID`) USING BTREE,
  CONSTRAINT `SPRING_SESSION_ATTRIBUTES_FK` FOREIGN KEY (`SESSION_PRIMARY_ID`) REFERENCES `spring_session` (`PRIMARY_ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of spring_session_attributes
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sys_admin
-- ----------------------------
DROP TABLE IF EXISTS `sys_admin`;
CREATE TABLE `sys_admin` (
  `id` bigint(20) NOT NULL,
  `create_time` datetime NOT NULL,
  `is_delete` bit(1) NOT NULL DEFAULT b'0',
  `operator` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `organization_id` bigint(20) DEFAULT NULL,
  `status` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `FK2h9w504ujc8y19ub2si0wvvw4` (`organization_id`) USING BTREE,
  CONSTRAINT `FK2h9w504ujc8y19ub2si0wvvw4` FOREIGN KEY (`organization_id`) REFERENCES `sys_organization` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_admin
-- ----------------------------
BEGIN;
INSERT INTO `sys_admin` VALUES (18, '2020-12-29 14:30:04', b'0', 'admin', '2021-03-04 14:10:09', '478668865@qq.com', '18788523442', 'System', '$2a$10$c6b6NKedL7ima4iIVhIbp.rZV/2mfJIcASCoCGe7pJZBY9.tkDgVm', 'admin', 17, 0);
INSERT INTO `sys_admin` VALUES (21, '2020-12-29 14:30:04', b'0', 'admin', '2021-02-22 15:28:14', '478668865@qq.com', '18788523442', '张三', '$2a$10$ywdMdSwxI3G9weH4cBdGo.60vLEy.bUk5TK2WsSIXs5Aaubx.3qQu', 'user1', 20, 0);
INSERT INTO `sys_admin` VALUES (24, '2020-12-29 14:30:04', b'0', 'HSystem', '2020-12-29 14:30:04', '478668865@qq.com', '18788523442', '李四', '$2a$10$ksxpVQeZgHqCN6V5zfNTQuVtHzG0.JZA9m0WWKEdfjIcbXmNFIf8S', 'user2', 23, 0);
INSERT INTO `sys_admin` VALUES (25, '2020-12-30 11:42:06', b'0', 'admin', '2020-12-30 14:47:41', '222@qq.com', '18788523442', '管理员', NULL, '18788523442', 17, 0);
COMMIT;

-- ----------------------------
-- Table structure for sys_organization
-- ----------------------------
DROP TABLE IF EXISTS `sys_organization`;
CREATE TABLE `sys_organization` (
  `id` bigint(20) NOT NULL,
  `create_time` datetime NOT NULL,
  `is_delete` bit(1) NOT NULL DEFAULT b'0',
  `operator` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sort` int(11) NOT NULL,
  `type` int(11) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `status` int(11) NOT NULL DEFAULT '0',
  `balance` decimal(19,2) DEFAULT NULL COMMENT '当前余额',
  `business_license_id` varchar(255) DEFAULT NULL COMMENT '营业执照-图片ID',
  `company_address` varchar(255) DEFAULT NULL COMMENT '公司地址',
  `company_area` varchar(255) DEFAULT NULL COMMENT '公司地区',
  `company_phone` varchar(255) DEFAULT NULL COMMENT '公司电话',
  `company_size` varchar(255) DEFAULT NULL COMMENT '公司规模',
  `expiration_date` datetime DEFAULT NULL COMMENT '到期时间',
  `industry` varchar(255) DEFAULT NULL COMMENT '所属行业',
  `legal_representative` varchar(255) DEFAULT NULL COMMENT '法人代表',
  `mailbox` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `renewal_date` datetime DEFAULT NULL COMMENT '续期时间',
  `version` varchar(255) DEFAULT NULL COMMENT '当前版本',
  `credit_id` varchar(255) DEFAULT NULL COMMENT '信用代码',
  `old_company_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `FKc50ghw3gv37epedfra5n124xg` (`parent_id`) USING BTREE,
  CONSTRAINT `FKc50ghw3gv37epedfra5n124xg` FOREIGN KEY (`parent_id`) REFERENCES `sys_organization` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_organization
-- ----------------------------
BEGIN;
INSERT INTO `sys_organization` VALUES (17, '2020-12-29 14:30:04', b'0', 'HSystem', '2020-12-29 14:30:04', '网络货运平台', 0, NULL, NULL, 0, 500.00, '88997gnmufgg', '云南昆明', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_organization` VALUES (20, '2020-12-29 14:30:04', b'0', 'HSystem', '2020-12-29 14:30:04', '昆明中西科技', 0, 0, 17, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_organization` VALUES (23, '2020-12-29 14:30:04', b'0', 'HSystem', '2020-12-29 14:30:04', '昆明亿玺科技', 0, 0, 17, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_organization` VALUES (26, '2020-12-29 14:30:04', b'0', 'HSystem', '2020-12-29 14:30:04', '财务部门', 0, 1, 20, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_organization` VALUES (27, '2020-12-29 14:30:04', b'0', 'HSystem', '2020-12-29 14:30:04', '开发部门', 0, 1, 20, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_organization` VALUES (28, '2020-12-29 14:30:04', b'0', 'HSystem', '2020-12-29 14:30:04', '行政部门', 0, 1, 20, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_organization` VALUES (29, '2020-12-29 14:30:04', b'0', 'HSystem', '2020-12-29 14:30:04', 'Java开发部', 0, 1, 23, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_organization` VALUES (30, '2020-12-29 14:30:04', b'0', 'HSystem', '2020-12-29 14:30:04', 'C++开发部', 0, 1, 23, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_organization` VALUES (31, '2020-12-29 14:30:04', b'0', 'HSystem', '2020-12-29 14:30:04', 'PHP开发部', 0, 1, 23, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_organization` VALUES (111, '2021-01-27 12:48:46', b'0', 'HSystem', '2021-01-27 12:48:46', '中玺测试', 0, 0, 17, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '123456789', 1);
INSERT INTO `sys_organization` VALUES (112, '2021-02-18 14:00:17', b'0', 'HSystem', '2021-02-18 14:00:17', '中流科技', 0, 0, 17, 0, NULL, NULL, NULL, NULL, '18666666666', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '9153010007761414X8', 44);
COMMIT;

-- ----------------------------
-- Table structure for sys_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource` (
  `id` bigint(20) NOT NULL,
  `create_time` datetime NOT NULL,
  `is_delete` bit(1) NOT NULL DEFAULT b'0',
  `operator` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `parent_name` varchar(255) DEFAULT NULL,
  `perms` varchar(255) DEFAULT NULL,
  `sort` int(11) NOT NULL,
  `type` int(11) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `status` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `FK3fekum3ead5klp7y4lckn5ohi` (`parent_id`) USING BTREE,
  CONSTRAINT `FK3fekum3ead5klp7y4lckn5ohi` FOREIGN KEY (`parent_id`) REFERENCES `sys_resource` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_resource
-- ----------------------------
BEGIN;
INSERT INTO `sys_resource` VALUES (1, '2021-01-08 14:20:07', b'0', 'HSystem', '2021-01-08 14:20:07', NULL, 'root', NULL, NULL, 0, NULL, NULL, NULL, 0);
INSERT INTO `sys_resource` VALUES (2, '2021-01-08 14:20:07', b'0', 'HSystem', '2021-01-08 14:20:07', 'system', '系统管理', 'root', '', 0, 0, '', 1, 0);
INSERT INTO `sys_resource` VALUES (3, '2021-01-08 14:20:07', b'0', 'HSystem', '2021-01-08 14:20:07', 'system', '平台管理', 'root', '', 0, 0, '', 1, 0);
INSERT INTO `sys_resource` VALUES (4, '2021-01-08 14:20:07', b'0', 'HSystem', '2021-01-08 14:20:07', 'admin', '管理员列表', '系统管理', 'get/uaa/sys/admin/**', 0, 1, 'sys/user', 2, 0);
INSERT INTO `sys_resource` VALUES (5, '2021-01-08 14:20:07', b'0', 'HSystem', '2021-01-08 14:20:07', 'role', '角色管理', '系统管理', 'get/uaa/sys/role/**', 0, 1, 'sys/role', 2, 0);
INSERT INTO `sys_resource` VALUES (6, '2021-01-08 14:20:07', b'0', 'HSystem', '2021-01-08 14:20:07', 'sql', 'SQL监控', '系统管理', '', 0, 1, 'http://gateway.api/uaa/druid/sql.html', 2, 0);
INSERT INTO `sys_resource` VALUES (7, '2021-01-08 14:20:07', b'0', 'HSystem', '2021-01-08 14:20:07', 'job', '定时任务', '系统管理', '', 0, 1, 'job/schedule', 2, 0);
INSERT INTO `sys_resource` VALUES (8, '2021-01-08 14:20:07', b'0', 'admin', '2021-03-08 12:04:27', 'mudedi', 'swaggerApi', '系统管理', '', 0, 1, 'http://127.0.0.1:8800/swagger-ui.html', 2, 0);
INSERT INTO `sys_resource` VALUES (9, '2021-01-08 14:20:07', b'0', 'HSystem', '2021-01-08 14:20:07', 'log', '系统日志', '系统管理', '', 0, 1, 'sys/log', 2, 0);
INSERT INTO `sys_resource` VALUES (10, '2021-01-08 14:20:07', b'0', 'HSystem', '2021-01-08 14:20:07', 'admin', '商家入住', '平台管理', '', 0, 1, 'sys/user', 3, 0);
INSERT INTO `sys_resource` VALUES (11, '2021-01-08 14:20:07', b'0', 'HSystem', '2021-01-08 14:20:07', 'role', '会员管理', '平台管理', '', 0, 1, 'sys/role', 3, 0);
INSERT INTO `sys_resource` VALUES (12, '2021-01-08 14:20:07', b'0', 'HSystem', '2021-01-08 14:20:07', 'menu', '菜单管理', '平台管理', 'get/uaa/sys/resource/**', 0, 1, 'sys/menu', 3, 0);
INSERT INTO `sys_resource` VALUES (13, '2021-01-08 14:20:07', b'0', 'HSystem', '2021-01-08 14:20:07', 'menu', '企业管理', '平台管理', 'get/uaa/sys/organization/**', 0, 1, 'platform/company', 3, 0);
INSERT INTO `sys_resource` VALUES (35, '2021-01-08 15:48:08', b'0', 'admin', '2021-02-19 10:00:16', 'zonghe', '网络货运', 'root', '', 2, 0, '', 1, 0);
INSERT INTO `sys_resource` VALUES (36, '2021-01-08 15:49:07', b'0', 'admin', '2021-02-19 12:39:50', 'xiangqu', '车辆信息', '网络货运', 'vvv', 0, 1, 'freightcenter/car/carlist', 35, 0);
INSERT INTO `sys_resource` VALUES (37, '2021-01-11 13:56:36', b'0', 'admin', '2021-03-03 11:00:59', 'tubiao', '司机管理', '网络货运', 'vv', 0, 1, 'freightcenter/driver/driverlist', 35, 0);
INSERT INTO `sys_resource` VALUES (38, '2021-01-11 13:57:27', b'0', 'admin', '2021-02-19 14:11:25', 'shoucang', '位置信息', '网络货运', 'vv', 0, 1, 'freightcenter/location/location', 35, 0);
INSERT INTO `sys_resource` VALUES (39, '2021-01-11 13:58:02', b'0', 'admin', '2021-02-19 11:24:39', 'xiangqufill', '订单管理', '网络货运', 'vv', 0, 1, 'freightcenter/order/order', 35, 0);
INSERT INTO `sys_resource` VALUES (40, '2021-01-11 13:59:02', b'0', 'admin', '2021-02-19 11:24:26', 'role', '资金流水', '网络货运', 'vv', 0, 1, 'freightcenter/capitalflow/capitalflow', 35, 0);
INSERT INTO `sys_resource` VALUES (89, '2021-01-22 10:18:29', b'0', 'admin', '2021-03-05 09:18:07', 'editor', '货物管理', '网络货运', '', 0, 1, 'freightcenter/goods/goodslist', 35, 0);
INSERT INTO `sys_resource` VALUES (114, '2021-02-19 12:02:44', b'0', 'admin', '2021-02-19 12:02:44', 'zhedie', 'demo测试', 'root', '', 0, 0, '', 1, 0);
INSERT INTO `sys_resource` VALUES (115, '2021-02-19 12:04:42', b'0', 'admin', '2021-02-19 15:39:13', 'xiangqufill', '测试ant抽屉', 'demo测试', '', 0, 1, 'test/carlist', 114, 0);
INSERT INTO `sys_resource` VALUES (143, '2021-02-22 16:11:51', b'0', 'admin', '2021-02-22 16:46:14', '', '修改', '角色管理', 'put/uaa/sys/role/**', 0, 2, '', 5, 0);
INSERT INTO `sys_resource` VALUES (144, '2021-02-22 16:11:55', b'0', 'admin', '2021-02-22 16:46:06', '', '添加', '角色管理', 'post/uaa/sys/role/**', 0, 2, '', 5, 0);
INSERT INTO `sys_resource` VALUES (183, '2021-02-23 11:11:06', b'0', 'admin', '2021-02-23 11:11:06', 'mudedi', '测试卡片', 'demo测试', '', 0, 1, 'test/elcar', 114, 0);
INSERT INTO `sys_resource` VALUES (184, '2021-03-02 10:25:54', b'0', 'admin', '2021-03-02 10:25:54', 'xiangqu', '测试上传', 'demo测试', '', 0, 1, 'test/uploadtest', 114, 0);
COMMIT;

-- ----------------------------
-- Table structure for sys_resource_urls
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource_urls`;
CREATE TABLE `sys_resource_urls` (
  `resource_id` bigint(20) NOT NULL,
  `urls` varchar(255) DEFAULT NULL,
  KEY `FKdrxhftk4rjyw98jo7r2qbboat` (`resource_id`) USING BTREE,
  CONSTRAINT `FKdrxhftk4rjyw98jo7r2qbboat` FOREIGN KEY (`resource_id`) REFERENCES `sys_resource` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_resource_urls
-- ----------------------------
BEGIN;
INSERT INTO `sys_resource_urls` VALUES (4, 'get/uaa/sys/admin/**');
INSERT INTO `sys_resource_urls` VALUES (4, 'sys/user');
INSERT INTO `sys_resource_urls` VALUES (5, 'get/uaa/sys/role/**');
INSERT INTO `sys_resource_urls` VALUES (5, 'sys/role');
INSERT INTO `sys_resource_urls` VALUES (12, 'get/uaa/sys/resource/**');
INSERT INTO `sys_resource_urls` VALUES (12, 'sys/menu');
INSERT INTO `sys_resource_urls` VALUES (13, 'platform/company');
INSERT INTO `sys_resource_urls` VALUES (13, 'get/uaa/sys/organization/**');
INSERT INTO `sys_resource_urls` VALUES (144, 'post/uaa/sys/role/**');
INSERT INTO `sys_resource_urls` VALUES (143, 'put/uaa/sys/role/**');
INSERT INTO `sys_resource_urls` VALUES (183, '');
INSERT INTO `sys_resource_urls` VALUES (184, '');
INSERT INTO `sys_resource_urls` VALUES (37, 'vv');
INSERT INTO `sys_resource_urls` VALUES (89, '');
INSERT INTO `sys_resource_urls` VALUES (8, '');
COMMIT;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL,
  `create_time` datetime NOT NULL,
  `is_delete` bit(1) NOT NULL DEFAULT b'0',
  `operator` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `name` varchar(20) NOT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `status` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_role` VALUES (14, '2020-12-29 14:30:03', b'0', 'admin', '2021-02-22 17:24:53', '超级管理员', NULL, 1);
INSERT INTO `sys_role` VALUES (15, '2020-12-29 14:30:03', b'0', 'admin', '2021-02-22 17:25:04', '昆明中西科技角色', NULL, 1);
INSERT INTO `sys_role` VALUES (16, '2020-12-29 14:30:03', b'0', 'admin', '2021-02-22 17:25:12', '昆明亿玺科技角色', NULL, 1);
INSERT INTO `sys_role` VALUES (35, '2020-12-30 14:15:24', b'0', 'admin', '2020-12-30 14:15:24', '测试', '啊啊啊', 0);
INSERT INTO `sys_role` VALUES (158, '2021-02-22 16:47:24', b'0', 'user1', '2021-02-22 16:47:24', '11', '11', 0);
INSERT INTO `sys_role` VALUES (162, '2021-02-22 17:05:50', b'0', 'admin', '2021-02-22 17:25:23', '222', '22222', 0);
COMMIT;

-- ----------------------------
-- Table structure for sys_role_admin
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_admin`;
CREATE TABLE `sys_role_admin` (
  `id` bigint(20) NOT NULL,
  `admin_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `FKrus3s7vn1ku9y9mlqbb63p5yc` (`admin_id`) USING BTREE,
  KEY `FKdukaeqnlwbx0n0bmnt0tqgfl8` (`role_id`) USING BTREE,
  CONSTRAINT `FKdukaeqnlwbx0n0bmnt0tqgfl8` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`),
  CONSTRAINT `FKrus3s7vn1ku9y9mlqbb63p5yc` FOREIGN KEY (`admin_id`) REFERENCES `sys_admin` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_admin
-- ----------------------------
BEGIN;
INSERT INTO `sys_role_admin` VALUES (32, 18, 14);
INSERT INTO `sys_role_admin` VALUES (34, 24, 16);
INSERT INTO `sys_role_admin` VALUES (51, 25, 35);
INSERT INTO `sys_role_admin` VALUES (52, 25, 35);
INSERT INTO `sys_role_admin` VALUES (142, 21, 15);
COMMIT;

-- ----------------------------
-- Table structure for sys_role_organization
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_organization`;
CREATE TABLE `sys_role_organization` (
  `id` bigint(20) NOT NULL,
  `organization_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `FK9q7lk50yfri5ckyffxiedatwe` (`organization_id`) USING BTREE,
  KEY `FKgicqkyqikjg47w2oa51xm1osb` (`role_id`) USING BTREE,
  CONSTRAINT `FK9q7lk50yfri5ckyffxiedatwe` FOREIGN KEY (`organization_id`) REFERENCES `sys_organization` (`id`),
  CONSTRAINT `FKgicqkyqikjg47w2oa51xm1osb` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_organization
-- ----------------------------
BEGIN;
INSERT INTO `sys_role_organization` VALUES (19, 17, 14);
INSERT INTO `sys_role_organization` VALUES (22, 20, 15);
INSERT INTO `sys_role_organization` VALUES (25, 23, 16);
INSERT INTO `sys_role_organization` VALUES (36, 17, 35);
INSERT INTO `sys_role_organization` VALUES (159, 20, 158);
INSERT INTO `sys_role_organization` VALUES (163, 17, 162);
COMMIT;

-- ----------------------------
-- Table structure for sys_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_resource`;
CREATE TABLE `sys_role_resource` (
  `id` bigint(20) NOT NULL,
  `create_time` datetime NOT NULL,
  `is_delete` bit(1) NOT NULL DEFAULT b'0',
  `operator` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `resource_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  `status` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `FKkj7e3cva1e2s3nsd0yghpbsnk` (`resource_id`) USING BTREE,
  KEY `FK7urjh5xeujvp29nihwbs5b9kr` (`role_id`) USING BTREE,
  CONSTRAINT `FK7urjh5xeujvp29nihwbs5b9kr` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`),
  CONSTRAINT `FKkj7e3cva1e2s3nsd0yghpbsnk` FOREIGN KEY (`resource_id`) REFERENCES `sys_resource` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_resource
-- ----------------------------
BEGIN;
INSERT INTO `sys_role_resource` VALUES (44, '2020-12-30 14:18:32', b'0', 'admin', '2020-12-30 14:18:32', 2, 35, 0);
INSERT INTO `sys_role_resource` VALUES (45, '2020-12-30 14:18:32', b'0', 'admin', '2020-12-30 14:18:32', 3, 35, 0);
INSERT INTO `sys_role_resource` VALUES (46, '2020-12-30 14:18:32', b'0', 'admin', '2020-12-30 14:18:32', 4, 35, 0);
INSERT INTO `sys_role_resource` VALUES (47, '2020-12-30 14:18:32', b'0', 'admin', '2020-12-30 14:18:32', 5, 35, 0);
INSERT INTO `sys_role_resource` VALUES (48, '2020-12-30 14:18:32', b'0', 'admin', '2020-12-30 14:18:32', 12, 35, 0);
INSERT INTO `sys_role_resource` VALUES (49, '2020-12-30 14:18:32', b'0', 'admin', '2020-12-30 14:18:32', 13, 35, 0);
INSERT INTO `sys_role_resource` VALUES (166, '2021-02-22 17:21:37', b'0', 'user1', '2021-02-22 17:21:37', 114, 158, 0);
INSERT INTO `sys_role_resource` VALUES (167, '2021-02-22 17:21:37', b'0', 'user1', '2021-02-22 17:21:37', 115, 158, 0);
INSERT INTO `sys_role_resource` VALUES (168, '2021-02-22 17:25:01', b'0', 'admin', '2021-02-22 17:25:01', 2, 15, 0);
INSERT INTO `sys_role_resource` VALUES (169, '2021-02-22 17:25:02', b'0', 'admin', '2021-02-22 17:25:02', 3, 15, 0);
INSERT INTO `sys_role_resource` VALUES (170, '2021-02-22 17:25:02', b'0', 'admin', '2021-02-22 17:25:02', 4, 15, 0);
INSERT INTO `sys_role_resource` VALUES (171, '2021-02-22 17:25:02', b'0', 'admin', '2021-02-22 17:25:02', 5, 15, 0);
INSERT INTO `sys_role_resource` VALUES (172, '2021-02-22 17:25:02', b'0', 'admin', '2021-02-22 17:25:02', 6, 15, 0);
INSERT INTO `sys_role_resource` VALUES (173, '2021-02-22 17:25:02', b'0', 'admin', '2021-02-22 17:25:02', 7, 15, 0);
INSERT INTO `sys_role_resource` VALUES (174, '2021-02-22 17:25:03', b'0', 'admin', '2021-02-22 17:25:03', 8, 15, 0);
INSERT INTO `sys_role_resource` VALUES (175, '2021-02-22 17:25:03', b'0', 'admin', '2021-02-22 17:25:03', 9, 15, 0);
INSERT INTO `sys_role_resource` VALUES (176, '2021-02-22 17:25:03', b'0', 'admin', '2021-02-22 17:25:03', 12, 15, 0);
INSERT INTO `sys_role_resource` VALUES (177, '2021-02-22 17:25:03', b'0', 'admin', '2021-02-22 17:25:03', 143, 15, 0);
INSERT INTO `sys_role_resource` VALUES (178, '2021-02-22 17:25:03', b'0', 'admin', '2021-02-22 17:25:03', 144, 15, 0);
INSERT INTO `sys_role_resource` VALUES (179, '2021-02-22 17:25:03', b'0', 'admin', '2021-02-22 17:25:03', 114, 15, 0);
INSERT INTO `sys_role_resource` VALUES (180, '2021-02-22 17:25:04', b'0', 'admin', '2021-02-22 17:25:04', 115, 15, 0);
COMMIT;

-- ----------------------------
-- Table structure for user_company_personal
-- ----------------------------
DROP TABLE IF EXISTS `user_company_personal`;
CREATE TABLE `user_company_personal` (
  `user_id` varchar(40) NOT NULL COMMENT '用户ID',
  `username` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `time_of_entry` varchar(255) DEFAULT NULL,
  `department_name` varchar(255) DEFAULT NULL,
  `company_id` varchar(255) NOT NULL COMMENT '公司ID',
  `sex` varchar(255) DEFAULT NULL COMMENT '性别',
  `date_of_birth` varchar(255) DEFAULT NULL COMMENT '出生日期',
  `the_highest_degree_of_education` varchar(255) DEFAULT NULL COMMENT '最高学历',
  `national_area` varchar(255) DEFAULT NULL COMMENT '国家地区',
  `passport_no` varchar(255) DEFAULT NULL COMMENT '护照号',
  `id_number` varchar(255) DEFAULT NULL COMMENT '身份证号',
  `id_card_photo_positive` varchar(255) DEFAULT NULL COMMENT '身份证照片-正面',
  `id_card_photo_back` varchar(255) DEFAULT NULL COMMENT '身份证照片-背面',
  `native_place` varchar(255) DEFAULT NULL COMMENT '籍贯',
  `nation` varchar(255) DEFAULT NULL COMMENT '民族',
  `english_name` varchar(255) DEFAULT NULL COMMENT '英文名',
  `marital_status` varchar(255) DEFAULT NULL COMMENT '婚姻状况',
  `staff_photo` varchar(255) DEFAULT NULL COMMENT '员工照片',
  `birthday` varchar(255) DEFAULT NULL COMMENT '生日',
  `zodiac` varchar(255) DEFAULT NULL COMMENT '属相',
  `age` varchar(255) DEFAULT NULL COMMENT '年龄',
  `constellation` varchar(255) DEFAULT NULL COMMENT '星座',
  `blood_type` varchar(255) DEFAULT NULL COMMENT '血型',
  `domicile` varchar(255) DEFAULT NULL COMMENT '户籍所在地',
  `political_outlook` varchar(255) DEFAULT NULL COMMENT '政治面貌',
  `time_to_join_the_party` varchar(255) DEFAULT NULL COMMENT '入党时间',
  `archiving_organization` varchar(255) DEFAULT NULL COMMENT '存档机构',
  `state_of_children` varchar(255) DEFAULT NULL COMMENT '子女状态',
  `do_children_have_commercial_insurance` varchar(255) DEFAULT NULL COMMENT '子女有无商业保险',
  `is_there_any_violation_of_law_or_discipline` varchar(255) DEFAULT NULL COMMENT '有无违法违纪行为',
  `are_there_any_major_medical_histories` varchar(255) DEFAULT NULL COMMENT '有无重大病史',
  `qq` varchar(255) DEFAULT NULL COMMENT 'QQ',
  `wechat` varchar(255) DEFAULT NULL COMMENT '微信',
  `residence_card_city` varchar(255) DEFAULT NULL COMMENT '居住证城市',
  `date_of_residence_permit` varchar(255) DEFAULT NULL COMMENT '居住证办理日期',
  `residence_permit_deadline` varchar(255) DEFAULT NULL COMMENT '居住证截止日期',
  `place_of_residence` varchar(255) DEFAULT NULL COMMENT '现居住地',
  `postal_address` varchar(255) DEFAULT NULL COMMENT '通讯地址',
  `contact_the_mobile_phone` varchar(255) DEFAULT NULL,
  `personal_mailbox` varchar(255) DEFAULT NULL,
  `emergency_contact` varchar(255) DEFAULT NULL COMMENT '紧急联系人',
  `emergency_contact_number` varchar(255) DEFAULT NULL COMMENT '紧急联系电话',
  `social_security_computer_number` varchar(255) DEFAULT NULL COMMENT '社保电脑号',
  `provident_fund_account` varchar(255) DEFAULT NULL COMMENT '公积金账号',
  `bank_card_number` varchar(255) DEFAULT NULL COMMENT '银行卡号',
  `opening_bank` varchar(255) DEFAULT NULL COMMENT '开户行',
  `educational_type` varchar(255) DEFAULT NULL COMMENT '学历类型',
  `graduate_school` varchar(255) DEFAULT NULL COMMENT '毕业学校',
  `enrolment_time` varchar(255) DEFAULT NULL COMMENT '入学时间',
  `graduation_time` varchar(255) DEFAULT NULL COMMENT '毕业时间',
  `major` varchar(255) DEFAULT NULL COMMENT '专业',
  `graduation_certificate` varchar(255) DEFAULT NULL COMMENT '毕业证书',
  `certificate_of_academic_degree` varchar(255) DEFAULT NULL COMMENT '学位证书',
  `home_company` varchar(255) DEFAULT NULL COMMENT '上家公司',
  `title` varchar(255) DEFAULT NULL COMMENT '职称',
  `resume` varchar(255) DEFAULT NULL COMMENT '简历',
  `is_there_any_competition_restriction` varchar(255) DEFAULT NULL COMMENT '有无竞业限制',
  `proof_of_departure_of_former_company` varchar(255) DEFAULT NULL COMMENT '前公司离职证明',
  `remarks` text COMMENT '备注',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user_company_personal
-- ----------------------------
BEGIN;
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
