package com.qfedu.controller;

import com.qfedu.common.JsonResult;
import com.qfedu.entity.Admin;
import com.qfedu.service.AdminService;
import com.qfedu.utils.StrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @program: QFVideos
 * @ClassName: AdminController
 * @description: TODO
 * @author: ccq
 * @create: 2019-08-07 15:53
 **/
@Controller
@RequestMapping("/admin")
@ResponseBody
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/login.do")
    public JsonResult login(String username,String password,HttpSession session){
        try {
            Admin admin = adminService.findName(username, password);
            session.setAttribute(StrUtils.LOGIN_USER, admin);
            return new JsonResult(1, null);
        } catch (Exception e) {
            return new JsonResult(0, e.getMessage());
        }
    }

    @RequestMapping("/logout.do")
    public JsonResult logout(HttpSession session){
        session.invalidate();
        return new JsonResult(1,null);

    }
    @RequestMapping("/getLoginUser.do")
    public JsonResult loginUser( HttpSession session){

       return new JsonResult(1, session.getAttribute(StrUtils.LOGIN_USER));

    }

}
