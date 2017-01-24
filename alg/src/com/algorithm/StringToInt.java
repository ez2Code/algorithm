package com.algorithm;

/**
 * Created by Levy on 2017/1/24.
 */
public class StringToInt {
    public int myAtoi(String str) {
        if(str==null){
            return 0;
        }
        str = str.trim();
        boolean positive = true;
        if (str.startsWith("+")||str.startsWith("-")){
            if(str.startsWith("-")){
                positive = false;
            }
            str = str.substring(1);
        }
        if (str.equals("")){
            return 0;
        }
        while (str.startsWith("0")){
            str = str.substring(1);
        }
        if(str.length()>10){
            str = str.substring(0,11);
        }
        char[] chars = str.toCharArray();
        long result = 0;
        for(int i =0;i<str.length();i++){
            if (isNum(chars[i])){
                result = result*10 + (chars[i]-48);
            }else {
                break;
            }
        }
        if(result>Integer.MAX_VALUE){
            if (positive) {
                return Integer.MAX_VALUE;
            }else {
                return Integer.MIN_VALUE;
            }
        }
        if (positive){
            return (int) result;
        }
        return (int) (0-result);
    }

    public boolean isNum(char c){
        return c>47&&c<58;
    }
    public static void main(String args[]){
        String s = "9223372036854775809";
        System.out.println(s);
        System.out.println(Long.MAX_VALUE);
        System.out.println(new StringToInt().myAtoi(s));
    }
}
