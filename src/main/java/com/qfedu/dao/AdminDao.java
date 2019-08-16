package com.qfedu.dao;

import com.qfedu.entity.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminDao {

    public Admin findName(String username);


}
