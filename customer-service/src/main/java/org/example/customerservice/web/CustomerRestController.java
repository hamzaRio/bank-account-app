package org.example.customerservice.web;


import org.example.customerservice.entities.Customer;
import org.example.customerservice.repository.CustomerRepository;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class CustomerRestController {
        private CustomerRepository customerRepository;
        public CustomerRestController(CustomerRepository customerRepository) {
            this.customerRepository = customerRepository;
        }
        @GetMapping("/customers")
        public List<Customer> CustomersList() {
            return customerRepository.findAll();
        }
        @GetMapping("/customers/{id}")
        public Customer getCustomerById(@PathVariable Long id) {
            return customerRepository.findById(id).get();
        }
}
