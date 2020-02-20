package com.example.accessingdatajpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataJpaApplication {

	private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AccessingDataJpaApplication.class);
	}

	@Bean
	public CommandLineRunner demo(MealRepository repository) {
		return (args) -> {
			// save a few customers
			repository.save(new Meal("carpachio", 5000));
			repository.save(new Meal("beef",1000));
			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Meal customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			Meal customer = repository.findById(1);
			log.info("Meal found with findById(1):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");

			// fetch customers by last name
			log.info("Meal found with description('beef'):");
			log.info("--------------------------------------------");
			repository.findByDescription("beef").forEach(beef -> {
				log.info(beef.toString());
			});
			// for (Customer bauer : repository.findByLastName("Bauer")) {
			// 	log.info(bauer.toString());
			// }
			log.info("");
		};
	}

}
