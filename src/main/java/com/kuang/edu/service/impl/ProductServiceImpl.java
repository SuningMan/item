package com.kuang.edu.service.impl;

import com.kuang.edu.dao.ProductDao;
import com.kuang.edu.entity.Product;
import com.kuang.edu.mapper.ProductMapper;
import com.kuang.edu.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lvqs
 * @since 2020-02-25
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productMapper;

    @Override
    public List<Product> findAllProduct(Map<String, Object> map) {
        return productMapper.findAllProduct(map);
    }

}
