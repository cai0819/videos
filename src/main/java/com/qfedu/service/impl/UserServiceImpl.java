package com.qfedu.service.impl;

import com.qfedu.dao.UserDao;
import com.qfedu.entity.User;
import com.qfedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @program: QFVideos
 * @ClassName: UserServiceImpl
 * @description: TODO
 * @author: ccq
 * @create: 2019-08-08 11:03
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findEmail(String email) {
        User user = userDao.login(email);
        if (user != null) {
            throw new RuntimeException("账号已存在！");
        }

        return user;
    }

    @Override
    public User login(String email, String password) {
        User user = userDao.login(email);


        if (user.getEmail() == null) {
            throw new RuntimeException("账号错误");
        }
        if (!password.equals(user.getPassword())) {
            throw new RuntimeException("密码错误");
        }

        return user;
    }

    @Override
    public User findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void uploadHeadImg(Integer id, String imgUrl) {

        userDao.uploadHeadImg(id, imgUrl);
    }

    @Override
    public void updatePassword(User user, String oldPassword, String newPassword, String newPassword2) {

        if (user == null) {
            throw new RuntimeException("用户未登录！");
        }
        if (!user.getPassword().equals(oldPassword)) {
            throw new RuntimeException("原密码错误！");
        }
        if (!newPassword.equals(newPassword2)) {
            throw new RuntimeException("两次密码不一致！");
        }
        userDao.updatePassword(user.getId(), newPassword);

    }

    @Override
    public void register(String email, String password, String password2) {

        User userByEmail = userDao.login(email);
        if (userByEmail != null) {
            throw new RuntimeException("邮箱已存在！");
        }
        if (!password.equals(password2)) {
            throw new RuntimeException("两次密码不一致");
        }
        userDao.register(email, password, new Date());
    }
}

