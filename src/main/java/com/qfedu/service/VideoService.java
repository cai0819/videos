package com.qfedu.service;


import com.qfedu.entity.Video;
import com.qfedu.vo.VVideoInfo;

import java.util.List;

/**
 * @program: QFVideos
 * @ClassName: VideoService
 * @description: TODO
 * @author: ccq
 * @create: 2019-08-02 15:53
 **/
public interface VideoService {

    public List<VVideoInfo> findAllVideos(String Title, Integer speakerId,Integer courseId, Integer page, Integer limit);

    public void add(Video video);

    public void update(Video video);

    public Video findById(Integer id);

    public void deleteById(Integer id);

    public void deleteByIds(Integer[] ids);

    public Video findVideoAndSpeaker(Integer id);
}
