package com.company.controller;

import java.util.List;
import java.util.Map;
import com.company.entity.JsonResult;
import com.company.entity.LoginUser;
import com.company.entity.Menu;
import com.company.entity.User;
import com.company.service.MenuService;
import com.company.utils.ResultUtil;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/Menu")
@SessionAttributes("loginUser")
public class MenuController extends BaseController<Menu>{

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private MenuService menuService;

	/**
	 * author zhoubing
	 * data  2018-2-27
	 * @return 父级菜单集合
	 */
	@GetMapping("/findPMenuByRoleId")
	public JsonResult findPMenuByRoleId(@RequestParam Map map){
		JsonResult jsonResult;
		List<Menu> menuList = menuService.findPMenuByRoleId(map);
		jsonResult = ResultUtil.success(menuList);
		return jsonResult;
	}

	/**
	 * author zhoubing
	 * data  2018-1-27
	 * @return子级菜单集合
	 */
	@GetMapping("/findCMenuByRoleId")
	public JsonResult findCMenuByRoleId(@RequestParam Map map){
		JsonResult jsonResult;
		List<Menu> menuList = menuService.findCMenuByRoleId(map);
		jsonResult = ResultUtil.success(menuList);
		return jsonResult;
	}

	@PostMapping("/addMenu")
	public JsonResult addMenu(@RequestParam Map map,@ModelAttribute("loginUser") LoginUser loginUser){
		JsonResult jsonResult;
		map.put("createBy",loginUser.getUserId());
		/*对排列序号进行处理*/
		if(map.get("menuOrder").equals("")){//如果没有定义排列序号的值
			//如果新增的菜单是该级菜单的首菜单，则该级菜单MaxIndex为null，则令新增菜单的Index为1即可。
			map.put("menuOrder",menuService.getMaxOrder(map) != null? menuService.getMaxOrder(map)+1:1);
		}
		menuService.add(map);
		jsonResult = ResultUtil.success();
		return jsonResult;
	}

	@PostMapping("/updateMenu")
	public JsonResult updateMenu(@RequestParam Map map,@ModelAttribute("loginUser") LoginUser loginUser){
		JsonResult jsonResult;
		map.put("updateBy",loginUser.getUserId());

		/*对排列序号进行处理*/
		if(map.get("menuOrder").equals("")){//如果没有定义排列序号的值
			//如果更新的菜单是该级菜单的首菜单，则该级菜单MaxIndex为null，则令新增菜单的Index为1即可。
			map.put("menuOrder",menuService.getMaxOrder(map) != null? menuService.getMaxOrder(map)+1:1);
		}
		menuService.update(map);
		jsonResult = ResultUtil.success();
		return jsonResult;
	}

	@GetMapping("/selectData")
	public JsonResult selectData(@RequestParam Map map){
		JsonResult jsonResult;
		List<Map> mapList = menuService.selectData(map);
		jsonResult = ResultUtil.success(mapList);
		return jsonResult;
	}

	@GetMapping("/selectOrderByMenuPid")
	public JsonResult selectOrderByMenuPid(@RequestParam Map map){
		JsonResult jsonResult;
		List<Map> mapList = menuService.selectOrderByMenuPid(map);
		jsonResult = ResultUtil.success(mapList);
		return jsonResult;
	}
}
