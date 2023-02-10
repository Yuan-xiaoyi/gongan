package com.example.gongan.mapper;

import com.example.gongan.entity.record;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface recordMapper {
    //新增打卡记录
    @Insert("""
             insert into record(id,id_number,time,geo,face)
             values(#{id},#{idNumber},#{time},#{geo},#{face})
            """)
    Integer addRecord(record record);

    //根据身份证号查找所有打卡记录
    @Select("select * from record where id_number=#{idNumber}")
    List<record> findRecordByIdNumber(String idNumber);

    //根据身份证号查找所有打卡记录的最新的一条
    @Select("select * from record where id_number=#{idNumber} order by time desc limit 1")
    record findLastRecordByIdNumber(String idNumber);
}
