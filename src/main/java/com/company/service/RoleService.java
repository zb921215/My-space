package com.company.service;

import com.company.entity.Role;
import com.github.pagehelper.PageInfo;
import java.util.List;
import java.util.Map;

/**
 * @author sine
 * @version
 */
public interface RoleService extends BaseService<Role>{

    List<Map> selectData(Map map);

}
