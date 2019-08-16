package com.qfedu.controller;

import com.github.pagehelper.Page;
import com.qfedu.common.JsonResult;
import com.qfedu.dao.CourseDao;
import com.qfedu.entity.Course;
import com.qfedu.entity.User;
import com.qfedu.entity.Video;
import com.qfedu.service.CourseService;
import com.qfedu.service.VideoService;
import com.qfedu.utils.StrUtils;
import com.qfedu.vo.VVideoInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: QFVideos
 * @ClassName: VideoController
 * @description: TODO
 * @author: ccq
 * @create: 2019-08-02 16:46
 **/
@Controller
@RequestMapping("/video")
@ResponseBody
public class VideoController {
    @Autowired
    private VideoService videoService;
    @Autowired
    private CourseService courseService;
    @RequestMapping("/page.do")
    public Map<String, Object> listTradeInfo(HttpSession session,String title, Integer speakerId, Integer courseId , Integer page, Integer limit){

        List<VVideoInfo> list = videoService.findAllVideos(title, speakerId, courseId,  page, limit);
        long total = ((Page) list).getTotal();
        Map<String, Object> map = new HashMap<>();
        // 结合layui的表格组件，0表示成功
        map.put("code", 0);
        map.put("msg", "");
        // 表中总记录数
        map.put("count", total);
        // 获取到的分页数据0                    0.

        map.put("data", list);
        return map;
    }

    @RequestMapping("/add.do")

    public JsonResult addVideo(Video video){
        videoService.add(video);
        return new JsonResult(1,null) ;
    }

    @RequestMapping("/update.do")
    public JsonResult updateVideo(Video video){
        videoService.update(video);
        return new JsonResult(1,null);
    }
    @RequestMapping("/query.do")
     public JsonResult findById(@Param("id") Integer id){
        Video video = videoService.findById(id);
        return new JsonResult(1,video);
     }
     @RequestMapping("/delete.do")
     public JsonResult deleteById(Integer id){
        videoService.deleteById(id);
        return new JsonResult(1,null);
     }

     @RequestMapping("/deleteIds.do")
     public JsonResult deleteByIdS(Integer[] ids){
        videoService.deleteByIds(ids);
        return  new JsonResult(1,null);
     }

    @RequestMapping("/showVideo")
    public String showVideo(Model model, Integer videoId, String subjectName) {

        Video video = videoService.findVideoAndSpeaker( videoId);

        Course course = courseService.findCourseAndVideo(video.getCourseId());

        model.addAttribute("video", video);
        model.addAttribute("subjectName", subjectName);
        model.addAttribute("course", course);

        return "forward:/section.jsp";
    }

}
