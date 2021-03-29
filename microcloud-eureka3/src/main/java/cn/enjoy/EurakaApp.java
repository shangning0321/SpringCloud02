package cn.enjoy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @program: SpringCloud02
 * @description:
 * @author: liu yan
 * @create: 2021-03-15 20:00
 */
@SpringBootApplication
@EnableEurekaServer
public class EurakaApp {
    public static void main(String[] args) {
        SpringApplication.run(EurakaApp.class,args);
    }
}


