package designpattern.prototype.real;

/**
 * Created by betterfly
 * Date : 2019.01.28
 */
public class Student {
    private String name;
    private Integer sId;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sId=" + sId +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }
}
