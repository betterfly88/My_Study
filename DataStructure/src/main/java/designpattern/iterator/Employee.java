package designpattern.iterator;

/**
 * Created by betterfly
 * Date : 2019.04.09
 */
public class Employee {
    private String name;
    private int age;

    public Employee(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }
}
