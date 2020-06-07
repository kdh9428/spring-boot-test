package xyz.springboot.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(HomeController.class)
@ExtendWith(SpringExtension.class)
class HomeControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@Test
	void hello() throws Exception {
		
		mockMvc.perform(get("/hello")
				 .accept(MediaType.TEXT_HTML))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(view().name("hello"));
	}
	@Test
	void my() throws Exception {
		
		mockMvc.perform(get("/my"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(view().name("my"));
	}
}
