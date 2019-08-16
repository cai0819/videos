package com.qfedu.service.impl;

import com.github.pagehelper.PageHelper;
import com.qfedu.dao.SpeakerDao;
import com.qfedu.entity.Speaker;
import com.qfedu.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: QFVideos
 * @ClassName: SpeakerServiceImpl
 * @description: TODO
 * @author: ccq
 * @create: 2019-08-05 16:17
 **/
@Service
public class SpeakerServiceImpl implements SpeakerService {
    @Autowired(required = false)
    private SpeakerDao speakerDao;
    @Override
    public List<Speaker> findAll(String speakerName,Integer id, Integer page,Integer limit) {
        PageHelper.startPage(page,limit);
        List<Speaker> list =speakerDao.findAll(speakerName,id);
        return list;
    }

    @Override
    public void add(Speaker speaker) {

        speakerDao.add(speaker);
    }

    @Override
    public void update(Speaker speaker) {
        speakerDao.update(speaker);
    }

    @Override
    public Speaker findById(Integer id) {
        return speakerDao.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        speakerDao.deleteById(id);
    }

    @Override
    public List<Speaker> findAllSpeaker() {
        List<Speaker> list = speakerDao.findAllSpeaker();
        return list;
    }

    @Override
    public void deleteByIds(Integer[] ids) {
        speakerDao.deleteByIds(ids);
    }
}
