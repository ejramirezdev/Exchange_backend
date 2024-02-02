package dev.exchange.exchangeproject.controller;
import dev.exchange.exchangeproject.inputs.BankAccount.CreateBankAccountInput;
import dev.exchange.exchangeproject.inputs.BankAccount.UpdateBankAccountInput;
import dev.exchange.exchangeproject.models.BankAccount;
import dev.exchange.exchangeproject.service.BankAccountService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;


@Controller
@AllArgsConstructor
public class BankAccountController {

    private final BankAccountService bankAccountService;

    @MutationMapping
    public BankAccount createBankAccount(CreateBankAccountInput createBankAccountInput){
        return bankAccountService.createBankAccout(createBankAccountInput);
    }

    @MutationMapping
    public BankAccount updateBankAccount(UpdateBankAccountInput updateBankAccountInput){
        return bankAccountService.updateBankAccount(updateBankAccountInput);
    }

    @QueryMapping
    public BankAccount findBankAccountById(String id){
        return bankAccountService.findBankAccountById(id);
    }

    @MutationMapping
    public String deleteBankAccountById(String id){
        return bankAccountService.deleteBankAccountById(id);
    }

}
