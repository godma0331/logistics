package com.mjj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: mjj
 * @Date:
 * @Description:
 * @version: 1.0
 */
@Controller
public class GotoController {


    @RequestMapping(value = {"/","/login"})
    public String show(){
        return "login";
    }

    @RequestMapping("goto")
    public String gotoUrl(String url){
        if (url.equals("")||url.equals(null)){
            return "error";
        }
        return url;
    }
}
