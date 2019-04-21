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

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jk.mapper.serlogin.UserMapper;
import com.jk.model.usersigninbean.UserBean;
import com.jk.utils.HttpClientUtil;
import com.jk.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;


    //登录
    @Override
    public HashMap<String, Object> login(String accountnumber,String password) {
        HashMap<String, Object> result = new HashMap<>();
       UserBean userBean = new UserBean();
        userBean.setAccountnumber(accountnumber);
        userBean.setPassword(password);
        //通过前天传过来的账号获取账号的信息
        UserBean userInfo = userMapper.findUserInfoByAccount(userBean.getAccountnumber());
        if (userInfo == null) {
            result.put("code", 2);
            result.put("msg", "账号或密码错误");
            return result;
        }
        //判断前台传过来的密码是否和数据库的一致（注意：前台的密码需要加密后再比较）
        String passwords = userBean.getPassword();
        String md516 = Md5Util.getMd516(passwords);
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
    //注册
    @Override
    public String register(String accountnumber, String password, String numbers) {
        UserBean userBean = new UserBean();
        String promptstatement="";
        //检查该账户是否存在数据库 如果大于0表示存在
        int count= userMapper.Accountquery (accountnumber);
        if (count > 0) {
            promptstatement ="账号已存在";
            return promptstatement;
        }
        int countnumbers = userMapper.numbersquery(numbers);
        if (countnumbers >0){
            promptstatement = "手机号已存在";
            return promptstatement;
        }

        //md5加密
        password=Md5Util.getMd516(password);
        userMapper.adduest(accountnumber,password,numbers);
        return promptstatement;


    }
        int code=0;
    @Override
    public String gainMessgerCode(String numbers) {
        //验证手机号是否存在
        UserBean user = userMapper.findUserByLoginNumber(numbers);
        if(user==null){
            return "手机号不存在";
        }
        String url = "https://api.miaodiyun.com/20150822/industrySMS/sendSMS";
        HashMap<String, Object> params = new HashMap<>();
        String accountSid = "7b77f165bf8f4e27a9baac24e67fcc44";//2
        params.put("accountSid", accountSid);//开发者主账号ID（ACCOUNT SID）
        params.put("templateid", "1140753730");//短信模板ID
        //6位随机数，验证码
         code = (int) Math.ceil(Math.random()*899999+100000);
        //String codeStr = String.valueOf(code);
        params.put("param", code);//短信模板中的变量值
        params.put("to", numbers);//手机号
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String time = sdf.format(new Date());
        params.put("timestamp", time);//时间戳
        String token = "4783ac78a87444208dd9ee72175b9b16";//4
        String sig = Md5Util.getMd532(accountSid+token+time);
        params.put("sig", sig);//签名
        //发送短信
        String returnStr = HttpClientUtil.post(url, params);
        JSONObject parseObject = JSON.parseObject(returnStr);
        String respCode = parseObject.getString("respCode");
        if(!respCode.equals("00000")){
            return "发送短信验证码失败";
        }

        return "发送短信验证码成功";
    }

    @Override
    public String messageLogin(String numbers, Integer verificationCode) {
        //验证手机号是否存在
        UserBean user = userMapper.findUserByLoginNumber(numbers);
        if(user==null){
            return "手机号不存在";
        }
        //验证短信验证码是否正确
        if(code!=verificationCode){
            return "验证码错误";
        }
        //登录成功
        code=0;
        return "登录成功";
    }


}

