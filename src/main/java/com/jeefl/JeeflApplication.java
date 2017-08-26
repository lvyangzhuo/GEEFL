package com.jeefl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;

@SpringBootApplication
public class JeeflApplication implements EmbeddedServletContainerCustomizer {

	public static void main(String[] args) {
		SpringApplication.run(JeeflApplication.class, args);
	}

	/**
	 * 实现 EmbeddedServletContainerCustomizer 接口
	 * 设置spring boot 内置tomcat端口号
	 * @param container
	 */
	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		container.setPort(8070);
	}
}
