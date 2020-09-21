package com.kakao.app.service;

import com.kakao.common.entity.Customer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RegistUserServiceTest {
    public RegistService registService;

    @Before
    public void setUp(){
        registService = new RegistService();
    }

    @Test
    public void 신규_가입(){
//        Customer customer = registService.generateCustomer();
//
//        System.out.println(customer.toString());
    }
}