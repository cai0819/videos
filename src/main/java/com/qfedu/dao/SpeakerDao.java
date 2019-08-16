package com.qfedu.dao;

import com.qfedu.entity.Speaker;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: QFVideos
 * @ClassName: SpeakerDao
 * @description: TODO
 * @author: ccq
 * @create: 2019-08-05 16:14
 **/
public interface SpeakerDao {
    public List<Speaker> findAll(@Param("speakerName") String speakerName,@Param("id") Integer id);

    public void add(Speaker speaker);

    public void update(Speaker speaker);

    public Speaker findById(Integer id);

    public void deleteById(Integer id);

    public List<Speaker> findAllSpeaker();

    public void deleteByIds(Integer[] ids);


}
