package com.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Levy on 2017/1/20.
 */
public class LongSunStr {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int max=0;
        int lastLen = 0;
        for(int i=0;i<s.length();i++){
            Integer index = map.get(s.charAt(i));
            int temp = 0;
            map.put(s.charAt(i),i);
            if(index == null){
                temp = lastLen+1;
            }else {
                temp = (lastLen+1<i-index)?(lastLen+1):(i-index);
            }
            lastLen = temp;
            max = max>temp?max:temp;
        }
        return max;
    }
    public static void main(String args[]){
        String s = "pwwkew";
        System.out.println(new LongSunStr().lengthOfLongestSubstring(s));
    }
}
