package cn.enjoy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @program: SpringCloud02
 * @description:
 * @author: liu yan
 * @create: 2021-03-28 17:25
 */
@SpringBootApplication
@EnableTurbine
public class TurbineApp {

    public static void main(String[] args) {
        SpringApplication.run(TurbineApp.class,args);
    }
}
