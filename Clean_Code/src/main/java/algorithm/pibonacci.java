package algorithm;

/**
 * Created by betterFLY on 2018. 8. 22.
 * Github : http://github.com/betterfly88
 */

public class pibonacci {
    public static void main(String [] args){
        System.out.println(recursive(5));

        System.out.println(recursiveFactorial(5));

        // (4)+(3), (3)+(2), (2) + (1)
    }

    public static int recursive(int n){
        if(n <= 1){
            return n;
        }

        return n + recursive(n -1);
    }

    public static int recursiveFactorial(int n){
        if(n <= 1){
            return 1;
        }

        return n * recursive(n -1);
    }
}
