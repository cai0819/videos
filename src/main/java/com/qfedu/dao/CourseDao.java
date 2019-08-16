package com.qfedu.dao;

import com.qfedu.entity.Course;
import com.qfedu.vo.VCourseInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseDao {

    public List<VCourseInfo> findAll(@Param("courseTitle") String courseTitle);

    public void add(Course course);

    public void update(Course course);

    public Course findById(Integer id);

    public void deleteById(Integer id);

    public List<Course> findAllCourse();

    public void deleteByIds(Integer[] ids);

    public Course findCourseAndVideo(Integer id);
}
