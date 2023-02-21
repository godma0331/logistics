package com.mjj.controller;

import com.mjj.dto.UserDto;
import com.mjj.pojo.Role;
import com.mjj.pojo.User;
import com.mjj.service.RoleService;
import com.mjj.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: mjj
 * @Date:
 * @Description:
 * @version: 1.0
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping("query")
    public String query(User user, Model model) throws Exception {
        List<User> users = userService.query(user);
        model.addAttribute("users",users);
        return "user/user";
    }

    @RequestMapping("userDispatch")
    public String userDispatch(Model model) throws Exception{
        User user = new User();
        List<Role> roles = roleService.query(new Role());
        model.addAttribute("roles",roles);
        model.addAttribute("user",user);
        return "user/updateUser";
    }

    @RequestMapping("saveOrUpdate")
    public String saveOrUpdate(UserDto userDto) throws Exception{
        userService.saveOrUpdate(userDto);
        return "redirect:/user/query";
    }

    @RequestMapping("checkUserName")
    @ResponseBody
    public String checkUserName(User user) throws Exception {
        List<User> users = userService.query(user);
        if (users==null || users.size()==0){
            return "1";
        }
        return "0";
    }
}
