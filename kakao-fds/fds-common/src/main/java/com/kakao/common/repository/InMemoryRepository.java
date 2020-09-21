package com.kakao.common.repository;

import com.kakao.common.config.H2Configuration;
import com.kakao.common.utils.PropertiesReader;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class InMemoryRepository implements RepositoryFactory{
    private static String PROPERTIES_FILE = "application.properties";

    @Override
    public Connection connect() throws ClassNotFoundException, IOException, SQLException {
        PropertiesReader propertiesReader = new PropertiesReader();
        Properties p = propertiesReader.read(H2Configuration.class, PROPERTIES_FILE);
        Class.forName(p.getProperty("datasource.in-memory.driver-class-name"));

        //        Statement st = connection.createStatement();
//        st.execute("CREATE TABLE customer (\n" +
//                "    customerNo BIGINT(20) NOT NULL AUTO_INCREMENT,\n" +
//                "    name varchar(50) NOT NULL,\n" +
//                "    birth datetime NOT NULL,\n" +
//                "    reg_date datetime default sysdate\n" +
//                ")");

        return DriverManager.getConnection(p.getProperty("datasource.in-memory.url"), p.getProperty("datasource.in-memory.user"),"");
    }
}
