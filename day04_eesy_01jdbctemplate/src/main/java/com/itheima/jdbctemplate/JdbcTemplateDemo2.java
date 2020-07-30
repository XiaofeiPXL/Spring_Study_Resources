package com.itheima.jdbctemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @program: day04_eesy_01jdbctemplate
 * @description: TODO
 * @author: Xiaofei Wang
 * @created: 2020/07/29 20:05
 */


public class JdbcTemplateDemo2 {
    public static void main(String[] args) {
        //获取容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        //获取bean对象
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        //执行方法
        //保存
        jdbcTemplate.update("insert into account(name,money)values(?,?)","fff",2000f);
        //更新
        //删除
        //查询所有
        //查询一个
        //查询返回一行一列(使用聚合函数)
    }
}
