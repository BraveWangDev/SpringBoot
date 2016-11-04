package com.example.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Brave on 16/11/4.
 */
@RestController
public class helloController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String viewHome() {
        return "hello SpringSecurity";
    }

}
