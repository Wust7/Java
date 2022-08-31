package com.wust.mybatis.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wust.mybatis.mapper.EmpMapper;
import com.wust.mybatis.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class PageHelperTest {
    /**
     * limit index pageSize
     *
     * index:当前页的起始索引（0开始）
     * pageSize：每页显示条数
     * pageNum：当前页的页码
     * index=（pageNum-1）*pageSize
     *
     * PageInfo<Emp> page = new PageInfo<>(emps,5);
     * emps:表示分页数据
     * 5表示当前导航分页的数量
     */

    @Test
    public void test1(){
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            //开启分页
            PageHelper.startPage(2,4);
            List<Emp> emps = mapper.selectByExample(null);
            PageInfo<Emp> page = new PageInfo<>(emps,5);
            System.out.println(page);
            emps.forEach(x-> System.out.println(x));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
