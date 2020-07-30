package com.itheima.service;

import com.itheima.domain.Account;

import java.util.List;

/**
 * @program: day02_eesy_02account_xmlioc
 * @description: 账户的业务层接口
 * @author: Xiaofei Wang
 * @created: 2020/07/26 20:16
 */


public interface IAccountService {
    /**
     * 查询所有账户的信息
     * @return 返回对应的账户信息列表
     */
    List<Account> findAllAccount();

    /**
     * 根据id查询账户信息
     * @param id 账户id
     * @return 对应的账户信息
     */
    Account findAccountById(Integer id);

    /**
     * 保存账户
     * @param account 账户对象
     */
    void saveAccount(Account account);

    /**
     * 更新账户信息
     * @param account 对应的账户
     */
    void updateAccount(Account account);

    /**
     * 删除账户
     * @param id 账户ID
     */
    void deleteAccount(Integer id);

    /**
     * 转账
     * @param sourceName 转出账户名称
     * @param targetName 转入账户名称
     * @param money 转账金额
     */
    void transfer(String sourceName, String targetName,Float money);
}
