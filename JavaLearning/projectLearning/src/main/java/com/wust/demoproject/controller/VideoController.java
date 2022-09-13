package com.wust.demoproject.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wust.demoproject.domain.Video;
import com.wust.demoproject.service.VideoService;
import com.wust.demoproject.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 视频控制器
 */

@RestController
@RequestMapping("/api/v1/pub/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @GetMapping("list")
    public Object list() throws JsonProcessingException {
        List<Video> videos = videoService.listVideo();
        //序列化操作 List-->JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = objectMapper.writeValueAsString(videos);
        System.out.println(jsonStr);

        System.out.println(123);
        //反序列化：JSON-->List
        List<Video> list = objectMapper.readValue(jsonStr, List.class);

        return JsonData.buildSuccess(videos);
    }

    @PostMapping("save_video_chapter")
    public JsonData saveVideo(@RequestBody Video video){
        System.out.println(video.toString());
        return JsonData.buildSuccess("");
    }
}
