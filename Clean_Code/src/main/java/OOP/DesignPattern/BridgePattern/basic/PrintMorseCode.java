package OOP.DesignPattern.BridgePattern.basic;

/**
 * Created by betterFLY on 2018. 3. 17.
 * Github : http://github.com/betterfly88
 */

public class PrintMorseCode extends MorseCode{
    //betterfly
    public PrintMorseCode b(){
        dash();dot();dot();dot();
        return this;
    }
    public PrintMorseCode e(){
        dot();
        return this;
    }

    public PrintMorseCode t(){
        dash();
        return this;
    }

    public PrintMorseCode r(){
        dot();dash();dot();
        return this;
    }

    public PrintMorseCode f(){
        dot();dot();dash();dot();
        return this;
    }

    public PrintMorseCode l(){
        dot();dash();dot();dot();
        return this;
    }

    public PrintMorseCode y(){
        dash();dot();dash();dash();
        return this;
    }
}
