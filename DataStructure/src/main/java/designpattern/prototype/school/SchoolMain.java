package designpattern.prototype.school;

/**
 * Created by betterfly
 * Date : 2019.01.28
 */
public class SchoolMain {
    public static void main(String[] args) throws CloneNotSupportedException {
        PhysicalInform ps = new PhysicalInform();
        ps.setHeight(170);
        ps.setWeight(80);

        PhysicalInform shallowPs = ps;
        PhysicalInform deepPs = null;
        deepPs = (PhysicalInform)ps.clone();

        System.out.println(ps);
        System.out.println(shallowPs);
        System.out.println(deepPs);

        System.out.println("======================");
        ps.setHeight(185);
        ps.setWeight(66);
        System.out.println(ps);
        System.out.println(shallowPs);
        System.out.println(deepPs);


        System.out.println("\n\n");

        Student st = new Student();
        st.age = 22;
        st.team = "SLiPP Team";
        st.name = "betterFLY";

        Family family = new Family();
        family.age = 50;
        family.name = "father";
        family.isOfficeWorkers = true;
        st.family = family;

        Student deepCopyStudent = (Student)st.clone();
        deepCopyStudent.name = "효자손";
        deepCopyStudent.age = 10;
        deepCopyStudent.team = "TOMO Team";
        deepCopyStudent.family.name = "mother";
        deepCopyStudent.family.age = 55;

        System.out.println(st);
        System.out.println(deepCopyStudent);

        System.out.println("======================");

        System.out.println(st.family);
        System.out.println(deepCopyStudent.family);
        /*
        정리
        원시 타입(Primitive)의 경우 얕은 복사를 통해 값을 변경할 수 없다.
         */

    }
}
