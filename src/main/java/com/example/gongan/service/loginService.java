package com.example.gongan.service;

import com.example.gongan.entity.manager;
import com.example.gongan.entity.rule;
import com.example.gongan.mapper.loginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class loginService {
    @Autowired
    private loginMapper loginMapper;


    public manager login(String account, String password){
        return loginMapper.login(account, password);
    }


    public Integer addManager(manager manager){
        return loginMapper.addManager(manager);
    }

    public Integer delManager(String id){
        return loginMapper.delManager(id);
    }

}
