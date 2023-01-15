package com.company.account;

import com.company.account.model.Customer;
import com.company.account.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;


@SpringBootApplication
public class AccountApiApplication implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    public AccountApiApplication(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(AccountApiApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Customer customer = customerRepository.save(new Customer("", "Ibrahim", "Qarayev", new HashSet<>()));
        System.out.println(customer);
    }
}
