package com.company.service;

import java.util.List;
import java.util.Map;
import com.company.entity.Menu;
import com.github.pagehelper.PageInfo;

/**
 * @author sine
 * @version
 */
public interface MenuService extends BaseService<Menu>{

    List<Menu> findPMenuByRoleId(Map map);

    List<Menu> findCMenuByRoleId(Map map);

    void add(Map map);

    void update(Map map);

    List<Map> selectData(Map map);

    List<Map> selectOrderByMenuPid(Map map);

    Integer getMaxOrder(Map map);
}
