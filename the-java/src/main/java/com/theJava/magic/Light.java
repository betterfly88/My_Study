package com.theJava.magic;

public class Light {
    boolean isTurnOn;

    public void turnOn(){
        if(!isTurnOn){
            isTurnOn = true;
        }
    }

    public void turnOff(){
        if(isTurnOn){
            isTurnOn = false;
        }
    }

    public void lightState(){
        if(isTurnOn){
            System.out.println("Turn on the light.");
        }else{
            System.out.println("Turn off the light.");
        }
    }
}
