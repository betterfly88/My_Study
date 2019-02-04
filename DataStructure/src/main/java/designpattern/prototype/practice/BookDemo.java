package designpattern.prototype.practice;

/**
 * Created by betterfly
 * Date : 2019.01.27
 */
public class BookDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        BookShop bs = new BookShop();
        bs.setShopName("First Books Store");
        bs.loadData();

        BookShop bs2 = (BookShop)bs.clone();
        bs.getList().remove(2);
        bs2.setShopName("Second Books Store");
        System.out.println(bs.toString());
        System.out.println(bs2.toString());
    }
}
