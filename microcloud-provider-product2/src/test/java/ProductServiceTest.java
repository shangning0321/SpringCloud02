import cn.enjoy.ProductApp;
import cn.enjoy.service.ProductService;
import cn.enjoy.vo.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @program: SpringCloud02
 * @description:
 * @author: liu yan
 * @create: 2021-03-15 14:26
 */
@SpringBootTest(classes = ProductApp.class)
@RunWith(SpringRunner.class)
public class ProductServiceTest {
    @Resource
    private ProductService productService;

    @Test
    public void testGet(){
        System.out.println(productService.get(2));
    }

    @Test
    public void testAdd() {
        Product dept = new Product() ;
        dept.setProductName("lison-" + System.currentTimeMillis());
        System.out.println(productService.add(dept));
    }
    @Test
    public void testList() {
        System.out.println(productService.list());
    }
}
