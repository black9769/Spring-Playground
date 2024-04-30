package com.black9769.playground.user.controller;

import com.black9769.playground.user.entity.User;
import com.black9769.playground.user.repo.UserRepository;
import com.black9769.playground.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class userController {
    private final UserService userService;

    private final UserRepository userRepository;

    @Autowired
    public userController(UserService userService, UserRepository userRepository){
        this.userService = userService;
        this.userRepository = userRepository;
    }
    @GetMapping("api/test")
    public String test() {
        List<User> userList = userRepository.findAll();
        return userList.get(0).getName();
    }

    @GetMapping("api/jpa")
    public Iterable<User> list(){
        return userRepository.findAll();
    }

    @GetMapping("api/test2")
    public String test2() {
        return "test 중입니다 22";
    }
}
