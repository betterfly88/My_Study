package com.betterfly.springboot.account;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

import static org.junit.Assert.*;

/**
 * Created by betterfly
 * Date : 2019.03.14
 */

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {
    /*
    슬라이스 테스트는 @DataJpaTest
    레파지토리를 포함한 레파지토리와 관련된 빈들만 등록만 해서 테스트를 만드는 것

    슬라이스 테스트에는
    in memory database가 반드시 필요함
    h2 db를 테스트 의존성에 추가하기
     */

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void di(){

    }
}