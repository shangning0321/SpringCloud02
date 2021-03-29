package cn.enjoy.controller;

import cn.enjoy.service.ProductService;
import cn.enjoy.vo.Product;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: SpringCloud02
 * @description:
 * @author: liu yan
 * @create: 2021-03-15 15:15
 */
@RequestMapping("/product")
@RestController
public class ProductController {
    @Resource
    private ProductService productService;

    @Resource
    private DiscoveryClient client;

    @RequestMapping(value = "/get/{id}")
    public Object get(@PathVariable("id") Long id){
        return productService.get(id);
    }

    @RequestMapping(value = "/add")
    public Object add(@RequestBody Product product){
        return productService.add(product);
    }

    @RequestMapping(value="/list")
    public Object list() {
        return this.productService.list() ;
    }

    @RequestMapping("/discover")
    public Object discover() { // 直接返回发现服务信息
        return this.client ;
    }
}
