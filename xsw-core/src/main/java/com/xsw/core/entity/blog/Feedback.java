package com.xsw.core.entity.blog;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.xsw.core.entity.auth.User;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 反馈表
 * </p>
 *
 * @author xiesw
 * @since 2020/12/25 14:27
 */
@Data
@TableName("xsw_feedback")
public class Feedback implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ASSIGN_UUID)
    private String feedbackId;

    /**
     * 管理员UID
     */
    private String admin_uid;

    /**
     * 用户uid
     */
    private String uid;

    /**
     * 标题
     */
    private String title;

    /**
     * 反馈的内容
     */
    private String content;

    /**
     * 回复
     */
    private String reply;

    /**
     * 反馈状态： 0：已开启  1：进行中  2：已完成  3：已拒绝
     */
    private Integer feedbackStatus;


    // 以下字段不存入数据库，封装为了前端使用

    /**
     * 反馈用户
     */
    @TableField(exist = false)
    private User user;

}
