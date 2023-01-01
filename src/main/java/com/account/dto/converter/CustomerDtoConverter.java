package com.account.dto.converter;

import com.account.dto.AccountCustomerDto;
import com.account.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerDtoConverter {

    private final TransactionDtoConverter transactionDtoConverter;

    public CustomerDtoConverter(TransactionDtoConverter transactionDtoConverter) {
        this.transactionDtoConverter = transactionDtoConverter;
    }

    public AccountCustomerDto customerToAccountCustomerDto(Customer customer) {

        if (customer == null) {
            return new AccountCustomerDto("", "", "");
        }

        return new AccountCustomerDto(
                customer.getId(),
                customer.getName(),
                customer.getSurname()
        );


    }


}
