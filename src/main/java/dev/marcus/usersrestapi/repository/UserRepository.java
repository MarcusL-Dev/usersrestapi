package dev.marcus.usersrestapi.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.marcus.usersrestapi.entity.User;

public interface UserRepository extends JpaRepository<User, UUID> { }
