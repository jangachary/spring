package com.pz.h2demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 
 * @author jangachary
 *
 */

@ComponentScan("com.pz")
@SpringBootApplication
@ComponentScan({ "com.pz", "" })
@EnableTransactionManagement
//@EnableWebSecurity
@EnableJpaRepositories("com.pz")
@EntityScan(basePackages = "com.pz.beans")

public class H2DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(H2DemoApplication.class, args);
	}
}
