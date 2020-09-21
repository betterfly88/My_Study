package com.kakao.app.controller;

import com.kakao.app.domain.RegistUserDto;
import com.kakao.app.service.RegistService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class RegistController {
    static final Logger logger = LoggerFactory.getLogger(RegistController.class);
    private RegistService registService = new RegistService();

    public void execute(){
        RegistUserDto registUserDto = inputCustomerInfo();
    }

    private RegistUserDto inputCustomerInfo(){
        RegistUserDto registUser = new RegistUserDto();
        System.out.print("이름을 입력 해주세요 : ");
        Scanner sc = new Scanner(System.in);
        registUser.setName(sc.next());

        System.out.print("생년월일(YYYY-MM-DD)을 입력해주세요 : ");
        registUser.setBirth(sc.next());

        logger.info(registUser.toString());
        return registUser;
    }
}
