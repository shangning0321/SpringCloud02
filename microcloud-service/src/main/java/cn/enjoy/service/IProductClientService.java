package cn.enjoy.service;

import cn.enjoy.feign.FeignClientConfig;
import cn.enjoy.service.fallback.IProductClientServiceFallbackFactory;
import cn.enjoy.vo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @program: SpringCloud02
 * @description:
 * @author: liu yan
 * @create: 2021-03-27 19:28
 */
@FeignClient(name = "MICROCLOUD-PROVIDER-PRODUCT",configuration = FeignClientConfig.class,
        fallbackFactory = IProductClientServiceFallbackFactory.class)
public interface IProductClientService {

    @RequestMapping("/product/get/{id}")
    public Product getProduct(@PathVariable("id")Long id);

    @RequestMapping("/product/list")
    public List<Product> listProduct();

    @RequestMapping("/product/add")
    public boolean  addProduct(Product product);
}
