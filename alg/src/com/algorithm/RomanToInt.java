package com.algorithm;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * Created by Levy on 2017/1/25.
 */
public class RomanToInt {
    private static List<String>[] cache = new List[4];
    static {
        cache[0] = Arrays.asList("","I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX");
        cache[1] = Arrays.asList("","X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC");
        cache[2] = Arrays.asList("","C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM");
        cache[3] = Arrays.asList("","M", "MM", "MMM");
    }
    public int romanToInt(String s) {
        int pos = 0;
        Deque<Integer> tmp = new ArrayDeque<>();
        while (s.length()>0){
            int i = 1;
            if(s.length()>1&&cache[pos].contains(s.substring(s.length()-2,s.length()))&&cache[pos].indexOf(s.substring(s.length()-2,s.length()))==9){
                i=3;
            }else {
                while (i <= s.length() && cache[pos].contains(s.substring(s.length() - i, s.length()))) {
                    i++;
                }
            }
            tmp.addFirst(cache[pos].indexOf(s.substring(s.length()-i+1,s.length())));
            s = s.substring(0,s.length()-i+1);
            pos++;
        }
        int result = 0;
        while (!tmp.isEmpty()){
            result = result*10+tmp.pop();
        }
        return result;
    }
    public static void main(String[] args){
        String roman = "MMDXXXII";
        System.out.println(new RomanToInt().romanToInt(roman));
    }

}
