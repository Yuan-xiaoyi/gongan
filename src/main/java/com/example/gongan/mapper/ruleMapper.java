package com.example.gongan.mapper;

import com.example.gongan.entity.rule;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ruleMapper {

    //新增录入人及其打卡规则
    @Insert("""
             insert into rule(id,name,id_number,phone,status,cycle,start_time,end_time,geo,face)
             values(#{id},#{name},#{idNumber},#{phone},#{status},#{cycle},#{startTime},#{endTime},#{geo},#{face})
            """)
    Integer addRule(rule rule);

    //根据身份证号查找用户
    @Select("select id,name,id_number,phone,status,cycle,start_time,end_time,geo,face from rule where id_number=#{idNumber}")
    rule findRuleByIdNumber(String idNumber);


    // 根据电话查用户
    @Select("select id,name,id_number,phone,status,cycle,start_time,end_time,geo,face from rule where phone=#{phone}")
    rule findUserByPhone(String phone);

    // 所有未到结束时间的rule
    @Select("SELECT * FROM rule WHERE TO_DAYS(NOW()) - TO_DAYS(end_time) <= 0")
    List<rule> findAllRule();
}
