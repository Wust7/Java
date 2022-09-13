package com.wust.demoproject.mapper;

import com.wust.demoproject.domain.Video;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class VideoMapper {

    private static Map<Integer, Video> videoMap = new HashMap<>();
    static{
        videoMap.put(1,new Video(1,"test1"));
        videoMap.put(2,new Video(2,"test2"));
        videoMap.put(3,new Video(3,"test3"));
        videoMap.put(4,new Video(4,"test4"));
        videoMap.put(5,new Video(5,"test5"));
    }

    public List<Video> listVideo(){
        List<Video> list = new ArrayList<>();
        list.addAll(videoMap.values());
        return list;
    }
}
