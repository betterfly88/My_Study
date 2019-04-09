package iterator;

import designpattern.iterator.Company;
import designpattern.iterator.Employee;
import designpattern.iterator.Iterator;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
/**
 * Created by betterfly
 * Date : 2019.04.06
 */


public class IteratorTest {
    private Company company;
    @Before
    public void setUp(){
        company = new Company();
        company.appendEmployee(new Employee("자바맨", 95));
        company.appendEmployee(new Employee("betterFLY", 14));
        company.appendEmployee(new Employee("슬립친구", 35));
    }

    @Test
    public void 반복자_패턴(){
        Iterator<Employee> iterator = company.iterator();

        assertThat(iterator.currentItem().getName(), is("자바맨"));
        assertThat(iterator.currentItem().getAge(), is(95));
        assertThat(company.getEmployee(2).getName(), is("슬립친구"));
        assertThat(company.employeesSize(), is(3));

        while(iterator.hasNext()){
            Employee employee = iterator.next();
            System.out.println(employee.getName());
        }
    }

    @Test
    public void Set_접근(){
        Queue<String> queue = new ConcurrentLinkedDeque<>();
        queue.offer("셋1");
        queue.offer("셋2");
        queue.offer("셋3");

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
