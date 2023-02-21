package com.mjj.service;

import com.mjj.pojo.Role;

import java.util.List;

/**
 * @Author: mjj
 * @Date:
 * @Description:
 * @version: 1.0
 */
public interface RoleService {
    List<Role> query(Role role) throws Exception;

    Integer addRole(Role role) throws Exception;

    Integer updateRole(Role role) throws Exception;

    Integer deteleRole(Integer id) throws Exception;

    Role queryById(Integer id) throws Exception;
}
