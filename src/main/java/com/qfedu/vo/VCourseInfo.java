package com.qfedu.vo;

/**
 * @program: QFVideos
 * @ClassName: VCourseInfo
 * @description: TODO
 * @author: ccq
 * @create: 2019-08-05 20:45
 **/
public class VCourseInfo {

    private int id;
    private String courseTitle;
    private String courseDesc;
    private String subjectName;

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

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
