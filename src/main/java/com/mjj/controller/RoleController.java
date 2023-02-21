package com.mjj.controller;

import com.mjj.pojo.Role;
import com.mjj.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author: mjj
 * @Date:
 * @Description:
 * @version: 1.0
 */
@Controller
@RequestMapping("role")
public class RoleController {
    @Autowired
    private RoleService service;

    @RequestMapping("query")
    public String query(Role role, Model model) throws Exception {
        List<Role> roles = service.query(role);
        model.addAttribute("roles",roles);
        return "role/role";
    }

    @RequestMapping("roleDispatch")
    public String handlePageDispatch(Integer id,Model model) throws Exception {
        Role role = new Role();
        if (id!=null){
            role = service.queryById(id);
            model.addAttribute("role",role);
        }else {
            model.addAttribute("role",role);
        }
        return "role/updateRole";
    }

    @RequestMapping("saveOrUpdate")
    public String saveOrUpdate(Role role) throws Exception{
        if (role.getRoleId()!=null && role.getRoleId()>0){
            service.updateRole(role);
        }else {
            service.addRole(role);
        }
        return "redirect:/role/query";
    }

    @RequestMapping("deleteById")
    public String deleteById(Integer id) throws Exception{
        service.deteleRole(id);
        return "redirect:/role/query";
    }
}
