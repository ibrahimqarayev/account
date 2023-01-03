package com.account.dto.converter;

import com.account.dto.CustomerAccountDto;
import com.account.dto.TransactionDto;
import com.account.model.Account;
import com.account.model.Transaction;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CustomerAccountDtoConverter {

    private final TransactionDtoConverter converter;

    public CustomerAccountDtoConverter(TransactionDtoConverter converter) {
        this.converter = converter;
    }

    public CustomerAccountDto accountToCustomerAccountDto(Account account) {

        return new CustomerAccountDto(
                Objects.requireNonNull(account.getId()),
                account.getBalance(),
                account.getCreationDate(),
                account.getTransaction()
                        .stream()
                        .map(converter::transactionToTransactionDto)
                        .collect(Collectors.toSet())

        );
    }


}
