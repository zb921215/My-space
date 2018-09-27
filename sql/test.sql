/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 27/09/2018 21:52:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu`  (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单id',
  `menu_pid` int(11) NULL DEFAULT NULL COMMENT '上级菜单id',
  `menu_name` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `menu_url` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单链接',
  `menu_icon` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `menu_order` int(11) NULL DEFAULT NULL COMMENT '菜单顺序',
  `create_by` int(11) NULL DEFAULT NULL COMMENT '建表人ID',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '建表时间',
  `update_by` int(11) NULL DEFAULT NULL COMMENT '更新人ID',
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES (1, NULL, '系统管理', NULL, 'glyphicon glyphicon-cog', 1, 1, '2018-01-28 00:13:41', 1, '2018-03-08 12:58:15');
INSERT INTO `t_menu` VALUES (2, 1, '用户管理', 'page/system/user.html', 'glyphicon glyphicon-cog', 1, 1, '2018-01-28 00:22:27', 1, '2018-09-15 19:29:45');
INSERT INTO `t_menu` VALUES (3, 1, '菜单管理', 'page/system/menu.html', 'glyphicon glyphicon-list-alt', 2, 1, '2018-02-28 09:13:49', 1, '2018-09-11 23:01:03');
INSERT INTO `t_menu` VALUES (4, 1, '角色管理', 'page/system/role.html', 'glyphicon glyphicon-fire', 3, 1, '2018-03-05 17:06:08', 1, '2018-09-12 21:52:51');

-- ----------------------------
-- Table structure for t_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission`  (
  `permission_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `role_id` int(11) NULL DEFAULT NULL COMMENT '角色id',
  `menu_id` int(11) NULL DEFAULT NULL COMMENT '菜单id',
  `permission_value` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '拥有权限:1:查看；2：添加；3：修改；4：删除',
  `create_by` int(11) NULL DEFAULT NULL COMMENT '建表人ID',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '建表时间',
  `update_by` int(11) NULL DEFAULT NULL COMMENT '更新人ID',
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`permission_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_permission
-- ----------------------------
INSERT INTO `t_permission` VALUES (1, 1, 1, '1,2,3,4', 1, '2018-03-07 11:10:33', 1, '2018-09-13 21:15:25');
INSERT INTO `t_permission` VALUES (2, 1, 2, '1,2,3,4', 1, '2018-03-07 16:16:18', 1, '2018-09-12 21:53:47');
INSERT INTO `t_permission` VALUES (3, 1, 3, '1,2,3,4', 1, '2018-03-07 15:04:54', 1, '2018-09-12 22:27:33');
INSERT INTO `t_permission` VALUES (4, 1, 4, '1,2,3,4', 1, '2018-03-07 15:10:10', 1, '2018-09-12 21:53:48');

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `role_mark` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  `create_by` int(11) NULL DEFAULT NULL COMMENT '建表人ID',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '建表时间',
  `update_by` int(11) NULL DEFAULT NULL COMMENT '更新人ID',
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES (1, '管理员', '拥有所有权限', 1, '2018-02-01 22:42:17', 1, '2018-09-11 21:01:35');
INSERT INTO `t_role` VALUES (2, '普通人员', '拥有部分权限', 1, '2018-09-13 20:58:18', 1, '2018-09-27 21:47:43');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_account` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户账号',
  `user_password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户姓名',
  `user_remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户描述',
  `role_id` int(11) NULL DEFAULT NULL COMMENT '角色ID',
  `create_by` int(11) NULL DEFAULT NULL COMMENT '建表人ID',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '建表时间',
  `update_by` int(11) NULL DEFAULT NULL COMMENT '更新人ID',
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'admin', 'E10ADC3949BA59ABBE56E057F20F883E', '李小三', '第一个账号，超级管理员', 1, 1, NULL, 1, '2018-09-27 21:47:58');
INSERT INTO `t_user` VALUES (2, 'wang', 'E10ADC3949BA59ABBE56E057F20F883E', '王小二', '这是王小二', NULL, 1, '2018-09-13 20:59:01', 1, '2018-09-27 21:48:21');

SET FOREIGN_KEY_CHECKS = 1;
