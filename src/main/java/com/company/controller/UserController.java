package com.company.controller;

import com.company.entity.JsonResult;
import com.company.entity.LoginUser;
import com.company.entity.User;
import com.company.service.UserService;
import com.company.utils.MD5Utils;
import com.company.utils.ResultUtil;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/User")
@SessionAttributes("loginUser")
public class UserController extends BaseController<User>{

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public JsonResult add(@RequestParam Map map,HttpServletRequest request){
        JsonResult jsonResult;
        LoginUser loginUser = (LoginUser) request.getSession().getAttribute("loginUser");
        map.put("createBy",loginUser.getUserId());
        map.put("userPassword", MD5Utils.MD5Encode(map.get("userPassword").toString()));
        userService.add(map);
        jsonResult = ResultUtil.success();
        return jsonResult;
    }

    @GetMapping("/selectData")
    public JsonResult selectData(@RequestParam Map map){
        JsonResult jsonResult;
        List<User> userList = userService.selectData(map);
        jsonResult = ResultUtil.success(userList);
        return jsonResult;
    }

}
