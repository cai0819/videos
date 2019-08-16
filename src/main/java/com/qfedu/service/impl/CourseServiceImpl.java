package com.qfedu.service.impl;

import com.github.pagehelper.PageHelper;
import com.qfedu.dao.CourseDao;
import com.qfedu.entity.Course;
import com.qfedu.service.CourseService;
import com.qfedu.vo.VCourseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: QFVideos
 * @ClassName: CourseServiceImpl
 * @description: TODO
 * @author: ccq
 * @create: 2019-08-05 20:56
 **/
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired(required = false)
    private CourseDao courseDao;
    @Override
    public List<VCourseInfo> findAll(String courseTitle, Integer page,Integer limit) {

        PageHelper.startPage(page,limit);
        List<VCourseInfo> list = courseDao.findAll(courseTitle);
        return list;
    }

    @Override
    public void add(Course course) {
      courseDao.add(course);
    }

    @Override
    public void update(Course course) {

        courseDao.update(course);
    }

    @Override
    public Course findById(Integer id) {

        return courseDao.findById(id);
    }

    @Override
    public void deleteById(Integer id) {

        courseDao.deleteById(id);
    }

    @Override
    public List<Course> findAllCourse() {

       List<Course> list = courseDao.findAllCourse();
         return list;
    }

    @Override
    public void deleteByIds(Integer[] ids) {
        courseDao.deleteByIds(ids);
    }

    @Override
    public Course findCourseAndVideo(Integer id) {


        return courseDao.findCourseAndVideo(id);
    }


}
