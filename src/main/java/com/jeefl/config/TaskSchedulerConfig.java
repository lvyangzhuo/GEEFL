package com.jeefl.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 计划任务配置类
 * Created by lyz on 2017-10-4.
 */
@Configuration
@EnableScheduling
@ComponentScan("com.jeefl.demo.controller")
public class TaskSchedulerConfig {

}
