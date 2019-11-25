package com.yangfan.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.yangfan.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {
//////
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EurekaClient eurekaClient;

//    @Value("${order.url}")
//    private String url="";
    @GetMapping("/order/{id}/{name}")
    public User getOrder(@PathVariable Integer id,@PathVariable String name){
        InstanceInfo urlHome = eurekaClient.getNextServerFromEureka("PROVIDER-USER", false);
        String pageUrl = urlHome.getHomePageUrl();
        System.out.println(pageUrl);
        User user = restTemplate.getForObject(pageUrl+"/user/" + id+"/"+name, User.class);
        return user;
    }
}
