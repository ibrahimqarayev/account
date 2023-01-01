package com.account.dto.converter;

import com.account.dto.AccountDto;
import com.account.model.Account;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;


@Component
public class AccountDtoConverter {

    private final CustomerDtoConverter customerDtoConverter;
    private final TransactionDtoConverter transactionDtoConverter;

    public AccountDtoConverter(CustomerDtoConverter customerDtoConverter, TransactionDtoConverter transactionDtoConverter) {
        this.customerDtoConverter = customerDtoConverter;
        this.transactionDtoConverter = transactionDtoConverter;
    }

    public AccountDto accountToAccountDto(Account account) {

        return new AccountDto(
                account.getId(),
                account.getBalance(),
                account.getCreationDate(),
                customerDtoConverter.customerToAccountCustomerDto(account.getCustomer()),
                account.getTransaction()
                        .stream()
                        .map(transaction -> transactionDtoConverter.transactionToTransactionDto(transaction))
                        .collect(Collectors.toSet())
        );


    }





}
