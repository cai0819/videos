package com.qfedu.service;

import com.qfedu.entity.Admin;

/**
 * @program: QFVideos
 * @ClassName: AdminService
 * @description: TODO
 * @author: ccq
 * @create: 2019-08-07 15:54
 **/
public interface AdminService {

    public Admin findName(String username,String password);


}
