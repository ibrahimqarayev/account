package com.account.dto.converter;

import com.account.dto.TransactionDto;
import com.account.model.Transaction;
import org.springframework.stereotype.Component;


@Component
public class TransactionDtoConverter {

    public TransactionDto transactionToTransactionDto(Transaction transaction) {

        return new TransactionDto(
                transaction.getId(),
                transaction.getAmount(),
                transaction.getTransactionType(),
                transaction.getTransactionDate()
        );

    }

}
