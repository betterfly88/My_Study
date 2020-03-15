package com.theJava;

import org.junit.Test;

import static org.junit.Assert.*;

public class LightTest {
    @Test
    public void 불을_켜고_상태를_확인한다(){
        Light light = new Light();
        light.turnOn();
        light.lightState();

        assertTrue(light.isTurnOn);
    }

}