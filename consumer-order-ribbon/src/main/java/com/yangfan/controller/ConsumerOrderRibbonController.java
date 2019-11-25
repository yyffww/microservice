package com.yangfan.controller;

import com.yangfan.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import java.util.Map;

@Api(value = "消费者控制器",tags = "消费者控制层")
@RestController
public class ConsumerOrderRibbonController {
    private static final String REST_URL_PREFIX="http://PROVIDER-USER/";

    @Autowired
    private RestTemplate restTemplate;

    @ApiOperation(value = "用户测试",tags = "消费者控制层",httpMethod = "GET")
    @GetMapping("/order/{id}/{name}")
    public User getOrder(@PathVariable("id") Integer id,@PathVariable("name") String name){
        System.out.println(id+name);
        User user = restTemplate.getForObject(REST_URL_PREFIX +"user/"+ id+"/"+name, User.class);
        return user;
    }

    @ApiOperation(value = "获取所有用户",tags = "消费者控制层",httpMethod = "GET")
    @GetMapping("/getuser")
    public Map  getUserAll(){
        System.out.println("================");
        Map forObject = restTemplate.getForObject(REST_URL_PREFIX+"getuser/", Map.class);
       return forObject;
    }

    @GetMapping("/discovery")
    public Object discovery(){
        return restTemplate.getForObject(REST_URL_PREFIX+"dept/discovery/",Object.class);
    }
}
