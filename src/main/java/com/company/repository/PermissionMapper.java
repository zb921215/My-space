package com.company.repository;

import com.company.entity.LoginUser;
import com.company.entity.Permission;
import com.company.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author sine
 * @version 
 */

@Mapper
public interface PermissionMapper extends BaseMapper<Permission>{

    List<Map> getPermission(Map map);

    void insertByEntity(Map map);

    void updateByEntity(Map map);

    Permission selectSingle(Map map);

    Map getPermissionByMenuName(Map map);

}