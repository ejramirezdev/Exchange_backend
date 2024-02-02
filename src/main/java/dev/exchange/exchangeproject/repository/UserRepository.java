package dev.exchange.exchangeproject.repository;

import dev.exchange.exchangeproject.models.PlatformUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<PlatformUser, String> {
}
