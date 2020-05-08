package com.kuang.edu.dao;

import com.kuang.edu.entity.ProductMaintain;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (ProductMaintain)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-08 11:16:47
 */
public interface ProductMaintainDao {

    /**
     * 通过ID查询单条数据
     *
     * @param productId 主键
     * @return 实例对象
     */
    ProductMaintain queryById(String productId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ProductMaintain> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param productMaintain 实例对象
     * @return 对象列表
     */
    List<ProductMaintain> queryAll(ProductMaintain productMaintain);

    /**
     * 新增数据
     *
     * @param productMaintain 实例对象
     * @return 影响行数
     */
    int insert(ProductMaintain productMaintain);

    /**
     * 修改数据
     *
     * @param productMaintain 实例对象
     * @return 影响行数
     */
    int update(ProductMaintain productMaintain);

    /**
     * 通过主键删除数据
     *
     * @param productId 主键
     * @return 影响行数
     */
    int deleteById(String productId);

}