package com.yangfan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Hello world!
 *
 */
@EnableDiscoveryClient //服务发现
@EnableEurekaClient
@SpringBootApplication
public class ProviderUser7001
{
    public static void main( String[] args )
    {
        SpringApplication.run(ProviderUser7001.class,args);
    }

}
