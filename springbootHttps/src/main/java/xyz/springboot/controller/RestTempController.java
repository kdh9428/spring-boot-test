package xyz.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class RestTempController {

	@GetMapping("/rest")
	public String rest() throws InterruptedException {
		Thread.sleep(5000l);
		return "rest";
	}
	
	@GetMapping("/word")
	public String word() throws InterruptedException {
		Thread.sleep(3000l);
		return "word";
	}
}
