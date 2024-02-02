package dev.exchange.exchangeproject.controller;

import dev.exchange.exchangeproject.inputs.User.CreateUserInput;
import dev.exchange.exchangeproject.inputs.User.UpdateUserInput;
import dev.exchange.exchangeproject.models.User;
import dev.exchange.exchangeproject.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @QueryMapping
    public User findUserById(String id) {
        return userService.findUserById(id);
    }

    @MutationMapping
    public User createUser(CreateUserInput createUserInput) {
        return userService.createUser(createUserInput);
    }

    @MutationMapping
    public User updateUser(UpdateUserInput updateUserInput) {
        return userService.updateUser(updateUserInput);
    }

    @MutationMapping
    public String deleteUserById(String id) {
        return userService.deleteUserById(id);
    }
}
