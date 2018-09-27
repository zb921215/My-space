package com.company.repository;

import com.company.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import java.util.Map;

/**
 * @author sine
 * @version 
 */

@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    List<Map> selectData(Map map);

}