package com.kuang.edu.service;

import com.kuang.edu.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lvqs
 * @since 2020-02-25
 */
public interface ProductService {
    /**
     *查询所有产品
     * @param map
     * @return
     */
    List<Product> findAllProduct(Map<String, Object> map);
}
