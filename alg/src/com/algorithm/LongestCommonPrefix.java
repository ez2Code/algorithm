package com.algorithm;

/**
 * Created by Levy on 2017/1/25.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null||strs.length==0){
            return "";
        }
        if (strs.length==1){
            return strs[0];
        }
        int minLen = strs[0].length();
        for(String s:strs){
            minLen = minLen<s.length()?minLen:s.length();
        }
        boolean equal = true;
        int i = 0;
        for (;i<minLen;i++){
            for (int j = 1;j<strs.length;j++){
                if (strs[0].charAt(i)!=strs[j].charAt(i)){
                    equal = false;
                    break;
                }
            }
            if (!equal){
                break;
            }
        }
        return strs[0].substring(0,i);
    }
    public static void main(String[] args){
        String[] strings = new String[]{"C","C"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strings));
    }
}
