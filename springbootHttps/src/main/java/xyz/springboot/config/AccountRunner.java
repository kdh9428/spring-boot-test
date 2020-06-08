package xyz.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import xyz.springboot.account.Account;
import xyz.springboot.account.AccountService;

@Component
public class AccountRunner implements ApplicationRunner{
	
	@Autowired
	AccountService accountService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Account test = accountService.createAccount("dahun","1234");
	}
}
