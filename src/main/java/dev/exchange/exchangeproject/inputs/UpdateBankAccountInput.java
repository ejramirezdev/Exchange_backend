package dev.exchange.exchangeproject.inputs;

import dev.exchange.exchangeproject.models.Transaction;
import dev.exchange.exchangeproject.models.enums.AccountType;

import java.util.List;

public record UpdateBankAccountInput(
        String id,
        String accountNumber,
        String bankName,
        String bankAddress,
        String swiftCode,
        AccountType accountType,
        Long accountDni,
        List<Transaction> transactions
) {
}
