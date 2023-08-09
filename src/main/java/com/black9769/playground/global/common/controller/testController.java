package com.black9769.playground.global.common.controller;

import com.black9769.playground.global.common.entity.User;
import com.black9769.playground.global.common.repo.UserRepository;
import com.black9769.playground.global.common.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class testController {
    private UserService userService;

    private UserRepository userRepository;

    @Autowired
    public testController(UserService userService, UserRepository userRepository){
        this.userService = userService;
        this.userRepository = userRepository;
    }
    @GetMapping("api/test")
    public String test() {
        List<User> userList = userRepository.findAll();
        return "백앤드 자동배포 테스트중";
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
