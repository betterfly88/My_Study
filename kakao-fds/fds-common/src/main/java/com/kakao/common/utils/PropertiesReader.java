package com.kakao.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    public Properties read(Class clazz, String path) throws IOException {
        Properties properties = new Properties();
        InputStream is = clazz.getClassLoader().getResourceAsStream(path);
        properties.load(is);
        is.close();

        return properties;
    }
}
