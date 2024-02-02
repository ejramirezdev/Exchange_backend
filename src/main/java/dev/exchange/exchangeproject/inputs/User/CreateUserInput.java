package dev.exchange.exchangeproject.inputs.User;

import dev.exchange.exchangeproject.models.ExchangeAccount;
import dev.exchange.exchangeproject.models.PlatformUser;
import dev.exchange.exchangeproject.models.enums.UserRoles;

import java.util.List;

public record CreateUserInput(
        UserRoles role,
        String email,
        List<PlatformUser> contacts,
        ExchangeAccount exchangeAccount
) {
}
