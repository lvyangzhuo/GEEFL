package com.jeefl.demo.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lyz on 2017-8-6.
 */
@RestController
@EnableAutoConfiguration
public class HelloWorldController {

    @RequestMapping(value = "/hello")
    public String hello(){
        return "Hello World";
    }
}
