package com.xsw.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xsw.blog.mapper.BlogMapper;
import com.xsw.blog.service.BlogService;
import com.xsw.core.entity.blog.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author xiesw
 * @since 2020/12/25 15:37
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Override
    public boolean add(Blog blog) {
        return blogMapper.insert(blog) == 0;
    }

    @Override
    public boolean update(Blog blog) {
        return blogMapper.updateById(blog) == 0;
    }

    @Override
    public boolean del(String blogId) {
        return blogMapper.deleteById(blogId) == 0;
    }

    @Override
    public Page<Blog> get(String uid, int cuurent, int size) {

        LambdaQueryWrapper<Blog> wrapper = new LambdaQueryWrapper<>();
        if (!StringUtils.isEmpty(uid)) {
            wrapper.eq(Blog::getUid, uid);
        }
        Page<Blog> blogPage = blogMapper.selectPage(new Page<>(cuurent, size), wrapper);

        return blogPage;
    }
}
