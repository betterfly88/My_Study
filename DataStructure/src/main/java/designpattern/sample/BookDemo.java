package designpattern.sample;

/**
 * Created by betterfly
 * Date : 2019.02.13
 */
public class BookDemo {
    public static void main(String[] args) throws CloneNotSupportedException{
        KyoboStore k = new KyoboStore();
        k.setArea("강남_1호점");
        k.makeBookList();

        KyoboStore k2 = k.clone();
        k2.setArea("강남_2호점");

        k.getBookList().remove(1);

        System.out.println(k);
        System.out.println(k2);
    }
}
