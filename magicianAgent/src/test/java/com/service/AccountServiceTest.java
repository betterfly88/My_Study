package com.service;

import com.theJava.di.ContainerService;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountServiceTest {

    @Test
    public void IoC_컨테이너(){
        AccountService accountService = ContainerService.getObject(AccountService.class);
        assertNotNull(accountService);
        assertNotNull(accountService.accountRepository);
        accountService.accountRepository.save();
    }

}