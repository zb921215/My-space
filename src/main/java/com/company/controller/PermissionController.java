package com.company.controller;

import com.company.entity.JsonResult;
import com.company.entity.LoginUser;
import com.company.entity.Permission;
import com.company.service.PermissionService;
import com.company.service.UserService;
import com.company.utils.ResultUtil;
import com.github.pagehelper.PageInfo;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Permission")
@SessionAttributes("loginUser")
public class PermissionController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PermissionService permissionService;

    /*根据角色ID获取其对应所有菜单的权限。*/
    @GetMapping("/getPermission")
    public JsonResult getPermission(@RequestParam Map map){
        JsonResult jsonResult;
        PageInfo<Map> pageInfo = permissionService.getPermission(map);
        jsonResult = ResultUtil.successList(pageInfo.getList(),pageInfo.getTotal());
        return jsonResult;
    }

    /*根据角色ID获取其权限。*/
    @GetMapping("/findPermission")
    public JsonResult findPermission(@RequestParam Map map){
        JsonResult jsonResult;
        List<Map> mapList = permissionService.findPermission(map);
        jsonResult = ResultUtil.success(mapList);
        return jsonResult;
    }

    /*更改权限*/
    @PostMapping("/updatePermission")
    public JsonResult updatePermission(@RequestParam Map map,@ModelAttribute("loginUser") LoginUser loginUser){
        JsonResult jsonResult;
        map.put("updateBy",loginUser.getUserId());
        if(null==map.get("permissionId")){//如果之前该角色没有对应的该菜单权限→新增。
            map.put("createBy",loginUser.getUserId());
            permissionService.add(map);
        }else{//如果该角色已经有该菜单的权限，则只需要更新即可。
            map.put("updateBy",loginUser.getUserId());
            permissionService.updatePermissionByMap(map);
        }
        jsonResult = ResultUtil.success();
        return jsonResult;
    }

    /*根据角色ID获取该菜单权限。*/
    @GetMapping("/getPermissionByMenuName")
    public JsonResult getPermissionByMenuName(@RequestParam Map map){
        JsonResult jsonResult;
        Map resultMap = permissionService.getPermissionByMenuName(map);
        jsonResult = ResultUtil.success(resultMap);
        return jsonResult;
    }

}
