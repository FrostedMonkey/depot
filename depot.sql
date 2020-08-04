/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : depot

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2019-08-24 12:12:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for depot_dict
-- ----------------------------
DROP TABLE IF EXISTS `depot_dict`;
CREATE TABLE `depot_dict` (
  `dict_id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_id` int(11) DEFAULT NULL,
  `goods_pid` int(11) DEFAULT NULL,
  `goods_pname` varchar(255) DEFAULT NULL,
  `goods_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`dict_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of depot_dict
-- ----------------------------
INSERT INTO `depot_dict` VALUES ('1', null, '100', '家用电器', null);
INSERT INTO `depot_dict` VALUES ('2', '101', '100', '家用电器', '电视');
INSERT INTO `depot_dict` VALUES ('3', '102', '100', '家用电器', '洗衣机');
INSERT INTO `depot_dict` VALUES ('4', '103', '100', '家用电器', '空调');
INSERT INTO `depot_dict` VALUES ('5', '104', '100', '家用电器', '电饭煲');
INSERT INTO `depot_dict` VALUES ('6', '105', '100', '家用电器', '吸尘器');
INSERT INTO `depot_dict` VALUES ('7', null, '200', '家居家纺', null);
INSERT INTO `depot_dict` VALUES ('8', '201', '200', '家居家纺', '收纳袋');
INSERT INTO `depot_dict` VALUES ('9', '202', '200', '家居家纺', '枕头');
INSERT INTO `depot_dict` VALUES ('10', '203', '200', '家居家纺', '床品套件');
INSERT INTO `depot_dict` VALUES ('11', '204', '200', '家居家纺', '防尘罩');
INSERT INTO `depot_dict` VALUES ('12', null, '300', '汽车配件', null);
INSERT INTO `depot_dict` VALUES ('13', '301', '300', '汽车配件', '机油');
INSERT INTO `depot_dict` VALUES ('14', '302', '300', '汽车配件', '轮胎');
INSERT INTO `depot_dict` VALUES ('15', '303', '300', '汽车配件', '脚垫');
INSERT INTO `depot_dict` VALUES ('16', '304', '300', '汽车配件', '贴膜');
INSERT INTO `depot_dict` VALUES ('17', '305', '300', '汽车配件', '车载香水');
INSERT INTO `depot_dict` VALUES ('18', '306', '300', '汽车配件', '行车记录仪');

-- ----------------------------
-- Table structure for depot_goods
-- ----------------------------
DROP TABLE IF EXISTS `depot_goods`;
CREATE TABLE `depot_goods` (
  `goods_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `goods_name` varchar(50) NOT NULL DEFAULT '' COMMENT '名称',
  `goods_number` int(11) NOT NULL DEFAULT '0' COMMENT '剩余量',
  PRIMARY KEY (`goods_id`)
) ENGINE=InnoDB AUTO_INCREMENT=305 DEFAULT CHARSET=utf8mb4 COMMENT='商品表';

-- ----------------------------
-- Records of depot_goods
-- ----------------------------
INSERT INTO `depot_goods` VALUES ('101', '电视', '900');
INSERT INTO `depot_goods` VALUES ('102', '洗衣机', '7000');
INSERT INTO `depot_goods` VALUES ('103', '空调', '2856');
INSERT INTO `depot_goods` VALUES ('202', '枕头', '0');
INSERT INTO `depot_goods` VALUES ('204', '防尘罩', '1000');
INSERT INTO `depot_goods` VALUES ('304', '贴膜', '3233');

-- ----------------------------
-- Table structure for depot_trade
-- ----------------------------
DROP TABLE IF EXISTS `depot_trade`;
CREATE TABLE `depot_trade` (
  `trade_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '交易单id',
  `goods_id` int(11) NOT NULL DEFAULT '0' COMMENT '商品id',
  `apply_person` varchar(50) NOT NULL DEFAULT '' COMMENT '申请人',
  `apply_time` datetime NOT NULL DEFAULT '1900-01-01 00:00:00' COMMENT '申请时间',
  `approval_person` varchar(50) DEFAULT '' COMMENT '审核人',
  `approval_time` datetime DEFAULT '1900-01-01 00:00:00' COMMENT '审核时间',
  `checkout_person` varchar(50) DEFAULT '' COMMENT '质检/准备人',
  `checkout_time` datetime DEFAULT '1900-01-01 00:00:00' COMMENT '检验/准备时间',
  `enter_person` varchar(50) DEFAULT '' COMMENT '确认人',
  `enter_time` datetime DEFAULT '1900-01-01 00:00:00' COMMENT '确认时间',
  `come_out_person` varchar(255) DEFAULT '' COMMENT '出入库确认时间',
  `kuaidi` varchar(255) DEFAULT '' COMMENT '出入库确认人',
  `come_out_time` datetime DEFAULT '1900-01-01 00:00:00' COMMENT '出入库时间',
  `number` int(11) NOT NULL DEFAULT '0' COMMENT '数量',
  `trade_status` varchar(20) NOT NULL DEFAULT '0' COMMENT '状态0:未审批 1：审批通过 2:审批被驳回 5：入库已检验 10：入库已确认 15：已入库  20：已准备 25：出库确认 30：已出库',
  `trade_type` tinyint(2) DEFAULT '0' COMMENT '类型0：入库 1：出库',
  PRIMARY KEY (`trade_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COMMENT='交易表';

-- ----------------------------
-- Records of depot_trade
-- ----------------------------
INSERT INTO `depot_trade` VALUES ('17', '204', '陈晨', '2019-05-05 14:23:10', '陈晨', '2019-05-05 14:23:19', '陈晨', '2019-05-05 14:26:17', '陈晨', '2019-05-05 14:26:25', '陈晨', '', '2019-05-05 14:31:39', '200', '15', '0');
INSERT INTO `depot_trade` VALUES ('18', '101', '陈晨', '2019-05-05 14:32:18', '陈晨', '2019-05-05 14:33:26', '陈晨', '2019-05-05 14:35:02', '陈晨', '2019-05-05 14:35:05', '', '70486904248837', '1900-01-01 00:00:00', '1000', '30', '1');
INSERT INTO `depot_trade` VALUES ('19', '103', '陈晨', '2019-05-07 14:56:36', '陈晨', '2019-05-07 14:56:50', '陈晨', '2019-05-07 14:56:58', '陈晨', '2019-05-07 14:57:03', '陈晨', '', '2019-05-07 14:57:04', '100', '15', '1');
INSERT INTO `depot_trade` VALUES ('20', '304', '陈晨', '2019-05-07 14:56:44', '陈晨', '2019-05-07 14:56:54', '陈晨', '2019-05-07 14:57:01', '陈晨', '2019-05-07 14:57:06', '陈晨', '', '2019-05-07 14:57:08', '1000', '15', '1');
INSERT INTO `depot_trade` VALUES ('21', '202', '陈晨', '2019-05-07 14:57:31', '陈晨', '2019-05-07 14:57:57', '陈晨', '2019-05-07 14:58:08', '陈晨', '2019-05-07 14:58:11', '陈晨', '', '2019-05-07 14:58:12', '2000', '15', '0');
INSERT INTO `depot_trade` VALUES ('22', '103', '陈晨', '2019-05-07 14:57:48', '陈晨', '2019-05-07 14:57:53', '陈晨', '2019-05-07 14:58:01', '陈晨', '2019-05-07 14:58:04', '陈晨', '', '2019-05-07 14:58:07', '1000', '15', '0');
INSERT INTO `depot_trade` VALUES ('23', '202', '陈晨', '2019-05-07 19:44:29', '陈晨', '2019-05-07 19:44:37', '陈晨', '2019-05-07 19:44:43', '陈晨', '2019-05-07 19:44:46', '', '70486904248837', '1900-01-01 00:00:00', '3000', '30', '1');
INSERT INTO `depot_trade` VALUES ('24', '104', '陈晨', '2019-05-07 19:51:56', '仓库主管', '2019-05-12 11:44:30', '系统管理员', '2019-06-17 17:08:54', '系统管理员', '2019-06-17 17:08:58', '', '', '1900-01-01 00:00:00', '1000', '10', '0');
INSERT INTO `depot_trade` VALUES ('25', '101', '陈晨', '2019-05-10 14:37:20', '仓库主管', '2019-05-11 18:05:16', '', '1900-01-01 00:00:00', '', '1900-01-01 00:00:00', '', '', '1900-01-01 00:00:00', '2000', '1', '1');
INSERT INTO `depot_trade` VALUES ('26', '105', '仓库管理员', '2019-05-10 16:06:20', '仓库主管', '2019-05-11 17:59:18', '', '1900-01-01 00:00:00', '', '1900-01-01 00:00:00', '', '', '1900-01-01 00:00:00', '200', '0', '0');
INSERT INTO `depot_trade` VALUES ('27', '101', '仓库管理员', '2019-05-10 17:21:43', '仓库主管', '2019-05-11 19:41:36', '', '1900-01-01 00:00:00', '', '1900-01-01 00:00:00', '', '', '1900-01-01 00:00:00', '100', '1', '1');
INSERT INTO `depot_trade` VALUES ('28', '101', '仓库管理员', '2019-05-10 17:27:27', '仓库主管', '2019-05-11 21:54:19', '', '1900-01-01 00:00:00', '', '1900-01-01 00:00:00', '', '', '1900-01-01 00:00:00', '100', '1', '1');
INSERT INTO `depot_trade` VALUES ('29', '301', '仓库管理员', '2019-05-11 17:24:06', '仓库主管', '2019-05-11 18:00:19', '', '1900-01-01 00:00:00', '', '1900-01-01 00:00:00', '', '', '1900-01-01 00:00:00', '1000', '0', '0');
INSERT INTO `depot_trade` VALUES ('30', '105', '仓库管理员', '2019-05-11 21:35:15', '', '1900-01-01 00:00:00', '', '1900-01-01 00:00:00', '', '1900-01-01 00:00:00', '', '', '1900-01-01 00:00:00', '10', '0', '0');
INSERT INTO `depot_trade` VALUES ('31', '104', '仓库管理员', '2019-05-11 21:41:19', '', '1900-01-01 00:00:00', '', '1900-01-01 00:00:00', '', '1900-01-01 00:00:00', '', '', '1900-01-01 00:00:00', '10', '0', '0');
INSERT INTO `depot_trade` VALUES ('32', '101', '仓库管理员', '2019-05-11 21:54:02', '仓库主管', '2019-05-12 10:50:54', '', '1900-01-01 00:00:00', '', '1900-01-01 00:00:00', '', '', '1900-01-01 00:00:00', '100', '1', '1');
INSERT INTO `depot_trade` VALUES ('33', '304', '仓库管理员', '2019-05-12 09:30:39', '仓库主管', '2019-05-12 09:33:42', '', '1900-01-01 00:00:00', '', '1900-01-01 00:00:00', '', '', '1900-01-01 00:00:00', '100', '1', '0');
INSERT INTO `depot_trade` VALUES ('34', '304', '仓库管理员', '2019-05-12 11:43:53', '', '1900-01-01 00:00:00', '', '1900-01-01 00:00:00', '', '1900-01-01 00:00:00', '', '', '1900-01-01 00:00:00', '100', '0', '1');

-- ----------------------------
-- Table structure for sys_module
-- ----------------------------
DROP TABLE IF EXISTS `sys_module`;
CREATE TABLE `sys_module` (
  `module_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '资源唯一标识',
  `module_pid` int(11) DEFAULT NULL COMMENT '编号',
  `module_name` varchar(50) NOT NULL DEFAULT '' COMMENT '名称',
  `module_url` varchar(50) NOT NULL DEFAULT '' COMMENT 'url',
  `module_ismenu` tinyint(2) NOT NULL DEFAULT '0' COMMENT '是否菜单0:否1：是',
  `module_status` tinyint(2) NOT NULL DEFAULT '0' COMMENT '状态 0:未开启 1:开启',
  PRIMARY KEY (`module_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3011 DEFAULT CHARSET=utf8mb4 COMMENT='资源表';

-- ----------------------------
-- Records of sys_module
-- ----------------------------
INSERT INTO `sys_module` VALUES ('1000', null, '安全模块', '', '1', '1');
INSERT INTO `sys_module` VALUES ('1005', '1000', '用户管理', '/user/toUser', '0', '1');
INSERT INTO `sys_module` VALUES ('1010', '1000', '角色管理', '/role/toRole', '0', '1');
INSERT INTO `sys_module` VALUES ('2000', null, '仓库管理', '', '1', '1');
INSERT INTO `sys_module` VALUES ('2005', '2000', '出入库申请', '/plan/toPlan', '0', '1');
INSERT INTO `sys_module` VALUES ('2010', '2000', '入库管理', '/depot/toCome', '0', '1');
INSERT INTO `sys_module` VALUES ('2015', '2000', '出库管理', '/depot/toOut', '0', '1');
INSERT INTO `sys_module` VALUES ('2020', '2000', '仓库存储', '/goods/toGoods', '0', '1');
INSERT INTO `sys_module` VALUES ('3000', null, '历史统计', '', '1', '1');
INSERT INTO `sys_module` VALUES ('3005', '3000', '出库统计', '/depot/toOutEcharts', '0', '1');
INSERT INTO `sys_module` VALUES ('3010', '3000', '入库统计', '/depot/toComeEcharts', '0', '1');

-- ----------------------------
-- Table structure for sys_rm
-- ----------------------------
DROP TABLE IF EXISTS `sys_rm`;
CREATE TABLE `sys_rm` (
  `module_id` int(11) NOT NULL COMMENT '资源唯一标志',
  `role_id` int(11) NOT NULL COMMENT '角色唯一标识',
  KEY `module_id` (`module_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `sys_rm_ibfk_1` FOREIGN KEY (`module_id`) REFERENCES `sys_module` (`module_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `sys_rm_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='资源角色关系表';

-- ----------------------------
-- Records of sys_rm
-- ----------------------------
INSERT INTO `sys_rm` VALUES ('2005', '2');
INSERT INTO `sys_rm` VALUES ('2010', '2');
INSERT INTO `sys_rm` VALUES ('2015', '2');
INSERT INTO `sys_rm` VALUES ('2020', '2');
INSERT INTO `sys_rm` VALUES ('3005', '2');
INSERT INTO `sys_rm` VALUES ('3010', '2');
INSERT INTO `sys_rm` VALUES ('2005', '1');
INSERT INTO `sys_rm` VALUES ('2010', '1');
INSERT INTO `sys_rm` VALUES ('2015', '1');
INSERT INTO `sys_rm` VALUES ('2020', '1');
INSERT INTO `sys_rm` VALUES ('1005', '3');
INSERT INTO `sys_rm` VALUES ('1010', '3');
INSERT INTO `sys_rm` VALUES ('2005', '3');
INSERT INTO `sys_rm` VALUES ('2010', '3');
INSERT INTO `sys_rm` VALUES ('2015', '3');
INSERT INTO `sys_rm` VALUES ('2020', '3');
INSERT INTO `sys_rm` VALUES ('3005', '3');
INSERT INTO `sys_rm` VALUES ('3010', '3');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色唯一标识',
  `role_name` varchar(50) NOT NULL DEFAULT '' COMMENT '名称',
  `role_remark` varchar(255) NOT NULL DEFAULT '' COMMENT '备注',
  `role_status` tinyint(2) NOT NULL DEFAULT '0' COMMENT '状态 0:未确定 1：已确定 2：未启用  3:启用',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COMMENT='角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '仓库管理员', '仓库管理员', '3');
INSERT INTO `sys_role` VALUES ('2', '仓库主管', '仓库主管', '3');
INSERT INTO `sys_role` VALUES ('3', '系统管理员', '系统管理员', '3');
INSERT INTO `sys_role` VALUES ('5', '测试数据', '测试数据', '0');

-- ----------------------------
-- Table structure for sys_ur
-- ----------------------------
DROP TABLE IF EXISTS `sys_ur`;
CREATE TABLE `sys_ur` (
  `user_id` int(11) NOT NULL COMMENT '用户唯一标志',
  `role_id` int(11) NOT NULL COMMENT '角色唯一标识',
  KEY `user_id` (`user_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `sys_ur_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `sys_ur_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户角色关系表';

-- ----------------------------
-- Records of sys_ur
-- ----------------------------
INSERT INTO `sys_ur` VALUES ('20', '2');
INSERT INTO `sys_ur` VALUES ('21', '1');
INSERT INTO `sys_ur` VALUES ('19', '3');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'user_id',
  `user_name` varchar(50) NOT NULL DEFAULT '' COMMENT '姓名',
  `user_pwd` varchar(50) NOT NULL DEFAULT '' COMMENT '密码',
  `user_status` tinyint(2) NOT NULL DEFAULT '0' COMMENT '状态 0:未确定 1：已确定 2：未启用  3:启用',
  `employee_name` varchar(50) NOT NULL DEFAULT '' COMMENT '姓名',
  `phone` varchar(11) NOT NULL DEFAULT '' COMMENT '电话号码',
  `employee_address` varchar(60) NOT NULL DEFAULT '' COMMENT '联系地址',
  `birthday` datetime NOT NULL DEFAULT '1900-01-01 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '生日',
  `sex` tinyint(2) NOT NULL DEFAULT '0' COMMENT '性别 0:男 1：nv',
  `id_card` varchar(18) NOT NULL DEFAULT '' COMMENT '身份证号码',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_name` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('19', 'admin', '8a3c9086d9c8c9f24fe5fdd88a7fefc4', '2', '系统管理员', '17792405089', '陕西西安', '2019-06-17 16:50:43', '0', '610121199705086433');
INSERT INTO `sys_user` VALUES ('20', 'test1', '877f2517f80af6faf3db0bd6bcea6407', '3', '仓库主管', '17792405089', '陕西西安', '2019-05-11 21:44:12', '0', '610121199705066544');
INSERT INTO `sys_user` VALUES ('21', 'test2', '5bbe02f987da9380cad081a5a7ec183a', '3', '仓库管理员', '17792405089', '陕西西安', '2019-05-11 21:44:12', '0', '610121199706089544');
INSERT INTO `sys_user` VALUES ('22', 'ceshi', '6345f234247af1f54d7adca64c2ca5e2', '0', '测试数据', '17792405089', '测试数据', '1900-01-01 00:00:00', '0', '1');
