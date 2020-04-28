package xyz.springboot.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

	@GetMapping("/hello")
	public String hello() {
		System.out.println("테스트 확인");
		return "test";
	}
	
	@PostMapping("/users/create")
	public @ResponseBody User create(@RequestBody User user) {
		System.out.println("여기 들어옴");
		return user;
	}
}
