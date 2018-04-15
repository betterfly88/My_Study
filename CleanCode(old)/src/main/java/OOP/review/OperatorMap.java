package OOP.review;

import java.util.Map;

/**
 * Created by betterFLY on 2018. 3. 1.
 * Github : http://github.com/betterfly88
 */

public class OperatorMap {
    public void Add(Map<String, Operator> map, Operator op){
        map.put(op.getKey(),op);
    }
}
