package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import com.itheima.service.IAccountService;

import java.util.List;

/**
 * @program: day02_eesy_02account_xmlioc
 * @description: 账户操作的实现类
 * @author: Xiaofei Wang
 * @created: 2020/07/26 20:25
 */


public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAllAccount() {

        return accountDao.findAllAccount();
    }

    public Account findAccountById(Integer id) {

        return accountDao.findAccountById(id);
    }

    public void saveAccount(Account account) {

        accountDao.saveAccount(account);

    }

    public void updateAccount(Account account) {

        accountDao.updateAccount(account);

    }

    public void deleteAccount(Integer id) {

        accountDao.deleteAccount(id);

    }

    public void transfer(String sourceName, String targetName, Float money) {
        System.out.println("transfer方法开始执行了...");
        //2.1根据名称查询转出账户
        Account sourceAccount = accountDao.findAccountByName(sourceName);
        //2.2根据名称查询转入账户
        Account targetAccount = accountDao.findAccountByName(targetName);
        //2.3转出账户减钱
        sourceAccount.setMoney(sourceAccount.getMoney() - money);
        //2.4转入账户加钱
        targetAccount.setMoney(targetAccount.getMoney() + money);
        //2.5更新转出账户
        accountDao.updateAccount(sourceAccount);
        //int i=10/0;
        //2.6更新转入账户
        accountDao.updateAccount(targetAccount);

    }
}
