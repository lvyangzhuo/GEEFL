package com.jeefl.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lyz
 * @date 2017-10-23
 */
@Controller
public class VueController {

    @RequestMapping("vue")
    public String vue(){
        return "vue";
    }
}
