package com.example.gongan.service;

import com.example.gongan.entity.record;
import com.example.gongan.mapper.recordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class recordService {
    @Autowired
    private recordMapper recordMapper;
    public Integer addRecord(record record){
        return recordMapper.addRecord(record);
    }
    public List<record> findRecordByIdNumber(String idNumber){
        return recordMapper.findRecordByIdNumber(idNumber);
    }
    public  record findLastRecordByIdNumber(String idNumber) {
        return recordMapper.findLastRecordByIdNumber(idNumber);
    }
}
