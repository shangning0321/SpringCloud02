package cn.enjoy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @program: SpringCloud02
 * @description:
 * @author: liu yan
 * @create: 2021-03-15 15:30
 */
@SpringBootApplication
@EnableHystrixDashboard
public class ConsumerhystrixdashboardApp {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerhystrixdashboardApp.class,args);
    }
}
