package com.example.movie.service;

//import com.example.movie.config.FeignConfiguration;
//import com.example.movie.config.FeignDisableHystrixConfiguration;
import com.example.movie.config.FeignLogConfiguration;
import com.example.movie.domain.User;
import feign.Param;
import feign.RequestLine;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author Lucifer
 * @do Feign的客户端接口构建
 * @date 2018/03/26 9:28
 */
//@Component
//@FeignClient(name = "user", configuration = FeignDisableHystrixConfiguration.class)
//@FeignClient(name = "microservice-simple-provider-user", configuration = FeignConfiguration.class)
//@FeignClient(name = "microservice-simple-provider-user", configuration = FeignLogConfiguration.class, fallbackFactory = FeignClientFallback.class)
@FeignClient(name = "microservice-simple-provider-user", configuration = FeignLogConfiguration.class, fallback = FeignClientFallback.class)
public interface UserFeignClient {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public User findById(@RequestParam("id") Long id);

    /*@RequestMapping(value = "/", method = RequestMethod.POST)
    public User findById(@RequestBody User user);*/

    /*@RequestLine("GET /{id}")
    public User findById(@Param("id") Long id, @Param("ic") Long ic);*/

}

@Component
class FeignClientFallback implements UserFeignClient{

    @Override
    public User findById(Long id) {
        User user = new User();
        user.setId(-1L);
        user.setName("somebody");
        return user;
    }
}

/*@Slf4j
@Component
class FeignClientFallback implements FallbackFactory<UserFeignClient>{

    @Override
    public UserFeignClient create(Throwable cause){
        return new UserFeignClient() {
            @Override
            public User findById(Long id) {
                FeignClientFallback.log.info("fallback; reason was:",cause);
                User user = new User();
                if (cause instanceof IllegalArgumentException){
                    user.setId(-1L);
                }else {
                    user.setId(-2L);
                }
                user.setName("默认用户");
                return user;
            }
        };
    }

}*/
