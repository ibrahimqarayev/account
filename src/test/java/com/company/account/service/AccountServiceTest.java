package com.company.account.service;

import com.company.account.dto.converter.AccountDtoConverter;
import com.company.account.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

public class AccountServiceTest {

    private AccountService accountService;
    private AccountRepository accountRepository;
    private CustomerService customerService;
    private AccountDtoConverter accountDtoConverter;


    @BeforeEach
    void setUp() {
        accountRepository = Mockito.mock(AccountRepository.class);
        customerService = Mockito.mock(CustomerService.class);
        accountDtoConverter = Mockito.mock(AccountDtoConverter.class);
        accountService = new AccountService(accountRepository, customerService, accountDtoConverter);

    }


}