package com.company.account.dto.converter;

import com.company.account.dto.AccountCustomerDto;
import com.company.account.dto.CustomerDto;
import com.company.account.model.Customer;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CustomerDtoConverter {


    private final CustomerAccountDtoConverter customerAccountDtoConverter;

    public CustomerDtoConverter(CustomerAccountDtoConverter customerAccountDtoConverter) {
        this.customerAccountDtoConverter = customerAccountDtoConverter;
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

    public CustomerDto customerToCustomerDto(Customer customer) {

        return new CustomerDto(
                customer.getId(),
                customer.getName(),
                customer.getSurname(),
                customer.getAccounts()
                        .stream()
                        .map(customerAccountDtoConverter::accountToCustomerAccountDto)
                        .collect(Collectors.toSet())
        );
    }


}
