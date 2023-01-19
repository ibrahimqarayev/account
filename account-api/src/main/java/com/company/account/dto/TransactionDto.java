package com.company.account.dto;

import com.company.account.constant.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {

    private String id;

    private BigDecimal amount;

    private TransactionType transactionType;
    //TransactionType transactionType = TransactionType.INITIAL;

    private LocalDateTime transactionDate;

}
