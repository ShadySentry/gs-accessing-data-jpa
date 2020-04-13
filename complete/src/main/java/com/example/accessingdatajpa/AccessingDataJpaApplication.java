package com.example.accessingdatajpa;

import com.example.accessingdatajpa.model.Meal;
import com.example.accessingdatajpa.model.Menu;
import com.example.accessingdatajpa.model.Restaurant;
import com.example.accessingdatajpa.repository.MealRepository;
import com.example.accessingdatajpa.repository.MenuRepository;
import com.example.accessingdatajpa.repository.RestaurantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Collections;

@SpringBootApplication
public class AccessingDataJpaApplication {

	private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(AccessingDataJpaApplication.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", "8083"));
		app.run(args);
//		SpringApplication.run(AccessingDataJpaApplication.class);
	}
//todo: have to be in @Configuration bean. Also can be moved to application.properties and configured to correct dataSource. Code is below:
//	@Bean
//    DataSource dataSource(){
//	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
//	    dataSource.setDriverClassName("org.hsqldb.jdbc.jdbcdriver");
//	    dataSource.setUsername("User");
//	    dataSource.setPassword("123");
//	    dataSource.setUrl("jdbc:hsqldb:file:D:/Temp/dataJpaTest");
//	    return dataSource;
//    }

	@Bean
	public CommandLineRunner demo(MealRepository mealRepository,
								  MenuRepository menuRepository,
								  RestaurantRepository restaurantRepository) {
		return (args) -> {
			// save a few customers
			Meal meal1= new Meal("carpachio", 5000);
			mealRepository.save(meal1);
			Meal meal2 = new Meal("beef", 1000);
			mealRepository.save(meal2);

			Menu menu1 = new Menu("CastelvaniaMenu");
			menuRepository.save(menu1);
			Menu menu2 = new Menu("Torchello's menu");
			menuRepository.save(menu2);

			Restaurant restaurant1 = new Restaurant("Castelvania");
			restaurantRepository.save(restaurant1);
			Restaurant restaurant2 = new Restaurant("Torchello");
			restaurantRepository.save(restaurant2);

			// fetch all customers
			log.info("Meals found with findAll():");
			log.info("-------------------------------");
			for (Meal customer : mealRepository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual meal by ID
			Meal meal = mealRepository.findById(1L).orElse(null);
//			Meal meal = mealRepository.findById(Long.valueOf("1")).orElse(null);
			log.info("Meal found with findById(1):");
			log.info("--------------------------------");
			log.info(meal.toString());
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
			log.info("Found with description 'Torchello's menu':");
			log.info(menuRepository.findByDescription("Torchello's menu").toString());

			log.info("");
			log.info("-------------------------------");
			log.info("find all Restaurants");
			for(Restaurant restaurant:restaurantRepository.findAll()){
				log.info(restaurant.toString());
			}

			log.info("");
			log.info("");
			log.info("-------------------------------");
			log.info("adding relations");
			meal1.addMenu(menu1);

			Meal updatedMeal= mealRepository.save(meal1);
			log.info("updated meal: "+updatedMeal.getDescription()+"-> \n" + updatedMeal);

			Menu updatedMenu = menuRepository.findById(menu1.getId()).orElse(null);
			log.info("updatedMenu: "+"\n" + updatedMenu);
			restaurant1.addMenu(menu1);
			restaurant2.addMenu(menu2);

			Restaurant updatedRestaurant1 = restaurantRepository.save(restaurant1);
			Restaurant updatedRestaurant2 = restaurantRepository.save(restaurant2);
			log.info("-------------------------------");
			log.info("find all updated restaurants");
			for(Restaurant restaurant: restaurantRepository.findAll()){
				log.info(restaurant.toString());
			}

			log.info("");
			log.info("find restaurant by id");
			log.info(restaurantRepository.findById(restaurant1.getId()).toString());

			log.info("");
			log.info("find restaurant by description");
			log.info(restaurantRepository.findByDescription(restaurant2.getDescription()).toString());
			log.info("-------------------------------");

			log.info("");
			log.info("updated menu");
			for (Menu menuWithRestaurant:menuRepository.findAll()){
				log.info(menuWithRestaurant.toString());
			}


			log.info("-------------------------------");
		};
	}

}
