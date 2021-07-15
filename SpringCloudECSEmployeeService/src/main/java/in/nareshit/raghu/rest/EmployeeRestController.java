package in.nareshit.raghu.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
@RefreshScope
public class EmployeeRestController {

	@Value("${my.app.title}")
	private String title;
	
	@GetMapping("/data")
	public String myData() {
		return "TITLE FROM GIT ->" + title;
	}
}
