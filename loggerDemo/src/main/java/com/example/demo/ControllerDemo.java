package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerDemo {
	@RequestMapping(method = RequestMethod.POST, path = "/aa")
	public void sayHello() {
		Logger logger = LoggerFactory.getLogger(ControllerDemo.class);
		logger.info("Pushed  log to azure app insight with with slf4j on 26 Jul ");
		System.out.println("dfds");
	}
}
