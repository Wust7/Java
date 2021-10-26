package com.example.springbootmybatis;

import com.example.springbootmybatis.domain.User;
import com.example.springbootmybatis.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringbootMybatisApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testFindALl() {
        List<User> list = userMapper.findAll();
        System.out.println(list);
    }

}
