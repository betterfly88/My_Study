package com.kakao.common.config;

import com.kakao.lib.config.PropertiesValue;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class H2Configuration {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        PropertiesValue propertiesValue = new PropertiesValue();
        Properties p = propertiesValue.read(H2Configuration.class, "application.properties");

        Class.forName(p.getProperty("datasource.driver-class-name"));
        Connection connection = DriverManager.getConnection(p.getProperty("datasource.url"), p.getProperty("datasource.user"),"");

        Statement st = connection.createStatement();
        st.execute("CREATE TABLE customer (\n" +
                "    customerNo BIGINT(20) NOT NULL AUTO_INCREMENT,\n" +
                "    name varchar(50) NOT NULL,\n" +
                "    birth datetime NOT NULL,\n" +
                "    reg_date datetime default sysdate\n" +
                ")");

        connection.close();

        System.out.println(connection.getMetaData().getConnection());
    }
}
