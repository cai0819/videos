package com.qfedu.controller;

import com.github.pagehelper.Page;
import com.qfedu.common.JsonResult;
import com.qfedu.entity.Course;
import com.qfedu.entity.User;
import com.qfedu.service.CourseService;
import com.qfedu.utils.StrUtils;
import com.qfedu.vo.VCourseInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: QFVideos
 * @ClassName: CourseController
 * @description: TODO
 * @author: ccq
 * @create: 2019-08-05 21:23
 **/
@Controller
@RequestMapping("/course")
@ResponseBody
public class CourseController {

    @Autowired
    private CourseService courseService;
    @RequestMapping("/page.do")
    public Map<String, Object> listTradeInfo(HttpSession session,String courseTitle,Integer page, Integer limit){

        List<VCourseInfo> list = courseService.findAll(courseTitle,page, limit);
        long total = ((Page) list).getTotal();
        Map<String, Object> map = new HashMap<>();
        // 结合layui的表格组件，0表示成功
        map.put("code", 0);
        map.put("msg", "");
        // 表中总记录数
        map.put("count", total);
        // 获取到的分页数据
        map.put("data", list);
        return map;
    }


    @RequestMapping("/add.do")

    public JsonResult addCourse(Course course){
        courseService.add(course);
        return new JsonResult(1,null) ;
    }

    @RequestMapping("/update.do")
    public JsonResult updateVideo(Course course){
        courseService.update(course);
        return new JsonResult(1,null);
    }
    @RequestMapping("/query.do")
    public JsonResult findById(@Param("id") Integer id){
        Course course = courseService.findById(id);
        return new JsonResult(1,course);
    }
    @RequestMapping("/delete.do")
    public JsonResult deleteById(Integer id){
        courseService.deleteById(id);
        return new JsonResult(1,null);
    }

    @RequestMapping("/findAllCourse.do")
    public JsonResult findAllCourse(){
       List<Course> list2= courseService.findAllCourse();
        return new JsonResult(1,list2);
    }

    @RequestMapping("/deleteIds.do")
    public JsonResult deleteByIdS(Integer[] ids){
        courseService.deleteByIds(ids);
        return  new JsonResult(1,null);
    }




}
