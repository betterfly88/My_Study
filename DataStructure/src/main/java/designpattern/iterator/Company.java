package designpattern.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by betterfly
 * Date : 2019.04.09
 */
public class Company implements Aggregate{
    private List<Employee> employees;

    public Company(){
        this.employees = new ArrayList<>();
    }

    public Employee getEmployee(int index){
        return this.employees.get(index);
    }

    public void appendEmployee(Employee employee){
        this.employees.add(employee);
    }

    public int employeesSize(){
        return this.employees.size();
    }
    @Override
    public Iterator iterator() {
        return new ListIterator<Employee>(this.employees);
    }
}
