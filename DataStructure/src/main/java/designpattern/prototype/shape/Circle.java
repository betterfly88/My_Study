package designpattern.prototype;

import sun.security.provider.SHA;

/**
 * Created by betterfly
 * Date : 2019.01.23
 */
public class Circle extends Shape {

    public Circle(){
        super.type = "Circle";
    }

    @Override
    public void draw(){
        System.out.println("draw"+ super.type + "Shape!");
    }
}
