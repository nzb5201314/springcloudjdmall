/**
 * Copyright (C), 2019,金科
 * FileName: UserMapper
 * Author:   HT
 * Date:     2019/4/16 22:37
 * History:
 * HT          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.mapper.serlogin;

import com.jk.model.usersigninbean.UserBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * 〈一句话功能简述〉<br> 
 * 〈登录注册持久层〉
 *
 * @author Administrator
 * @create 2019/4/16
 * @since 1.0.0
 */
public interface UserMapper {
    //登录查出账号所有信息
    @Select("select * from h_user t where t.accountnumber= #{accountnumber}")
    UserBean findUserInfoByAccount(String accountnumber);
    //注册查询账号是否存在
    @Select("select count(*) from h_user t where t.accountnumber=#{accountnumber}")
    int Accountquery(String accountnumber);
    //注册查询手机号是否存在
    @Select("select count(*) from h_user t where t.numbers=#{numbers}")
    int numbersquery(String numbers);
    //注册新用户
    @Insert("insert into h_user (accountnumber,password,numbers) values(#{accountnumber},#{password},#{numbers})")
    void adduest(String accountnumber, String password, String numbers);
    //获取手机信息
    @Select("select * from h_user t where t.numbers=#{numbers}")
    UserBean findUserByLoginNumber(String numbers);
}

