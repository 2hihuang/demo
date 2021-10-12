package com.example.demo.service;

import com.example.demo.bean.Demo;
import com.example.demo.dao.DemoJdbcTemplate;
import com.example.demo.dao.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DemoService{

    @Autowired
    private DemoRepository repository;

    @Autowired
    private DemoJdbcTemplate demoJdbcTemplate;

    public List<Demo> findAll() {
        List<Demo> demos = (List<Demo>) repository.findAll();
        return demos;
    }

    @Transactional
    public void save(Demo demo) {
        repository.save(demo);
    }

    public Demo getById(Long id) {
        return demoJdbcTemplate.getByid(id);
    }

}
