package com.jxl.redis;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {
			SpringApplication.run(Application.class, args);
			System.out.println("Start to test connect redis");
			UserService userService = (UserService) SpringUtil.getBean("userService");
			String aaaa = userService.getString("aaaa");
			System.out.println(aaaa);
		}

	
	
	}

