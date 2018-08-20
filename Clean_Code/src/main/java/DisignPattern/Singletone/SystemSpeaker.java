package DisignPattern.Singletone;

import sun.rmi.runtime.Log;

import java.util.logging.Logger;

/**
 * Created by betterFLY on 2018. 8. 19.
 * Github : http://github.com/betterfly88
 */

public class SystemSpeaker {
    // 생성자가 생성되기전 instance라는 객체가 존재해있어야 하기 때문에 static 으로 선언을 해놓는다.
    static private SystemSpeaker instance;
    private int volume;

    // Singletone 이기 때문에 private으로 외부에서 생성 못하도록 제한
    private SystemSpeaker(){
        volume = 5;
    }

    public static SystemSpeaker getInstance() {
        //getInstance() 가 SystemSpeaker의 인스턴스를 찾는 과정이기 때문에 그리고 하나의 인스턴스만 존재해야 하기 때문에
        // instance에 null을 체크하여 하나의 시스템 스피커 인스턴스만을 생성함
        if(instance == null){
            instance = new SystemSpeaker();
            Logger.getLogger("make new instance");
            System.out.println("make new instance");
        }else{
            Logger.getLogger("instance is already made");
            System.out.println("instance is already made");
        }
        return instance;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
