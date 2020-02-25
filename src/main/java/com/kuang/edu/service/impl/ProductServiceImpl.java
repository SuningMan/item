package com.kuang.edu.service.impl;

import com.kuang.edu.entity.Product;
import com.kuang.edu.mapper.ProductMapper;
import com.kuang.edu.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lvqs
 * @since 2020-02-25
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

}
