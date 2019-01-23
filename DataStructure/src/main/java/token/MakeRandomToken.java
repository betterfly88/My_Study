package token;

import java.util.Random;

/**
 * Created by betterfly
 * Date : 2019.01.10
 */
public class MakeRandomToken {
    public static void main(String[] args) {
        String token = makeToken();
        System.out.println(token);
    }

    private static String makeToken(){
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<20; i++){
            Random random = new Random();
            sb.append(makeRandomValue(random.nextInt(3)));
        }

        return sb.toString();
    }

    private static String makeRandomValue(int type){
        Random random = new Random();
        String randomStr = null;
        switch(type){
            case 0 : // 숫자
                randomStr = String.valueOf(random.nextInt(10));
                break;
            case 1 : // 소문자
                randomStr = String.valueOf((char) ((int) (random.nextInt(26)) + 97));
                break;
            case 2 : // 대문자
                randomStr = String.valueOf((char) ((int) (random.nextInt(26)) + 65));
                break;
        }
        return randomStr;
    }
}
