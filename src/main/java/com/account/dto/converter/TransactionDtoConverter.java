package com.account.dto.converter;

import com.account.dto.TransactionDto;
import com.account.model.Transaction;
import org.springframework.stereotype.Component;


@Component
public class TransactionDtoConverter {

    public TransactionDto convert(Transaction transaction) {
        return new TransactionDto(
                transaction.getId(),
                transaction.getAmount(),
                transaction.getTransactionType(),
                transaction.getTransactionDate()
        );
    }


}
