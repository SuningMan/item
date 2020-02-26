package com.kuang.edu.service;

import com.kuang.edu.entity.User;
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
public interface UserService extends IService<User> {

    /**
     * 查询是否有此用户
     * @param map
     * @return
     */
    User findUserIsExist(Map<String, Object> map);

    List<User> findAll();
}
