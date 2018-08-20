package DisignPattern.Singletone;

/**
 * Created by betterFLY on 2018. 8. 19.
 * Github : http://github.com/betterfly88
 */

public class Main {

    public static void main(String [] args){
        SystemSpeaker speaker1 = SystemSpeaker.getInstance();
        SystemSpeaker speaker2 = SystemSpeaker.getInstance();

        // 예상값 : 5,5
        System.out.println(speaker1.getVolume());
        System.out.println(speaker2.getVolume());


        // 예상값 : 11, 11
        speaker1.setVolume(11);
        System.out.println(speaker1.getVolume());
        System.out.println(speaker2.getVolume());

        // 예상값 : 15, 15
        speaker2.setVolume(15);
        System.out.println(speaker1.getVolume());
        System.out.println(speaker2.getVolume());


        /*
            SystemSpeaker 자체를 하나의 인스턴스로 생성했기 때문에
            변수를 다르게 선언했지만 동일한 결과를 반환한다.
         */
    }
}
