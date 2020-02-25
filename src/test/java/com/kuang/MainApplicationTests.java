package com.kuang;

import com.kuang.edu.entity.User;
import com.kuang.edu.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
class MainApplicationTests {

	@Autowired
	UserMapper userMapper;
	@Test
	void findAllUser() {
		List<User> userList = userMapper.selectList(null);
		userList.forEach(System.out::println);
	}

}
