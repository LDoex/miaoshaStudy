package com.oyyk.miaosha.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.transform.Result;
import java.util.AbstractList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

@Controller
@RequestMapping("/demo")
public class SampleController {
    @RequestMapping("/thymeleaf")
    public String thymeleaf(Model model) {
        model.addAttribute("name", "oyyk");
        return "hello";
    }

}
