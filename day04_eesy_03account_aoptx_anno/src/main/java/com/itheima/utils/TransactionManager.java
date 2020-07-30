package com.itheima.utils;

/**
 * @program: day03_eesy_01account
 * @description: TODO
 * @author: Xiaofei Wang
 * @created: 2020/07/28 19:15
 */


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 和事务管理相关的工具类，它包含了，开启事务，提交事务，回滚事务和释放连接
 */
@Component("transactionManager")
@Aspect
public class TransactionManager {

    @Autowired
    private ConnectionUtils connectionUtils;

    @Pointcut("execution(* com.itheima.service.impl.*.*(..))")
    public void pt1(){}
    /**
     * 开启事务
     */
    public  void beginTransaction(){
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
            System.out.println("事务开始");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 提交事务
     */
    public  void commit(){
        try {
            connectionUtils.getThreadConnection().commit();
            System.out.println("事务提交");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     */
    public  void rollback(){
        try {
            connectionUtils.getThreadConnection().rollback();
            System.out.println("事务回滚");
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    /**
     * 释放连接
     */
    public  void release(){
        try {
            connectionUtils.getThreadConnection().close();//还回连接池中
            connectionUtils.removeConnection();
            System.out.println("连接释放");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Around("pt1()")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
        Object rtValue = null;
        try{
            Object[] args = proceedingJoinPoint.getArgs();
            this.beginTransaction();
            rtValue = proceedingJoinPoint.proceed();
            this.commit();
            return rtValue;
        }catch(Throwable throwable){
            this.rollback();
            throw new RuntimeException(throwable);
        }finally {
            this.release();
        }
    }
}
