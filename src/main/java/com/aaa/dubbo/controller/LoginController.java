package com.aaa.dubbo.controller;

import com.aaa.dubbo.model.User;
import com.aaa.dubbo.service.IUserService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @ClassName LoginController
 * @Author wang
 * @Date 2019/9/7 0:14
 * @Version 1.0
 */
@Controller
public class LoginController {
    /**
     * roundribbon:轮询
     * random:随机
     * leastActive:最小活跃数访问：谁被请求数最小访问谁
     */
    @Reference(loadbalance = "random")
    private IUserService userService;
    /**
     * 跳转到登陆页面
     *
     * @return
     */
    @RequestMapping("/")
    private String turnAllPage() {
        return "login";
    }
    /**
     * 登陆方法
     * ModelMap类似于Model/ModelAndView
     * @param user
     * @return
     */
    @RequestMapping("/login")
    public String login(User user, ModelMap modelMap){
        Map<String,Object> resultMap=userService.selectUserByUsernameAndPassword(user);
        if (200==(Integer) resultMap.get("code")){
            User u= (User) resultMap.get("result");
            modelMap.addAttribute("user",u);
            return "redirect:/turnAllPage";
        }else {
            return "404";
        }
    }
}

