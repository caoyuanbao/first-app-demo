package com.cj.firstappdemo.controller;

import com.cj.firstappdemo.domain.User;
import com.cj.firstappdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/1/18 0018.
 */
@RestController
public class UserController {

    /**
     * 构造器注入方式
     */
    private  final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/person/save")
    public User save(@RequestParam String name){
        User user = new User();
        user.setName(name);
        if (userRepository.save(user)){
            System.out.printf("用户对象：%s保存成功\n",user);
        }
        return user;
    }

}
