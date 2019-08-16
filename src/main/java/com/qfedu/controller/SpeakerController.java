package com.qfedu.controller;

import com.github.pagehelper.Page;
import com.qfedu.common.JsonResult;
import com.qfedu.entity.Speaker;
import com.qfedu.entity.User;
import com.qfedu.service.SpeakerService;
import com.qfedu.utils.StrUtils;
import com.qfedu.vo.VVideoInfo;
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
 * @ClassName: SpeakerController
 * @description: TODO
 * @author: ccq
 * @create: 2019-08-05 16:15
 **/
@Controller
@RequestMapping("/speaker")
@ResponseBody
public class SpeakerController {

    @Autowired
    private SpeakerService speakerService;
    @RequestMapping("/page.do")
    public Map<String, Object> listSpeakerInfo(HttpSession session, String speakerName, Integer id , Integer page, Integer limit){

        List<Speaker> list = speakerService.findAll(speakerName, id,  page, limit);
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
    public JsonResult addSpeaker(Speaker speaker){
        speakerService.add(speaker);
        return new JsonResult(1,null) ;
    }
    @RequestMapping("/update.do")
    public JsonResult updateSpeaker(Speaker speaker){
        speakerService.update(speaker);
        return new JsonResult(1,null);
    }
    @RequestMapping("/query.do")
    public JsonResult findById(@Param("id") Integer id){
        Speaker speaker = speakerService.findById(id);
        return new JsonResult(1,speaker);
    }
    @RequestMapping("/delete.do")
    public JsonResult deleteById(Integer id){
        speakerService.deleteById(id);
        return new JsonResult(1,null);
    }
    @RequestMapping("/findAllSpeaker.do")
     public JsonResult findAllSpeaker(){
      List<Speaker> list1 =  speakerService.findAllSpeaker();
        return new JsonResult(1,list1);
     }

    @RequestMapping("/deleteIds.do")
    public JsonResult deleteByIdS(Integer[] ids){
        speakerService.deleteByIds(ids);
        return  new JsonResult(1,null);
    }

}
