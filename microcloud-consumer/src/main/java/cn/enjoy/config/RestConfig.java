package cn.enjoy.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Base64;

/**
 * @program: SpringCloud02
 * @description:
 * @author: liu yan
 * @create: 2021-03-15 15:31
 */
@Configuration
public class RestConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean//账号密码 加密
    public HttpHeaders getHeaders(){
        HttpHeaders httpHeaders = new HttpHeaders();
        String auth = "admin:enjoy";
        byte[] encode = Base64.getEncoder()
                .encode(auth.getBytes(Charset.forName("US-ASCII")));
        String s = "Basic "+new String(encode);
        httpHeaders.set("Authorization",s);
        return httpHeaders;
    };

/*    //负载均衡-随机
    @Bean
    public IRule ribbonRule(){
      return new RandomRule();
    };*/

}
