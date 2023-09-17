package com.pazbelloso.loginproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication(scanBasePackages={"com.pazbelloso.loginproject"} )
//@ComponentScan("com.pazbelloso.loginproject")
public class LoginProjectApplication {
	public static void main(String[] args) {
		SpringApplication.run(LoginProjectApplication.class, args);
	}

}
