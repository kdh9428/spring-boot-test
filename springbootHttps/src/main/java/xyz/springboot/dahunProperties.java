package xyz.springboot;

import java.time.Duration;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@ConfigurationProperties("dahun")
@Validated
public class dahunProperties {

	@NotEmpty
	@Size(min=10)
	private String name;

	@Min(5)
	@Max(10)
	private int age;
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	private Duration sessionTimeOut = Duration.ofSeconds(30);
	
	public Duration getSessionTimeOut() {
		return sessionTimeOut;
	}

	public void setSessionTimeOut(Duration sessionTimeOut) {
		this.sessionTimeOut = sessionTimeOut;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
