package dev.marcus.usersrestapi.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import dev.marcus.usersrestapi.entity.User;
import dev.marcus.usersrestapi.repository.UserRepository;
import dev.marcus.usersrestapi.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;

    @Override
    public User createUser(User user){
        return userRepository.save(user);
    }

    @Override
    public User getUserById(UUID userId){
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.get();
    }

    @Override
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @Override
    public User updateUser(@RequestBody User user){
        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updatedUser = userRepository.save(existingUser);
        return updatedUser;
    }

    @Override
    public void deleteUser(UUID userId){
        userRepository.deleteById(userId);
    }
}
