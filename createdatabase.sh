#!/bin/bash

mysql -u root -p password <<EOF

DROP DATABASE IF EXISTS news;
CREATE DATABASE news;
USE news;

DROP TABLE IF EXISTS t_category;
CREATE TABLE t_category (
  id smallint(2) NOT NULL AUTO_INCREMENT,
  categoryName varchar(20) NOT NULL,
  categoryPriority smallint(1) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS t_news;
CREATE TABLE t_news (
  id int(10) NOT NULL AUTO_INCREMENT,
  newsTitle varchar(30) NOT NULL,
  newsPublishTime datetime NOT NULL,
  newsContent text NOT NULL,
  newsIsPicture smallint(1) NOT NULL,
  newsPictureSite varchar(100) DEFAULT NULL,
  newsIsTopLine smallint(1) NOT NULL,
  newsIsHot smallint(1) NOT NULL,
  newsHitCount int(6) NOT NULL,
  newsCategoryId smallint(2) NOT NULL,
  newsCommentCount int(4) NOT NULL,
  PRIMARY KEY (id),
  KEY ncategoryid (newsCategoryId),
  CONSTRAINT ncategoryid FOREIGN KEY (newsCategoryId) REFERENCES t_category (id)
) ENGINE=InnoDB AUTO_INCREMENT=258 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS t_comment;
CREATE TABLE t_comment (
  id int(8) NOT NULL AUTO_INCREMENT,
  commentUser varchar(20) NOT NULL,
  commentContent varchar(255) NOT NULL,
  commentPublishTime datetime NOT NULL,
  commentNewsId int(10) NOT NULL,
  PRIMARY KEY (id),
  KEY cnewsid (commentNewsId),
  CONSTRAINT cnewsid FOREIGN KEY (commentNewsId) REFERENCES t_news (id)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS t_user;
CREATE TABLE t_user (
  userName varchar(20) NOT NULL,
  userPass varchar(20) NOT NULL DEFAULT '',
  isRoot varchar(20) DEFAULT 'false',
  PRIMARY KEY (userName)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

EOF