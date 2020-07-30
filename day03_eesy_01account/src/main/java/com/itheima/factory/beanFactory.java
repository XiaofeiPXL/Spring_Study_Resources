package com.itheima.factory;

import com.itheima.service.IAccountService;
import com.itheima.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * @program: day03_eesy_01account
 * @description: 用于创建service的代理对象工厂
 * @author: Xiaofei Wang
 * @created: 2020/07/29 00:24
 */


public class beanFactory {


    private IAccountService accountService;
    private TransactionManager transactionManager;

    public final void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }


    /**
     * 获取Service的代理对象
     *
     * @return 对应方法的返回值
     */
    public IAccountService getAccountService() {
        return (IAccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object returnValue = null;
                        try {
                            transactionManager.beginTransaction();
                            returnValue = method.invoke(accountService, args);
                            transactionManager.commit();
                            return returnValue;
                        } catch (Exception e) {
                            transactionManager.rollback();
                            throw new RuntimeException(e);
                        } finally {
                            transactionManager.release();
                        }
                    }
                });
    }
}