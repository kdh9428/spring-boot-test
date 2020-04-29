package xyz.springboot.user;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

	@PostMapping("/users/create")
	public @ResponseBody User create(@RequestBody User user) {
		System.out.println("여기 들어옴");
		return user;
	}
	
	@GetMapping("/hel")
	public @ResponseBody Map<String, Object> test() throws Exception{
		ObjectMapper json = new ObjectMapper();
		
		Map<String, Object> tt = new HashMap<String, Object>();
		User user = new User();
		user.setUsername("test");
		user.setPassword("123");
		tt.put("te", "ttt");
		tt.put("ts", "ttt");
		tt.put("td", "ttt");
		tt.put("tr", "ttt");
		tt.put("User", user);
		json.writeValueAsString(tt);
		System.out.println(json);
		return tt;
	}
}
