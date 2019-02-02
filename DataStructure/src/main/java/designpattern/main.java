package designpattern;

import designpattern.prototype.game.Diablo;
import designpattern.prototype.game.Monster;
import designpattern.prototype.shape.Shape;
import designpattern.prototype.shape.ShapeCache;

/**
 * Created by betterfly
 * Date : 2019.01.23
 */
public class main {
    public static void main(String[] args) {
//        Monster diablo = new Diablo();
//        System.out.println(diablo.getName());
//        System.out.println(diablo.getType());
//
//        Monster anda = diablo;
//        anda.setName("안다리엘");
//        anda.setType("1차 왕");
//        System.out.println(anda.getName());
//        System.out.println(anda.getType());
//
//        System.out.println(diablo.getName());
//        System.out.println(diablo.getType());

        shapeExecutor();
    }

    public static void shapeExecutor(){
        ShapeCache.loadCache();

        Shape circle = ShapeCache.getShape("1");
        System.out.println(circle.getType());

        Shape rectangle = ShapeCache.getShape("2");
        System.out.println(rectangle.getType());
        rectangle = ShapeCache.getShape("1");
        System.out.println(rectangle.getType());
    }
}