package com.jeefl.demo.controller;

import org.springframework.stereotype.Controller;

/**
 * Created by lyz on 2017-9-23.
 */
@Controller
public class JunitTestController {

    public int evaluate(String expression) {
        int sum = 0;
        for (String summand : expression.split("\\+")){
            sum += Integer.valueOf(summand);
        }
        return sum;
    }
}
