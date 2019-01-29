package designpattern.prototype;

import java.util.Hashtable;

/**
 * Created by betterfly
 * Date : 2019.01.23
 */
public class ShapeCache {
    private static Hashtable<String, Shape> hashTable = new Hashtable<String, Shape>();

    public static Shape getShape(String shapeId){
        Shape cachedShape = hashTable.get(shapeId);
        return (Shape)cachedShape.clone();
    }

    public static void loadCache(){
        Circle circle = new Circle();
        circle.setId("1");
        hashTable.put(circle.getId(), circle);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("2");
        hashTable.put(rectangle.getId(), rectangle);

    }
}
