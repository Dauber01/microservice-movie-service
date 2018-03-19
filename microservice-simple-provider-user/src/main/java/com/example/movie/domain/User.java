package com.example.movie.domain;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * user数据库映射实体表
 * @author Lucifer
 * @date 2018/03/16 10:59
 */
@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String username;

    @Column
    private String name;

    @Column
    private Integer age;

    @Column
    private BigDecimal balance;

}
