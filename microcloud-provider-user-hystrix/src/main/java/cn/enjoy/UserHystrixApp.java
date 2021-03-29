package cn.enjoy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @program: SpringCloud02
 * @description:
 * @author: liu yan
 * @create: 2021-03-15 14:18
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class UserHystrixApp {
    public static void main(String[] args) {
        SpringApplication.run(UserHystrixApp.class,args);
    }
}
