package dev.exchange.exchangeproject.repository;

import dev.exchange.exchangeproject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
