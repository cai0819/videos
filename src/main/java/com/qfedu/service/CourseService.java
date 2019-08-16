package com.qfedu.service;

import com.qfedu.entity.Course;
import com.qfedu.vo.VCourseInfo;

import java.util.List;

public interface CourseService {
    public List<VCourseInfo> findAll(String courseTitle,Integer page, Integer limit);

    public void add(Course course);

    public void update(Course course);

    public Course findById(Integer id);

    public void deleteById(Integer id);

    public List<Course> findAllCourse();

    public void deleteByIds(Integer[] ids);

    public Course findCourseAndVideo(Integer id);
}
