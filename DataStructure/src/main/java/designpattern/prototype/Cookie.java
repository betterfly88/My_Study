package designpattern.prototype;

/**
 * Created by betterfly
 * Date : 2019.01.22
 */
public class Cookie implements Cloneable{
    private int id;

    public Object clone() throws CloneNotSupportedException {
        Cookie cookie = (Cookie) super.clone();
        return cookie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
