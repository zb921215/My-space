package com.company.service;

import com.company.entity.Permission;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * @author sine
 * @version
 */
public interface PermissionService extends BaseService<Permission>{

    PageInfo<Map> getPermission(Map map);

    void add(Map map);

    void updatePermissionByMap(Map map);

    Permission selectSingle(Map map);

    List<Map> findPermission(Map map);

    Map getPermissionByMenuName(Map map);

}
