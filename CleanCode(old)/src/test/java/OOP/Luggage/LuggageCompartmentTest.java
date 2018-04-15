package OOP.Luggage;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.Assertions;
//import org.junit.Assert;
import org.junit.Test;

/**
 * Created by betterFLY on 2018. 2. 25.
 * Github : http://github.com/betterfly88
 */

public class LuggageCompartmentTest {

    LuggageCompartment lc;

    @Test
    public void shoud_update_luggage_rest_space(){
        Luggage luggage = new Luggage(1l, 10);

        if(lc.canContains(luggage)){
            lc.add(luggage);
            Assertions.assertThat(lc.canContains(luggage)).isFalse();
        }

        /*
            클라이언트에서 LuggageCompartment 의 extract 메서드를 호출하지않고 (remove 후 restSize 를 계산해줌
            다이렉트로 remove 메서드를 구현한다면 (상속받은 ArrayList(슈퍼클래스)의 메서드를 다이렉트로 호출)
            결국 restSpace가 계산되지 않고 리스트의 luggage만 제거되어 원하는 과정이 생략된다.
         */
//        lc.remove(luggage);
        lc.extract(luggage);
        Assertions.assertThat(lc.canContains(luggage)).isTrue();
    }
}
