package com.company.account.service;

import com.company.account.dto.converter.CustomerDtoConverter;
import com.company.account.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

public class CustomerServiceTest {

    private CustomerRepository customerRepository;
    private CustomerDtoConverter customerDtoConverter;

    @BeforeEach
    void setUp() {
        customerRepository = Mockito.mock(CustomerRepository.class);
        customerDtoConverter = Mockito.mock(CustomerDtoConverter.class);
    }
}
