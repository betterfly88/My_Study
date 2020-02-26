package net.class101.server1.multi;

public class MultiplyCalculator implements Runnable {
    @Override
    public void run() {
        long multiply=1;
        for(long i=1 ; i <= 10 ; i++ ) {
            multiply *= i ;
            System.out.println("** "+i + "곱하기 결과: " + multiply);
        }

        System.out.println("=========================");
        System.out.println("1~10 곱셈: " + multiply);
    }
}
