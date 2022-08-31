package com.wust.mybatis.test;

import com.wust.mybatis.mapper.UserMapper;
import com.wust.mybatis.pojo.User;
import com.wust.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest {
    @Test
    public void testInsertUser() throws IOException {
        //加载核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        //获取SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        //获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);

        //获取SqlSession  ---是java程序与数据库之间的会话 --- true表示设置为自动
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //获取mapper接口对象，帮忙创建实现类
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //测试功能
        int result = mapper.insertUser();

        //提交事务
//        sqlSession.commit();
        System.out.println(result);
    }

    @Test
    public void test1() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        mapper.updateUser();
//        mapper.deleteUser();
//        User user = mapper.getUserById();

        List<User> userAllUser = mapper.getUserAllUser();
        userAllUser.forEach(x-> System.out.println(x));
    }

    @Test
    public void test2() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userAllUser = mapper.getUserByUsername("张三");
        System.out.println(userAllUser);
    }

    @Test
    public void test3() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userAllUser = mapper.checkLogin("张三","1234");
        System.out.println(userAllUser);
    }

    @Test
    public void test4() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Object> map = new HashMap<>();
        map.put("username","张三");
        map.put("password","1234");
        User userAllUser = mapper.checkLoginByMap(map);
        System.out.println(userAllUser);
    }

    @Test
    public void test5() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.insertByUser(new User(null,"wst","1111",23,"男","qq.qq"));
        System.out.println(res);
    }

    @Test
    public void test6() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.checkLoginByParam("wst","1111");
        System.out.println(user);
    }

    @Test
    public void test7() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Integer integer = mapper.getCount();
        System.out.println(integer);
    }

    @Test
    public void test8() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(mapper.getUserByIdToMap(3));
    }

    @Test
    public void test9() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(mapper.getAllUserToMap());
    }

    @Test
    public void test10() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(mapper.getUserByLike("s"));
    }

    @Test
    public void test11() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(mapper.deleteMore("3,6"));
    }

    @Test
    public void test12() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = mapper.getUserByTableName("t_user");
        list.forEach(x-> System.out.println(x));
    }

    @Test
    public void test13() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(null, "jyq", "234", 21, "女", "qrewqr");
        mapper.insertUserById(user);
        System.out.println(user);
    }
}
