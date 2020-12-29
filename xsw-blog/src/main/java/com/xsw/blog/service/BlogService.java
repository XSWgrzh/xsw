package com.xsw.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xsw.core.entity.blog.Blog;

/**
 * @author xiesw
 * @since 2020/12/25 15:34
 */
public interface BlogService {

    boolean add(Blog blog);

    boolean update(Blog blog);

    boolean del(String blogId);

    Page<Blog> get(String uid, int cuurent, int size);

}
