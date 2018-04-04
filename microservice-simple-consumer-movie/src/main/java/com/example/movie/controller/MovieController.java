package com.example.movie.controller;

//import com.example.movie.config.FeignConfiguration;
import com.example.movie.domain.User;
import com.example.movie.service.UserFeignClient;
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

    @GetMapping(value = "/user/{id}")
    public User findById(@PathVariable Long id){
        return this.userFeignClient.findById(id, 1L);
    }

}
