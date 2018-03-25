package OOP.DesignPattern.BridgePattern.bridge;


/**
 * Created by betterFLY on 2018. 3. 17.
 * Github : http://github.com/betterfly88
 */

public class ExcuteMorseCode extends MorseCode{
    public ExcuteMorseCode(MorseCodeFunction function) {
        super(function);
    }

    //betterfly
    public ExcuteMorseCode b(){
        dash();dot();dot();dot();
        return this;
    }
    public ExcuteMorseCode e(){
        dot();
        return this;
    }

    public ExcuteMorseCode t(){
        dash();
        return this;
    }

    public ExcuteMorseCode r(){
        dot();dash();dot();
        return this;
    }

    public ExcuteMorseCode f(){
        dot();dot();dash();dot();
        return this;
    }

    public ExcuteMorseCode l(){
        dot();dash();dot();dot();
        return this;
    }

    public ExcuteMorseCode y(){
        dash();dot();dash();dash();
        return this;
    }
}
