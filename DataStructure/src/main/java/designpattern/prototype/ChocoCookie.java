package designpattern.prototype;

import designpattern.prototype.Cookie;

/**
 * Created by betterfly
 * Date : 2019.01.23
 */
public class ChocoCookie extends Cookie {
    private String name;
    private int size;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
