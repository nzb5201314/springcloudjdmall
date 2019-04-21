package com.jk.controller.serlogin; /**
 * Copyright (C), 2019,金科
 * FileName: UserLogin
 * Author:   HT
 * Date:     2019/4/16 19:32
 * History:
 * HT          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

import com.jk.service.serlogin.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
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
    //登录
    @RequestMapping(value="/userlogin", method= RequestMethod.GET)
    @ResponseBody
    public HashMap<String, Object> login(String accountnumber,String password,HttpSession session){


        return userService.login(accountnumber,password);
    }

    //注册
    @RequestMapping(value="/register", method= RequestMethod.GET)
    @ResponseBody
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

