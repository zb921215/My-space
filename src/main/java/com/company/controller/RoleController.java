package com.company.controller;

import com.company.entity.JsonResult;
import com.company.entity.Role;
import com.company.service.RoleService;
import com.company.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/Role")
public class RoleController extends BaseController<Role>{

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RoleService roleService;

    @GetMapping("/selectData")
    public JsonResult selectData(@RequestParam Map map){
        JsonResult jsonResult;
        List<Map> mapList = roleService.selectData(map);
        jsonResult = ResultUtil.success(mapList);
        return jsonResult;
    }

}
