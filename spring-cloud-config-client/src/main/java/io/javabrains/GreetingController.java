package io.javabrains;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class GreetingController {

	Logger log = LoggerFactory.getLogger(GreetingController.class);

	@Value("${my.greeting:default value msg}")
	private String greetMessage;

	@Value("Hello static msg")
	private String staticMsg;

	@Value("${my.list.names}")
	private List<String> listValues;

	@Value("#{${dbValues}}")
	private Map<String, String> dbValues;

	private @Autowired DBSetting dbSetting;

	private @Autowired Environment environment;

	@GetMapping("/greeting")
	public String greeting() {
//		return "Hello from rest controller";
		return greetMessage + " " + staticMsg + " " + listValues + " " + dbValues;
	}

	@GetMapping("/staticMsg")
	public String staticMsg() {
//		return "Hello from rest controller";
		return staticMsg;
	}

	@GetMapping("/dbSetting")
	public String dbSetting() {
		log.trace("Inside GreetingController class dbSetting invoked");
		return dbSetting.getConnection() + " " + dbSetting.getHost() + " " + dbSetting.getPort();
	}

	@GetMapping("/envDetails")
	public String envDetails() {
		return environment.toString();
//		return environment.getActiveProfiles();
	}

}
