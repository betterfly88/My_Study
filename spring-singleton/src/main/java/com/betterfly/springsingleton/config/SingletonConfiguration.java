package com.betterfly.springsingleton.config;

import com.betterfly.springsingleton.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SingletonConfiguration {
    @Autowired
    @Qualifier("student")
    private Student student1;

    @Autowired
    @Qualifier("student")
    private Student student2;

    @Autowired
    @Qualifier("student3")
    private Student student3;

    @Bean(name="student3")
    public Student studentBean(){
        return new Student();
    }

    @Bean
    public void getStudentSingleton(){
        student1.setName("학생_1");
        System.out.println("=====student 1만 생성한 상태=====");
        System.out.println("student 1 : " + student1.getName());
        System.out.println("student 2 : " + student2.getName());

        System.out.println("=====student 2를 생성함=====");
        student2.setName("학생_2");
        System.out.println("student 1 : " + student1.getName());
        System.out.println("student 2 : " + student2.getName());
        System.out.println("student 3 : " + student3.getName());

        student3.setName("학생_3");
        System.out.println("student 1 : " + student1.getName());
        System.out.println("student 2 : " + student2.getName());
        System.out.println("student 3 : " + student3.getName());

    }
}
