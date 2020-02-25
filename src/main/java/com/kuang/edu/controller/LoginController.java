package com.kuang.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: lqs
 * @Date: 2020/2/25 15:17
 */
@Controller
public class LoginController {

    /**
     * 登陆界面
     * @return
     */
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

}
