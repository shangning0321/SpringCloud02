package cn.enjoy.service.fallback;

import cn.enjoy.service.IZUUlClientService;
import cn.enjoy.vo.Product;
import cn.enjoy.vo.Users;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: SpringCloud02
 * @description:
 * @author: liu yan
 * @create: 2021-03-29 20:15
 */
@Component
public class IZUUlClientServiceallbackFactory implements FallbackFactory<IZUUlClientService> {

    @Override
    public IZUUlClientService create(Throwable cause) {

        return new IZUUlClientService(){

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

            @Override
            public Users getUsers(String name) {
                Users user = new Users();
                user.setSex("F");
                user.setAge(17);
                user.setName("zuul-fllback："+name);
                return user;
            }
        };
    }
}
