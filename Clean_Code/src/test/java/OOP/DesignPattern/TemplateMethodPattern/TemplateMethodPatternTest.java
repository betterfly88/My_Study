package OOP.DesignPattern.TemplateMethodPattern;

/**
 * Created by betterFLY on 2018. 3. 17.
 * Github : http://github.com/betterfly88
 */


import OOP.DesignPattern.TemplateMethodPattern.templatemethod.AbstGameConnectHelper;
import OOP.DesignPattern.TemplateMethodPattern.templatemethod.DefaultGameConnectHelper;
import org.junit.Test;

public class TemplateMethodPatternTest {

    @Test
    public void 템플릿메소드패턴_실행(){
        AbstGameConnectHelper helper = new DefaultGameConnectHelper();
        helper.requestConnection("아이디 인증 과정 시작");
    }
}
