package com.itheima.dao;

import com.itheima.domain.Account;

/**
 * @program: day04_eesy_01jdbctemplate
 * @description: TODO
 * @author: Xiaofei Wang
 * @created: 2020/07/29 20:14
 */


public interface IAccountDao {
    /**
     * 根据Id查询账户
     * @param accountId 账户ID
     * @return 对应的账户
     */
    Account findAccountById(Integer accountId);

    /**
     * 根据名称查询账户
     * @param accountName 账户名称
     * @return 对应的账户名称
     */
    Account findAccountByName(String accountName);

    /**
     * 更新账户
     * @param account 账户
     */
    void updateAccount(Account account);
}
