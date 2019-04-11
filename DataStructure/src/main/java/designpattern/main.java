package designpattern;

import designpattern.iterator.Company;
import designpattern.iterator.Employee;
import designpattern.iterator.Iterator;
import designpattern.prototype.shape.Shape;
import designpattern.prototype.shape.ShapeCache;

/**
 * Created by betterfly
 * Date : 2019.01.23
 */
public class main {
    public static void main(String[] args) {
        Company company = new Company();
        company.appendEmployee(new Employee("자바맨", 95));
        company.appendEmployee(new Employee("betterFLY", 14));
        company.appendEmployee(new Employee("슬립친구", 35));

        Iterator<Employee> iterator = company.iterator();
        System.out.println(iterator.currentItem().getName());
        System.out.println(iterator.currentItem().getAge());

        while(iterator.hasNext()){
            Employee employee = iterator.next();
            System.out.println(employee.getName());
        }

    }
}