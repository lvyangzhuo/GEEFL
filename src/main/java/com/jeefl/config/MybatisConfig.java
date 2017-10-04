package com.jeefl.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by lyz on 2017-10-4.
 */
@Configuration
@MapperScan({"com.jeefl.**.**.mapper*"})
public class MybatisConfig {
}
