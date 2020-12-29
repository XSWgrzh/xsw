package com.xsw.core.entity.blog;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 博客表
 * @author xiesw
 * @since 2020/12/25 14:06
 */
@Data
@TableName("xsw_blog")
public class Blog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 唯一
     */
    @TableId(type = IdType.ASSIGN_UUID)
    private String blog_id;

    /**
     * 博客标题
     */
    private String title;

    /**
     * 博客简介
     * updateStrategy = FieldStrategy.IGNORED ：表示更新时候忽略非空判断
     */
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private String summary;

    /**
     * 博客内容
     */
    private String content;

    /**
     * 标签uid
     */
    private String tagId;

    /**
     * 博客分类UID
     */
    private String blogSortId;

    /**
     * 博客点击数
     */
    private Integer clickCount;

    /**
     * 博客收藏数
     */
    private Integer collectCount;

    /**
     * 标题图片UID
     */
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private String fileId;

    /**
     * 管理员UID
     */
    private String uid;

    /**
     * 是否发布
     */
    private String isPublish;

    /**
     * 是否原创
     */
    private String isOriginal;

    /**
     * 如果原创，作者为管理员名
     */
    private String author;

    /**
     * 文章出处
     */
    private String articlesPart;

    /**
     * 推荐级别，用于首页推荐
     * 0：正常
     * 1：一级推荐(轮播图)
     * 2：二级推荐(top)
     * 3：三级推荐 ()
     * 4：四级 推荐 (特别推荐)
     */
    private Integer level;

    /**
     * 排序字段，数值越大，越靠前
     */
    private Integer sort;

    /**
     * 是否开启评论(0:否， 1:是)
     */
    private String openComment;

    /**
     * 文章类型【0 博客， 1：推广】
     */
    private String type;

    /**
     * 外链【如果是推广，那么将跳转到外链】
     */
    private String outsideLink;

    /**
     * @TableField 配置需要填充的字段
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date createTime;

    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;


    // 以下字段不存入数据库，封装为了方便使用

    /**
     * 标签,一篇博客对应多个标签
     */
    @TableField(exist = false)
    private List<Tag> tagList;

    /**
     * 标题图
     */
    @TableField(exist = false)
    private List<String> photoList;

    /**
     * 博客分类
     */
    @TableField(exist = false)
    private BlogSort blogSort;

    /**
     * 博客分类名
     */
    @TableField(exist = false)
    private String blogSortName;

    /**
     * 博客标题图
     */
    @TableField(exist = false)
    private String photoUrl;

    /**
     * 点赞数
     */
    @TableField(exist = false)
    private Integer praiseCount;

    /**
     * 版权申明
     */
    @TableField(exist = false)
    private String copyright;
}
