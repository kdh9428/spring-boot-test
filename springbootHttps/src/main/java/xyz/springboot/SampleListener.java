package xyz.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


@Component
public class SampleListener implements ApplicationListener<ApplicationStartedEvent>{
	
	
	@Autowired
	dahunProperties pro;
	
	private Logger logger = LoggerFactory.getLogger(SampleListener.class);

	@Override
	public void onApplicationEvent(ApplicationStartedEvent event) {
		
		logger.debug("============================");
		logger.debug(pro.getName());
		logger.debug("숫자는 안되네");
		logger.info("============================");
		
		
		System.out.println("========================");
		System.out.println("Application is starting");
		System.out.println(pro.getSessionTimeOut());
		System.out.println(pro.getName());
		System.out.println(pro.getAge());
		System.out.println("========================");
	}
}
