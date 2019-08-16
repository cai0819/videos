package com.qfedu.service;

import com.qfedu.entity.User;

public interface UserService {
    public User findEmail(String email);
    public User login(String email,String password);

    public User findById(Integer id);

    public void update(User user);

    public void uploadHeadImg(Integer id, String imgUrl);

    public void updatePassword(User user, String oldPassword, String newPassword, String newPassword2);

    public void register(String email, String password, String password2);
}
