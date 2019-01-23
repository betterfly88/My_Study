package token;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by betterfly
 * Date : 2019.01.10
 */
public class TokenLogs {
    static List<String> tokenArrayList = new ArrayList<String>();
    static Set<String> tokenSet = new HashSet<String>();
    static int totalCount = 0;

    public static void main(String[] args) {
        try {
            // push.log.2019-01-09
            // push.log.test
            File file = new File("/Users/betterfly/dev/repository/my-study/My_Study/DataStructure/push.log.2019-01-09");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            int successCount = 0 ;
            while ((line = reader.readLine()) != null) {
                //subscript 기준
                getTokenCountBySubscript(line);
//                getTokenList(line);

                // startDate 기준
//                getTokenCountByPublish(line);
            }

            // 히스토리 등록된 토큰 수 : 30255개
            int size = tokenArrayList.size() - tokenSet.size();
            System.out.println("전체 : "+tokenArrayList.size());
            System.out.println("중복 : "+size);
            System.out.println("중복 제외 : "+tokenSet.size());
//            System.out.println("Success Count : " + successCount);
//            System.out.println("오차 : "+(30255 -tokenArrayList.size()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getSuccessCount(String line) throws Exception{
        if(line.contains("success: ")){
            String[] getTimezone = line.split(",");
            compareLogTime(getTimezone[1]);

//            if (compareLogTime(getTimezone[1])) {
                String count = line.split("success: ")[1].split(",")[0];
//                if(Pattern.matches("(^[0-9]*$)", count)){
                totalCount += Integer.parseInt(count);
//            }
        }
        return totalCount;
    }

    // Subscript Message
    public static void getTokenCountBySubscript(String line) throws Exception{
        if (line.contains("Subscript Message")) {
            // 시간 비교하기
            String[] getTimezone = line.split(",");
            compareLogTime(getTimezone[1]);
//            if (compareLogTime(getTimezone[1])) {
//            if (compareLogTime(getTimezone[1]) <= 600) {
//                // Token 담기
//                if(line.contains("registration_ids\":")){
//                    String parse = line.trim();
//                    String[] getToken = parse.split("registration_ids\":\\[")[1].split("]");
//                    StringTokenizer st = new StringTokenizer(getToken[0], ",");
//                    while (st.hasMoreTokens()) {
//                        String token = st.nextToken();
//                        tokenArrayList.add(token);
//                        tokenSet.add(token);
//                    }
//                }
//            }
//
//            else
                if(compareLogTime(getTimezone[1]) > 600){
                if (line.contains("Subscript Message: [")) {
                    // Token 담기
                    String parse = line.trim();
                    String[] getToken = parse.split("Subscript Message: \\[")[1].split("]");
                    StringTokenizer st = new StringTokenizer(getToken[0], ",");
                    while (st.hasMoreTokens()) {
                        String token = st.nextToken();
                        tokenArrayList.add(token);
                        tokenSet.add(token);
                    }
                }
            }
        }
    }


    public static void getTokenList(String line) {
        if (line.contains("Subscript Message: [")) {
            // Token 담기
            String parse = line.trim();
            String[] getToken = parse.split("Subscript Message: \\[")[1].split("]");
            StringTokenizer st = new StringTokenizer(getToken[0], ",");
            while (st.hasMoreTokens()) {
                String token = st.nextToken();
                tokenArrayList.add(token);
                tokenSet.add(token);
            }
        }
    }

    // Publish Message
    public static void getTokenCountByPublish(String line){
        if(line.contains("Publish Message")){
            String startDate = line.split("startDate\":")[1].split(",")[0];
            if(startDate.contains("2019-01-09 19:00:00.226")){
                String sstoken = line.split("registration_ids")[1].split("\\[")[1].split("]")[0];
                String tokenList = sstoken.replaceAll("\\\\","");
                StringTokenizer st = new StringTokenizer(tokenList, ",");
                while(st.hasMoreTokens()){
                    String token = st.nextToken();
                    tokenArrayList.add(token);
                    tokenSet.add(token);
                }
            }
        }
    }

    public static long compareLogTime(String logTime) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss", Locale.KOREA);
        // 기준 시간
        Date date1 = sdf.parse("10:00:00");
        long getTime = 0;
        if(logTime.trim().startsWith("2019")) {
            String[] time = logTime.split("\\s");
            Date date2 = sdf.parse(time[2]);
             getTime = (date2.getTime() - date1.getTime()) / 1000; // 1초
        }
        return getTime;
//            if(getTime <= 600){ // 600 : 10분, 3600 : 1시간
////                System.out.println(time[2]);
//                return true;
//            }
//        }
//        return false;
    }
}
