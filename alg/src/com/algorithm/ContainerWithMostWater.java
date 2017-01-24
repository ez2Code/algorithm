package com.algorithm;

/**
 * Created by Levy on 2017/1/24.
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max = (height.length-1)*min(height[0],height[height.length-1]);
        for(int i=0,j=height.length-1;i<j;){
            if(height[i]<height[j]){
                i++;
            }else {
                j--;
            }
            max = max(max,(j-i)*min(height[i],height[j]));
        }
        return max;
    }
    private int min(int left, int right){
        return left>right?right:left;
    }
    private int max(int left, int right){
        return left<right?right:left;
    }
    public static void main(String args[]){
        int[] input = new int[]{1,1};
        System.out.println(new ContainerWithMostWater().maxArea(input));
    }
}
