package com.company.service.impl;

import com.company.entity.Permission;
import com.company.repository.PermissionMapper;
import com.company.service.PermissionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class PermissionServiceImpl extends BaseServiceImpl<Permission> implements PermissionService {

	@Autowired
	private PermissionMapper permissionMapper;

	@Override
	public PageInfo<Map> getPermission(Map map) {
		PageHelper.startPage(Integer.parseInt(map.get("pageNumber").toString()),Integer.parseInt(map.get("pageSize").toString()));
		List<Map> mapList = permissionMapper.getPermission(map);
		PageInfo<Map> pageInfo = new PageInfo<>(mapList);
		return pageInfo;
	}

	@Override
	public void add(Map map) {
		permissionMapper.insertByEntity(map);
	}

    @Override
    public void updatePermissionByMap(Map map) {
		permissionMapper.updateByEntity(map);
    }

	@Override
	public Permission selectSingle(Map map) {
		return permissionMapper.selectSingle(map);
	}

    @Override
    public List<Map> findPermission(Map map) {
        return permissionMapper.getPermission(map);
    }

	@Override
	public Map getPermissionByMenuName(Map map) {
		return permissionMapper.getPermissionByMenuName(map);
	}

}
