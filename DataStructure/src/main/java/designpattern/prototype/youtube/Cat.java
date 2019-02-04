package designpattern.prototype.youtube;

/**
 * Created by betterfly
 * Date : 2019.01.27
 */
public class Cat implements Cloneable{
    private String catName;
    private Age age;

    public Age getAge() {
        return age;
    }

    public void setAge(Age age) {
        this.age = age;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public Cat copy() throws CloneNotSupportedException {
        Cat cat = (Cat)this.clone();
        //깊은 복사를 위한 Age세팅
        cat.setAge(new Age(this.getAge().getYear(), this.getAge().getValue()));
        return cat;
    }
}
