package xyz.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.boot.web.reactive.function.client.WebClientCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Application.class);
//		app.setWebApplicationType(WebApplicationType.NONE);
		System.out.println("테스트 확인");
		app.run(args);
	}
	
	/*@Bean
	public WebClientCustomizer webClientCustomizer() {
		return webClientBuilder -> webClientBuilder.baseUrl("http://localhost:8080");
	}

	@Bean
	public RestTemplateCustomizer restTemplateCustomizer() {
		return restTemplate -> restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
	}*/
// 
//	@Bean
//	public ServletWebServerFactory serverFactory() {
//		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
//		tomcat.addAdditionalTomcatConnectors(createStandardConnector());
//		
//		return tomcat;
//	}
//	
//	private Connector createStandardConnector() {
//		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
//		connector.setPort(8080);
//		return connector;
//	}
}
