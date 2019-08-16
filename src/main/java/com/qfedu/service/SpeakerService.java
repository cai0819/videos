package com.qfedu.service;

import com.qfedu.entity.Speaker;

import java.util.List;

public interface SpeakerService {
    public List<Speaker> findAll(String speakerName,Integer id,Integer page,Integer limit);

    public void add(Speaker speaker);

    public void update(Speaker speaker);

    public Speaker findById(Integer id);

    public void deleteById(Integer id);

    public List<Speaker> findAllSpeaker();

    public void deleteByIds(Integer[] ids);
}
