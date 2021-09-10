package com.oyyk.miaosha.controller;

import com.oyyk.miaosha.domain.User;
import com.oyyk.miaosha.redis.RedisService;
import com.oyyk.miaosha.result.Result;
import com.oyyk.miaosha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.AbstractList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

@Controller
@RequestMapping("/demo")
public class SampleController {
    @Autowired
    UserService userService;

    @Autowired
    RedisService redisService;

    @RequestMapping("/thymeleaf")
    public String thymeleaf(Model model) {
        model.addAttribute("name", "oyyk");
        return "hello";
    }

    @RequestMapping("/db/get")
    @ResponseBody
    public Result<User> dbGet() {
        User user = userService.getById(1);
        return  Result.success(user);
    }

    @RequestMapping("/db/tx")
    @ResponseBody
    public Result<Boolean> dbTx() {
        userService.tx();
        return  Result.success(true);
    }

    @RequestMapping("/redis/get")
    @ResponseBody
    public Result<Long> redisGet() {
        Long v1 = redisService.get("key1", Long.class);
        return Result.success(v1);
    }
    @RequestMapping("/redis/set")
    @ResponseBody
    public Result<String> redisSet() {
        boolean v1 = redisService.set("key2", "hello,imooc");
        String str = redisService.get("key2", String.class);
        return Result.success(str);
    }
}
