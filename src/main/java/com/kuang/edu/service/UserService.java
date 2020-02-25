package com.kuang.edu.service;

import com.kuang.edu.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lvqs
 * @since 2020-02-25
 */
public interface UserService extends IService<User> {

    public List<User> findAll();
}
