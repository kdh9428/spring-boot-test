package xyz.springboot.controller;


import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlHeading1;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

@ExtendWith(SpringExtension.class)
@WebMvcTest(SimpleController.class)
class SimpleControllerTest {

	@Autowired
	WebClient webClient;
	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	@Disabled
	public void hello() throws Exception {
		HtmlPage page = webClient.getPage("/hello");
		HtmlHeading1 h1 =  page.getFirstByXPath("//h1");
		assertThat(h1.getTextContent()).isEqualToIgnoringCase("dahun");
	}
	
	@Test
	public void hateoas() throws Exception{
		mockMvc.perform(get("/test"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$._links.self").exists());
	}
}
