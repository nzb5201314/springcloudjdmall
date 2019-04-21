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

import com.jk.service.serlogin.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
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
    //登录
    @RequestMapping(value="/userlogin", method= RequestMethod.GET)
    public HashMap<String, Object> login(String password, String accountnumber){

        return userService.login(password,accountnumber);
    }
    //注册
    @RequestMapping(value="/register", method= RequestMethod.GET)
    public String register(String accountnumber,String password,String numbers){

        return userService.register(accountnumber,password,numbers);
    }
    //获取短信
    @RequestMapping(value="/gainMessgerCode", method= RequestMethod.GET)
    @ResponseBody
    public String gainMessgerCode(String numbers){
        return userService.gainMessgerCode(numbers);
    }
    //短信验证
    @RequestMapping(value="/messageLogin", method= RequestMethod.GET)
    @ResponseBody
    public String messageLogin(String numbers, Integer verificationCode){
        return userService.messageLogin(numbers,verificationCode);
    }

}

