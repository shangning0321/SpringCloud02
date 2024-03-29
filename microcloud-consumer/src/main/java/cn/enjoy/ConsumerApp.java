package cn.enjoy;

import cn.xiangxue.config.RibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @program: SpringCloud02
 * @description:
 * @author: liu yan
 * @create: 2021-03-15 15:30
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "MICROCLOUD-PROVIDER-PRODUCT",configuration = RibbonConfig.class)
public class ConsumerApp {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApp.class,args);
    }
}
