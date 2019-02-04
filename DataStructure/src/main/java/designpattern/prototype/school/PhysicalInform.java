package designpattern.prototype.school;

/**
 * Created by betterfly
 * Date : 2019.01.28
 */
public class PhysicalInform implements Cloneable{
    public int height;
    public int weight;

    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    @Override
    public String toString() {
        return "PhysicalInform@" +
                hashCode()+
                " {height=" + height +
                ", weight=" + weight +
                '}';
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
