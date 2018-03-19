package com.example.movie.repository;

import com.example.movie.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * user的数据库操作dao
 * @author Lucifer
 * @date 2018/03/16 11:03
 */
public interface UserRepository extends JpaRepository<User,Long>{

}
