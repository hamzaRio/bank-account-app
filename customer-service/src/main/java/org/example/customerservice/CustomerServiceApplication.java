package org.example.customerservice;

import org.example.customerservice.config.GlobalConfig;
import org.example.customerservice.entities.Customer;
import org.example.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties({GlobalConfig.class})
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository ) {
		return args -> {
			List<Customer> customerList = List.of(
					Customer.builder()
							.firstname("john")
							.lastname("smith")
							.email("john@example.com")
							.build(),
					Customer.builder()
							.firstname("Emily")
							.lastname("stain")
							.email("emily@gmail.com")
							.build()
			);

			customerRepository.saveAll(customerList);
		};
	}

}
