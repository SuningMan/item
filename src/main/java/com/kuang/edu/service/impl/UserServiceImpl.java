package com.kuang.edu.service.impl;

import com.kuang.edu.entity.User;
import com.kuang.edu.mapper.UserMapper;
import com.kuang.edu.service.UserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User findUserIsExist(Map<String, Object> map) {
        return userMapper.findUserIsExist(map);
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }
}
