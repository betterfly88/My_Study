package designpattern.prototype;

import org.w3c.dom.css.Rect;

/**
 * Created by betterfly
 * Date : 2019.01.23
 */
public class Rectangle extends Shape {

    public Rectangle(){
        super.type = "Rectangle";
    }

    @Override
    public void draw(){
        System.out.println("draw"+ super.type + "Shape!");
    }
}
