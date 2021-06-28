package io.javabrains;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication 
public class FeignClientDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignClientDataApplication.class, args);
	}

}
