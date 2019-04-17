/**
 * Copyright (C), 2019,金科
 * FileName: UserServiceinterface
 * Author:   HT
 * Date:     2019/4/17 10:06
 * History:
 * HT          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.service.serlogin;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * 〈一句话功能简述〉<br> 
 * 〈登录注册接口〉
 *
 * @author Administrator
 * @create 2019/4/17
 * @since 1.0.0
 */
@FeignClient(value = "SERVICE-PROVIDER")
public interface UserServiceinterface extends UserService {

}


