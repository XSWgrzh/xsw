package com.xsw.blog.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.xsw.blog.service.BlogService;
import com.xsw.core.entity.blog.Blog;
import com.xsw.core.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author xiesw
 * @since 2020/12/25 15:32
 */
@Slf4j
@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping
    public Result add(Blog blog) {
        return new Result(blogService.add(blog));
    }

    @PutMapping
    public Result update(Blog blog) {
        return new Result(blogService.update(blog));
    }

    @DeleteMapping
    public Result del(String blogId) {
        return new Result(blogService.del(blogId));
    }

    @GetMapping
    @SentinelResource(value = "getblog", blockHandler = "get")
    public Result get(String uid, int current, int size) {
        return new Result(blogService.get(uid, current, size));
    }

    public Result get(String uid, int current, int size, BlockException exception) {
        return Result.build(900, "访问速度太块啦");
    }


}
