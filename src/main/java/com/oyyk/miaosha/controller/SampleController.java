package com.oyyk.miaosha.controller;

import com.oyyk.miaosha.domain.User;
import com.oyyk.miaosha.redis.RedisService;
import com.oyyk.miaosha.redis.UserKey;
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
    public Result<User> redisGet() {
        User user = redisService.get(UserKey.getById,""+1, User.class);
        return Result.success(user);
    }
    @RequestMapping("/redis/set")
    @ResponseBody
    public Result<Boolean> redisSet() {
        User user = new User();
        user.setId(1);
        user.setName("1111");
        redisService.set(UserKey.getById,""+1, user);

        return Result.success(true);
    }
}
