package com.qfedu.entity;

import java.util.List;

/**
 * @program: QFVideos
 * @ClassName: Course
 * @description: TODO
 * @author: ccq
 * @create: 2019-08-03 17:42
 **/
public class Course {

    private int id;
    private String courseTitle;
    private String courseDesc;
    private String subjectId;

    public List<Video> getVideoList() {
        return videoList;
    }

    public void setVideoList(List<Video> videoList) {
        this.videoList = videoList;
    }

    private List<Video> videoList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseDesc() {
        return courseDesc;
    }

    public void setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }
}
