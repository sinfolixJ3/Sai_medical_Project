package com.sinfolix.Sai_Samarth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@SpringBootApplication
public class SaiSamarthApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaiSamarthApplication.class, args);
	}

}
