package com.wust.mybatis.test;

import com.wust.mybatis.mapper.DeptMapper;
import com.wust.mybatis.mapper.DynamicSQLMapper;
import com.wust.mybatis.pojo.Dept;
import com.wust.mybatis.pojo.Emp;
import com.wust.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DynamicSQLMapperTest {

    @Test
    public void test1(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> list = mapper.getEmpByCondition(new Emp(null, "", 1, "1", "11", null));
        System.out.println(list);
    }

    @Test
    public void test2(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> list = mapper.getEmpByChoose(new Emp(null, "", 1, "", "11", null));
        System.out.println(list);
    }

    @Test
    public void test3(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        int i = mapper.deleteMoreByArray(new Integer[]{6, 7, 8});
        System.out.println(i);
    }

    @Test
    public void test4(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp1 = new Emp(null, "a1", 22, "男", "qrweq", null);
        Emp emp2 = new Emp(null, "a2", 22, "男", "qrweq", null);
        Emp emp3 = new Emp(null, "a3", 22, "男", "qrweq", null);
        List<Emp> emps = Arrays.asList(emp1, emp2, emp3);
        int i = mapper.insertMoreByList(emps);
        System.out.println(i);
    }
}
