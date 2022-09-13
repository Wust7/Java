package com.wust.online_class;

import com.wust.online_class.dao.VideoMapper;
import com.wust.online_class.domain.Video;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class SqlSessionDemo {
    public static void main(String[] args) throws IOException {
        InputStream is = Resources.getResourceAsStream("config/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        VideoMapper mapper = sqlSession.getMapper(VideoMapper.class);
//        Video video = mapper.selectById(44);
//        List<Video> videos = mapper.selectList();
        List<Video> videos = mapper.selectListByXML();
        videos.forEach(x-> System.out.println(x));
    }
}
