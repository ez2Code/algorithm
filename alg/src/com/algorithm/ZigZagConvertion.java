package com.algorithm;

/**
 * Created by Levy on 2017/1/24.
 */
public class ZigZagConvertion {
    public String convert(String s, int numRows) {
        if(s.length()<numRows||numRows<2){
            return s;
        }
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<numRows;i++){
            if(i==0||i==numRows-1){
                for(int j=0;j<chars.length;j++){
                    if((2*numRows-2)*j+i>=chars.length){
                        break;
                    }
                    sb.append(chars[(2*numRows-2)*j+i]);
                }
            }else {
                for(int j=0;j<chars.length;j++){
                    if((2*numRows-2)*j+i>=chars.length){
                        break;
                    }
                    sb.append(chars[(2*numRows-2)*j+i]);
                    if(((2*numRows-2)*(j+1)-i)>=chars.length){
                        break;
                    }
                    sb.append(chars[(2*numRows-2)*(j+1)-i]);
                }
            }
        }
        return sb.toString();
    }
    public static void main(String args[]){
        String s = "ABCDE";
        System.out.println(new ZigZagConvertion().convert(s,2));
    }
}
