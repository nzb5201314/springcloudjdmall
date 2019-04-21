/**
 * Copyright (C), 2019
 * FileName: UserService
 * Author:   nzb
 * Date:     2019/4/16 18:34
 * History:
 * nzb              <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.service.serlogin;

import com.jk.model.usersigninbean.UserBean;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * 〈一句话功能简述〉〈〉
 *
 * @author nzb
 * @create 2019/4/16
 * @since 1.0.0
 */
public interface UserService {
    //登录
    @RequestMapping(value="/userlogin", method= RequestMethod.GET)
    public HashMap<String, Object> login(@RequestParam(value="password") String password, @RequestParam(value="accountnumber") String accountnumber);
    //注册
    @RequestMapping(value="/register", method= RequestMethod.GET)
    String register(@RequestParam(value="accountnumber")String accountnumber,@RequestParam(value="password") String password,@RequestParam(value="numbers") String numbers);
    //获取验证码
    @RequestMapping(value="/gainMessgerCode", method= RequestMethod.GET)
    String gainMessgerCode(@RequestParam(value="numbers")String numbers);
    //验证短信验证码
    @RequestMapping(value="/messageLogin", method= RequestMethod.GET)
    String messageLogin(@RequestParam(value="numbers")String numbers,@RequestParam(value="verificationCode")Integer verificationCode);
}
