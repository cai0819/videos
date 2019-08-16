package com.qfedu.dao;

import com.qfedu.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * @program: QFVideos
 * @ClassName: UserDao
 * @description: TODO
 * @author: ccq
 * @create: 2019-08-08 10:19
 **/
public interface UserDao {

    public User login(String email);

    public User findById(Integer id);

    public void update(User user);

    public void uploadHeadImg(@Param("id") Integer id, @Param("imgUrl") String imgUrl);

    public void updatePassword(@Param("id") Integer id, @Param("password") String password);

    public void register(@Param("email") String email, @Param("password") String password, @Param("createTime") Date createTime);
}
