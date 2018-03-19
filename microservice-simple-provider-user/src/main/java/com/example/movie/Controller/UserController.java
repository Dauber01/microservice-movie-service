package com.example.movie.Controller;

import com.example.movie.domain.User;
import com.example.movie.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * user对外实现的接口
 * @author Lucifer
 * @date 2018/03/16 11:05
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User findById(@PathVariable long id){
        User user = this.userRepository.findOne(id);
        return user;
    }

}
