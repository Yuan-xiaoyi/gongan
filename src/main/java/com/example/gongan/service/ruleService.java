package com.example.gongan.service;

import com.example.gongan.entity.rule;
import com.example.gongan.mapper.ruleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ruleService {
    @Autowired
    private ruleMapper ruleMapper;
    public int addRule(rule rule){
        return ruleMapper.addRule(rule);
    }
    public rule findRuleByIdNumber(String idNumber){
        return ruleMapper.findRuleByIdNumber(idNumber);
    }

    public rule findUserByPhone(String phone){
        return ruleMapper.findUserByPhone(phone);
    }

}
