/**
 * Created by betterfly
 * Date : 2018.12.29
 * 참고 : https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op2.html
 */
public class SampleClass extends Number implements Comparable<Integer>{
    public int compareTo(Integer anotherInteger){
        int thisVal = this.intValue();
        int anotherVal = anotherInteger.intValue();
        return (thisVal < anotherVal ? -1 : (thisVal == anotherVal ? 0 : 1));
    }

    @Override
    public int intValue() {
        return 0;
    }

    @Override
    public long longValue() {
        return 0;
    }

    @Override
    public float floatValue() {
        return 0;
    }

    @Override
    public double doubleValue() {
        return 0;
    }
}
