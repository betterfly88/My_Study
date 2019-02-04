package designpattern.prototype.school;

/**
 * Created by betterfly
 * Date : 2019.01.28
 */
public class Student implements Cloneable {
    String name;
    String team;
    int age;
    Family family;

    @Override
    public Student clone() throws CloneNotSupportedException{
        Student student = (Student)super.clone();
        student.family = (Family)family.clone();

        return student;
    }

    @Override
    public String toString() {
        return "Student@" +
                hashCode() +
                "{name='" + name + '\'' +
                ", team='" + team + '\'' +
                ", age=" + age +
                ", family=" + family +
                '}';
    }
}
