package com.itheima.test;


import com.itheima.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @program: day02_eesy_02account_xmlioc
 * @description: 业务层实现类的测试
 * @author: Xiaofei Wang
 * @created: 2020/07/27 00:54
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {

    @Autowired
    private IAccountService iAccountService;

    @Test
    public void testTransfer(){
        iAccountService.transfer("bbb","ccc",400.00f);
    }
}
