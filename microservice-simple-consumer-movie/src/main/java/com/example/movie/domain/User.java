package com.example.movie.domain;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 用户实体类
 * @author Lucifer
 * @date 2018/03/16 13:45
 */
@Data
public class User {

    private long id;

    private String username;

    private String name;

    private Integer age;

    private BigDecimal balance;

}
