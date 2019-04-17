/**
 * Copyright (C), 2019,金科
 * FileName: UserServiceImpl
 * Author:   HT
 * Date:     2019/4/16 22:22
 * History:
 * HT          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.service.serlogin;

import com.jk.mapper.serlogin.UserMapper;
import com.jk.model.usersigninbean.UserBean;
import com.jk.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * 〈登录注册业务逻辑层〉<br>
 * 〈a〉
 *
 * @author Administrator
 * @create 2019/4/16
 * @since 1.0.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public HashMap<String, Object> login(UserBean userBean, String imgcode, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        HttpSession session = request.getSession();
        String sessioncode = session.getAttribute("imgcode").toString();
        //判断验证码是否正确
        if (!imgcode.equals(sessioncode)) {
            result.put("code", 1);
            result.put("msg", "验证码错误");
            return result;
        }
        //通过前天传过来的账号获取账号的信息
        //UserBean userInfo = userDao.findUserInfoByAccount(userBean.getLoginnumber());
        UserBean userInfo = userMapper.findUserInfoByAccount(userBean.getAccountnumber());
        if (userInfo == null) {
            result.put("code", 2); 
            result.put("msg", "账号或密码错误");
            return result;
        }
        //判断前台传过来的密码是否和数据库的一致（注意：前台的密码需要加密后再比较）
        String password = userBean.getPassword();
        String md516 = Md5Util.getMd516(password);
        if (!userInfo.getPassword().equals(md516)) {
            result.put("code", 3);
            result.put("msg", "账号或密码错误");
            return result;
        }
        //将用户信息存入到session中
        /*session.setAttribute(session.getId(),userInfo);*/
        result.put("code", 0);
        result.put("msg", "登录成功");

        return result;
    }
}

