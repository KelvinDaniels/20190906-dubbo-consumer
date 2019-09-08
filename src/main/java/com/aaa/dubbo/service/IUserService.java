package com.aaa.dubbo.service;

import com.aaa.dubbo.model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface IUserService {
    /**
     * 登陆
     * 根据用户名和密码查询
     * @param user
     * @return
     */
    Map<String,Object> selectUserByUsernameAndPassword(User user);
}
