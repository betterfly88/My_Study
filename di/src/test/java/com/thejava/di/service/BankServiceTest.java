package com.thejava.di.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BankServiceTest {

    @Autowired
    BankService bankService;

    @Test
    public void DI_주입_확인(){
        Assert.assertNotNull(bankService);
        Assert.assertNotNull(bankService.bankRepository);
    }
}