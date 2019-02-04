package designpattern.prototype.youtube;

/**
 * Created by betterfly
 * Date : 2019.01.27
 */
public class Age {
    public int year;
    public int value;

    public Age(int _year, int _value){
        this.year = _year;
        this.value = _value;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
