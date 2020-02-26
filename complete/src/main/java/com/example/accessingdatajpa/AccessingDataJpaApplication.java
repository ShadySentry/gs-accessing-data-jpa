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
	public CommandLineRunner demo(MealRepository mealRepository, MenuRepository menuRepository) {
		return (args) -> {
			// save a few customers
			mealRepository.save(new Meal("carpachio", 5000));
			mealRepository.save(new Meal("beef",1000));

			menuRepository.save(new Menu("CastelvaniaMenu"));
			menuRepository.save(new Menu("Torchello"));

			// fetch all customers
			log.info("Meals found with findAll():");
			log.info("-------------------------------");
			for (Meal customer : mealRepository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			Meal customer = mealRepository.findById(1);
			log.info("Meal found with findById(1):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");

			// fetch customers by last name
			log.info("Meal found with description('beef'):");
			log.info("--------------------------------------------");
			mealRepository.findByDescription("beef").forEach(beef -> {
				log.info(beef.toString());
			});
			// for (Customer bauer : mealRepository.findByLastName("Bauer")) {
			// 	log.info(bauer.toString());
			// }

			log.info("");
			log.info("Menus found with findAll():");
			log.info("-------------------------------");
			for (Menu menu:menuRepository.findAll()){
				log.info(menu.toString());
			}

			log.info("");
			log.info("Menu found with id");
			Menu menu = menuRepository.findById(3L).orElse(null);
			log.info(menu.toString());



			log.info("");
			log.info("Found with description 'Torchello':");
			log.info(menuRepository.findByDescription("Torchello").toString());


			log.info("-------------------------------");
			log.info("-------------------------------");
		};
	}

}
