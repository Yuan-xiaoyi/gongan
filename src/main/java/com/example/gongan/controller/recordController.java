package com.example.gongan.controller;

import com.example.gongan.entity.record;
import com.example.gongan.entity.rule;
import com.example.gongan.service.recordService;
import com.example.gongan.service.ruleService;
import com.example.gongan.util.lastTwoDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Controller
public class recordController {
    @Autowired
    private recordService recordService;
    @Autowired
    private ruleService ruleService;

    //  @RequestBody：负责把json对象解析成Java对象
    //  @ResponseBody：负责把Java对象转换成json对象

    //新增记录
    @PostMapping("/addRecord")
    @ResponseBody
    public HashMap<String,String> addRecord(@RequestBody record record){
        HashMap<String,String> res = new HashMap();
        rule user = ruleService.findRuleByIdNumber(record.getIdNumber());
        // 获取当前时间
        Date curDate = new Date();
        Date curDay = new Date(curDate.getYear(), curDate.getMonth()+1, curDate.getDate());

        /**
         * Date.compareTo（date)
         * 如果两个日期相等，则返回值为0。
         * 如果Date在date参数之后，则返回值大于0。
         * 如果Date在date参数之前，则返回值小于0。
         * */
        if (user.getEndTime().compareTo(curDate) < 0){ // 周期已经结束
            res.put("code", "500");
            res.put("msg", "无需打卡");
            return res;
        }else {
            // 获取此周期的最后两天
            HashMap<String, Date> map = lastTwoDay.getLastTwoDay(user.getCycle());
            Date day1 = map.get("CycleFirstDay");
            Date day2 = map.get("CycleLastDay");
            // 获取最后一次记录的时间
            record lastRecord = recordService.findLastRecordByIdNumber(user.getIdNumber());
            Date date = lastRecord.getTime();
            Date day = new Date(date.getYear(), date.getMonth() + 1, date.getDate());

            if (day1.compareTo(curDay) <= 0 && day2.compareTo(curDay) >= 0 && !(day1.compareTo(day) <= 0 && day2.compareTo(day) >= 0)) {
                // 当前处于打卡周期内，且 查询此周期内无打卡记录
                // 添加记录逻辑
                String uuid = UUID.randomUUID().toString();
                record nRecord = new record(uuid, record.getIdNumber(), record.getTime(), record.getGeo(), record.getFace());
                if (recordService.addRecord(nRecord) == 1) {
                    res.put("code", "200");
                    res.put("msg", "添加成功");
                    return res;
                }
                res.put("code", "500");
                res.put("msg", "添加失败");
                return res;
            } else if (!(day1.compareTo(curDay) <= 0 && day2.compareTo(curDay) >= 0)) {
                // 当前处于打卡周期外
                res.put("code", "500");
                res.put("msg", "不在打卡时间段内");
                return res;
            } else if (day1.compareTo(day) <= 0 && day2.compareTo(day) >= 0) {
                // 此周期内有打卡记录
                res.put("code", "500");
                res.put("msg", "本周期内已打卡");
                return res;
            }
        }
        return res;
    }

    // 根据身份ID查询
    @PostMapping("/findRecordByIdNumber")
    @ResponseBody
    public List<record> findRecordByIdNumber(@RequestParam String idNumber){
        return recordService.findRecordByIdNumber(idNumber);
    }

}
