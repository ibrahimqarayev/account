package com.account.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Data
public class AccountDto {

    private String id;

    private BigDecimal balance = BigDecimal.ZERO;

    private LocalDateTime creationDate;

    private AccountCustomerDto customer;

    private Set<TransactionDto> transactions;

}
