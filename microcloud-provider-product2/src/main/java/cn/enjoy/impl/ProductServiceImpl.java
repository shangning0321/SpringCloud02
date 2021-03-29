package cn.enjoy.impl;;

import cn.enjoy.mapper.ProductMapper;
import cn.enjoy.service.ProductService;
import cn.enjoy.vo.Product;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: SpringCloud02
 * @description:
 * @author: liu yan
 * @create: 2021-03-15 14:16
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;

    @Override
    public Product get(long id) {
        return productMapper.findById(id);
    }

    @Override
    public boolean add(Product product) {
        return productMapper.create(product);
    }

    @Override
    public List<Product> list() {
        return productMapper.findAll();
    }
}
