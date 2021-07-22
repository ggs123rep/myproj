package dru.eureka.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
@RefreshScope
public class ConsumerApp {
	
	@Value("${my.app.title}")
	private String title;
	
	@GetMapping("/data")
	public String showEmpProfile() {
		return "FROM PROFILE SERVICE" + title ;
	}
}
