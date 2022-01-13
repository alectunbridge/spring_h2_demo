package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
public class RestEndpoint {

    private DataSource datasource;

    @Autowired
    public RestEndpoint(DataSource datasource) {
        this.datasource = datasource;
    }

    @GetMapping
    public String getEmployees(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
        return jdbcTemplate.queryForObject("select count(*) from EMPLOYEE", String.class);
    }
}
