package com.algorithm;

/**
 * Created by Levy on 2017/1/24.
 */
public class IntegertoRoman {
    private static String[][] cache;
    static {
        cache = new String[4][10];
        cache[0] = new String[]{"","I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        cache[1] = new String[]{"","X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        cache[2] = new String[]{"","C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        cache[3] = new String[]{"","M", "MM", "MMM"};
    }
    public String intToRoman(int num) {
        int i=0;
        StringBuilder sb = new StringBuilder();
        while (num>0){
            sb.append(cache[i][num%10]);
            num = num/10;
            i++;
        }
        return sb.toString();
    }

}
