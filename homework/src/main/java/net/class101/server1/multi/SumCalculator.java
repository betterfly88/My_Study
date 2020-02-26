package net.class101.server1.multi;

public class SumCalculator extends Thread{

    @Override
    public void run() {
        int sum = 0;

        for(int i=0; i<10; i++){
            sum += i;

            System.out.println(">> "+i + " 더하기 == "+ sum);
        }

        System.out.println("=========================");
        System.out.println("1~10 합계 : "+sum);
    }
}
