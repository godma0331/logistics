package com.mjj.service.impl;

import com.mjj.dto.UserDto;
import com.mjj.mapper.UserMapper;
import com.mjj.mapper.UserRoleMapper;
import com.mjj.pojo.User;
import com.mjj.pojo.UserExample;
import com.mjj.pojo.UserRoleKey;
import com.mjj.service.UserService;
import org.apache.shiro.crypto.hash.Md2Hash;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.provider.MD5;

import java.util.List;
import java.util.UUID;

/**
 * @Author: mjj
 * @Date:
 * @Description:
 * @version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public List<User> query(User user) throws Exception {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        if (user!=null){
            if (user.getUserName()!=null && !"".equals(user.getUserName())){
                criteria.andUserNameEqualTo(user.getUserName());
            }
        }
        return userMapper.selectByExample(userExample);
    }

    @Override
    public Integer addUser(User user) throws Exception {
        return userMapper.insertSelective(user);
    }

    @Override
    public Integer updateUser(User user) throws Exception {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public Integer deteleUser(Integer id) throws Exception {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer saveOrUpdate(UserDto userDto) throws Exception{
        User user = userDto.getUser();
        List<Integer> roleIds = userDto.getRoleIds();

        String salt = UUID.randomUUID().toString();
        Md5Hash passwordHash = new Md5Hash(user.getPassword(), salt);
        user.setPassword(passwordHash.toString());
        user.setU1(salt);

        this.addUser(user);
        if (roleIds!=null && roleIds.size()>0){
            for (Integer roleId : roleIds) {
                UserRoleKey userRole = new UserRoleKey();
                userRole.setUserId(user.getUserId());
                userRole.setRoleId(roleId);
                userRoleMapper.insertSelective(userRole);
            }
        }
        return 1;
    }
}
