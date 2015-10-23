/*
Navicat MySQL Data Transfer

Source Server         : 本地数据库，随便玩
Source Server Version : 50619
Source Host           : localhost:3306
Source Database       : forum

Target Server Type    : MYSQL
Target Server Version : 50619
File Encoding         : 65001

Date: 2015-10-23 20:58:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `board`
-- ----------------------------
DROP TABLE IF EXISTS `board`;
CREATE TABLE `board` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `des` varchar(256) DEFAULT NULL,
  `topic_num` int(11) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `modified_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of board
-- ----------------------------
INSERT INTO `board` VALUES ('11', 'test2', 'test des', '0', '2015-10-19 23:34:02', '2015-10-19 23:34:02');

-- ----------------------------
-- Table structure for `login_log`
-- ----------------------------
DROP TABLE IF EXISTS `login_log`;
CREATE TABLE `login_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `login_area` varchar(255) NOT NULL,
  `ip` varchar(255) NOT NULL,
  `login_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of login_log
-- ----------------------------
INSERT INTO `login_log` VALUES ('1', '1', 'hz', '127.0.0.1', '2015-10-19 23:34:29');

-- ----------------------------
-- Table structure for `post`
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `topic_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `post_seq_num` int(11) NOT NULL,
  `post_text` text NOT NULL,
  `like_num` int(11) DEFAULT '0',
  `dislike_num` int(11) DEFAULT '0',
  `created_time` datetime DEFAULT NULL,
  `modified_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES ('3', '0', '1', '0', 'hello world', '1', '1', '2015-10-19 23:52:09', '2015-10-19 23:52:09');
INSERT INTO `post` VALUES ('4', '0', '1', '0', 'hello world', '1', '1', '2015-10-19 23:59:25', '2015-10-19 23:59:25');
INSERT INTO `post` VALUES ('5', '0', '1', '0', 'hello world', '1', '1', '2015-10-20 00:00:26', '2015-10-20 00:00:26');
INSERT INTO `post` VALUES ('6', '0', '1', '0', 'hello world', '1', '1', '2015-10-20 00:03:45', '2015-10-20 00:03:45');
INSERT INTO `post` VALUES ('7', '0', '1', '0', 'hello world', '1', '1', '2015-10-20 00:04:25', '2015-10-20 00:04:25');
INSERT INTO `post` VALUES ('8', '0', '1', '0', 'hello world', '1', '1', '2015-10-20 00:05:05', '2015-10-20 00:05:05');
INSERT INTO `post` VALUES ('9', '0', '1', '0', 'hello kitty', '1', '1', '2015-10-20 00:05:37', '2015-10-20 00:00:00');
INSERT INTO `post` VALUES ('10', '0', '1', '0', 'hello kitty', '1', '1', '2015-10-20 00:06:14', '2015-10-20 00:00:00');

-- ----------------------------
-- Table structure for `topic`
-- ----------------------------
DROP TABLE IF EXISTS `topic`;
CREATE TABLE `topic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `board_id` int(11) NOT NULL,
  `topic_title` varchar(1024) NOT NULL,
  `user_id` int(11) NOT NULL,
  `view_num` int(11) DEFAULT '0',
  `post_num` int(11) DEFAULT '0',
  `last_post_time` datetime DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `modified_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of topic
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  `passwd` varchar(128) DEFAULT NULL,
  `real_name` varchar(128) DEFAULT NULL,
  `phone_number` varchar(128) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `modified_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'test', 'test', null, null, null, null, null, null);
INSERT INTO `user` VALUES ('6', 'test', 'test', null, null, null, null, '2015-10-19 22:42:52', '2015-10-19 22:42:52');
INSERT INTO `user` VALUES ('7', 'test', 'test', null, null, null, null, null, null);
INSERT INTO `user` VALUES ('8', 'test', 'test', null, null, null, null, '2015-10-19 23:02:38', null);
INSERT INTO `user` VALUES ('9', 'test', 'test', null, null, null, null, '2015-10-19 23:03:05', '2015-10-19 23:03:05');

-- ----------------------------
-- Table structure for `user_token`
-- ----------------------------
DROP TABLE IF EXISTS `user_token`;
CREATE TABLE `user_token` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `token` varchar(128) NOT NULL,
  `modified_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_token
-- ----------------------------
INSERT INTO `user_token` VALUES ('4', '2', '1111', '2015-10-07 23:44:43');
INSERT INTO `user_token` VALUES ('5', '10', 'test', '2015-10-19 23:08:51');
