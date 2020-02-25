package com.kuang.edu.controller;


import com.kuang.edu.entity.User;
import com.kuang.edu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lvqs
 * @since 2020-02-25
 */
@RestController
@RequestMapping("/edu/user")
public class UserController {
    @Autowired
    UserService userService;
    /**
     * 查询所有用户
     * @return
     */
    @GetMapping
    public List<User> list(){
       List<User> userList = userService.findAll();
       userList.forEach(System.out::println);
        return userList;
    }
}

