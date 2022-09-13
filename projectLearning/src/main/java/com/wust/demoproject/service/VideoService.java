package com.wust.demoproject.service;

import com.wust.demoproject.domain.Video;
import org.springframework.stereotype.Service;

import java.util.List;

public interface VideoService {
    List<Video> listVideo();
}
