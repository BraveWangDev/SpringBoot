package com.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Brave on 16/10/9.
 *
 * 注意:
 *      这里要使用@Controller注解
 *      而不要使用@RestController
 *      否则return "hello";不能跳转到hello.html
 */
@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @RequestMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("hello", "hello Thymeleaf!");
        return "hello";
    }

}


