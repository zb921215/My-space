package com.company.service;

import com.company.entity.LoginUser;
import com.company.entity.User;
import java.util.List;
import java.util.Map;

/**
 * @author sine
 * @version
 */
public interface UserService extends BaseService<User>{

    LoginUser selectSingle(Map map);

    List<User> selectData(Map map);

    void update(User user);

    Map getUserInfo(Integer userId);

}
