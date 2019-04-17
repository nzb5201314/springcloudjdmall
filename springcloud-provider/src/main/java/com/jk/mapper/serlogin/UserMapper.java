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

/**
 * 〈一句话功能简述〉<br> 
 * 〈登录注册持久层〉
 *
 * @author Administrator
 * @create 2019/4/16
 * @since 1.0.0
 */
public interface UserMapper {

    UserBean findUserInfoByAccount(String accountnumber);

}

