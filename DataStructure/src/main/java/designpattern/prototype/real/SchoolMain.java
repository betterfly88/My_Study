package designpattern.prototype.real;

/**
 * Created by betterfly
 * Date : 2019.01.28
 */
public class SchoolMain {
    public static void main(String[] args) throws CloneNotSupportedException{
        School sc = new School();
        sc.setSchoolName("SLiPP School");
        sc.makeStudent();

        School sc2 = sc.clone();
        sc2.setSchoolName("Second School");
        sc.getStudentList().remove(0);

        System.out.println(sc);
        System.out.println(sc2);
    }
}
