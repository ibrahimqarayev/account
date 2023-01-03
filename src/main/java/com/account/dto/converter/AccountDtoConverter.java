package com.account.dto.converter;

import com.account.dto.AccountDto;
import com.account.dto.CustomerAccountDto;
import com.account.model.Account;
import com.account.model.Customer;
import com.account.model.Transaction;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;


@Component
public class AccountDtoConverter {

    private final CustomerDtoConverter customerDtoConverter;
    private final TransactionDtoConverter transactionDtoConverter;

    public AccountDtoConverter(CustomerDtoConverter customerDtoConverter,
                               TransactionDtoConverter transactionDtoConverter) {
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
                        .map(transactionDtoConverter::transactionToTransactionDto)
                        .collect(Collectors.toSet())
        );


    }



}
