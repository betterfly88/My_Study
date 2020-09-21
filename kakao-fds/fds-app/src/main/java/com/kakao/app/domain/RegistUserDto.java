package com.kakao.app.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RegistUserDto {
    private String name;
    private LocalDate birth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = LocalDate.parse(birth, DateTimeFormatter.ISO_DATE);
    }
}
