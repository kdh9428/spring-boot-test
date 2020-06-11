package xyz.springboot.account;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Optional;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@DataJpaTest
class AccountRepositoryTest {

	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	AccountRepository accountRepository;
	
	@Test
	public void id() throws SQLException {
		
//		try(Connection connection = dataSource.getConnection();) {
//			DatabaseMetaData metaData = connection.getMetaData();
//			System.out.println(metaData.getURL());
//			System.out.println(metaData.getDriverName());
//			System.out.println(metaData.getUserName());
//		}
		Account account = new Account();
		account.setUsername("dahun");
		account.setPassword("123");
		
		Account newAccount = accountRepository.save(account);
		assertThat(newAccount).isNotNull();
		
		Optional<Account> existingAccount = accountRepository.findByUsername(newAccount.getUsername());
		assertThat(existingAccount).isNotEmpty();
		
		
		Optional<Account> nonExistingAccount = accountRepository.findByUsername("asdf");
		assertThat(nonExistingAccount).isEmpty();
		
		
		
	}
}
