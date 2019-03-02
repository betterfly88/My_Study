package com.betterfly.props;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;

/**
 * Created by betterfly
 * Date : 2019.03.03
 */
// https://docs.spring.io/spring-boot/docs/2.0.3.RELEASE/reference/html/configuration-metadata.html#configuration-metadata-annotation-processor
@Component
@ConfigurationProperties("betterfly")
public class SpringProperties {
    @NotEmpty
    private String name;
    private int age;
    private String fullName;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
