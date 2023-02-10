package com.example.gongan.controller;

import com.example.gongan.entity.rule;
import com.example.gongan.service.ruleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@Controller
public class ruleController {
    @Autowired
    private ruleService ruleService;

    @PostMapping("/addRule")
    @ResponseBody
    public int addRule(@RequestBody rule rule){
        String uuid = UUID.randomUUID().toString();
        rule nRule = new rule(uuid,rule.getName(),rule.getIdNumber(),rule.getPhone(),rule.getStatus(),rule.getCycle(),
                                rule.getStartTime(),rule.getEndTime(),rule.getGeo(),rule.getFace());
        return ruleService.addRule(nRule);
    }

    // 根据身份ID查询
    @PostMapping("/findRuleByIdNumber")
    @ResponseBody
    public rule findRuleByIdNumber(@RequestParam String idNumber){
        return ruleService.findRuleByIdNumber(idNumber);
    }
}
