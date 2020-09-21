package com.kakao.common.utils;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.*;

public class PropertiesReaderTest {
    private PropertiesReader reader;

    @Before
    public void setUp(){
        reader = new PropertiesReader();
    }


    @Test
    public void Properties_세팅값을_가져온다() throws IOException {
        Properties p = reader.read(PropertiesReaderTest.class, "application.properties");

        String user = p.getProperty("datasource.user");

        assertTrue(user.equals("sa"));
    }
}