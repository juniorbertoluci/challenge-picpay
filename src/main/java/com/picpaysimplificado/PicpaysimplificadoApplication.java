package com.picpaysimplificado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableCaching
@EnableScheduling
@EnableAsync
public class PicpaysimplificadoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PicpaysimplificadoApplication.class, args);
	}

}
