package org.example.accountservice;

import org.example.accountservice.clients.CustomerRestClient;
import org.example.accountservice.entities.BankAccount;
import org.example.accountservice.enums.AccountType;
import org.example.accountservice.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BankAccountRepository repository, CustomerRestClient restClient) {
        return args -> {
            restClient.AllCustomers().forEach(c ->
                    {
                        BankAccount Account1 =  BankAccount.builder()
                                .accountId(UUID.randomUUID().toString())
                                .currency("MAD")
                                .balance(Math.random() * 800000)
                                .createAt(LocalDate.now())
                                .type(AccountType.CURRENT_ACCOUNT)
                                .customerId(c.getCustomerId())
                                .build();
                        BankAccount Account2 = BankAccount.builder()
                                .accountId(UUID.randomUUID().toString())
                                .currency("MAD")
                                .balance(Math.random() * 800000)
                                .createAt(LocalDate.now())
                                .type(AccountType.SAVING_ACCOUNT)
                                .customerId(c.getCustomerId())
                                .build();
                        repository.save(Account1);
                        repository.save(Account2);
                    }
            );


        };
    }

}
