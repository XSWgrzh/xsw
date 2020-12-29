package com.xsw.blog.rpc;

import com.xsw.core.entity.blog.Blog;
import com.xsw.core.rpc.blog.BlogService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author xiesw
 * @since 2020/12/25 12:02
 */
@Service
public class BlogServiceProvice implements BlogService {

    @Override
    public boolean add(Blog blog) {
        return new Blog() != null;
    }
}
