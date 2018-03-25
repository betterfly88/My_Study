package OOP.Luggage;

import java.util.ArrayList;

/**
 * Created by betterFLY on 2018. 2. 25.
 * Github : http://github.com/betterfly88
 */

//public class LuggageCompartment extends ArrayList<Luggage> {
public class LuggageCompartment{
    ArrayList<Luggage> list = new ArrayList<Luggage>();
    private int restSpace;

    public LuggageCompartment(int restSpace){
        this.restSpace = restSpace;
    }

//    @Override
    public boolean add(Luggage luggage){
        this.restSpace -=luggage.getSize();
//        super.add(luggage);
        list.add(luggage);
        return false;
    }

    public boolean canContains(Luggage luggage){
        return this.restSpace > luggage.getSize();
    }

    public void extract(Luggage luggage){
        this.restSpace += luggage.getSize();
//        super.remove(luggage);
        list.remove(luggage);
    }
}

