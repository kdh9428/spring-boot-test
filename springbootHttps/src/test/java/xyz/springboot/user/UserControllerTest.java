package xyz.springboot.user;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest
class UserControllerTest {

	@Autowired
	MockMvc mockMvc;
	
//	@Test
//	public void hello() throws Exception {
//		mockMvc.perform(get("/hello"))
//			.andExpect(status().isOk())
//			.andExpect(content().string("hello"));
//	}
	
	@Test
	public void createUser_JSON() throws Exception {
		String userJson = "{\"username\":\"dahun\",\"password\":\"123\"}";
		mockMvc.perform(post("/users/create").contentType(MediaType.APPLICATION_JSON)
				.characterEncoding("UTF-8")
				.accept(MediaType.APPLICATION_JSON)
				.content(userJson))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.username", is(equalTo("dahun"))))
				.andExpect(jsonPath("$.password", is(equalTo("123"))));
	}
	@Test
	public void createUser_XML() throws Exception {
		String userJson = "{\"username\":\"dahun\",\"password\":\"123\"}";
		mockMvc.perform(post("/users/create").contentType(MediaType.APPLICATION_JSON)
				.characterEncoding("UTF-8")
				.accept(MediaType.APPLICATION_XML)
				.content(userJson))
		.andExpect(status().isOk())
		.andExpect(xpath("/User/username").string("dahun"))
		.andExpect(xpath("/User/password").string("123"))
		.andDo(print());
	}
}
