package com.example.gongan.mapper;

import com.example.gongan.entity.manager;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface loginMapper {
    //新增管理员
    @Insert("""
             insert into manager(id,account,password,name) 
             values(#{id},#{account},#{password},#{name})
            """)
    Integer addManager(manager manager);

    // 删除管理员
    @Delete("""
             delete from manager where id=#{id}
            """)
    Integer delManager(String id);

    // 登录
    @Select("select id,account,password,name from manager where account=#{account} and password=#{password}")
    manager login(String account, String password);


}
