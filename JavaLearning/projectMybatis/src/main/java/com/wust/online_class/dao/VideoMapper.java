package com.wust.online_class.dao;

import com.wust.online_class.domain.Video;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface VideoMapper {

    Video selectById(@Param("video_id") int VideoId);

    @Select("select * from video")
    List<Video> selectList();

    List<Video> selectListByXML();
}
