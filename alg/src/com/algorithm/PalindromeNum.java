package com.algorithm;

/**
 * Created by Levy on 2017/1/24.
 */
public class PalindromeNum {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }if(x<10){
            return true;
        }
        int reverse = reverse(x);
        return reverse==x;
    }
    public int reverse(int x) {
        long result = 0;
        while(x!=0){
            result = result*10 + x%10;
            x = x/10;
        }
        if(result>Integer.MAX_VALUE||result<Integer.MIN_VALUE){
            return 0;
        }
        return (int) result;
    }
}
