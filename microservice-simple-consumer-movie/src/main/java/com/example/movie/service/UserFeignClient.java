package com.example.movie.service;

//import com.example.movie.config.FeignConfiguration;
import com.example.movie.config.FeignLogConfiguration;
import com.example.movie.domain.User;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 * @author Lucifer
 * @do Feign的客户端接口构建
 * @date 2018/03/26 9:28
 */
//@Component
//@FeignClient(name = "microservice-simple-provider-user", configuration = FeignConfiguration.class)
@FeignClient(name = "microservice-simple-provider-user", configuration = FeignLogConfiguration.class)
public interface UserFeignClient {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public User findById(@RequestParam("id") Long id, @RequestParam("ic") Long ic);

    /*@RequestLine("GET /{id}")
    public User findById(@Param("id") Long id, @Param("ic") Long ic);*/

}
