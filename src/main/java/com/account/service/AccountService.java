package com.account.service;

import com.account.dto.AccountDto;
import com.account.dto.CreateAccountRequest;
import com.account.model.Account;
import com.account.model.Customer;
import com.account.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final CustomerService customerService;

    public AccountService(AccountRepository accountRepository, CustomerService customerService) {
        this.accountRepository = accountRepository;
        this.customerService = customerService;
    }

    public AccountDto createAccount(CreateAccountRequest createAccountRequest) {
        Customer customer = customerService.findById(createAccountRequest.getCustomerId());

        Account account=new Account(
                customer,
                createAccountRequest.getInitialCredit(),
                LocalDateTime.now()
        );

    }

}
