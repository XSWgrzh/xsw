package com.xsw.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xsw.blog.mapper.BlogMapper;
import com.xsw.blog.mapper.BlogSortMapper;
import com.xsw.blog.service.BlogSortService;
import com.xsw.core.entity.blog.Blog;
import com.xsw.core.entity.blog.BlogSort;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * @author xiesw
 * @since 2021/1/6 16:28
 */
@Service
public class BlogSortServiceImpl implements BlogSortService {

    @Autowired
    private BlogSortMapper blogSortMapper;
    @Autowired
    private BlogMapper blogMapper;

    @Override
    public boolean add(BlogSort blog) {
        // blog.setBlogSortId(IdUtil.simpleUUID());

        return blogSortMapper.insert(blog) == 1;
    }

    @Override
    public boolean update(BlogSort blogSort) {
        return blogSortMapper.updateById(blogSort) == 1;
    }

    @Override
    @GlobalTransactional
    public boolean del(String blogSortId) {

        blogMapper.delete(new LambdaQueryWrapper<Blog>().eq(Blog::getBlogSortId, blogSortId));
        int x = 1 / 0;
        int delete = blogSortMapper.deleteById(blogSortId);
        return delete == 1;
    }

    @Override
    public Page<BlogSort> get(String uid, int current, int size) {
        return null;
    }
}
