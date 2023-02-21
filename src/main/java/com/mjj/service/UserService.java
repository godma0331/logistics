package com.mjj.service;

import com.mjj.dto.UserDto;
import com.mjj.pojo.User;

import java.util.List;

/**
 * @Author: mjj
 * @Date:
 * @Description:
 * @version: 1.0
 */

public interface UserService {
    List<User> query(User user) throws Exception;

    Integer addUser(User user) throws Exception;

    Integer updateUser(User user) throws Exception;

    Integer deteleUser(Integer id) throws Exception;

    Integer saveOrUpdate(UserDto userDto) throws Exception;
}
