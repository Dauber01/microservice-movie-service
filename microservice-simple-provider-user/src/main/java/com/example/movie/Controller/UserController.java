package com.example.movie.Controller;

import com.example.movie.domain.User;
import com.example.movie.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * user对外实现的接口
 * @author Lucifer
 * @date 2018/03/16 11:05
 */
@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /*@GetMapping("/{id}")
    public User findById(@PathVariable long id){
        //拿到登陆的user信息
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails){
            UserDetails user = (UserDetails)principal;
            Collection<? extends GrantedAuthority> collection = user.getAuthorities();
            for (GrantedAuthority c : collection){
                UserController.log.info("当前用户是{},角色是{}",user.getUsername(),c.getAuthority());
            }
        }else {
            //do other things
        }
        User findOne = this.userRepository.findOne(id);
        return findOne;
    }*/

    @GetMapping("/")
    //@PostMapping("/")
    public User findById(@RequestParam Long id){
        User user = this.userRepository.findOne(id);
        return user;
    }

}
