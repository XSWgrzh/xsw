package com.xsw.core.entity.blog;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 友情链接表
 *
 * @author xiesw
 * @since 2020/12/25 14:06
 */
@Data
@TableName("xsw_link")
public class Link implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ASSIGN_UUID)
    private String linkId;

    /**
     * 友链标题
     */
    private String title;

    /**
     * 友链介绍
     */
    private String summary;

    /**
     * 友链地址
     */
    private String url;

    /**
     * 友链状态： 0 申请中， 1：上线  2: 已下架
     */
    private Integer linkStatus;

    /**
     * 点击数
     */
    private Integer clickCount;

    /**
     * 排序字段
     */
    private Integer sort;

    /**
     * 管理员UID
     */
    private String adminUid;

    /**
     * 申请用户Uid
     */
    private String userUid;

    /**
     * 站长邮箱
     */
    private String email;

    /**
     * 网站图标uid
     */
    private String fileUid;

    /**
     * 状态
     */
    private Integer status;



}
