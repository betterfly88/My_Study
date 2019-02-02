package designpattern.prototype.capable;

/**
 * Created by betterfly
 * Date : 2019.01.29
 */
public class AuthorizedSignatory implements Cloneable {
    private String name;
    private String designation;

    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
    @Override
    public String toString() {
        return "AuthorizedSignatory{" +
                "name='" + name + '\'' +
                ", designation='" + designation + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
