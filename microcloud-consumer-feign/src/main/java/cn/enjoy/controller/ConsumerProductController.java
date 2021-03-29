package cn.enjoy.controller;

import cn.enjoy.service.IProductClientService;
import cn.enjoy.vo.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @Resource
    private IProductClientService iProductClientService;

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
}
