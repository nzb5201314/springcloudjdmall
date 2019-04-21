/**
 * Copyright (C), 2019,金科
 * FileName: jumpuser
 * Author:   HT
 * Date:     2019/4/17 14:56
 * History:
 * HT          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.controller.serlogin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 〈一句话功能简述〉<br> 
 * 〈跳转页面〉
 *
 * @author Administrator
 * @create 2019/4/17
 * @since 1.0.0
 */
@RestController
public class jumpuser {
    @RequestMapping("tologin")
    public ModelAndView tologin(){

        return new ModelAndView("loginhtml/login") ;
    }
    @RequestMapping("toregister")
    public ModelAndView toregister(){

        return new ModelAndView("loginhtml/register") ;
    }
    @RequestMapping("tologinwassuccessful")
    public ModelAndView tologinwassuccessful(){

        return new ModelAndView("loginhtml/loginwassuccessful") ;
    }
    @RequestMapping("toverification")
    public ModelAndView toverification(){

        return new ModelAndView("loginhtml/verification") ;
    }

}

