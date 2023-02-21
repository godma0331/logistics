package com.mjj.dto;

import com.mjj.pojo.User;

import java.util.List;

/**
 * @Author: mjj
 * @Date:
 * @Description:
 * @version: 1.0
 */
public class UserDto {
    public User user;
    public List<Integer> roleIds;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Integer> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Integer> roleIds) {
        this.roleIds = roleIds;
    }
}
