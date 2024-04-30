package com.black9769.playground.user.service;

import com.black9769.playground.user.entity.User;
import com.black9769.playground.user.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    UserRepository userRepository;

    public Optional<User> getNameById(int userId) {

        return userRepository.findAllById(userId);
    }

}
