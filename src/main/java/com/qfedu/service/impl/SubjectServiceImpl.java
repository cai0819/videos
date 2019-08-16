package com.qfedu.service.impl;

import com.qfedu.dao.SubjectDao;
import com.qfedu.entity.Subject;
import com.qfedu.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: QFVideos
 * @ClassName: SubjectServiceImpl
 * @description: TODO
 * @author: ccq
 * @create: 2019-08-14 19:34
 **/
@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
   private SubjectDao subjectDao;

    @Override
    public List<Subject> findAll() {
        return subjectDao.findAll();
    }

    @Override
    public Subject findAllAndCourse(Integer id) {
        return subjectDao.findAllAndCourse(id);
    }
}
