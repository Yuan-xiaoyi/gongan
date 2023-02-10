package com.example.gongan.controller;

import com.example.gongan.entity.manager;
import com.example.gongan.entity.rule;
import com.example.gongan.service.loginService;
import com.example.gongan.service.ruleService;
import com.example.gongan.util.token.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.UUID;

@Controller
public class loginController {
    @Autowired
    private loginService loginService;
    @Autowired
    private ruleService ruleService;

    // 网页端登录
    @PostMapping("/login")
    @ResponseBody
    public HashMap<String, String> login(@RequestParam String account, @RequestParam String password){
        manager manager = loginService.login(account, password);
        HashMap<String,String> res = new HashMap<>();
        if(manager != null){
            res.put("token", "token");
            res.put("msg","登录成功");
            return res;
        }
        res.put("msg","登录失败");
        return res;
    }

    // 微信登录
    @PostMapping("/loginWx")
    @ResponseBody
    public HashMap<String,String> loginWx(@RequestParam String phoneNumber){

        rule userinfo = ruleService.findUserByPhone(phoneNumber);
        if(userinfo!=null){
            rule user = new rule();
            user.setName(userinfo.getName());
            String signToken = TokenUtil.sign(user);//首次登录token签名
            HashMap<String,String> jsonObject=new HashMap<>();
            jsonObject.put("token",signToken);
            jsonObject.put("msg","登录成功");
            return jsonObject;
        }
        return  null;
    }

    @PostMapping("/addManager")
    @ResponseBody
    public Integer addManager(@RequestBody manager manager){
        String uuid = UUID.randomUUID().toString();
        manager mgr = new manager(uuid,manager.getAccount(),manager.getPassword(),manager.getName());
        return loginService.addManager(mgr);
    }

    @GetMapping("/delManager")
    @ResponseBody
    public Integer delManager(@RequestParam String id){
        return loginService.delManager(id);
    }
}
