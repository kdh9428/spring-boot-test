package xyz.springboot.MySQLRunner;

import java.sql.Connection;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class MySQLRunner implements ApplicationRunner{

	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbctemplate;
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {

		try(Connection connection = dataSource.getConnection()){
			System.out.println(dataSource.getClass());
			System.out.println(connection.getMetaData().getURL());
			System.out.println(connection.getMetaData().getUserName());
			
			Statement createStatement = connection.createStatement();
			String sql ="CREATE TABLE USER(ID INTEGER NOT NULL, NAME VARCHAR(255),PRIMARY KEY(ID))";
			createStatement.execute(sql);
		}
		
	jdbctemplate.execute("insert into user values(1,'dahun')");
		
	}
}
