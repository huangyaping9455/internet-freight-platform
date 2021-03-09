/*
 Navicat Premium Data Transfer

 Source Server         : 阿里云主节点
 Source Server Type    : MySQL
 Source Server Version : 50733
 Source Host           : 120.24.43.129:3306
 Source Schema         : internet_freight

 Target Server Type    : MySQL
 Target Server Version : 50733
 File Encoding         : 65001

 Date: 09/03/2021 12:09:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for internet_actual_carrier_info
-- ----------------------------
DROP TABLE IF EXISTS `internet_actual_carrier_info`;
CREATE TABLE `internet_actual_carrier_info` (
  `id` varchar(255) NOT NULL,
  `create_time` datetime NOT NULL,
  `is_delete` bit(1) NOT NULL DEFAULT b'0',
  `operator` varchar(255) DEFAULT NULL,
  `organization_id` varchar(255) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `actual_carrier_business_license` varchar(255) DEFAULT NULL,
  `actual_carrierid` varchar(255) DEFAULT NULL,
  `actual_carrier_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of internet_actual_carrier_info
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for internet_car
-- ----------------------------
DROP TABLE IF EXISTS `internet_car`;
CREATE TABLE `internet_car` (
  `id` varchar(255) NOT NULL,
  `create_time` datetime NOT NULL,
  `is_delete` bit(1) NOT NULL DEFAULT b'0',
  `operator` varchar(255) DEFAULT NULL,
  `organization_id` varchar(255) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `gross_mass` decimal(24,2) DEFAULT NULL COMMENT '吨位',
  `issue_date` date DEFAULT NULL COMMENT '发证日期',
  `issuing_organizations` varchar(255) DEFAULT NULL COMMENT '发证机关',
  `owner` varchar(255) DEFAULT NULL COMMENT '所有人',
  `register_date` date DEFAULT NULL COMMENT '注册日期',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `road_transport_certificate_number` bigint(20) DEFAULT NULL COMMENT '道路运输证号',
  `trailer_vehicle_plate_number` varchar(255) DEFAULT NULL COMMENT '挂车牌照号',
  `use_character` varchar(255) DEFAULT NULL COMMENT '使用性质',
  `vehicle_energy_type` varchar(255) DEFAULT NULL COMMENT '车辆能源类型',
  `vehicle_number` varchar(255) DEFAULT NULL,
  `vehicle_plate_color_code` varchar(255) DEFAULT NULL COMMENT '车牌颜色代码',
  `vehicle_tonnage` decimal(24,2) DEFAULT NULL COMMENT '核定载质量',
  `vehicle_type` varchar(255) DEFAULT NULL COMMENT '车辆类型代码',
  `vin` varchar(255) DEFAULT NULL COMMENT '车辆识别代号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT=' 网络货运平台车辆基础数据';

-- ----------------------------
-- Records of internet_car
-- ----------------------------
BEGIN;
INSERT INTO `internet_car` VALUES ('1366633370362347520', '2021-03-02 14:16:01', b'0', NULL, '17', 0, '2021-03-04 09:16:51', 30.00, '2021-03-30', '云南昆明交警支队', '挂靠', '2021-03-01', '测试', 1234567890, '云A55555挂', '非营运', 'B', '云A55555', '3', 25.00, 'Q31', '123456789');
INSERT INTO `internet_car` VALUES ('1366937164061143040', '2021-03-03 10:23:11', b'0', NULL, '17', 0, '2021-03-03 10:23:11', NULL, '2021-03-30', '', '公司', '2021-03-01', '', NULL, '', '营运', 'B', '云A66666', '2', NULL, 'H10', '');
COMMIT;

-- ----------------------------
-- Table structure for internet_car_attachment_urls
-- ----------------------------
DROP TABLE IF EXISTS `internet_car_attachment_urls`;
CREATE TABLE `internet_car_attachment_urls` (
  `internet_car_id` varchar(255) NOT NULL,
  `car_attachmenturls` varchar(255) DEFAULT NULL,
  KEY `FKq9jpppg9c37bb36g9khblie2e` (`internet_car_id`),
  CONSTRAINT `FKq9jpppg9c37bb36g9khblie2e` FOREIGN KEY (`internet_car_id`) REFERENCES `internet_car` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of internet_car_attachment_urls
-- ----------------------------
BEGIN;
INSERT INTO `internet_car_attachment_urls` VALUES ('1366937164061143040', 'group1/M00/00/1B/rBsQDmA-8w2AK-9zAACZHqaZaX4.11.png');
COMMIT;

-- ----------------------------
-- Table structure for internet_car_driver
-- ----------------------------
DROP TABLE IF EXISTS `internet_car_driver`;
CREATE TABLE `internet_car_driver` (
  `car_id` varchar(255) NOT NULL,
  `driver_id` varchar(255) NOT NULL,
  PRIMARY KEY (`car_id`,`driver_id`),
  KEY `FK59y3gd23tswokxi1kn6a8qd2n` (`driver_id`),
  CONSTRAINT `FK59y3gd23tswokxi1kn6a8qd2n` FOREIGN KEY (`driver_id`) REFERENCES `internet_driver` (`id`),
  CONSTRAINT `FK5bf3wqo7dyakywmvgcidsm6jj` FOREIGN KEY (`car_id`) REFERENCES `internet_car` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of internet_car_driver
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for internet_car_goods
-- ----------------------------
DROP TABLE IF EXISTS `internet_car_goods`;
CREATE TABLE `internet_car_goods` (
  `car_id` varchar(255) NOT NULL,
  `goods_id` varchar(255) NOT NULL,
  PRIMARY KEY (`car_id`,`goods_id`),
  KEY `FKllyme7qg5kf7rtrptbuxxrw5w` (`goods_id`),
  CONSTRAINT `FK6hrx6jerjsqe63bsl9y044kqy` FOREIGN KEY (`car_id`) REFERENCES `internet_car` (`id`),
  CONSTRAINT `FKllyme7qg5kf7rtrptbuxxrw5w` FOREIGN KEY (`goods_id`) REFERENCES `internet_goods` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of internet_car_goods
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for internet_consignee_info
-- ----------------------------
DROP TABLE IF EXISTS `internet_consignee_info`;
CREATE TABLE `internet_consignee_info` (
  `id` varchar(255) NOT NULL,
  `create_time` datetime NOT NULL,
  `is_delete` bit(1) NOT NULL DEFAULT b'0',
  `operator` varchar(255) DEFAULT NULL,
  `organization_id` varchar(255) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `consignee` varchar(255) DEFAULT NULL,
  `consigneeid` varchar(255) DEFAULT NULL,
  `country_subdivision_code` varchar(255) DEFAULT NULL,
  `goods_receipt_place` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of internet_consignee_info
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for internet_consignor_info
-- ----------------------------
DROP TABLE IF EXISTS `internet_consignor_info`;
CREATE TABLE `internet_consignor_info` (
  `id` varchar(255) NOT NULL,
  `create_time` datetime NOT NULL,
  `is_delete` bit(1) NOT NULL DEFAULT b'0',
  `operator` varchar(255) DEFAULT NULL,
  `organization_id` varchar(255) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `consignorid` varchar(255) DEFAULT NULL,
  `consignor` varchar(255) DEFAULT NULL,
  `country_subdivision_code` varchar(255) DEFAULT NULL,
  `place_of_loading` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of internet_consignor_info
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for internet_driver
-- ----------------------------
DROP TABLE IF EXISTS `internet_driver`;
CREATE TABLE `internet_driver` (
  `id` varchar(255) NOT NULL,
  `create_time` datetime NOT NULL,
  `is_delete` bit(1) NOT NULL DEFAULT b'0',
  `operator` varchar(255) DEFAULT NULL,
  `organization_id` varchar(255) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `driver_license_url` varchar(255) DEFAULT NULL,
  `driver_name` varchar(255) DEFAULT NULL COMMENT '司机姓名',
  `driving_license` varchar(255) DEFAULT NULL,
  `issuing_organizations` varchar(255) DEFAULT NULL,
  `qualification_certificate` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `valid_period_from` date DEFAULT NULL,
  `valid_period_to` date DEFAULT NULL,
  `vehicle_class` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='司机表';

-- ----------------------------
-- Records of internet_driver
-- ----------------------------
BEGIN;
INSERT INTO `internet_driver` VALUES ('1366988046614175744', '2021-03-03 13:45:22', b'0', NULL, '17', 0, '2021-03-04 16:04:55', NULL, '李启云', '123456789', '云南昆明', '0871000000', '120102', '15559908866', '2021-03-02', '2024-03-29', 'A1');
INSERT INTO `internet_driver` VALUES ('1367004966293913600', '2021-03-03 14:52:36', b'0', NULL, '17', 0, '2021-03-03 14:52:36', NULL, '李启云1', '1212', '1212', '12211212', '110101', '122112121212', '2021-03-01', '2021-03-30', '2112');
INSERT INTO `internet_driver` VALUES ('1367015432902696960', '2021-03-03 15:34:12', b'0', NULL, '17', 0, '2021-03-04 16:11:59', NULL, '李启云2', '11', '11', '11', '530102', '111', '2021-03-01', '2021-03-09', '11');
COMMIT;

-- ----------------------------
-- Table structure for internet_driver_attachment_urls
-- ----------------------------
DROP TABLE IF EXISTS `internet_driver_attachment_urls`;
CREATE TABLE `internet_driver_attachment_urls` (
  `internet_driver_id` varchar(255) NOT NULL,
  `driver_attachmenturls` varchar(255) DEFAULT NULL,
  KEY `FKoxbvgbxo7jty3o7t1mxx9qfm1` (`internet_driver_id`),
  CONSTRAINT `FKoxbvgbxo7jty3o7t1mxx9qfm1` FOREIGN KEY (`internet_driver_id`) REFERENCES `internet_driver` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of internet_driver_attachment_urls
-- ----------------------------
BEGIN;
INSERT INTO `internet_driver_attachment_urls` VALUES ('1366988046614175744', 'group1/M00/00/1B/rBsQDmA_R2uAVW6OAACZHqaZaX4.11.png');
INSERT INTO `internet_driver_attachment_urls` VALUES ('1366988046614175744', 'group1/M00/00/1B/rBsQDmBANoKASx7wAFWrsqLY1PI.22.png');
COMMIT;

-- ----------------------------
-- Table structure for internet_financial
-- ----------------------------
DROP TABLE IF EXISTS `internet_financial`;
CREATE TABLE `internet_financial` (
  `id` varchar(255) NOT NULL,
  `create_time` datetime NOT NULL,
  `is_delete` bit(1) NOT NULL DEFAULT b'0',
  `operator` varchar(255) DEFAULT NULL,
  `organization_id` varchar(255) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `actual_carrier_id` varchar(255) DEFAULT NULL,
  `carrier` varchar(255) DEFAULT NULL,
  `document_number` varchar(255) DEFAULT NULL COMMENT '资金流水单号',
  `remark` varchar(255) DEFAULT NULL,
  `send_to_pro_date_time` datetime DEFAULT NULL COMMENT '资金流水单上传到省级监测系统的时间',
  `vehicle_number` varchar(255) DEFAULT NULL,
  `vehicle_plate_color_code` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资金流水表';

-- ----------------------------
-- Records of internet_financial
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for internet_financial_statement
-- ----------------------------
DROP TABLE IF EXISTS `internet_financial_statement`;
CREATE TABLE `internet_financial_statement` (
  `id` varchar(255) NOT NULL,
  `create_time` datetime NOT NULL,
  `is_delete` bit(1) NOT NULL DEFAULT b'0',
  `operator` varchar(255) DEFAULT NULL,
  `organization_id` varchar(255) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `bank_code` varchar(255) DEFAULT NULL,
  `date_time` datetime DEFAULT NULL,
  `monetary_amount` decimal(18,3) DEFAULT NULL,
  `payment_means_code` varchar(255) DEFAULT NULL,
  `receipt_account` varchar(255) DEFAULT NULL,
  `recipient` varchar(255) DEFAULT NULL,
  `sequence_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='财务报表';

-- ----------------------------
-- Records of internet_financial_statement
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for internet_goods
-- ----------------------------
DROP TABLE IF EXISTS `internet_goods`;
CREATE TABLE `internet_goods` (
  `id` varchar(255) NOT NULL,
  `create_time` datetime NOT NULL,
  `is_delete` bit(1) NOT NULL DEFAULT b'0',
  `operator` varchar(255) DEFAULT NULL,
  `organization_id` varchar(255) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `cargo_type_classification_code` varchar(255) DEFAULT NULL,
  `consignee` varchar(255) DEFAULT NULL,
  `consigneeid` varchar(255) DEFAULT NULL,
  `country_subdivision_code` varchar(255) DEFAULT NULL,
  `cube` decimal(9,4) DEFAULT NULL,
  `description_of_goods` varchar(512) DEFAULT NULL COMMENT '货物名称',
  `goods_item_gross_weight` decimal(14,3) DEFAULT NULL,
  `goods_receipt_place` varchar(255) DEFAULT NULL,
  `total_number_of_packages` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='货物信息';

-- ----------------------------
-- Records of internet_goods
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for internet_insurance
-- ----------------------------
DROP TABLE IF EXISTS `internet_insurance`;
CREATE TABLE `internet_insurance` (
  `id` varchar(255) NOT NULL,
  `create_time` datetime NOT NULL,
  `is_delete` bit(1) NOT NULL DEFAULT b'0',
  `operator` varchar(255) DEFAULT NULL,
  `organization_id` varchar(255) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `insurance_company` varchar(255) DEFAULT NULL,
  `policy_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of internet_insurance
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for internet_order_info
-- ----------------------------
DROP TABLE IF EXISTS `internet_order_info`;
CREATE TABLE `internet_order_info` (
  `id` varchar(255) NOT NULL,
  `create_time` datetime NOT NULL,
  `is_delete` bit(1) NOT NULL DEFAULT b'0',
  `operator` varchar(255) DEFAULT NULL,
  `organization_id` varchar(255) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `actual_carrier_id` varchar(255) DEFAULT NULL,
  `business_type_code` varchar(255) DEFAULT NULL,
  `carrier` varchar(255) DEFAULT NULL,
  `consignment_date_time` datetime DEFAULT NULL,
  `consignor_id` varchar(255) DEFAULT NULL,
  `despatch_actual_date_time` datetime DEFAULT NULL,
  `goods_receipt_date_time` datetime DEFAULT NULL,
  `original_document_number` varchar(255) DEFAULT NULL,
  `permit_number` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `send_to_pro_date_time` datetime DEFAULT NULL,
  `serial_number` varchar(255) DEFAULT NULL,
  `shipping_note_number` varchar(255) DEFAULT NULL,
  `total_monetary_amount` decimal(18,3) DEFAULT NULL,
  `transport_type_code` int(11) DEFAULT NULL,
  `unified_social_credit_identifier` varchar(255) DEFAULT NULL,
  `vehicle_amount` int(11) DEFAULT NULL,
  `insurance_information_id` varchar(255) DEFAULT NULL,
  `car_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1yl28ta2v71mxbhxek1ldris8` (`insurance_information_id`),
  KEY `FKli979g24pglbo3n09s78xoq67` (`car_id`),
  CONSTRAINT `FK1yl28ta2v71mxbhxek1ldris8` FOREIGN KEY (`insurance_information_id`) REFERENCES `internet_insurance` (`id`),
  CONSTRAINT `FKli979g24pglbo3n09s78xoq67` FOREIGN KEY (`car_id`) REFERENCES `internet_car` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of internet_order_info
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for tx_trans_message
-- ----------------------------
DROP TABLE IF EXISTS `tx_trans_message`;
CREATE TABLE `tx_trans_message` (
  `id` varchar(255) NOT NULL,
  `date` datetime DEFAULT NULL,
  `exchange` varchar(255) DEFAULT NULL,
  `payload` varchar(255) DEFAULT NULL,
  `queue` varchar(255) DEFAULT NULL,
  `routing_key` varchar(255) DEFAULT NULL,
  `sequence` int(11) DEFAULT NULL,
  `service` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tx_trans_message
-- ----------------------------
BEGIN;
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
