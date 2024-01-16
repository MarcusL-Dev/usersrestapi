package dev.marcus.usersrestapi.service;

import java.util.List;
import java.util.UUID;

import dev.marcus.usersrestapi.entity.User;

public interface UserService {
    User createUser(User user);

    User getUserById(UUID userId);

    List<User> getAllUsers();

    User updateUser(User user);

    void deleteUser(UUID userId);
}
