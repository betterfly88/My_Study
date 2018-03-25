package OOP.DesignPattern.BridgePattern.bridge;

/**
 * Created by betterFLY on 2018. 3. 17.
 * Github : http://github.com/betterfly88
 */

public class PrintMorseCode implements MorseCodeFunction {

    @Override
    public void dot() {
        System.out.print(".");
    }

    @Override
    public void dash() {
        System.out.print("-");
    }

    @Override
    public void space() {
        System.out.print(" ");
    }
}
