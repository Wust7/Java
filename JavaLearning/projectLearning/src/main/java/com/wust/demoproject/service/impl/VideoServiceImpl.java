package com.wust.demoproject.service.impl;

import com.wust.demoproject.domain.Video;
import com.wust.demoproject.mapper.VideoMapper;
import com.wust.demoproject.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//子类设置为加上该注解，实例化接口时去IOC容器中会找到该子类
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Override
    public List<Video> listVideo() {
        return videoMapper.listVideo();
    }
}
