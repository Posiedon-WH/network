package com.posiedon.network.serial;

import java.io.Serializable;

/**
 * @Author: Posiedon.wh
 * @Date: 2020/9/20 21:30
 */
public class UserInfo implements Serializable {

    private String name;
    private int age;

    public UserInfo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
