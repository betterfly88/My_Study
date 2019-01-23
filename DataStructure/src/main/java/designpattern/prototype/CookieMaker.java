package designpattern.prototype;

/**
 * Created by betterfly
 * Date : 2019.01.23
 */
public class CookieMaker {
    private Cookie cookie;
    public CookieMaker(Cookie cookie){
        this.cookie = cookie;
    }

    public Cookie makeCookie() throws CloneNotSupportedException {
        return (Cookie) cookie.clone();
    }
}
