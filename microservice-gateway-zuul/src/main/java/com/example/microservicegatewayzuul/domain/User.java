package com.example.microservicegatewayzuul.domain;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Lucifer
 * @do user的实体类
 * @date 2018/04/09 15:28
 */
@Data
public class User {

    private Long id;

    private String username;

    private String name;

    private Integer age;

    private BigDecimal balance;

}
