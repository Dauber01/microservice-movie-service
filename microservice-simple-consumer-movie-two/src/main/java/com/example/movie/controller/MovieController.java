package com.example.movie.controller;

//import com.example.movie.config.FeignConfiguration;
import com.example.movie.domain.User;
import com.example.movie.service.UserFeignClient;
import com.google.common.collect.Maps;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import feign.Client;
import feign.Contract;
import feign.Feign;
import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.Decoder;
import feign.codec.Encoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.feign.FeignClientsConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

/**
 * 对外服务接口
 * @author Lucifer
 * @date 2018/03/16 13:48
 */
@Slf4j
@RestController
//@Import(FeignClientsConfiguration.class)
public class MovieController {

   /* @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private DiscoveryClient discoveryClient;*/

 /*   //@Autowired
    private UserFeignClient userUserFeignClient;

    //@Autowired
    private UserFeignClient adminUserFeignClient;*/

    @Autowired
    private UserFeignClient userFeignClient;

   /* @Autowired
    public MovieController(Decoder decoder, Encoder encoder, Client client, Contract contract){
        //通过decoder,encoder,client,contract查看实例的类型
        this.userUserFeignClient = Feign.builder().client(client).encoder(encoder).decoder(decoder).contract(contract)
                                        .requestInterceptor(new BasicAuthRequestInterceptor("user","password1"))
                                        .target(UserFeignClient.class,"http://microservice-simple-provider-user/");
        this.adminUserFeignClient = Feign.builder().client(client).encoder(encoder).decoder(decoder).contract(contract)
                .requestInterceptor(new BasicAuthRequestInterceptor("admin","password2"))
                .target(UserFeignClient.class,"http://microservice-simple-provider-user/");
    }

    @GetMapping("/user-user/{id}")
    public User findByIdUser(@PathVariable Long id){
        return this.userUserFeignClient.findById(id);
    }

    @GetMapping("/user-admin/{id}")
    public User findByIdAdmin(@PathVariable Long id){
        return this.adminUserFeignClient.findById(id);
    }

    *//*@GetMapping("/user/{id}")
    public User findById(@PathVariable Long id){
        return this.restTemplate.getForObject("http://microservice-simple-provider-user/" + id, User.class);
    }*//*

    @GetMapping("/log-instance")
    public void logUserInstance(){
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-simple-provider-user");
        MovieController.log.info("{}:{}:{}",serviceInstance.getServiceId(),serviceInstance.getHost(),serviceInstance.getPort());
    }

    @GetMapping("/user-instaance")
    public List<ServiceInstance> showInfo(){
        return this.discoveryClient.getInstances("microservice-simple-provider-user");
    }*/

    /*@HystrixCommand(fallbackMethod = "findByIdFallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000"),
            @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds",value = "10000")
    },threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "1"),
            @HystrixProperty(name = "maxQueueSize", value = "10")
    })*/
    @GetMapping(value = "/user/{id}")
    public User findById(@PathVariable Long id){
        /*HashMap<String,Object> map = Maps.newHashMap();
        map.put("id",id);
        map.put("ic",1);*/
        /*User user = new User();
        user.setId(1);*/
        return this.userFeignClient.findById(id);
    }

   /* public User findByIdFallback(Long id){
        User user = new User();
        user.setId(-1L);
        user.setName("默认用户");
        return user;
    }*/

}
