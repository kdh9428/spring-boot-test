package xyz.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Component
public class RestRunner implements ApplicationRunner{

	@Autowired
	WebClient.Builder builder;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		WebClient webClient = builder
				.baseUrl("http://localhost:8080")
				.build();
		
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		//TODO /hello
		Mono<String> restMono = webClient.get().uri("/rest")
						.retrieve()
						.bodyToMono(String.class);
		restMono.subscribe(s->{
			System.out.println(s);

			if(stopWatch.isRunning()) {
				stopWatch.stop();
			}
			System.out.println(stopWatch.prettyPrint());
			stopWatch.start();
		});
		
		
		//TODO /word
		Mono<String> wordMono = webClient.get().uri("/word")
				.retrieve()
				.bodyToMono(String.class);
		wordMono.subscribe(s->{
			System.out.println(s);
			
			if(stopWatch.isRunning()) {
				stopWatch.stop();
			}
			System.out.println(stopWatch.prettyPrint());
			stopWatch.start();
		});
		
		
		
		
	}
}
