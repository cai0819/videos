package com.qfedu.dao;
import com.qfedu.entity.Video;
import com.qfedu.vo.VVideoInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @program: QFVideos
 * @ClassName: VideoDao
 * @description: TODO
 * @author: ccq
 * @create: 2019-08-02 16:15
 **/
public interface VideoDao {

    public List<VVideoInfo> findAll(@Param("title") String title, @Param("speakerId") Integer speakerId, @Param("courseId") Integer courseId);

    public void add(Video video);

    public void update(Video video);

    public Video findById(Integer id);

    public void deleteById(Integer id);

    public void deleteByIds(Integer[] ids);

    public Video findVideoAndSpeaker(Integer id);
}
