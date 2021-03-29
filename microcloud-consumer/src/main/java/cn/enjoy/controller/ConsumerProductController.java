package cn.enjoy.controller;

import cn.enjoy.vo.Product;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: SpringCloud02
 * @description:
 * @author: liu yan
 * @create: 2021-03-15 15:33
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerProductController {
    public static final String PRODUCT_GET_URL = "http://MICROCLOUD-PROVIDER-PRODUCT/product/get/";
    public static final String PRODUCT_LIST_URL = "http://MICROCLOUD-PROVIDER-PRODUCT/product/list/";
    public static final String PRODUCT_ADD_URL = "http://MICROCLOUD-PROVIDER-PRODUCT/product/add/";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private HttpHeaders httpHeaders;

    @Resource
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping("/product/get")
    public Object getProduct(Long id){
//        Product forObject = restTemplate.getForObject(PRODUCT_GET_URL + id, Product.class);
        Product forObject = restTemplate.exchange(PRODUCT_GET_URL + id,
                HttpMethod.GET, new HttpEntity<Object>(httpHeaders), Product.class).getBody();
        return forObject;
    }
    @RequestMapping("/product/list")
    public Object listProduct(){
//        List<Product> forObject = restTemplate.getForObject(PRODUCT_LIST_URL, List.class);
        //获取服务方信息
        ServiceInstance choose = loadBalancerClient.choose("MICROCLOUD-PROVIDER-PRODUCT");
        System.out.println("【*** ServiceInstance ***】host = " + choose.getHost()
                + "、port = " + choose.getPort()
                + "、serviceId = " + choose.getServiceId());
        List<Product> forObject = restTemplate.exchange(PRODUCT_LIST_URL,
                HttpMethod.GET, new HttpEntity<Object>(httpHeaders), List.class).getBody();
        return forObject;
    }
    @RequestMapping("/product/add")
    public Object addProduct(Product product){
//        Boolean aBoolean = restTemplate.postForObject(PRODUCT_ADD_URL, product, Boolean.class);
        Boolean aBoolean = restTemplate.exchange(PRODUCT_ADD_URL,
                HttpMethod.GET, new HttpEntity<Object>(product,httpHeaders), Boolean.class).getBody();
        return aBoolean;
    }
}
