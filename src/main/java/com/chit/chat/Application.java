package com.chit.chat;


import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;


@SpringBootApplication
@EnableDiscoveryClient
@PropertySource("classpath:persistence-mysql.properties")
public class Application {
	
	/*
	@Autowired
	
	private Environment env;
	
	// set up a logger for diagnostics
	
	private Logger logger = Logger.getLogger(getClass().getName());
	@Bean
	public DataSource securityDataSource() {
		
		// create connection pool
		ComboPooledDataSource securityDataSource
									= new ComboPooledDataSource();
				
		// set the jdbc driver class
		
		try {
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException exc) {
			throw new RuntimeException(exc);
		}
		
		// log the connection props
		// for sanity's sake, log this info
		// just to make sure we are REALLY reading data from properties file
		
		logger.info(">>> jdbc.url=" + env.getProperty("jdbc.url"));
		logger.info(">>> jdbc.user=" + env.getProperty("jdbc.user"));
		
		
		// set database connection props
		
		securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDataSource.setUser(env.getProperty("jdbc.user"));
		securityDataSource.setPassword(env.getProperty("jdbc.password"));
		
		// set connection pool props
		
		securityDataSource.setInitialPoolSize(
				getIntProperty("connection.pool.initialPoolSize"));

		securityDataSource.setMinPoolSize(
				getIntProperty("connection.pool.minPoolSize"));

		securityDataSource.setMaxPoolSize(
				getIntProperty("connection.pool.maxPoolSize"));

		securityDataSource.setMaxIdleTime(
				getIntProperty("connection.pool.maxIdleTime"));
		
		return securityDataSource;
	}
	
	// need a helper method 
	// read environment property and convert to int
	

	private int getIntProperty(String propName) {

		String propVal = env.getProperty(propName);
		
		// now convert to int
		int intPropVal = Integer.parseInt(propVal);
		
		return intPropVal;
	}

*/
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
    @Bean(name = "dataSource")
	public DriverManagerDataSource dataSource() throws SQLException {
	    DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
	    driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/vchat?useSSL=false");
	    driverManagerDataSource.setUsername("hbstudent");
	    driverManagerDataSource.setPassword("hbstudent");
	    System.out.println(driverManagerDataSource.getConnection().isClosed());
	    return driverManagerDataSource;
	}
	
  
}
