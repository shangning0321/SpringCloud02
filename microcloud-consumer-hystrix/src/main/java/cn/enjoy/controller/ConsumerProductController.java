package cn.enjoy.controller;

import cn.enjoy.service.IProductClientService;
import cn.enjoy.service.IZUUlClientService;
import cn.enjoy.vo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: SpringCloud02
 * @description:
 * @author: liu yan
 * @create: 2021-03-15 15:33
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerProductController {

    @Resource
    private IProductClientService iProductClientService;

    @Autowired
    private IZUUlClientService izuUlClientService;

    @RequestMapping("/product/get")
    public Object getProduct(Long id){
        Long idd = id;
        return iProductClientService.getProduct(idd);
    }

    @RequestMapping("/product/list")
    public Object listProduct(){
        return iProductClientService.listProduct();
    }

    @RequestMapping("/product/add")
    public Object addProduct(Product product){
        return iProductClientService.addProduct(product);
    }

    @RequestMapping("/product/getProductAndUser")
    public Object getProductAndUser(long id) {
        Map<String,Object> result = new HashMap();
        result.put("product",izuUlClientService.getProduct(id));
        result.put("user",izuUlClientService.getUsers(id+""));
        return  result;
    }
}
