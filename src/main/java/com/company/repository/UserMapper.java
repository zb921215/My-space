package com.company.repository;

import com.company.entity.LoginUser;
import com.company.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author sine
 * @version 
 */

@Mapper
public interface UserMapper extends BaseMapper<User>{

    LoginUser selectSingle(Map map);

    List<User> selectData(Map map);

    void updateByEntity(User user);

    Map getUserInfo(Integer userId);

}