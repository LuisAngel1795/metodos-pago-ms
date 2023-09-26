package com.ds.metodospago.metodospago;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
public class MetodosPagoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MetodosPagoApplication.class, args);
		context.getBean(DispatcherServlet.class).setThrowExceptionIfNoHandlerFound(true);
	}

}