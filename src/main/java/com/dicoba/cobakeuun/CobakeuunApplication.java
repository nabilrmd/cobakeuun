package com.dicoba.cobakeuun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@EnableWebMvc
@SpringBootApplication
//@EnableSwagger2
public class CobakeuunApplication {

	public static void main(String[] args) {
		SpringApplication.run(CobakeuunApplication.class, args);
	}

}
