package dev.exchange.exchangeproject.inputs.User;

import dev.exchange.exchangeproject.models.ExchangeAccount;
import dev.exchange.exchangeproject.models.User;
import dev.exchange.exchangeproject.models.enums.UserRoles;

import java.util.List;

public record UpdateUserInput(
        String id,
        UserRoles role,
        String email,
        List<User> contacts,
        ExchangeAccount exchangeAccount
) {
}
