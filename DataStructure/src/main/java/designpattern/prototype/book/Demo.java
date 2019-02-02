package designpattern.prototype.book;

import designpattern.prototype.real.School;

/**
 * Created by betterfly
 * Date : 2019.01.27
 */


/*
    shallow copy && deep copy
    얕은 복사 : 객체의 메모리 값만 참조하기 떄문에 원본 데이터의 값에 따라 참조 객체도 동일하게 영향을 받음
    깊은 복사 :
 */
public class Demo {
    public static void main(String[] args) throws CloneNotSupportedException {
        BookShop bs = new BookShop();
        bs.setShopName("Books Shop 1");
        bs.loadData();

        BookShop bs2 = (BookShop)bs.clone();
        bs2.setShopName("Books Shop 2");

        bs.getBooks().remove(1); // index 1번째 책 분실

        System.out.println(bs);
        System.out.println(bs2);
    }
}