package com.xsw.core.entity.blog;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.xsw.core.entity.auth.User;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 评论表
 * </p>
 *
 * @author xiesw
 * @since 2020/12/25 13:49
 */
@Data
@TableName("xsw_comment")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ASSIGN_UUID)
    private String commentId;

    /**
     * 用户uid
     */
    private String uid;

    /**
     * 回复某条评论的uid
     */
    private String toUid;

    /**
     * 该条评论下的，一级评论UID
     */
    private String firstCommentId;


    /**
     * 评论内容
     */
    private String content;

    /**
     * 博客uid
     */
    private String blogUid;

    /**
     * 评论来源： MESSAGE_BOARD，ABOUT，BLOG_INFO 等
     */
    private String source;

    /**
     * 评论类型： 0: 评论   1: 点赞
     */
    private Integer type;

    /**
     * 状态
     */
    private Integer status;

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

    /**
     * 本条评论是哪个用户说的
     */
    @TableField(exist = false)
    private User user;

    /**
     * 发表评论的用户名
     */
    @TableField(exist = false)
    private String userName;

    /**
     * 被回复的用户名
     */
    @TableField(exist = false)
    private String toUserName;


    /**
     * 本条评论对哪个用户说的，如果没有则为一级评论
     */
    @TableField(exist = false)
    private User toUser;

    /**
     * 本条评论下的回复
     */
    @TableField(exist = false)
    private List<Comment> replyList;

    /**
     * 本条评论回复的那条评论
     */
    @TableField(exist = false)
    private Comment toComment;

    /**
     * 评论来源名称
     */
    @TableField(exist = false)
    private String sourceName;

    /**
     * 该评论来源的博客
     */
    @TableField(exist = false)
    private Blog blog;

}
