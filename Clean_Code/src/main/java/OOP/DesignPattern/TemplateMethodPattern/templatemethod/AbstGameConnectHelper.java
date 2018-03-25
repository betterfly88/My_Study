package OOP.DesignPattern.TemplateMethodPattern.templatemethod;

/**
 * Created by betterFLY on 2018. 3. 17.
 * Github : http://github.com/betterfly88
 */

public abstract class AbstGameConnectHelper {
    /*
        외부에 노출이 되면 안되지만 하위 클래스에서는 사용할 수 있게 해야함 -> private (x) protected(o)
     */
    protected abstract String doSecurity(String string);
    protected abstract boolean authentication(String id, String password);
    protected abstract int authorization(String userName);
    protected abstract String connection(String info);


    /*
        게임 구현 중 로그인 보안 관련 절차를 담당하는 기능을 구현한다고 가정하자
     */
    //template method
    public String requestConnection(String encodedValue){
        //암호화된 encodedValue를 복호화 하는 작업
        String decodedCode = doSecurity(encodedValue);

        //복호화된 정보를 바탕으로 id/password를 받았다고 가정하자
        String id = "betterFLY";
        String password = "1234";

        if(!authentication(id, password)){
            throw new Error("아이디 또는 암호가 일치하지 않습니다");
        }

        String userName = "홍길동";
        int userAuth = authorization(userName);
        switch (userAuth){
            case -1 :
                throw new Error("쎳 다운!");
            case 0 :
                System.out.println("관리자");
                break;
            case 1 :
                System.out.println("유료 회원");
                break;
            case 2 :
                System.out.println("무료 회원");
                break;
            case 3 :
                System.out.println("권한 없음 ");
                break;
            default:
                System.out.println("기타 상황");
                break;
        }

         return connection(decodedCode);
    }




}
