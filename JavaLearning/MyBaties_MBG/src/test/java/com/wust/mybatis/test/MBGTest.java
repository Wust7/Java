package com.wust.mybatis.test;

import com.wust.mybatis.mapper.EmpMapper;
import com.wust.mybatis.pojo.Emp;
import com.wust.mybatis.pojo.EmpExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MBGTest {
    @Test
    public void test1(){
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            //查询所有数据
//            List<Emp> list = mapper.selectByExample(null);
//            list.forEach(x-> System.out.println(x));

//            EmpExample example = new EmpExample();
//            example.createCriteria().andEmpNameEqualTo("w1").andAgeGreaterThanOrEqualTo(2);
//            List<Emp> list2 = mapper.selectByExample(example);
//            list2.forEach(x-> System.out.println(x));

            //会将null值赋值给相应字段
//            mapper.updateByPrimaryKey(new Emp(1, "wst", null, "女", "werq", 3));
            //不会将null值赋值给相应字段，而是保留原来值
            mapper.updateByPrimaryKeySelective(new Emp(1, "wst", null, "女", "werq", 3));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
