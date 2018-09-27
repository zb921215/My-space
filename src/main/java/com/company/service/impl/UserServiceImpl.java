package com.company.service.impl;

import com.company.entity.LoginUser;
import com.company.entity.User;
import com.company.repository.UserMapper;
import com.company.service.UserService;
import com.company.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl  extends BaseServiceImpl<User> implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public LoginUser selectSingle(Map map) {
		map.put("userPassword", MD5Utils.MD5Encode(map.get("userPassword").toString()));
		return userMapper.selectSingle(map);
	}

	@Override
	public List<User> selectData(Map map) {
		return userMapper.selectData(map);
	}

	@Override
	public void update(User user) {
		userMapper.updateByEntity(user);
	}

    @Override
    public Map getUserInfo(Integer userId) {
		return userMapper.getUserInfo(userId);
    }

}
