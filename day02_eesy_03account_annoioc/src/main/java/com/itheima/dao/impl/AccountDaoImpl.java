package com.itheima.dao.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: day02_eesy_02account_xmlioc
 * @description: 持久层的实现类
 * @author: Xiaofei Wang
 * @created: 2020/07/26 20:50
 */

@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {

    @Autowired
    private QueryRunner runner;

    public List<Account> findAllAccount() {
        try{
            return runner.query("select * from account", new BeanListHandler<Account>(Account.class));
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public Account findAccountById(Integer id) {
        try{
            return runner.query("select * from account where id = ?", new BeanHandler<Account>(Account.class),id);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public void saveAccount(Account account) {
        try{
            runner.update("insert into account(name,money) values(?,?)", account.getName(),account.getMoney());
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public void updateAccount(Account account) {
        try{
            runner.update("update account set name=?,money=? where id=?", account.getName(),account.getMoney(),account.getId());
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public void deleteAccount(Integer id) {
        try{
            runner.update("delete from account where id=?",id);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
