/**
 * Copyright (C), 2019
 * FileName: UserBean
 * Author:   nzb
 * Date:     2019/4/16 18:34
 * History:
 * nzb              <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.model.usersigninbean;

import java.io.Serializable;

/**7
 * 〈一句话功能简述〉〈〉
 *
 * @author nzb
 * @create 2019/4/16
 * @since 1.0.0
 */
public class UserBean implements Serializable {
    private static final long serialVersionUID = -8726565627958286032L;

    private Integer userid;

    private String username;

    private String accountnumber;

    private String password;

    private String headportrait;

    private String numbers;


    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public String getHeadportrait() {
        return headportrait;
    }

    public void setHeadportrait(String headportrait) {
        this.headportrait = headportrait;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", accountnumber='" + accountnumber + '\'' +
                ", password='" + password + '\'' +
                ", headportrait='" + headportrait + '\'' +
                ", numbers='" + numbers + '\'' +
                '}';
    }
}
