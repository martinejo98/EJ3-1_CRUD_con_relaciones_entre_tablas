package com.example.BS9_Clase_RestTemplate_Usos_con_Feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.example.BS9_Clase_RestTemplate_Usos_con_Feign.feign")
public class BS9_Clase_RestTemplate_Usos_con_Feign {

	public static void main(String[] args) {
		SpringApplication.run(BS9_Clase_RestTemplate_Usos_con_Feign.class, args);
	}

}
