package com.betterfly.lombok;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Member {
    private String name;
    private int age;

    public boolean isSameAge(Member member){
        return this.age == member.getAge();
    }

}
