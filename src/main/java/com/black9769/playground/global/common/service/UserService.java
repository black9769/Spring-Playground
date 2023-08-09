package com.black9769.playground.global.common.service;

import com.black9769.playground.global.common.entity.User;
import com.black9769.playground.global.common.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    UserRepository userRepository;

    public Optional<User> getNameById(int userId) {

        return userRepository.findAllById(userId);
    }

}
