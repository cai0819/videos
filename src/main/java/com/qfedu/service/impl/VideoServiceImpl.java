package com.qfedu.service.impl;


import com.github.pagehelper.PageHelper;
import com.qfedu.dao.VideoDao;
import com.qfedu.entity.Video;
import com.qfedu.service.VideoService;
import com.qfedu.vo.VVideoInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: QFVideos
 * @ClassName: VideoServiceImpl
 * @description: TODO
 * @author: ccq
 * @create: 2019-08-02 15:54
 **/
@Service
public class VideoServiceImpl implements VideoService {
    @Autowired(required = false)
    private VideoDao videoDao;

    @Override
    public List<VVideoInfo> findAllVideos(String title,Integer speakerId, Integer courseId, Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<VVideoInfo> list =videoDao.findAll(title,speakerId,courseId);
        return list;
    }

    @Override
    public void add(Video video) {
        videoDao.add(video);
    }

    @Override
    public void update(Video video) {
        videoDao.update(video);
    }

    @Override
    public Video findById(Integer id) {
        return videoDao.findById(id);
    }

    @Override
    public void deleteById(Integer id) {

        videoDao.deleteById(id);
    }

    @Override
    public void deleteByIds(Integer[] ids) {
        videoDao.deleteByIds(ids);
    }

    @Override
    public Video findVideoAndSpeaker(Integer id) {
        return videoDao.findVideoAndSpeaker(id);
    }
}
