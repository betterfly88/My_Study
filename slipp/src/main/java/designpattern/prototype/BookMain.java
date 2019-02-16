package designpattern.prototype;

/**
 * Created by betterfly
 * Date : 2019.02.14
 */
public class BookMain {
    public static void main(String[] args) throws CloneNotSupportedException {
        KyoboStore kyobo = new KyoboStore();
        kyobo.setArea("강남_1호점");
        kyobo.makeBookList();

        KyoboStore kyobo_2 = (KyoboStore)kyobo.clone();
        kyobo_2.setArea("강남_2호점");

        kyobo.getBookList().remove(1);

        System.out.println(kyobo);
        System.out.println(kyobo_2);
    }
}
