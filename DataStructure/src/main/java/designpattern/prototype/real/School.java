package designpattern.prototype.real;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by betterfly
 * Date : 2019.01.28
 */
public class School implements Cloneable{
    private String schoolName;
    private List<Student> studentList = new ArrayList<>();

    @Override
    public School clone() throws CloneNotSupportedException {
        School school = new School();
        for(Student s : this.getStudentList()){
            school.getStudentList().add(s);
        }
        return school;
    }

    public void makeStudent(){
        for(int i=0; i<10; i++){
            Student st = new Student();
            st.setsId(i);
            st.setName("Student_"+i);
            this.getStudentList().add(st);
        }
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "School@" +
                hashCode() +
                "{schoolName='" + schoolName + '\'' +
                "studentList@'" + studentList.hashCode() + '\'' +
                ", studentList=" + studentList +
                '}';
    }
}
