package designpattern;

import designpattern.prototype.ChocoCookie;
import designpattern.prototype.Cookie;

/**
 * Created by betterfly
 * Date : 2019.01.23
 */
public class main {
    public static void main(String[] args) {
        ChocoCookie choco = new ChocoCookie();
        choco.setName("초코 쿠키맨");
        choco.setSize(10);
        ChocoCookie brown = choco;
        brown.setName("브라운 맨");
        brown.setSize(100);

        System.out.println("초코 쿠키 : "+choco.getName());
        System.out.println("초코 쿠키 크기 " + choco.getSize());

        System.out.println("브라운 쿠키 : "+brown.getName());
        System.out.println("브라운 쿠키 크기 " + brown.getSize());
    }
}
