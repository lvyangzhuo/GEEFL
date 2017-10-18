package com.jeefl.sys.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lyz
 * @date 2017-10-17
 */
@Controller
public class LoginController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
