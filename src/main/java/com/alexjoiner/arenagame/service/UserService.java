package com.alexjoiner.arenagame.service;

import com.alexjoiner.arenagame.domain.User;
import com.alexjoiner.arenagame.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User save(User user) {

        return userRepository.save(user);
    }

    public User findById(Long userId) {
        return userRepository.findById(userId).get();
    }

    public void delete(Long userId) {
        User user = userRepository.findById(userId).get();
        userRepository.delete(user);
    }
}

