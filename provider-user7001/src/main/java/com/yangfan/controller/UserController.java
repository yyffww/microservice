package com.yangfan.controller;

import com.netflix.appinfo.InstanceInfo;

import com.netflix.discovery.EurekaClient;
import com.yangfan.bean.User;
import com.yangfan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private DiscoveryClient client;

    @GetMapping("/user/{id}/{name}")
    public User getUser(@PathVariable("id") Integer id,@PathVariable("name") String name){
        System.out.println("7001");
        return new User(id,name);
    }

    @GetMapping("/eurekainfo")
    public String info(){
        InstanceInfo instance = eurekaClient.getNextServerFromEureka("CONSUMER-ORDER1", false);
        return instance.getHomePageUrl();
    }

    @GetMapping("/getuser")
    public Map<String,Object> getUserAll(){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("list",userService.getUserAll());
        map.put("datasource","7001");
        return map;
    }

    @GetMapping("/dept/discovery")
    public Object discovery(){
        List<String> list = client.getServices();
        System.out.println("*******"+list);
        List<ServiceInstance> serList = client.getInstances("PROVIDER-USER");
        for (ServiceInstance element:serList){
            System.out.println(element.getServiceId()+"\t"+element.getHost()+"\t"+element.getPort()+"\t"
            +element.getUri());
        }

        return this.client;
    }
}
