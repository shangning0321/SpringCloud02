package cn.enjoy.service.fallback;

import cn.enjoy.service.IProductClientService;
import cn.enjoy.vo.Product;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: SpringCloud02
 * @description:
 * @author: liu yan
 * @create: 2021-03-28 01:37
 */
@Component
public class IProductClientServiceFallbackFactory implements FallbackFactory<IProductClientService> {

    @Override
    public IProductClientService create(Throwable cause) {
        return new IProductClientService() {
            @Override
            public Product getProduct(Long id) {
                Product product = new Product();
                product.setProductId(999999L);
                product.setProductName("feign-hystrixName");
                product.setProductDesc("feign-hystrixDesc");
                return product;
            }

            @Override
            public List<Product> listProduct() {
                return null;
            }

            @Override
            public boolean addProduct(Product product) {
                return false;
            }
        };
    }
}
