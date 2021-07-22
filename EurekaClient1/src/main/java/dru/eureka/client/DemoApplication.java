package dru.eureka.client;
//testetstet
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DemoApplication {
//main
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
