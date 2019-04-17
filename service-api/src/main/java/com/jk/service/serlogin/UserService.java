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
import java.util.HashMap;

/**
 * 〈一句话功能简述〉〈〉
 *
 * @author nzb
 * @create 2019/4/16
 * @since 1.0.0
 */
public interface UserService {
    @RequestMapping(value="/userlogin",  method= RequestMethod.GET)
    public HashMap<String, Object> login(@RequestBody UserBean userBean,@RequestParam(value="imgcode") String imgcode, @RequestParam(value="request") HttpServletRequest request);

}
