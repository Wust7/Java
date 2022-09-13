package com.wust.demoproject;


import com.wust.demoproject.domain.Video;
import com.wust.demoproject.service.VideoService;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.Charset;
import java.util.List;


//单元测试
@RunWith(SpringRunner.class)//底层用junit SpringJUnit4ClassRunner
@SpringBootTest(classes = {DemoProjectApplication.class})//启动整个springboot工程
@AutoConfigureMockMvc //开启mvc自动配置
public class VideoTest {

    @Autowired
    private VideoService videoService;

    @Autowired
    private MockMvc mockMvc;


    //调用controller层api进行测试
    @Test
    public void testVideoListApi() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/pub/video/list"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        int status = mvcResult.getResponse().getStatus();
        System.out.println(status);
        //中文会乱码
//        String result = mvcResult.getResponse().getContentAsString();

        //指定编码方式就不会乱码
        String result = mvcResult.getResponse().getContentAsString(Charset.forName("utf-8"));
        System.out.println(result);
    }


    @Before//在测试程序加载前执行
    public void test1(){
        System.out.println("Before....");
    }


    @Test
    public void testVideoList(){
        List<Video> videos = videoService.listVideo();
        TestCase.assertTrue(videos.size()>0);
    }

//    @Test
//    public void test2(){
//        System.out.println("Test1....");
//        TestCase.assertEquals(3,3);
//    }
//
//    @Test
//    public void test22(){
//        System.out.println("Test2....");
//        TestCase.assertEquals(1,3);
//    }
    @After//在测试程序加载后执行
    public void test3(){
        System.out.println("After....");
    }
}
