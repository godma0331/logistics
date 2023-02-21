package com.mjj.service.impl;

import com.mjj.mapper.RoleMapper;
import com.mjj.pojo.Role;
import com.mjj.pojo.RoleExample;
import com.mjj.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: mjj
 * @Date:
 * @Description:
 * @version: 1.0
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper mapper;
    @Override
    public List<Role> query(Role role) throws Exception {
        RoleExample example = new RoleExample();
        return mapper.selectByExample(example);
    }

    @Override
    public Integer addRole(Role role) throws Exception {
        return mapper.insertSelective(role);
    }

    @Override
    public Integer updateRole(Role role) throws Exception {
        return mapper.updateByPrimaryKeySelective(role);
    }

    @Override
    public Integer deteleRole(Integer id) throws Exception {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public Role queryById(Integer id) throws Exception{
        return mapper.selectByPrimaryKey(id);
    }
}
