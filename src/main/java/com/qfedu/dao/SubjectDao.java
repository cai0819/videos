package com.qfedu.dao;

import com.qfedu.entity.Subject;

import java.util.List;

public interface SubjectDao {

    public List<Subject> findAll();

    public Subject findAllAndCourse(Integer id);
}
