package designpattern.prototype;

/**
 * Created by betterfly
 * Date : 2019.02.27
 */
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Kyobo k = new Kyobo();
        k.setArea("강남_1호점");
        k.bookList();

        Kyobo k2 = (Kyobo)k.clone();
        k2.setArea("강남_2호점");
        k.getBookList().remove(1);

        System.out.println(k);
        System.out.println(k2);
    }
}
