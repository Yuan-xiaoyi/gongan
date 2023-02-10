package com.example.gongan.service.schedule;

import com.example.gongan.entity.record;
import com.example.gongan.entity.rule;
import com.example.gongan.mapper.recordMapper;
import com.example.gongan.util.lastTwoDay;
import com.example.gongan.mapper.ruleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@Service
public class schedule {
    @Autowired
    private ruleMapper ruleMapper;
    @Autowired
    private recordMapper recordMapper;


    @Scheduled(cron = "0 30 9 * * ?")
    private void task(){
        //业务逻辑(每天定时查询需要发送短信【处于打卡周期内，且查询此周期内无打卡记录】的人，并发送短信)
        List<rule> userList = ruleMapper.findAllRule(); // 所有尚未结束的rule者
        Iterator<rule> userIter = userList.iterator();
        while (userIter.hasNext()) {
            rule user = userIter.next();

            // 获取此周期的最后两天
            HashMap<String, Date> map = lastTwoDay.getLastTwoDay(user.getCycle());
            Date day1 = map.get("CycleFirstDay");
            Date day2 = map.get("CycleLastDay");

            // 获取当前时间
            Date curDate = new Date();
            Date curDay = new Date(curDate.getYear(), curDate.getMonth()+1, curDate.getDate());

            // 获取最后一次记录的时间
            record lastRecord = recordMapper.findLastRecordByIdNumber(user.getIdNumber());
            Date date = lastRecord.getTime();
            Date day = new Date(date.getYear(), date.getMonth()+1, date.getDate());

            if(day1.compareTo(curDay) <= 0 && day2.compareTo(curDay) >= 0 && !(day1.compareTo(day) <= 0 && day2.compareTo(day) >= 0)) {
                // 处于打卡周期内，且查询此周期内无打卡记录
                // 发送短信逻辑

            }
//            if(day1.compareTo(curDay) <= 0 && day2.compareTo(curDay) >= 0) {
//                // 当期时间处于打卡周期内
//                System.out.println("in cycle");
//            }else {
//                System.out.println("not in cycle");
//            }
//
//            if(day1.compareTo(day) <= 0 && day2.compareTo(day) >= 0){
//                // 本周期内有记录
//                System.out.println("has valid record "+ user.getIdNumber());
//            }else {
//                System.out.println("not record "+ user.getIdNumber());
//            }


        }
    }
}
