package com.example.demo.dao;

import com.example.demo.bean.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class DemoJdbcTemplate {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Demo getByid(Long id) {
        String sql = "select * from demo where id = ?";
        RowMapper<Demo> mapper = new BeanPropertyRowMapper<>(Demo.class);
        return jdbcTemplate.queryForObject(sql, mapper, id);
    }
}
