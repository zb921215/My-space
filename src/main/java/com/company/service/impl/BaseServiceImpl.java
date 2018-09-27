package com.company.service.impl;

import com.company.repository.BaseMapper;
import com.company.service.BaseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class BaseServiceImpl<T> implements BaseService<T> {

	@Autowired
	private BaseMapper<T> baseMapper;

	@Override
	public PageInfo<Map> query(Map map) {
		PageHelper.startPage(
				map.get("pageNumber")!=null?Integer.parseInt(map.get("pageNumber").toString()):1,
				map.get("pageSize")!=null?Integer.parseInt(map.get("pageSize").toString()):10
		);
		List<Map> list = baseMapper.queryByObject(map);
		PageInfo<Map> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

    @Override
    public void delete(Map map) {
		baseMapper.delete(map);
    }

	@Override
	public void add(Map map) {
		baseMapper.insertByEntity(map);
	}

	@Override
	public void update(Map map) {
		baseMapper.updateByEntity(map);
	}
}
