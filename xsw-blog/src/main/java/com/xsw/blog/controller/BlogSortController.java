package com.xsw.blog.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.xsw.blog.service.BlogSortService;
import com.xsw.core.entity.blog.BlogSort;
import com.xsw.core.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author xiesw
 * @since 2021/1/6 16:24
 */
@Slf4j
@RestController
@RequestMapping("/blogSort")
public class BlogSortController {

    @Autowired
    private BlogSortService blogSortService;

    @PostMapping
    public Result add(BlogSort blogSort) {
        return new Result(blogSortService.add(blogSort));
    }

    @PutMapping
    public Result update(BlogSort blogSort) {
        return new Result(blogSortService.update(blogSort));
    }

    @DeleteMapping
    public Result del(String blogSortId) {
        return new Result(blogSortService.del(blogSortId));
    }

    @GetMapping
    @SentinelResource(value = "getblog", blockHandler = "get")
    public Result get(String uid, int current, int size) {
        return new Result(blogSortService.get(uid, current, size));
    }

    public Result get(String uid, int current, int size, BlockException exception) {
        return Result.build(900, "访问速度太块啦");
    }

}
