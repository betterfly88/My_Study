package OOP.review;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by betterFLY on 2018. 3. 1.
 * Github : http://github.com/betterfly88
 */

public class StringAddCalculator {
    String pattern = "^(//.\\n)";
    public String[] splitStringNumber(String s) {
        s = s.replaceAll(":", ",");
        return s.split(",");
    }

    public int sumStringNumber(String s) {
        String[] strnums = splitStringNumber(s);
        return sumStringArrayNumber(strnums);
    }

    public int sumStringArrayNumber(String[] strnums) {
        int sum = 0;

        for(String strnum : strnums)
            sum += getPositiveNumber(strnum);

        return sum;
    }

    public int getPositiveNumber(String strnum) {
        int num = Integer.parseInt(strnum);

        if(num < 0)
            throw new RuntimeException();

        return num;
    }

    public String getCustomSeparator(String s) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(s);
        return m.find() ? s.substring(2,3) : "";
    }


    public String[] splitStringToNumberByCustomSeparator(String s) {
        String separator = getCustomSeparator(s);
        s = s.replaceFirst(pattern, "");

        return s.split(separator);
    }

    public int sumStringNumberFromCustomSeparator(String s) {
        String[] strnums = splitStringToNumberByCustomSeparator(s);
        return sumStringArrayNumber(strnums);
    }
}
