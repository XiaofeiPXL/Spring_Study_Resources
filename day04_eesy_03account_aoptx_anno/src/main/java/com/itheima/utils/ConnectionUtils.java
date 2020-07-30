package com.itheima.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @program: day03_eesy_01account
 * @description: TODO
 * @author: Xiaofei Wang
 * @created: 2020/07/28 18:53
 */

@Component("connectionUtils")
public class ConnectionUtils {

    private ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

    @Autowired
    private DataSource dataSource;

    public Connection getThreadConnection(){
        try{
            //1.从Thread上获取连接
            Connection connection = threadLocal.get();
            //2.判断当前线程上是否有连接
            if(connection==null){
                //3.从数据源获取一个连接,并绑定到thread上
                connection = dataSource.getConnection();
                threadLocal.set(connection);
            }
            //4.返回当前线程上的连接
            return connection;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }


    /**
     * 把连接和线程解绑
     */
    public void removeConnection(){
        threadLocal.remove();
    }
}
