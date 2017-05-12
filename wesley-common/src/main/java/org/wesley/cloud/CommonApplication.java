package org.wesley.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Wesley
 */
@SpringBootApplication
@EnableEurekaClient
public class CommonApplication {

    public static void main(String[] args){
        SpringApplication.run(CommonApplication.class, args);
    }

}
