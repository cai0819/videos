package com.qfedu.controller;

import com.qfedu.common.JsonResult;
import com.qfedu.entity.User;
import com.qfedu.service.UserService;
import com.qfedu.utils.StrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @program: QFVideos
 * @ClassName: UserController
 * @description: TODO
 * @author: ccq
 * @create: 2019-08-08 11:12
 **/
@Controller
@RequestMapping("/user")

public class UserController {

    @Autowired
    private UserService userService;
    @RequestMapping("/login.do")
    @ResponseBody
    public JsonResult login(HttpSession session,String email,String password) {

        User user = userService.login(email, password);
        session.setAttribute("userLogin", user);

















































































        return new JsonResult(1, null);
    }

    @RequestMapping("/logout.do")
    @ResponseBody
    public JsonResult logout(HttpSession session){
        session.invalidate();
        return new JsonResult(1,null);
    }

    @RequestMapping("/logout2.do")
    public String logout2(HttpSession session){
        session.removeAttribute("userLogin");
        session.invalidate();
        return "redirect:/index.jsp";
    }

    @RequestMapping("/updateUser.do")
    public String update(HttpSession session,User user){
     User u= userService.findById(((User)session.getAttribute("userLogin")).getId());
        session.removeAttribute("userLogin");
        userService.update(user);
        User user1 = userService.findById(u.getId());
        session.setAttribute("userLogin",user1);
        return "redirect:/my_profile.jsp";
    }


    @RequestMapping("/upLoadImage.do")
    public String upLoadImage(@RequestParam MultipartFile imgUrl, HttpSession session) {

        User user = (User) session.getAttribute("userLogin");

        String dir = "D:/upload";

        File dirFile = new File(dir);
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }

        String filename = imgUrl.getOriginalFilename();

        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;

        File newFile = new File(dir, filename);
        try {
            imgUrl.transferTo(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        userService.uploadHeadImg(user.getId(), "/upload/" + filename);


        User sessionUser = userService.findById(user.getId());
        session.setAttribute("userLogin", sessionUser);

        return "redirect:/my_profile.jsp";
    }


    @RequestMapping("/updatePassword.do")
    @ResponseBody
    public JsonResult passwordSafe(String oldPassword, String newPassword, String newPassword2, HttpSession session) {

        try {
            User user = (User) session.getAttribute("userLogin");
            userService.updatePassword(user, oldPassword, newPassword, newPassword2);

            // 更新session中的用户信息
            User sessionUser = userService.findById(user.getId());
            session.setAttribute("userLogin", sessionUser);

            return new JsonResult(1, null);

        } catch (Exception e) {
            return new JsonResult(0, e.getMessage());
        }
    }

    @RequestMapping("/validatePassword.do")
    @ResponseBody
    public JsonResult validatePassword(String password, HttpSession session) {

        try {
            User user = (User) session.getAttribute("userLogin");

            if (!password.equals(user.getPassword())) {
                throw new RuntimeException("原密码错误！");
            }

            return new JsonResult(1, null);

        } catch (Exception e) {
            return new JsonResult(0, e.getMessage());
        }
    }


    @RequestMapping("/register.do")
    @ResponseBody
    public JsonResult insertUser(String email, String password, String psw_again, HttpSession session) {

        try {
            userService.register(email, password, psw_again);

            // 更新session中的用户信息
            User sessionUser = userService.login(email, password);
            session.setAttribute("userLogin", sessionUser);

            return new JsonResult(1, null);

        } catch (Exception e) {
            return new JsonResult(0, e.getMessage());
        }
    }

    @RequestMapping("/validateEmail")
    @ResponseBody
    public JsonResult validateEmail(String email) {

        try {
            userService.findEmail(email);
            return new JsonResult(1, null);

        } catch (Exception e) {
            return new JsonResult(0, e.getMessage());
        }
    }






}
