# Bridge Pattern

![Alt text](./template_method_pattern.gif)

> 템플릿 메소드 패턴의 이해
* 공통적인 프로세스는 묶어준다.  
알고리즘의 구조를 메서드에 정의하고
하위 클래스에서 알고리즘 구조의 변경 없이 알고리즘을 재정의 하는 패턴

###### 구현하려는 알고리즘에 일정한 프로세스 존재하고,  변경 가능성이 있을때 사용


1. 알고리즘을 여러 단계로 나눈다(Primitive Operation)

```java
public abstract class AbstGameConnectHelper {
    /*
        외부에 노출이 되면 안되지만 하위 클래스에서는 사용할 수 있게 해야함 -> private (x) protected(o)
     */
    protected abstract String doSecurity(String string);
    protected abstract boolean authentication(String id, String password);
    protected abstract int authorization(String userName);
    protected abstract String connection(String info);

```
2. 최종 구현을 담당할 Template Method 구현(TemplateMethod)

->Primitive Operation + Template Method

```java
 /*
    게임 구현 중 로그인 보안 관련 절차를 담당하는 기능을 구현한다고 가정하자
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
        실제 로직을 담당할 템플릿 메소
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

```


3. 각 메소드별 비즈니스로직을 담당할 기능 구현 클래스

```java

public class DefaultGameonnectHelper extends AbstGameConnectHelper {

    /*
        만약 기능이 추가된다면?
        - 더 강한 보안 기능을 추가해야 한다
        - 10시 이후에는 접속을 제한한다
     */
    @Override
    protected String doSecurity(String string) {
        System.out.println("디코드 작업!!");
        String decode = string.toLowerCase(); //디코드했다고 가정

        // 더 강한 보안 기능!
        System.out.println("강화된 디코드 작업!!");
        return decode;
    }

    @Override
    protected boolean authentication(String id, String password) {
        System.out.println("아이디/비밀번호 검증!");

        return true;
    }

    @Override
    protected int authorization(String userName) {
        System.out.println("접속 유저 권한 관리!");

        //userName을 통해 유저의 접속 권한을 확인하여 10시 이후에는 접속을 제한하는 리턴을 준다
        // 예를들어 미성년자는 -1을 리턴해서 템플릿 메소드에 구현된 기능 중 -1 일때 처리를 해준다
        return 0;
    }

    @Override
    protected String connection(String info) {
        System.out.println("접속 정보 확인");
        return info;
    }
}

```


4. 실제 구현 테스트
```java

import OOP.DesignPattern.TemplateMethodPattern.templatemethod.AbstGameConnectHelper;
import OOP.DesignPattern.TemplateMethodPattern.templatemethod.DefaultGameConnectHelper;
import org.junit.Before;
import org.junit.Test;

public class TemplateMethodPatternTest {

    @Test
    public void 템플릿메소드패턴_실행(){
        AbstGameConnectHelper helper = new DefaultGameonnectHelper();
        helper.requestConnection("아이디 인증 과정 시작");
    }
}

```

