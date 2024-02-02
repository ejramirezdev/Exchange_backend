package dev.exchange.exchangeproject.service;

import dev.exchange.exchangeproject.exception.ExceptionHandler;
import dev.exchange.exchangeproject.exception.enums.BankAccountExceptionsEnum;
import dev.exchange.exchangeproject.inputs.BankAccount.CreateBankAccountInput;
import dev.exchange.exchangeproject.inputs.BankAccount.UpdateBankAccountInput;
import dev.exchange.exchangeproject.models.BankAccount;
import dev.exchange.exchangeproject.repository.BankAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BankAccountService {


    private final BankAccountRepository bankAccountRepository;


    public BankAccount createBankAccout(CreateBankAccountInput createBankAccountInput) {
        BankAccount bankAccount = new BankAccount(createBankAccountInput.accountNumber(),
                createBankAccountInput.bankName(),
                createBankAccountInput.bankAddress(),
                createBankAccountInput.swiftCode(),
                createBankAccountInput.accountType(),
                createBankAccountInput.accountDni(),
                createBankAccountInput.transactions());
        return bankAccountRepository.save(bankAccount);
    }

    public BankAccount updateBankAccount(UpdateBankAccountInput updateBankAccountInput) {
        BankAccount bankAccount = bankAccountRepository.findById(updateBankAccountInput.id()).orElseThrow(() -> new ExceptionHandler(BankAccountExceptionsEnum.BANK_ACCOUNT_NOT_FOUND.toString()));
        bankAccount.setAccountDni(updateBankAccountInput.accountDni());
        bankAccount.setBankName(updateBankAccountInput.bankName());
        bankAccount.setAccountType(updateBankAccountInput.accountType());
        bankAccount.setBankAddress(updateBankAccountInput.bankAddress());
        bankAccount.setSwiftCode(updateBankAccountInput.swiftCode());
        return bankAccountRepository.save(bankAccount);
    }

    public BankAccount findBankAccountById(String id) {
        return bankAccountRepository.findById(id).orElseThrow(() -> new ExceptionHandler(BankAccountExceptionsEnum.BANK_ACCOUNT_NOT_FOUND.toString()));

    }

    public String deleteBankAccountById(String id) {
        BankAccount response = findBankAccountById(id);
        if (response == null) {
            throw new ExceptionHandler(BankAccountExceptionsEnum.BANK_ACCOUNT_NOT_FOUND.toString());
        }
        bankAccountRepository.deleteById(id);
        return response.getId();
    }

}
