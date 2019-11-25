package com.yangfan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Hello world!
 *
 */

@SpringBootApplication
@EnableEurekaClient
public class ProviderUser7002
{

    public static void main( String[] args )
    {
        SpringApplication.run(ProviderUser7002.class,args);
    }
}
