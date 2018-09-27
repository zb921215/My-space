package com.company.service.impl;

import java.util.List;
import java.util.Map;
import com.company.entity.Menu;
import com.company.repository.MenuMapper;
import com.company.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author sine
 * @version 
 */
@Service
public class MenuServiceImpl extends BaseServiceImpl<Menu> implements MenuService{

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private MenuMapper menuMapper;

	@Override
	public List<Menu> findPMenuByRoleId(Map map) {
		List<Menu> menuPList = menuMapper.findPMenuByRoleId(map);
		return menuPList;
	}

	@Override
	public List<Menu> findCMenuByRoleId(Map map) {
		List<Menu> menuCList = menuMapper.findCMenuByRoleId(map);
		return menuCList;
	}

	@Override
	@Transactional
	public void add(Map map) {
		//在数据库中查找比当前新增菜单下标大的菜单记录
		List<Menu> menuList = menuMapper.findMenuByOrder(map);
		for(Menu menu:menuList){
			menu.setMenuOrder(menu.getMenuOrder()+1);
			menu.setUpdateBy((int)map.get("createBy"));
			menuMapper.updateByEntity(menu);
		}
		menuMapper.insertByEntity(map);
	}

	@Override
	@Transactional
	public void update(Map map) {
		//在数据库中查找该记录之前的order
		Menu oldMenu = menuMapper.getMenuByOrder(map);//找到要修改的排列序号对应的菜单
		if(null!=oldMenu){
			Menu menu = menuMapper.selectSingle(map);//查找要修改的菜单之前的排列序号。
			oldMenu.setMenuOrder(menu.getMenuOrder());
			oldMenu.setUpdateBy((int)map.get("updateBy"));
			menuMapper.updateByEntity(oldMenu);
		}
		menuMapper.updateByEntity(map);
	}

	@Override
	public List<Map> selectData(Map map) {
		return menuMapper.selectData(map);
	}

	@Override
	public List<Map> selectOrderByMenuPid(Map map) {
		return menuMapper.selectOrderByMenuPid(map);
	}

	@Override
	public Integer getMaxOrder(Map map) {
		return menuMapper.getMaxOrder(map);
	}

}
