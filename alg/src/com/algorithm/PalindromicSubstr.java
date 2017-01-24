package com.algorithm;

/**
 * Created by Levy on 2017/1/23.
 */
public class PalindromicSubstr {
    public String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append('#');
        for (int i=0;i<s.length();i++){
            sb.append(s.charAt(i));
            sb.append('#');
        }
        char[] chars = sb.toString().toCharArray();
        int[] count = new int[sb.length()];
        int C=0,R=0;
        for(int i=0;i<chars.length-1;i++){
            int i_mirror = 2*C-i;
            count[i] = R>i?min(count[i_mirror],R-i):0;
            try {
                while (chars[i - count[i] - 1] == chars[i + count[i] + 1]) {
                    count[i]++;
                }
            }catch(IndexOutOfBoundsException e){
            }
            if(count[i]>R-i){
                C=i;
                R = i+count[i];
            }
        }
        int max = 0;
        int index = 0;
        for(int i=0;i<count.length;i++){
            if(max<count[i]) {
                max = count[i];
                index = i;
            }
        }
        return sb.substring(index-max,index+max).replaceAll("#","");
    }
    private int min(int left,int right){
        return left>right?right:left;
    }
    public static void main(String args[]){
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<1000;i++){
            sb.append('e');
        }
        long start = System.currentTimeMillis();
        String s = "cbbd";
        System.out.println(new PalindromicSubstr().longestPalindrome(s));
        System.out.println(System.currentTimeMillis()-start);
    }
}
