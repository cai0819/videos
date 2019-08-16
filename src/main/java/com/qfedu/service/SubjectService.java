package com.qfedu.service;

import com.qfedu.entity.Subject;

import java.util.List;

/**
 * @program: QFVideos
 * @ClassName: SubjectService
 * @description: TODO
 * @author: ccq
 * @create: 2019-08-14 19:33
 **/
public interface SubjectService {

    public List<Subject> findAll();

    public Subject findAllAndCourse(Integer id);
}
