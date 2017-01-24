package com.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Levy on 2017/1/13.
 */
public class TwoSum {
    private static final int[] nums = {0,2,3,4,5,6,0};
    public static int[] twoSum(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            Integer n = map.get(target-nums[i]);
            if(n!=null){
                return new int[]{n,i};
            }
            map.put(nums[i],i);
        }
        return null;
    }
    public static void main(String args[]){
        int[] i = twoSum(nums,0);
        System.out.println(i[0]);
        System.out.println(i[1]);
    }
}
