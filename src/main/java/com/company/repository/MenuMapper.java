package com.company.repository;

import com.company.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import java.util.Map;

/**
 * @author sine
 * @version 
 */

@Mapper
public interface MenuMapper extends BaseMapper<Menu>{

    List<Menu> findPMenuByRoleId(Map map);

    List<Menu> findCMenuByRoleId(Map map);

    List<Menu> selectByObject(Map map);

    List<Map> selectData(Map map);

    List<Map> selectOrderByMenuPid(Map map);

    Integer getMaxOrder(Map map);

    List<Menu> findMenuByOrder(Map map);

    void updateByEntity(Menu menu);

    Menu selectSingle(Map map);

    Menu getMenuByOrder(Map map);

}