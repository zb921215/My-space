package com.company.service.impl;

import com.company.entity.Role;
import com.company.repository.RoleMapper;
import com.company.service.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

/**
 * @author sine
 * @version 
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private RoleMapper roleMapper;

	@Override
	public List<Map> selectData(Map map) {
		return roleMapper.selectData(map);
	}

}
