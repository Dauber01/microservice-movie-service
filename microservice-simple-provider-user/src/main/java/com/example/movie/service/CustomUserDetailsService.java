/*package com.example.movie.service;

import com.example.movie.domain.SecurityUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

*//**
 * @author Lucifer
 * @do 实现security的注册接口, 模拟两个用户
 * @date 2018/03/26 10:46
 *//*
@Component
public class CustomUserDetailsService implements UserDetailsService{

    *//**
     * 模拟两个账户: ①账号user,密码password1,角色是user-role;②账号admin,密码password2,角色是admin-role
     * @param username
     * @return UserDetails
     * @throws UsernameNotFoundException
     *//*
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("user".equals(username)){
            return new SecurityUser("user","password1","user-role");
        }else if ("admin".equals(username)){
            return new SecurityUser("admin","password2","admin-role");
        }else {
            return null;
        }
    }
}*/
