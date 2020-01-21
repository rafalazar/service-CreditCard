package com.rafalazar.bootcamp.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

@EnableEurekaClient
@SpringBootApplication
public class ServiceCreditCardApplication implements CommandLineRunner{

	@Autowired
	private ReactiveMongoTemplate mongoTemplate;
	
	private static final Logger log = LoggerFactory.getLogger(ServiceCreditCardApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ServiceCreditCardApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		mongoTemplate.dropCollection("creditCard").subscribe();
		log.info("Collection deleted.");
	}

}
