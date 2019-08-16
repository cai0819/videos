package com.qfedu.controller;

import com.qfedu.common.JsonResult;
import com.qfedu.entity.Subject;
import com.qfedu.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @program: QFVideos
 * @ClassName: SubjectController
 * @description: TODO
 * @author: ccq
 * @create: 2019-08-14 19:37
 **/
@RequestMapping("/subject")
@Controller
public class SubjectController {


    @Autowired
    private SubjectService subjectService;

    @RequestMapping("/list")
    @ResponseBody
    public JsonResult findAll() {

        try {
            List<Subject> list = subjectService.findAll();
            return new JsonResult(1, list);

        } catch (Exception e) {
            return new JsonResult(0, e.getMessage());
        }
    }

    @RequestMapping("/listAllAndCourse")
    public String findAllAndCourse(Model model, HttpServletRequest request) {

        int subjectId = Integer.parseInt(request.getParameter("subjectId"));

        Subject subject = subjectService.findAllAndCourse(subjectId);

        model.addAttribute("subject", subject);

        return "forward:/course.jsp";

    }
}
