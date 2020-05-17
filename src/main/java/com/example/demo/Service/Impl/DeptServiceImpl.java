package com.example.demo.Service.Impl;

import com.example.demo.Entity.Dept;
import com.example.demo.Repository.DeptRepository;
import com.example.demo.Service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptRepository deptRepository;

    @Override
    public List<Dept> queryTreeSimpleData(){
        return deptRepository.findAllByPid("0");
    }

}
