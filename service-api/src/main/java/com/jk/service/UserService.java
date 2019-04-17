/**
 * Copyright (C), 2019
 * FileName: UserService
 * Author:   nzb
 * Date:     2019/4/16 18:34
 * History:
 * nzb              <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.service;

import com.jk.model.usersigninbean.UserBean;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * 〈一句话功能简述〉〈〉
 *
 * @author nzb
 * @create 2019/4/16
 * @since 1.0.0
 */
public interface UserService {

    public HashMap<String, Object> login(UserBean userBean, String imgcode, HttpServletRequest request);

}
