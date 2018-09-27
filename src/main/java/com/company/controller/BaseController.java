package com.company.controller;

import com.company.entity.JsonResult;
import com.company.entity.LoginUser;
import com.company.service.BaseService;
import com.company.utils.ResultUtil;
import com.github.pagehelper.PageInfo;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

public class BaseController<T> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private BaseService<T> baseService;

    @PostMapping("/add")
    public JsonResult add(@RequestParam Map<String,Object> map, HttpServletRequest request){
        LoginUser loginUser = (LoginUser) request.getSession().getAttribute("loginUser");
        map.put("updateBy",loginUser.getUserId());
        baseService.add(map);
        return ResultUtil.success();
    }

    @PostMapping("/delete")
    public JsonResult delete(@RequestParam Map<String,Object> map){
        map.put("ids",map.get("ids").toString().split(","));
        baseService.delete(map);
        return ResultUtil.success();
    }

    @PostMapping("/update")
    public JsonResult update(@RequestParam Map<String,Object> map,HttpServletRequest request){
        LoginUser loginUser = (LoginUser) request.getSession().getAttribute("loginUser");
        map.put("updateBy",loginUser.getUserId());
        baseService.update(map);
        return ResultUtil.success();
    }


    @GetMapping("/query")
    public JsonResult query(@RequestParam Map<String,Object> map){
        PageInfo<Map> pageInfo = baseService.query(map);
        return ResultUtil.successList(pageInfo.getList(),pageInfo.getTotal());
    }

}
