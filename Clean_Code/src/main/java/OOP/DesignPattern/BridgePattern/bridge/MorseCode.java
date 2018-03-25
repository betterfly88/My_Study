package OOP.DesignPattern.BridgePattern.bridge;

/**
 * Created by betterFLY on 2018. 3. 17.
 * Github : http://github.com/betterfly88
 */

public class MorseCode {

    private MorseCodeFunction function;

    public MorseCode(MorseCodeFunction function){
        this.function = function;
    }

    public void setFunction(MorseCodeFunction function){
        this.function = function;
    }

    public void dot(){
        function.dot();
    }

    public void dash(){
        function.dash();
    }

    public void sapce(){
        function.space();
    }
}

