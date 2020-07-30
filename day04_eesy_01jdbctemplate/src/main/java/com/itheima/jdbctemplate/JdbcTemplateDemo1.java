package com.itheima.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @program: day04_eesy_01jdbcTemplate
 * @description: JDBCTemplate的基本用法
 * @author: Xiaofei Wang
 * @created: 2020/07/29 17:40
 */


public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
        //准备数据源,spring的内置数据源
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/JDBCDemo?serverTimezone=UTC");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("514524wxfpxl");

        //创建JDBCTemplate对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(driverManagerDataSource);
        jdbcTemplate.execute("insert into account(name,money)values('ddd',1000)");
    }
}
