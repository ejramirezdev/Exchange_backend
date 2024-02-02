package dev.exchange.exchangeproject.service;

import dev.exchange.exchangeproject.exception.ExceptionHandler;
import dev.exchange.exchangeproject.exception.enums.UserExceptionsEnum;
import dev.exchange.exchangeproject.inputs.User.CreateUserInput;
import dev.exchange.exchangeproject.inputs.User.UpdateUserInput;
import dev.exchange.exchangeproject.models.User;
import dev.exchange.exchangeproject.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User createUser(CreateUserInput createUserInput) {
        User user = new User(createUserInput.role(),
                createUserInput.email(),
                createUserInput.contacts(),
                createUserInput.exchangeAccount());
        return userRepository.save(user);
    }

    public User updateUser(UpdateUserInput updateUserInput) {
        User user = userRepository.findById(updateUserInput.id()).orElseThrow(() -> new ExceptionHandler(UserExceptionsEnum.USER_NOT_FOUND.toString()));
        user.setRole(updateUserInput.role());
        user.setContacts(updateUserInput.contacts());
        user.setEmail(updateUserInput.email());
        user.setExchangeAccount(updateUserInput.exchangeAccount());
        return userRepository.save(user);
    }

    public User findUserById(String email) {
        return userRepository.findById(email).orElseThrow(() -> new ExceptionHandler(UserExceptionsEnum.USER_NOT_FOUND.toString()));
    }

    public String deleteUserById(String email) {
        User response = findUserById(email);
        if (response == null) {
            throw new ExceptionHandler(UserExceptionsEnum.USER_NOT_FOUND.toString());
        }
        userRepository.deleteById(email);
        return response.getEmail();
    }
}
