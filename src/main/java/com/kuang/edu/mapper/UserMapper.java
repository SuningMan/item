package com.kuang.edu.mapper;

import com.kuang.edu.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lvqs
 * @since 2020-02-25
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 查询是否有此用户
     * @param map
     * @return
     */
    User findUserIsExist(Map<String, Object> map);

    List<User> findAll();
}
