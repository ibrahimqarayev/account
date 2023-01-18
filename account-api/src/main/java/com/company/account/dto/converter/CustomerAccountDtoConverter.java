package com.company.account.dto.converter;

import com.company.account.dto.CustomerAccountDto;
import com.company.account.model.Account;
import org.springframework.stereotype.Component;

import java.util.Objects;
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
