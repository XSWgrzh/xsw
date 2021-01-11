package com.xsw.blog.service;

import com.xsw.core.entity.blog.BlogSort;
import org.springframework.data.domain.Page;

/**
 * @author xiesw
 * @since 2021/1/6 16:26
 */
public interface BlogSortService {
    boolean add(BlogSort blog);

    boolean update(BlogSort blogSort);

    boolean del(String blogSortId);

    Page<BlogSort> get(String uid, int current, int size);
}
