package dev.exchange.exchangeproject.models;

import dev.exchange.exchangeproject.models.enums.UserRoles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;


    @Enumerated(EnumType.STRING)
    private UserRoles role;

    @NotBlank
    @NotNull
    @Size(max = 50, message = "User name must be less than or equal to 50 characters")
    @Column(length = 50)
    private String email;

    @OneToMany
    private List<User> contacts;

    @OneToOne
    private ExchangeAccount exchangeAccount;

    public User(UserRoles role, String email, List<User> contacts, ExchangeAccount exchangeAccount) {
        this.role = role;
        this.email = email;
        this.contacts = contacts;
        this.exchangeAccount = exchangeAccount;
    }
}
