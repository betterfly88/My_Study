package com.betterfly;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by betterfly
 * Date : 2019.02.25
 */
@ConfigurationProperties("book")
public class BookProperties {
    private String title;
    private int serial;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }
}
