package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Video;

public interface VideoMapper extends BaseMapper<Video> {
    //@UpdateProvider(type = VideoProvider.class,method = "updateVideo")
    //int update(Video video);
}
