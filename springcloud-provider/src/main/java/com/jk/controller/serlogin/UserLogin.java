package com.jk.controller.serlogin; /**
 * Copyright (C), 2019,金科
 * FileName: UserLogin
 * Author:   HT
 * Date:     2019/4/16 19:32
 * History:
 * HT          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

import com.jk.model.usersigninbean.UserBean;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * 〈登录注册类〉
 *
 * @author ht
 * @create 2019/4/16
 * @since 1.0.0
 */
@Controller
public class UserLogin {
    @Autowired
    private UserService userService;

    @GetMapping("/userlogin")
    @ResponseBody
    public HashMap<String, Object> login(UserBean userBean, String imgcode, HttpServletRequest request){


        return userService.login(userBean,imgcode,request);
    }
}

