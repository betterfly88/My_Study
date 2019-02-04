package designpattern.prototype.school;

/**
 * Created by betterfly
 * Date : 2019.01.28
 */
public class Family implements Cloneable{
    String name;
    Integer age;
    boolean isOfficeWorkers;

    @Override
    public String toString() {
        return "Family@" +
                hashCode() +
                "{name='" + name + '\'' +
                ", age=" + age +
                ", isOfficeWorkers=" + isOfficeWorkers +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}
