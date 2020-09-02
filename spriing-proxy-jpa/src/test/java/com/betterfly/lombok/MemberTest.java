package com.betterfly.lombok;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MemberTest {

    @Test
    public void getterSetter(){
        Member m = new Member();
        m.setName("betterFLY");
        m.setAge(14);

        assertTrue(m.getName().equals("betterFLY"));
    }

}