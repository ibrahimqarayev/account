package com.company.account.service;

import com.company.account.dto.AccountDto;
import com.company.account.dto.request.CreateAccountRequest;
import com.company.account.dto.converter.AccountDtoConverter;
import com.company.account.model.Account;
import com.company.account.model.Customer;
import com.company.account.model.Transaction;
import com.company.account.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.function.Supplier;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final CustomerService customerService;
    private final AccountDtoConverter converter;


    public AccountService(AccountRepository accountRepository,
                          CustomerService customerService,
                          AccountDtoConverter converter, Clock clock, Supplier<UUID> uuidSupplier) {
        this.accountRepository = accountRepository;
        this.customerService = customerService;
        this.converter = converter;
    }

    public AccountDto createAccount(CreateAccountRequest createAccountRequest) {
        Customer customer = customerService.findCustomerById(createAccountRequest.getCustomerId());

        Account account = new Account(
                customer,
                createAccountRequest.getInitialCredit(),
                LocalDateTime.now()
        );


        if (createAccountRequest.getInitialCredit().compareTo(BigDecimal.ZERO) > 0) {
            Transaction transaction = new Transaction(
                    createAccountRequest.getInitialCredit(), account);
            account.getTransaction().add(transaction);
        }
        return converter.accountToAccountDto(accountRepository.save(account));
    }


}
