/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Version : 50713
 Source Host           : localhost
 Source Database       : test

 Target Server Version : 50713
 File Encoding         : utf-8

 Date: 11/04/2016 11:29:50 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `pid` varchar(32) NOT NULL,
  `course_name` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`pid`),
  UNIQUE KEY `UK_9dll001xc2cip6hug6axoab0p` (`course_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `course`
-- ----------------------------
BEGIN;
INSERT INTO `course` VALUES ('1', 'course1'), ('2', 'course2');
COMMIT;

-- ----------------------------
--  Table structure for `stu_cou`
-- ----------------------------
DROP TABLE IF EXISTS `stu_cou`;
CREATE TABLE `stu_cou` (
  `stu_id` varchar(32) NOT NULL,
  `cou_id` varchar(32) NOT NULL,
  PRIMARY KEY (`stu_id`,`cou_id`),
  KEY `FK_fd2i9jhyx88ktcbudlprem9y0` (`cou_id`),
  CONSTRAINT `FK_fd2i9jhyx88ktcbudlprem9y0` FOREIGN KEY (`cou_id`) REFERENCES `course` (`pid`),
  CONSTRAINT `FK_k71umpbvqf7722foi4l5d97g9` FOREIGN KEY (`stu_id`) REFERENCES `student` (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `stu_cou`
-- ----------------------------
BEGIN;
INSERT INTO `stu_cou` VALUES ('1', '1'), ('3', '1'), ('1', '2'), ('3', '2');
COMMIT;

-- ----------------------------
--  Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `pid` varchar(32) NOT NULL,
  `student_name` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`pid`),
  UNIQUE KEY `UK_9ox4dkm0nek6gub3j8slt1kaj` (`student_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `student`
-- ----------------------------
BEGIN;
INSERT INTO `student` VALUES ('1', 'student1'), ('2', 'student2'), ('3', 'student3');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
