package designpattern.prototype.youtube;

/**
 * Created by betterfly
 * Date : 2019.01.27
 */
public class CatDemo {
    public static void main(String[] args) throws CloneNotSupportedException{
        Cat navi = new Cat();
        navi.setCatName("Navi");
        navi.setAge(new Age(1999, 20));

//        Cat yo = navi;
        Cat yo = navi.copy();
        yo.setCatName("Yo!!");
//        yo.setAge(new Age(2010, 9));

        yo.getAge().setYear(2010);
        yo.getAge().setValue(9);

        System.out.println(navi.getCatName());
        System.out.println(yo.getCatName());
        System.out.println(navi.getAge().getYear() + " //" +navi.getAge().getValue());
        System.out.println(yo.getAge().getYear() + " //" +yo .getAge().getValue());

    }
}