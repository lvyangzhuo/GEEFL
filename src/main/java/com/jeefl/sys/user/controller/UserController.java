package com.jeefl.sys.user.controller;

import com.jeefl.sys.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by lyz on 2017-10-3.
 */
@RestController
@RequestMapping("sys/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("demo")
    public List userTest(){
        return userService.getUser();
    }

}
