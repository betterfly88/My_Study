package com.betterfly.springbootmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by betterfly
 * Date : 2019.03.22
 */

@Component
public class MySQLRunner implements ApplicationRunner {
    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        /*
        java 1.8에 업데이트된 try-resource 문법으로
        이와 같이 진행하면, try안에서 사용한 자원을 사용한 후 자동으로 제거(삭제)된다.
         */
        try(Connection connection = dataSource.getConnection()){
            System.out.println(dataSource.getClass()); // DBCP 확인
            System.out.println(connection.getMetaData().getURL());
            System.out.println(connection.getMetaData().getUserName());

            // table 생성
            Statement statement = connection.createStatement();
            String sql = "CREATE TABLE USER(id INTEGER NOT NULL, name VARCHAR(255), PRIMARY KEY (id))";
            statement.executeUpdate(sql);

            jdbcTemplate.execute("INSERT INTO USER VALUES (1,'betterfly')");
        }


        /**
         * dataSource API를 직접 구현하는 것보다 jdbcTemplate 사용을 추천
         *
         * jdbcTemplate을 사용하면 보다 간결하게 사용이 가능하다.
         * try-catch-finally 같은 리소스 반납처리가 잘 되어있고
         * 예외처리시 가독성이 좋은 에러를 확인할 수 있다.(에러 계층 구조가 잘 만들어져 있음)
         */
//        jdbcTemplate.execute("INSERT INTO USER VALUES (1,'betterfly')");
    }
}
