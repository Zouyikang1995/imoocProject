
CREATE DATABASE bbs;
USE bbs;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) COLLATE utf8_bin DEFAULT NULL COMMENT '用户名',
  `password` varchar(45) COLLATE utf8_bin DEFAULT NULL COMMENT '密码',
  `email` varchar(45) COLLATE utf8_bin DEFAULT NULL COMMENT '邮箱',
  `userStatus` int COMMENT '用户状态 0 正常 1 锁定 2 删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO user(username,password,email,userStatus) values('imooc1','123456','imooc1@imooc.com',0);

CREATE TABLE `post` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) COLLATE utf8_bin DEFAULT NULL COMMENT '用户名',
  `title` varchar(45) COLLATE utf8_bin DEFAULT NULL COMMENT '帖子标题',
  `category` varchar(45) COLLATE utf8_bin DEFAULT NULL COMMENT '帖子分类',
  `content` text COLLATE utf8_bin COMMENT '帖子内容',
  `tag` varchar(20) DEFAULT NULL COMMENT '帖子标签',
  `create_time` datetime DEFAULT NULL COMMENT '帖子创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
INSERT INTO post(username,title,category,content,tag,create_time) values('imooc1','第一个Java程序','帮助','第一个Java程序','Java',NOW());

CREATE TABLE `comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT '回复用户id',
  `username` varchar(45) COLLATE utf8_bin DEFAULT NULL COMMENT '回复用户名',
  `content` varchar(2000) COLLATE utf8_bin DEFAULT NULL COMMENT '回复内容',
  `create_time` datetime DEFAULT NULL COMMENT '回复时间',
  `post_id` bigint(20) NOT NULL COMMENT '对应的帖子id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

