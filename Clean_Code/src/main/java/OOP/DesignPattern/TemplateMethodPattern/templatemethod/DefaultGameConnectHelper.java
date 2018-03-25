package OOP.DesignPattern.TemplateMethodPattern.templatemethod;

/**
 * Created by betterFLY on 2018. 3. 17.
 * Github : http://github.com/betterfly88
 */

public class DefaultGameConnectHelper extends AbstGameConnectHelper {

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
