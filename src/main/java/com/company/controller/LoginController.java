package com.company.controller;

import com.company.entity.JsonResult;
import com.company.entity.LoginUser;
import com.company.entity.User;
import com.company.enums.ResultEnum;
import com.company.exception.CustomException;
import com.company.service.UserService;
import com.company.utils.MD5Utils;
import com.company.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@SessionAttributes("loginUser")
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @PostMapping("/doLogin")
    @ResponseBody
    public JsonResult doLogin(HttpServletRequest request, @RequestParam Map<String,Object> map){
        JsonResult jsonResult;
        LoginUser loginUser = userService.selectSingle(map);
        if(null!=loginUser){
            request.getSession().setAttribute("loginUser", loginUser);
            jsonResult = ResultUtil.success();
        }else{
            jsonResult = ResultUtil.error(ResultEnum.LOGIN_ERROR);
        }
        return jsonResult;
    }

    /*修改用户密码*/
    @RequestMapping(value="/modifyPassword",method=RequestMethod.GET)
    @ResponseBody
    public JsonResult modifyPassword(@RequestParam Map<String,Object> map,HttpServletRequest request){
        JsonResult jsonResult;
        LoginUser loginUser = (LoginUser) request.getSession().getAttribute("loginUser");
        String password = MD5Utils.MD5Encode(map.get("oldPassword").toString());
        if(!loginUser.getUserPassword().equals(password)){
            throw new CustomException(ResultEnum.NO_MATCH);
        }else{
            User user = new User();
            user.setUserId(loginUser.getUserId());
            user.setUserPassword(MD5Utils.MD5Encode(map.get("newPassword").toString()));
            user.setUpdateBy(loginUser.getUserId());
            userService.update(user);
        }
        logger.info("账号:"+loginUser.getUserAccount()+"已成功修改密码！");
        jsonResult = ResultUtil.success();
        return jsonResult;
    }

    @RequestMapping(value="/logout",method=RequestMethod.GET)
    @ResponseBody
    public JsonResult logout(@ModelAttribute("loginUser")LoginUser loginUser, SessionStatus sessionStatus){
        JsonResult jsonResult;
        String account = loginUser.getUserAccount();
        sessionStatus.setComplete();
        logger.info("账号:"+account+"已安全退出");
        jsonResult = ResultUtil.success();
        return jsonResult;
    }

    @RequestMapping(value = "/checkSession", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult checkSession(HttpServletRequest request) {
        JsonResult jsonResult;
        LoginUser loginUser = (LoginUser) request.getSession().getAttribute("loginUser");
        if(loginUser==null){
            jsonResult = ResultUtil.error(ResultEnum.NO_SESSION);
        }else{
            logger.debug("loginUser:" + loginUser.getUserId());
            jsonResult = ResultUtil.success(loginUser);
        }
        return jsonResult;
    }

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult getUserInfo(HttpServletRequest request) {
        JsonResult jsonResult;
        LoginUser loginUser = (LoginUser) request.getSession().getAttribute("loginUser");
        if(loginUser==null){
            jsonResult = ResultUtil.error(ResultEnum.NO_SESSION);
        }else{
            logger.debug("loginUser:" + loginUser.getUserId());
            Map map = userService.getUserInfo(loginUser.getUserId());
            jsonResult = ResultUtil.success(map);
        }
        return jsonResult;
    }


}
