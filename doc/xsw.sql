CREATE DATABASE IF NOT EXISTS `xsw` DEFAULT CHARACTER SET utf8 ;

USE `xsw`;

/*Table structure for table `xsw_admin` */

CREATE TABLE IF NOT EXISTS `xsw_user` (
  `uid` varchar(32) NOT NULL COMMENT '唯一uid',
  `user_name` varchar(32) NOT NULL COMMENT '用户名',
  `pass_word` varchar(32) NOT NULL COMMENT '密码',
  `gender` varchar(1) DEFAULT NULL COMMENT '性别(1:男2:女)',
  `avatar` varchar(255) DEFAULT NULL COMMENT '个人头像',
  `email` varchar(32) DEFAULT NULL COMMENT '邮箱',
  `birthday` date DEFAULT NULL COMMENT '出生年月日',
  `mobile` varchar(16) DEFAULT NULL COMMENT '手机',
  `valid_code` varchar(16) DEFAULT NULL COMMENT '邮箱验证码',
  `summary` varchar(255) DEFAULT NULL COMMENT '自我简介最多150字',
  `login_count` int(11) unsigned DEFAULT '0' COMMENT '登录次数',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `last_login_ip` varchar(50) DEFAULT '127.0.0.1' COMMENT '最后登录IP',
  `status` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '状态',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `nick_name` varchar(32) DEFAULT NULL COMMENT '昵称',
  `qq_number` varchar(32) DEFAULT NULL COMMENT 'QQ号',
  `we_chat` varchar(32) DEFAULT NULL COMMENT '微信号',
  `occupation` varchar(32) DEFAULT NULL COMMENT '职业',
  `github` varchar(32) DEFAULT NULL COMMENT 'github地址',
  `gitee` varchar(32) DEFAULT NULL COMMENT 'gitee地址',
  `role_uid` varchar(32) DEFAULT NULL COMMENT '拥有的角色uid',
  `person_resume` text COMMENT '履历',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理员表';


CREATE TABLE IF NOT EXISTS `xsw_blog` (
  `blog_id` varchar(32) NOT NULL COMMENT '唯一id',
  `title` varchar(32) DEFAULT NULL COMMENT '博客标题',
  `summary` varchar(255) DEFAULT NULL COMMENT '博客简介',
  `content` longtext COMMENT '博客内容',
  `tag_id` varchar(255) DEFAULT NULL COMMENT '标签id',
  `click_count` int(11) DEFAULT '0' COMMENT '博客点击数',
  `collect_count` int(11) DEFAULT '0' COMMENT '博客收藏数',
  `file_id` varchar(255) DEFAULT NULL COMMENT '标题图片id',
  `status` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '状态',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `uid` varchar(32) DEFAULT NULL COMMENT '管理员uid',
  `is_original` varchar(1) DEFAULT '1' COMMENT '是否原创（0:不是 1：是）',
  `author` varchar(32) DEFAULT NULL COMMENT '作者',
  `articles_part` varchar(128) DEFAULT NULL COMMENT '文章出处',
  `blog_sort_id` varchar(32) DEFAULT NULL COMMENT '博客分类ID',
  `level` tinyint(1) DEFAULT '0' COMMENT '推荐等级(0:正常)',
  `is_publish` varchar(1) DEFAULT '1' COMMENT '是否发布：0：否，1：是',
  `sort` int(11) NOT NULL DEFAULT '0' COMMENT '排序字段',
  `open_comment` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否开启评论(0:否 1:是)',
  `type` tinyint(1) NOT NULL DEFAULT '0' COMMENT '类型【0 博客， 1：推广】',
  `outside_link` varchar(1024) DEFAULT NULL COMMENT '外链【如果是推广，那么将跳转到外链】',
  PRIMARY KEY (`blog_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='博客表';

/*Table structure for table `t_blog_sort` */

CREATE TABLE IF NOT EXISTS `xsw_blog_sort` (
  `blog_sort_id` varchar(32) NOT NULL COMMENT '唯一id',
  `uid` varchar(32) NOT NULL COMMENT '用户id',
  `sort_name` varchar(255) DEFAULT NULL COMMENT '分类内容',
  `content` varchar(255) DEFAULT NULL COMMENT '分类简介',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `status` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '状态',
  `sort` int(11) DEFAULT '0' COMMENT '排序字段，越大越靠前',
  `click_count` int(11) DEFAULT '0' COMMENT '点击数',
  PRIMARY KEY (`blog_sort_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='博客分类表';

CREATE TABLE IF NOT EXISTS `xsw_collect` (
  `collect_id` varchar(32) NOT NULL COMMENT '唯一id',
  `uid` varchar(32) NOT NULL COMMENT '用户的uid',
  `blog_id` varchar(32) NOT NULL COMMENT '博客的uid',
  `status` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '状态',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  PRIMARY KEY (`collect_id`),
  UNIQUE key(`uid`,`blog_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='收藏表';


CREATE TABLE IF NOT EXISTS `xsw_comment` (
  `comment_id` varchar(32) NOT NULL COMMENT '唯一id',
  `uid` varchar(32) DEFAULT NULL COMMENT '用户uid',
  `to_uid` varchar(32) DEFAULT NULL COMMENT '回复某条评论的uid',
  `content` varchar(2048) DEFAULT NULL COMMENT '评论内容',
  `blog_id` varchar(32) DEFAULT NULL COMMENT '博客id',
  `status` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '状态',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `source` varchar(255) NOT NULL COMMENT '评论来源： MESSAGE_BOARD，ABOUT，BLOG_INFO 等',
  `type` tinyint(1) NOT NULL DEFAULT '0' COMMENT '评论类型 1:点赞 0:评论',
  `first_comment_id` varchar(32) DEFAULT NULL COMMENT '一级评论UID',
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评论表';


CREATE TABLE IF NOT EXISTS `xsw_comment_report` (
  `comment_report_id` varchar(32) NOT NULL COMMENT '唯一uid',
  `report_uid` varchar(32) DEFAULT NULL COMMENT '举报人uid',
  `comment_id` varchar(32) DEFAULT NULL COMMENT '被举报的评论id',
  `reported_user_uid` varchar(32) DEFAULT NULL COMMENT '被举报的用户uid',
  `content` varchar(1024) DEFAULT NULL COMMENT '举报的原因',
  `progress` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '进展状态: 0 未查看   1: 已查看  2：已处理',
  `status` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '状态',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  PRIMARY KEY (`comment_report_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评论举报表';


CREATE TABLE IF NOT EXISTS `xsw_exception_log` (
  `exception_log_id` varchar(32) NOT NULL COMMENT '唯一uid',
  `exception_json` mediumtext COMMENT '异常对象json格式',
  `exception_message` mediumtext COMMENT '异常信息',
  `status` tinyint(1) DEFAULT '1' COMMENT '状态',
  `create_time` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `ip` varchar(64) DEFAULT NULL COMMENT 'ip地址',
  `ip_source` varchar(64) DEFAULT NULL COMMENT 'ip来源',
  `method` varchar(64) DEFAULT NULL COMMENT '请求方法',
  `operation` varchar(255) DEFAULT NULL COMMENT '方法描述',
  `params` longtext COMMENT '请求参数',
  PRIMARY KEY (`exception_log_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `xsw_feedback` (
  `feedback_id` varchar(32) NOT NULL COMMENT '唯一uid',
  `uid` varchar(32) NOT NULL COMMENT '用户uid',
  `content` varchar(1000) DEFAULT NULL COMMENT '反馈的内容',
  `status` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '状态',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `feedback_status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '反馈状态： 0：已开启  1：进行中  2：已完成  3：已拒绝',
  `reply` varchar(255) DEFAULT NULL COMMENT '回复',
  `admin_uid` varchar(32) DEFAULT NULL COMMENT '管理员uid',
  PRIMARY KEY (`feedback_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='反馈表';


CREATE TABLE IF NOT EXISTS `xsw_link` (
  `link_id` varchar(32) NOT NULL COMMENT '唯一uid',
  `title` varchar(255) DEFAULT NULL COMMENT '友情链接标题',
  `summary` varchar(255) DEFAULT NULL COMMENT '友情链接介绍',
  `url` varchar(255) DEFAULT NULL COMMENT '友情链接URL',
  `click_count` int(11) DEFAULT '0' COMMENT '点击数',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `status` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '状态',
  `sort` int(11) DEFAULT '0' COMMENT '排序字段，越大越靠前',
  `link_status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '友链状态： 0 申请中， 1：已上线，  2：已下架',
  `uid` varchar(32) DEFAULT NULL COMMENT '申请用户UID',
  `admin_uid` varchar(32) DEFAULT NULL COMMENT '操作管理员UID',
  `email` varchar(255) DEFAULT NULL COMMENT '站长邮箱',
  `file_uid` varchar(255) DEFAULT NULL COMMENT '网站图标',
  PRIMARY KEY (`link_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='友情链接表';


CREATE TABLE IF NOT EXISTS `xsw_tag` (
  `tag_id` varchar(32) NOT NULL COMMENT '唯一uid',
  `content` varchar(1000) DEFAULT NULL COMMENT '标签内容',
  `status` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '状态',
  `click_count` int(11) DEFAULT '0' COMMENT '标签简介',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `sort` int(11) DEFAULT '0' COMMENT '排序字段，越大越靠前',
  PRIMARY KEY (`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='标签表';
