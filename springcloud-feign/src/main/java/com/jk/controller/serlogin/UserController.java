/**
 * Copyright (C), 2019,金科
 * FileName: UserController
 * Author:   HT
 * Date:     2019/4/17 9:54
 * History:
 * HT          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.controller.serlogin;

import com.jk.model.usersigninbean.UserBean;
import com.jk.service.serlogin.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * 〈一句话功能简述〉<br> 
 * 〈登录注册控制层〉
 *
 * @author Administrator
 * @create 2019/4/17
 * @since 1.0.0
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value="/userlogin", method= RequestMethod.GET)
    public HashMap<String, Object> login(UserBean userBean, String imgcode, HttpServletRequest request){


        return userService.login(userBean,imgcode,request);
    }

}

