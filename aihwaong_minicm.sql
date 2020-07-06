/*
Navicat MySQL Data Transfer

Source Server         : wanpMySQL
Source Server Version : 50617
Source Host           : 127.0.0.1:3306
Source Database       : aihwaong_minicm

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2020-07-07 00:34:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cm_building_area
-- ----------------------------
DROP TABLE IF EXISTS `cm_building_area`;
CREATE TABLE `cm_building_area` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL COMMENT '父id',
  `area_name` char(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '名称',
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `is_delete` enum('1','0') COLLATE utf8mb4_bin DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='楼宇区域 | 2020年6月1日 11:07:41';

-- ----------------------------
-- Records of cm_building_area
-- ----------------------------
INSERT INTO `cm_building_area` VALUES ('1', '0', '一栋', '2020-03-11 10:04:29', '2020-05-10 21:33:58', '1', '0');
INSERT INTO `cm_building_area` VALUES ('2', '0', 'rwasdas', '2020-03-11 10:10:29', null, '1', '1');
INSERT INTO `cm_building_area` VALUES ('3', '0', '二栋', '2020-03-11 12:08:31', null, '1', '0');
INSERT INTO `cm_building_area` VALUES ('4', '1', '一单元', '2020-03-11 12:24:26', '2020-03-22 22:51:54', '1', '0');
INSERT INTO `cm_building_area` VALUES ('5', '1', '二单元', '2020-03-11 12:38:46', '2020-03-22 22:51:58', '1', '0');
INSERT INTO `cm_building_area` VALUES ('6', '1', '三单元', '2020-03-11 12:38:54', null, '1', '0');
INSERT INTO `cm_building_area` VALUES ('7', '3', '一单元', '2020-03-11 12:39:04', null, '1', '0');
INSERT INTO `cm_building_area` VALUES ('8', '3', '二单元', '2020-03-11 12:39:09', null, '1', '0');
INSERT INTO `cm_building_area` VALUES ('9', '3', '三单元', '2020-03-11 12:39:17', null, '1', '0');
INSERT INTO `cm_building_area` VALUES ('10', '0', '三栋', '2020-05-10 21:33:50', null, '1', '1');
INSERT INTO `cm_building_area` VALUES ('11', '0', '三栋', '2020-05-10 21:52:18', null, '1', '0');
INSERT INTO `cm_building_area` VALUES ('12', '11', '一单元', '2020-05-10 21:52:44', null, '1', '0');
INSERT INTO `cm_building_area` VALUES ('13', '0', '四栋', '2020-05-10 21:58:39', null, '1', '0');
INSERT INTO `cm_building_area` VALUES ('30', '0', '五栋', '2020-06-27 20:03:22', null, '1', '0');
INSERT INTO `cm_building_area` VALUES ('31', '13', '一单元', '2020-06-27 20:10:41', null, '1', '0');
INSERT INTO `cm_building_area` VALUES ('32', '13', '二单元', '2020-06-27 20:10:47', null, '1', '0');
INSERT INTO `cm_building_area` VALUES ('33', '30', '一单元', '2020-06-27 20:11:10', null, '1', '0');
INSERT INTO `cm_building_area` VALUES ('34', '30', '二单元', '2020-06-27 20:11:13', null, '1', '0');

-- ----------------------------
-- Table structure for cm_chamber
-- ----------------------------
DROP TABLE IF EXISTS `cm_chamber`;
CREATE TABLE `cm_chamber` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `chamber_name` char(10) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` tinyint(4) DEFAULT NULL,
  `is_delete` enum('1','0') COLLATE utf8mb4_bin DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='房型室 | 2020年6月1日 11:25:32';

-- ----------------------------
-- Records of cm_chamber
-- ----------------------------
INSERT INTO `cm_chamber` VALUES ('1', '一室', '2020-06-27 17:15:20', null, '1', '0');
INSERT INTO `cm_chamber` VALUES ('5', '两室', '2020-06-27 20:00:38', null, '1', '0');
INSERT INTO `cm_chamber` VALUES ('6', '三室', '2020-06-27 20:00:43', null, '1', '0');
INSERT INTO `cm_chamber` VALUES ('7', '四室', '2020-06-27 20:00:48', null, '1', '0');

-- ----------------------------
-- Table structure for cm_hall
-- ----------------------------
DROP TABLE IF EXISTS `cm_hall`;
CREATE TABLE `cm_hall` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hall_name` char(10) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` tinyint(4) DEFAULT NULL,
  `is_delete` enum('1','0') COLLATE utf8mb4_bin DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='房型厅 | 2020年6月1日 11:25:32';

-- ----------------------------
-- Records of cm_hall
-- ----------------------------
INSERT INTO `cm_hall` VALUES ('4', '一厅', '2020-06-27 17:34:31', null, '1', '0');
INSERT INTO `cm_hall` VALUES ('5', '两厅', '2020-06-27 20:00:57', null, '1', '0');
INSERT INTO `cm_hall` VALUES ('6', '三厅', '2020-06-27 20:01:03', null, '1', '0');
INSERT INTO `cm_hall` VALUES ('7', '四厅', '2020-06-27 20:01:18', null, '1', '0');

-- ----------------------------
-- Table structure for cm_household_account
-- ----------------------------
DROP TABLE IF EXISTS `cm_household_account`;
CREATE TABLE `cm_household_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `household_info_id` int(11) DEFAULT NULL COMMENT '住户信息id',
  `status` tinyint(4) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `is_delete` enum('1','0') COLLATE utf8mb4_bin DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='住户账号 | 2020年6月1日 14:54:07';

-- ----------------------------
-- Records of cm_household_account
-- ----------------------------
INSERT INTO `cm_household_account` VALUES ('2', '18277155605', '$2a$10$3NFAtaLPrADR6rPosQBcIe/5Q11d8AwCRTlTzbah4yxOXayH91JxO', '1', null, '2020-06-28 21:23:45', null, '0');
INSERT INTO `cm_household_account` VALUES ('3', '18277155605', '$2a$10$QKYoNlC2I.XM0JxEjbNphO/XlfLsKgzlGFk6Z86lgRe98gq6qEklS', '1', null, '2020-06-30 09:36:27', null, '0');
INSERT INTO `cm_household_account` VALUES ('4', '18277155605', '$2a$10$96C3k7Ggf5bSeuGXhoQTuOyoAft2t/PNx6hgv1W5tyWqJfWWfQvqe', '1', null, '2020-06-30 09:36:57', null, '0');

-- ----------------------------
-- Table structure for cm_household_info
-- ----------------------------
DROP TABLE IF EXISTS `cm_household_info`;
CREATE TABLE `cm_household_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `real_name` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '真实姓名',
  `sex` enum('2','1') COLLATE utf8mb4_bin DEFAULT '1' COMMENT '性别 ： 1 男  |  2 女',
  `age` char(3) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '年龄',
  `native_place` char(10) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '籍贯',
  `identity_document` char(19) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '身份证',
  `telephone` char(11) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '联系电话',
  `nation` tinyint(2) DEFAULT NULL COMMENT '民族',
  `remark` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `is_delete` enum('1','0') COLLATE utf8mb4_bin DEFAULT '0' COMMENT '逻辑删除 ： 0 否  |  1 是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='住户信息 | 2020年6月1日 14:44:21';

-- ----------------------------
-- Records of cm_household_info
-- ----------------------------
INSERT INTO `cm_household_info` VALUES ('2', '业主1', '1', '23', '广东深圳', '442111199609101215', '18277155605', '1', null, '1', '2020-06-28 20:01:31', '2020-07-06 22:24:36', '0');
INSERT INTO `cm_household_info` VALUES ('3', '业主2', '1', '23', '北京', '442111199609101215', '18277155605', '2', null, '1', '2020-06-28 20:15:42', '2020-07-06 22:24:45', '0');
INSERT INTO `cm_household_info` VALUES ('4', '业主3', '1', '23', '上海', '442111199609221215', '18277155605', '3', null, '1', '2020-06-28 20:15:56', '2020-07-06 22:24:55', '0');
INSERT INTO `cm_household_info` VALUES ('7', '业主4', '2', '31', '山西运城', '442111198809221215', '18277155605', '1', null, '1', '2020-06-28 21:23:45', '2020-07-06 22:25:47', '0');
INSERT INTO `cm_household_info` VALUES ('8', '业主5', '2', '42', '浙江温州', '442111197709221215', '18277155605', '1', null, '1', '2020-06-30 09:36:27', '2020-07-06 22:26:08', '0');
INSERT INTO `cm_household_info` VALUES ('9', '业主6', '1', '53', '天津', '442111196609221215', '18277155605', '1', null, '1', '2020-06-30 09:36:57', '2020-07-06 22:27:05', '0');

-- ----------------------------
-- Table structure for cm_house_hold
-- ----------------------------
DROP TABLE IF EXISTS `cm_house_hold`;
CREATE TABLE `cm_house_hold` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `household_id` int(11) DEFAULT NULL COMMENT '业主id',
  `house_id` int(11) DEFAULT NULL COMMENT '房屋id',
  `status` tinyint(1) DEFAULT '1',
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `is_delete` enum('1','0') COLLATE utf8mb4_bin DEFAULT '0' COMMENT '逻辑删除 ： 0 否  |  1 是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='房屋关联业主 | 2020年6月1日 21:08:36';

-- ----------------------------
-- Records of cm_house_hold
-- ----------------------------
INSERT INTO `cm_house_hold` VALUES ('1', '2', '2', '1', '2020-06-29 10:40:29', null, '0');
INSERT INTO `cm_house_hold` VALUES ('5', '2', '4', '1', '2020-06-29 14:42:18', null, '0');
INSERT INTO `cm_house_hold` VALUES ('6', '2', '1', '1', '2020-06-29 14:42:34', null, '0');

-- ----------------------------
-- Table structure for cm_menu
-- ----------------------------
DROP TABLE IF EXISTS `cm_menu`;
CREATE TABLE `cm_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(64) DEFAULT NULL COMMENT '服务端路由',
  `path` varchar(64) DEFAULT NULL COMMENT '客户端路由',
  `component` varchar(64) DEFAULT NULL COMMENT '组件名称',
  `name` varchar(64) DEFAULT NULL COMMENT '菜单名称',
  `iconCls` varchar(64) DEFAULT NULL,
  `keepAlive` tinyint(1) DEFAULT NULL,
  `requireAuth` tinyint(1) DEFAULT NULL,
  `parentId` int(11) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT '1',
  `sort` int(3) DEFAULT '1' COMMENT '排序',
  `status` tinyint(4) DEFAULT NULL COMMENT '1',
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `is_delete` enum('1','0') CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `parentId` (`parentId`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8 COMMENT='菜单 | 2020年6月1日 16:27:49';

-- ----------------------------
-- Records of cm_menu
-- ----------------------------
INSERT INTO `cm_menu` VALUES ('1', '/', null, null, '所有', null, null, null, '0', '1', null, null, null, null, '0');
INSERT INTO `cm_menu` VALUES ('2', '/', '/index', 'index', '系统管理', null, null, '1', '1', '0', '1', null, null, null, '0');
INSERT INTO `cm_menu` VALUES ('3', '/', '/index', 'index', '楼宇管理', null, null, '1', '1', '1', '2', null, null, null, '0');
INSERT INTO `cm_menu` VALUES ('4', '/', '/index', 'index', '住户管理', null, null, '1', '1', '1', '3', null, null, null, '0');
INSERT INTO `cm_menu` VALUES ('5', '/', '/index', 'index', '车位管理', null, null, '1', '1', '1', '4', null, null, null, '0');
INSERT INTO `cm_menu` VALUES ('6', '/', '/index', 'index', '报修管理', null, null, '1', '1', '1', '5', null, null, null, '0');
INSERT INTO `cm_menu` VALUES ('10', '/system/base/**', '/system/base', 'systemBase', '基础信息', null, null, '1', '2', '1', '1', null, null, null, '0');
INSERT INTO `cm_menu` VALUES ('11', '/system/authority/**', '/system/authority', 'systemAuthority', '权限管理', null, null, '1', '2', '1', '1', null, '2020-06-22 20:44:23', '2020-06-22 20:44:57', '0');
INSERT INTO `cm_menu` VALUES ('29', '/system/menu/*', '/system/menu', 'systemMenu', '菜单管理', null, null, '1', '2', '1', '1', null, null, null, '0');
INSERT INTO `cm_menu` VALUES ('35', '/', '/index', 'index', '访客管理', null, null, '1', '1', '1', '6', null, '2020-06-25 15:15:16', null, '0');
INSERT INTO `cm_menu` VALUES ('36', '/', '/index', 'index', '通知管理', null, null, '1', '1', '1', '7', null, '2020-06-25 15:16:33', null, '0');
INSERT INTO `cm_menu` VALUES ('37', '/', '/index', 'index', '社区统计', null, null, '1', '1', '1', '8', null, '2020-06-25 15:16:50', null, '0');
INSERT INTO `cm_menu` VALUES ('38', '/house/**', '/house', 'house', '房屋管理', null, null, '1', '3', '1', '1', null, '2020-06-26 10:14:08', null, '0');
INSERT INTO `cm_menu` VALUES ('39', '/household/**', '/household', 'household', '住户信息', null, null, '1', '4', '1', '1', null, '2020-06-26 10:15:30', null, '0');
INSERT INTO `cm_menu` VALUES ('40', '/vehicle/**', '/car/vehicle', 'carVehicle', '车辆信息', null, null, '1', '5', '1', '1', null, '2020-06-26 10:40:24', null, '0');
INSERT INTO `cm_menu` VALUES ('41', '/parking/**', '/car/parkingLot', 'carParkingLot', '车位信息', null, null, '1', '5', '1', '1', null, '2020-06-26 10:41:48', null, '0');
INSERT INTO `cm_menu` VALUES ('42', '/repair/**', '/repair', 'repair', '报修管理', null, null, '1', '6', '1', '1', null, '2020-06-26 10:45:12', null, '0');
INSERT INTO `cm_menu` VALUES ('43', '/visitor/*', '/visitor', 'visitor', '访客登记', null, null, '1', '35', '1', '1', null, '2020-06-26 10:46:00', null, '0');
INSERT INTO `cm_menu` VALUES ('44', '/notice/*', '/notice', 'notice', '通知发布', null, null, '1', '36', '1', '1', null, '2020-06-26 10:46:34', null, '0');

-- ----------------------------
-- Table structure for cm_menu_role
-- ----------------------------
DROP TABLE IF EXISTS `cm_menu_role`;
CREATE TABLE `cm_menu_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mid` int(11) DEFAULT NULL COMMENT '菜单id',
  `rid` int(11) DEFAULT NULL COMMENT '角色id',
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `is_delete` enum('1','0') CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `mid` (`mid`),
  KEY `rid` (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=utf8 COMMENT='角色关联菜单 | 2020年6月1日 16:29:03';

-- ----------------------------
-- Records of cm_menu_role
-- ----------------------------
INSERT INTO `cm_menu_role` VALUES ('73', '38', '1', '2020-07-04 23:48:47', null, null, '0');
INSERT INTO `cm_menu_role` VALUES ('74', '39', '1', '2020-07-04 23:48:47', null, null, '0');
INSERT INTO `cm_menu_role` VALUES ('75', '40', '1', '2020-07-04 23:48:47', null, null, '0');
INSERT INTO `cm_menu_role` VALUES ('76', '41', '1', '2020-07-04 23:48:47', null, null, '0');
INSERT INTO `cm_menu_role` VALUES ('77', '42', '1', '2020-07-04 23:48:47', null, null, '0');
INSERT INTO `cm_menu_role` VALUES ('78', '43', '1', '2020-07-04 23:48:47', null, null, '0');
INSERT INTO `cm_menu_role` VALUES ('79', '44', '1', '2020-07-04 23:48:47', null, null, '0');
INSERT INTO `cm_menu_role` VALUES ('82', '10', '3', '2020-07-06 16:29:36', null, null, '0');
INSERT INTO `cm_menu_role` VALUES ('83', '11', '3', '2020-07-06 16:29:36', null, null, '0');
INSERT INTO `cm_menu_role` VALUES ('84', '29', '3', '2020-07-06 16:29:36', null, null, '0');
INSERT INTO `cm_menu_role` VALUES ('85', '38', '3', '2020-07-06 16:29:36', null, null, '0');
INSERT INTO `cm_menu_role` VALUES ('86', '39', '3', '2020-07-06 16:29:36', null, null, '0');
INSERT INTO `cm_menu_role` VALUES ('87', '40', '3', '2020-07-06 16:29:36', null, null, '0');
INSERT INTO `cm_menu_role` VALUES ('88', '41', '3', '2020-07-06 16:29:36', null, null, '0');
INSERT INTO `cm_menu_role` VALUES ('89', '42', '3', '2020-07-06 16:29:36', null, null, '0');
INSERT INTO `cm_menu_role` VALUES ('90', '43', '3', '2020-07-06 16:29:36', null, null, '0');
INSERT INTO `cm_menu_role` VALUES ('91', '44', '3', '2020-07-06 16:29:36', null, null, '0');

-- ----------------------------
-- Table structure for cm_nation
-- ----------------------------
DROP TABLE IF EXISTS `cm_nation`;
CREATE TABLE `cm_nation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8 COMMENT='民族 | 2020年6月1日 15:59:29';

-- ----------------------------
-- Records of cm_nation
-- ----------------------------
INSERT INTO `cm_nation` VALUES ('1', '汉族');
INSERT INTO `cm_nation` VALUES ('2', '蒙古族');
INSERT INTO `cm_nation` VALUES ('3', '回族');
INSERT INTO `cm_nation` VALUES ('4', '藏族');
INSERT INTO `cm_nation` VALUES ('5', '维吾尔族');
INSERT INTO `cm_nation` VALUES ('6', '苗族');
INSERT INTO `cm_nation` VALUES ('7', '彝族');
INSERT INTO `cm_nation` VALUES ('8', '壮族');
INSERT INTO `cm_nation` VALUES ('9', '布依族');
INSERT INTO `cm_nation` VALUES ('10', '朝鲜族');
INSERT INTO `cm_nation` VALUES ('11', '满族');
INSERT INTO `cm_nation` VALUES ('12', '侗族');
INSERT INTO `cm_nation` VALUES ('13', '瑶族');
INSERT INTO `cm_nation` VALUES ('14', '白族');
INSERT INTO `cm_nation` VALUES ('15', '土家族');
INSERT INTO `cm_nation` VALUES ('16', '哈尼族');
INSERT INTO `cm_nation` VALUES ('17', '哈萨克族');
INSERT INTO `cm_nation` VALUES ('18', '傣族');
INSERT INTO `cm_nation` VALUES ('19', '黎族');
INSERT INTO `cm_nation` VALUES ('20', '傈僳族');
INSERT INTO `cm_nation` VALUES ('21', '佤族');
INSERT INTO `cm_nation` VALUES ('22', '畲族');
INSERT INTO `cm_nation` VALUES ('23', '高山族');
INSERT INTO `cm_nation` VALUES ('24', '拉祜族');
INSERT INTO `cm_nation` VALUES ('25', '水族');
INSERT INTO `cm_nation` VALUES ('26', '东乡族');
INSERT INTO `cm_nation` VALUES ('27', '纳西族');
INSERT INTO `cm_nation` VALUES ('28', '景颇族');
INSERT INTO `cm_nation` VALUES ('29', '柯尔克孜族');
INSERT INTO `cm_nation` VALUES ('30', '土族');
INSERT INTO `cm_nation` VALUES ('31', '达斡尔族');
INSERT INTO `cm_nation` VALUES ('32', '仫佬族');
INSERT INTO `cm_nation` VALUES ('33', '羌族');
INSERT INTO `cm_nation` VALUES ('34', '布朗族');
INSERT INTO `cm_nation` VALUES ('35', '撒拉族');
INSERT INTO `cm_nation` VALUES ('36', '毛难族');
INSERT INTO `cm_nation` VALUES ('37', '仡佬族');
INSERT INTO `cm_nation` VALUES ('38', '锡伯族');
INSERT INTO `cm_nation` VALUES ('39', '阿昌族');
INSERT INTO `cm_nation` VALUES ('40', '普米族');
INSERT INTO `cm_nation` VALUES ('41', '塔吉克族');
INSERT INTO `cm_nation` VALUES ('42', '怒族');
INSERT INTO `cm_nation` VALUES ('43', '乌孜别克族');
INSERT INTO `cm_nation` VALUES ('44', '俄罗斯族');
INSERT INTO `cm_nation` VALUES ('45', '鄂温克族');
INSERT INTO `cm_nation` VALUES ('46', '崩龙族');
INSERT INTO `cm_nation` VALUES ('47', '保安族');
INSERT INTO `cm_nation` VALUES ('48', '裕固族');
INSERT INTO `cm_nation` VALUES ('49', '京族');
INSERT INTO `cm_nation` VALUES ('50', '塔塔尔族');
INSERT INTO `cm_nation` VALUES ('51', '独龙族');
INSERT INTO `cm_nation` VALUES ('52', '鄂伦春族');
INSERT INTO `cm_nation` VALUES ('53', '赫哲族');
INSERT INTO `cm_nation` VALUES ('54', '门巴族');
INSERT INTO `cm_nation` VALUES ('55', '珞巴族');
INSERT INTO `cm_nation` VALUES ('56', '基诺族');

-- ----------------------------
-- Table structure for cm_notice
-- ----------------------------
DROP TABLE IF EXISTS `cm_notice`;
CREATE TABLE `cm_notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_id` int(11) DEFAULT NULL COMMENT '通知类型',
  `title` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '标题',
  `editor` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '编辑',
  `description` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '描述',
  `content` longtext COLLATE utf8mb4_bin COMMENT '内容',
  `status` tinyint(4) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `is_delete` enum('1','0') COLLATE utf8mb4_bin DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='通知公告 | 2020年6月1日 15:06:48';

-- ----------------------------
-- Records of cm_notice
-- ----------------------------
INSERT INTO `cm_notice` VALUES ('1', '7', '物业通知格式关于机动车停车卡使用办法的通知', '王富琳', '物业通知格式关于机动车停车卡使用办法的通知1', 0x3C683120636C6173733D22716C2D616C69676E2D63656E746572223EE9809AE79FA5E6A087E9A2983C2F68313E3C683320636C6173733D22716C2D616C69676E2D63656E746572223EE789A9E4B89AE9809AE79FA5E6A0BCE5BC8FE585B3E4BA8EE69CBAE58AA8E8BDA6E5819CE8BDA6E58DA1E4BDBFE794A8E58A9EE6B395E79A84E9809AE79FA53C2F68333E3C703E3C7374726F6E673EE5B08AE695ACE79A84E8BDA6E4B8BBE682A8E5A5BD213C2F7374726F6E673E3C2F703E3C703EE4B8BAE4BA86E883BDE5AFB9E5B08FE58CBAE58685E79A84E69CBAE58AA8E8BDA6E5AE9EE8A18CE8A784E88C83E58C96E79A84E7AEA1E790862CE68891E7AEA1E79086E5A484E68F90E98692E59084E4BD8DE8BDA6E4B8BB3AE5A682E69E9CE682A8E58A9EE4BA86E69C88E7A79F2CE982A3E682A8E6898BE4B8ADE79A84E69C88E58DA1E5B0B1E698AFE587ADE8AF812CE8AFB7E59CA8E8BF9BE587BAE5A4A7E997A8E697B6E58099E4B880E5AE9AE8A681E4BAA4E7BB99E68AA4E58DABE69FA5E9AA8CE38082E5A682E4B88DE883BDE587BAE7A4BAE69C88E58DA12CE982A3E58FAAE883BDE8A786E4B8BAE4B8B4E5819CE694B6E8B4B9E38082E5908CE697B62CE5A682E69E9CE682A8E79A84E69C88E7A79FE588B0E69C9FE4BA862CE8AFB7E58F8AE697B6E588B0E7AEA1E79086E5A484E58A9EE79086E6898BE7BBAD2CE980BEE69C9FE69CAAE58A9EE79086E6898BE7BBADE79A84E8BDA6E8BE862CE5BD93E682A8E8BF9BE587BAE5B08FE58CBAE697B6E68891E4BBACE5B086E68C89E4B8B4E5819CE694B6E8B4B9E38082E68AA4E58DABE59CA8E682A8E8BF9BE5B08FE58CBAE697B6E5B086E7BB99E682A8E5BC80E585B7E8BF9BE587BAE587ADE69DA12CE6ADA4E69DA1E698AFE682A8E8BDA6E8BE86E8BF9BE587BAE5B08FE58CBAE79A84E9878DE8A681E587ADE8AF812CE59BA0E6ADA4E8AFB7E8BDA6E4B8BBE4BF9DE7AEA1E5A5BDE8AFA5E587ADE69DA1E38082E5A682E69E9CE682A8E4B88DE5B08FE5BF83E98197E5A4B1E4BA862CE4B8BAE4BA86E682A8E79A84E8BDA6E8BE86E5AE89E585A8E8AFB7E58F8AE697B6E9809AE79FA5E7AEA1E79086E5A4842CE5B9B6E588B0E7AEA1E79086E5A484E58A9EE79086E98197E5A4B1E6898BE7BBADE38082E68891E7AEA1E79086E5A484E5B086E4B8A5E6A0BCE68C89E785A7E6ADA4E8A784E5AE9AE6A380E69FA5E69C88E58DA1E5928CE587ADE69DA1E794B1E6ADA4E7BB99E682A8E5B8A6E69DA5E79A84E4B88DE4BEBF2CE6B7B1E8A1A8E6AD89E6848F2CE8B0A2E8B0A2E682A8E79A84E59088E4BD9CE380823C2F703E3C703EE789B9E6ADA4E9809AE79FA53C2F703E3C703EE7A4BEE58CBAE7AEA1E79086E5A4843C2F703E3C7020636C6173733D22716C2D616C69676E2D7269676874223E32303230E5B9B436E69C883136E697A53C2F703E, '1', '2020-07-01 15:13:56', null, '0');

-- ----------------------------
-- Table structure for cm_notice_type
-- ----------------------------
DROP TABLE IF EXISTS `cm_notice_type`;
CREATE TABLE `cm_notice_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(10) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `is_delete` enum('1','0') COLLATE utf8mb4_bin DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='通知公告类型 | 2020年6月1日 15:09:25';

-- ----------------------------
-- Records of cm_notice_type
-- ----------------------------
INSERT INTO `cm_notice_type` VALUES ('6', '紧急通知', '2020-06-27 19:59:35', null, '1', '0');
INSERT INTO `cm_notice_type` VALUES ('7', '施工通知', '2020-06-27 20:00:23', null, '1', '0');

-- ----------------------------
-- Table structure for cm_parking_area
-- ----------------------------
DROP TABLE IF EXISTS `cm_parking_area`;
CREATE TABLE `cm_parking_area` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `area_name` char(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '停车场名称',
  `remark` char(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `is_delete` enum('1','0') COLLATE utf8mb4_bin DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='停车场区域 | 2020年6月1日 11:29:07';

-- ----------------------------
-- Records of cm_parking_area
-- ----------------------------
INSERT INTO `cm_parking_area` VALUES ('2', '地上B区', '阿斯达岁的', '2020-03-13 09:30:20', null, '1', '1');
INSERT INTO `cm_parking_area` VALUES ('4', '阿萨德', '阿萨德', '2020-04-25 21:20:30', null, '1', '1');
INSERT INTO `cm_parking_area` VALUES ('11', 'A区停车场', 'A区', '2020-06-27 20:02:25', null, '1', '0');
INSERT INTO `cm_parking_area` VALUES ('12', 'B区停车场', 'B区', '2020-06-27 20:02:35', null, '1', '0');
INSERT INTO `cm_parking_area` VALUES ('13', 'C区停车场', 'C区', '2020-06-27 20:03:02', null, '1', '0');

-- ----------------------------
-- Table structure for cm_parking_lot
-- ----------------------------
DROP TABLE IF EXISTS `cm_parking_lot`;
CREATE TABLE `cm_parking_lot` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` char(30) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '车位编号',
  `parking_area_id` int(11) DEFAULT NULL COMMENT '停车场区域',
  `measure` decimal(10,0) DEFAULT NULL COMMENT '车位面积（平方米）',
  `business` tinyint(4) DEFAULT '1' COMMENT '业务状态 ： 1 空置  |  2 出租  |  3 出售',
  `status` tinyint(4) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `is_delete` enum('1','0') COLLATE utf8mb4_bin DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='停车位 | 2020年6月1日 15:57:24';

-- ----------------------------
-- Records of cm_parking_lot
-- ----------------------------
INSERT INTO `cm_parking_lot` VALUES ('1', 'A00001', '11', '20', '1', '1', '2020-06-29 16:34:02', '2020-07-05 00:55:58', '0');
INSERT INTO `cm_parking_lot` VALUES ('6', 'B00001', '12', '20', '1', '1', '2020-07-05 00:55:51', null, '0');

-- ----------------------------
-- Table structure for cm_parking_space_registration
-- ----------------------------
DROP TABLE IF EXISTS `cm_parking_space_registration`;
CREATE TABLE `cm_parking_space_registration` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `household_id` int(11) DEFAULT NULL COMMENT '业主id',
  `parking_lot_id` int(11) DEFAULT NULL COMMENT '车位id',
  `register_way` enum('1','0') COLLATE utf8mb4_bin DEFAULT '0' COMMENT '登记方式 ： 0 车位租赁  |  1 车位购买',
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `status` tinyint(4) DEFAULT '1' COMMENT '登记状态 ： 1  登记  |  0 撤销',
  `is_delete` enum('1','0') COLLATE utf8mb4_bin DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='车位登记 | 2020年6月1日 11:57:30';

-- ----------------------------
-- Records of cm_parking_space_registration
-- ----------------------------
INSERT INTO `cm_parking_space_registration` VALUES ('7', '9', '1', '0', '2020-06-30 11:34:42', '2020-06-30 11:35:05', '0', '0');

-- ----------------------------
-- Table structure for cm_personnel
-- ----------------------------
DROP TABLE IF EXISTS `cm_personnel`;
CREATE TABLE `cm_personnel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `real_name` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '姓名',
  `telephone` char(11) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '联系方式',
  `account` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '登录账号',
  `password` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '密码',
  `remark` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `status` tinyint(4) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `is_delete` enum('1','0') COLLATE utf8mb4_bin DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='社区职员 | 2020年6月1日 15:18:54';

-- ----------------------------
-- Records of cm_personnel
-- ----------------------------
INSERT INTO `cm_personnel` VALUES ('1', '王富琳', '18277155605', 'admin', '$2a$10$ySG2lkvjFHY5O0./CPIE1OI8VJsuKYEzOYzqIa7AJR6sEgSzUFOAm', null, '1', '2020-06-18 18:54:02', null, '0');
INSERT INTO `cm_personnel` VALUES ('2', '陈清华', '18277155605', 'cqh', '$2a$10$ySG2lkvjFHY5O0./CPIE1OI8VJsuKYEzOYzqIa7AJR6sEgSzUFOAm', null, '1', '2020-06-17 14:53:54', null, '0');
INSERT INTO `cm_personnel` VALUES ('3', '李海涛', '13877778888', 'lht', '$2a$10$9/OJ7olmGOEAel9jfPL3xekB/363OI5MP2q4mQq17FHwLUjrMRnuG', '', '1', '2020-06-24 10:12:50', null, '0');
INSERT INTO `cm_personnel` VALUES ('5', '陈洋洋', '18812345678', 'cyy', '$2a$10$1cuOKRXWp4W.40vlX8ejme5.EgvlIPlhkRlXaxLsVI8mkY9R.G8Cy', 'test', '1', '2020-06-27 17:22:42', null, '0');

-- ----------------------------
-- Table structure for cm_perssonel_role
-- ----------------------------
DROP TABLE IF EXISTS `cm_perssonel_role`;
CREATE TABLE `cm_perssonel_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL COMMENT '社区职员 perssonel_id',
  `rid` int(11) DEFAULT NULL COMMENT '角色id',
  `status` tinyint(4) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `is_delete` enum('1','0') COLLATE utf8mb4_bin DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='职员关联角色 | 2020年6月1日 16:26:59';

-- ----------------------------
-- Records of cm_perssonel_role
-- ----------------------------
INSERT INTO `cm_perssonel_role` VALUES ('1', '1', '3', '1', null, null, '0');
INSERT INTO `cm_perssonel_role` VALUES ('2', '2', '2', '1', null, null, '0');
INSERT INTO `cm_perssonel_role` VALUES ('3', '2', '1', '1', null, null, '0');

-- ----------------------------
-- Table structure for cm_repair
-- ----------------------------
DROP TABLE IF EXISTS `cm_repair`;
CREATE TABLE `cm_repair` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `repair_type_id` int(11) DEFAULT NULL COMMENT '修理类型',
  `description` text COLLATE utf8mb4_bin COMMENT '报修描述',
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL COMMENT '报修状态',
  `is_delete` enum('1','0') COLLATE utf8mb4_bin DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='报修申请 | 2020年6月1日 11:04:36';

-- ----------------------------
-- Records of cm_repair
-- ----------------------------
INSERT INTO `cm_repair` VALUES ('1', '1', 0x283129E69CBAE6A2B0E68D9FE4BCA4626169E38082E794B1E4BA8EE59F8EE5B882E5BBBAE8AEBEE7AEA1E79086E4B88DE4B8A5E38081E696BDE5B7A5E4B88DE59684E7AD89E5BC95E8B5B7E79A84EFBC8C6475E7BAA6E58DA0E794B5E7BC86E7BABFE8B7AFE4BA8BE695857A6869E79A84353025E380820A283229E99385E58C85E796B2E58AB3E38081E9BE9FE8A382E38081E88380E8A38264616FE38082E8BF99E698AFE794B1E4BA8EE794B5E7BC86E7BABFE8B7AFE5AE89E8A385E69DA1E4BBB6E4B88DE889AFE38081E588B6E980A0E58E82E79A84E588B6E980A0E8B4A8E9878FE5B7AEE38081E794B5E7BC86E995BFE69C9FE8BF87E8B49FE88DB7E7AD89E58E9FE59BA0E5BC95E8B5B7E79A84EFBC8CE5A49AE58D8AE58F91E7949FE59CA8E4B8ADE997B4E68EA5E5A4B4E5928CE7BB88E7ABAFE5A4B4E99984E8BF91E79A84E4B880E6AEB5E794B5E7BC86E59C9FEFBC8CE4B99FE69C89E4B880E4BA9BE58F91E7949FE59CA8E794B5E7BC86E5AF86E99B86E695A3E783ADE4B88DE889AFE79A84E59CB0E696B9E38082, '2020-06-30 17:18:28', null, '4', '0');

-- ----------------------------
-- Table structure for cm_repair_type
-- ----------------------------
DROP TABLE IF EXISTS `cm_repair_type`;
CREATE TABLE `cm_repair_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` char(50) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '类型名称',
  `remark` char(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '描述',
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `is_delete` enum('1','0') COLLATE utf8mb4_bin DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='报修类型 | 2020年6月1日 11:05:08';

-- ----------------------------
-- Records of cm_repair_type
-- ----------------------------
INSERT INTO `cm_repair_type` VALUES ('1', '线路维修', '线路维修', '2020-06-27 16:58:17', null, '1', '0');
INSERT INTO `cm_repair_type` VALUES ('2', '管道维修', '', '2020-06-27 20:01:40', null, '1', '0');

-- ----------------------------
-- Table structure for cm_role
-- ----------------------------
DROP TABLE IF EXISTS `cm_role`;
CREATE TABLE `cm_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(64) DEFAULT NULL COMMENT '角色名称',
  `role_identify` char(20) DEFAULT NULL COMMENT '角色标识',
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `is_delete` enum('1','0') CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COMMENT='角色（权限组） | 2020年6月1日 16:30:44';

-- ----------------------------
-- Records of cm_role
-- ----------------------------
INSERT INTO `cm_role` VALUES ('1', '部门经理', 'ROLE_DEP', '2020-06-18 15:30:31', null, '1', '0');
INSERT INTO `cm_role` VALUES ('2', '招聘主管', 'ROLE_REC', '2020-06-17 11:30:37', null, '1', '0');
INSERT INTO `cm_role` VALUES ('3', '系统管理员', 'ROLE_STS', '2020-06-16 21:30:55', null, '1', '0');
INSERT INTO `cm_role` VALUES ('4', 'test1', null, '2020-06-16 21:30:55', null, '1', '0');
INSERT INTO `cm_role` VALUES ('5', 'test1', null, '2020-06-16 21:30:55', null, '1', '0');
INSERT INTO `cm_role` VALUES ('6', 'test1', null, '2020-06-16 21:30:55', null, '1', '0');
INSERT INTO `cm_role` VALUES ('7', 'test1', null, '2020-06-16 21:30:55', null, '1', '0');
INSERT INTO `cm_role` VALUES ('8', 'test1', null, '2020-06-16 21:30:55', null, '1', '0');
INSERT INTO `cm_role` VALUES ('9', 'test1', null, '2020-06-16 21:30:55', null, '1', '0');
INSERT INTO `cm_role` VALUES ('10', 'test1', null, '2020-06-16 21:30:55', null, '1', '0');

-- ----------------------------
-- Table structure for cm_storied_house
-- ----------------------------
DROP TABLE IF EXISTS `cm_storied_house`;
CREATE TABLE `cm_storied_house` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ridgepole` int(2) DEFAULT NULL COMMENT '楼栋',
  `unit` int(2) DEFAULT NULL COMMENT '单元',
  `storey` char(10) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '楼层',
  `room_number` char(10) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '房号',
  `chamber` int(2) DEFAULT NULL COMMENT '室',
  `hall` int(2) DEFAULT NULL COMMENT '厅',
  `floor_space` char(10) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '建筑面积（平方）',
  `house_price` char(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '房屋价格',
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` tinyint(4) DEFAULT NULL,
  `is_delete` enum('1','0') COLLATE utf8mb4_bin DEFAULT '0' COMMENT '逻辑删除 ： 0 否  |  1 是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='房屋信息 | 2020年6月1日 16:36:20';

-- ----------------------------
-- Records of cm_storied_house
-- ----------------------------
INSERT INTO `cm_storied_house` VALUES ('1', '1', '4', '11', '121', '5', '5', '134', '140', '2020-03-12 08:52:39', '2020-06-27 22:48:05', '1', '0');
INSERT INTO `cm_storied_house` VALUES ('2', '1', '4', '1', '102', '1', '4', '122', '150', '2020-03-13 06:52:32', '2020-06-27 22:48:05', '1', '0');
INSERT INTO `cm_storied_house` VALUES ('3', '1', '6', '1', '103', '1', '4', '122', '140', '2020-03-13 07:50:45', '2020-06-27 22:48:05', '1', '0');
INSERT INTO `cm_storied_house` VALUES ('4', '1', '4', '1', '1', '1', '4', '1', '1', '2020-03-13 08:01:17', '2020-06-28 11:17:19', '1', '0');
INSERT INTO `cm_storied_house` VALUES ('5', '1', '5', '1', '101', '1', '4', '80', '120', '2020-03-22 22:51:39', '2020-06-27 22:48:05', '1', '0');
INSERT INTO `cm_storied_house` VALUES ('6', '1', '4', '15', '15101', '1', '4', '80', '120', '2020-05-10 21:35:09', '2020-06-27 22:48:05', '1', '0');
INSERT INTO `cm_storied_house` VALUES ('7', '11', '12', '1', '101', '1', '4', '150', '200', '2020-05-10 21:53:34', '2020-06-27 22:48:05', '1', '0');
INSERT INTO `cm_storied_house` VALUES ('8', '13', '14', '10', '10101', '1', '4', '120', '150', '2020-05-10 22:00:06', '2020-06-27 22:48:05', '1', '0');
INSERT INTO `cm_storied_house` VALUES ('9', '30', '33', '10', '501', '6', '4', '120', '140', '2020-03-12 08:52:39', '2020-06-27 22:48:05', '1', '0');

-- ----------------------------
-- Table structure for cm_vehicle_registration
-- ----------------------------
DROP TABLE IF EXISTS `cm_vehicle_registration`;
CREATE TABLE `cm_vehicle_registration` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `household_id` int(11) DEFAULT NULL COMMENT '业主id （account）',
  `brand` char(30) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '车辆品牌',
  `type` char(30) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '车辆型号',
  `plate_number` char(10) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '车牌号码',
  `contacts` char(5) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '联系人',
  `telephone` char(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '联系人手机号码',
  `external` enum('1','0') COLLATE utf8mb4_bin DEFAULT '0' COMMENT '外来车辆 : 1 是  |  0 否',
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `is_delete` enum('1','0') COLLATE utf8mb4_bin DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='车辆登记 | 2020年6月1日 11:45:45';

-- ----------------------------
-- Records of cm_vehicle_registration
-- ----------------------------
INSERT INTO `cm_vehicle_registration` VALUES ('1', null, '保时捷', 'Taycan', '粤B00001', '业主1', '18277155605', '0', '2020-06-30 16:02:52', null, '1', '0');
INSERT INTO `cm_vehicle_registration` VALUES ('2', '4', '丰田', '埃尔法', '粤B00002', '业主3', '18277155605', '0', '2020-06-30 16:20:52', null, '1', '0');

-- ----------------------------
-- Table structure for cm_visitor
-- ----------------------------
DROP TABLE IF EXISTS `cm_visitor`;
CREATE TABLE `cm_visitor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `real_name` char(30) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '访客姓名',
  `sex` tinyint(4) DEFAULT NULL COMMENT '性别',
  `telephone` char(11) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '联系方式',
  `remark` char(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `is_delete` enum('1','0') COLLATE utf8mb4_bin DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='访客登记 | 2020年6月1日 11:30:03';

-- ----------------------------
-- Records of cm_visitor
-- ----------------------------
INSERT INTO `cm_visitor` VALUES ('5', '张大炮', '1', '18877887788', '张大炮拜访一栋一单元李铁柱', '2020-07-01 17:01:45', null, '1', '0');
