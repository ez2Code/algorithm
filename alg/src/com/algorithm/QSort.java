package com.algorithm;

import java.util.List;

/**
 * Created by Levy on 2017/1/13.
 */
public class QSort {
    public void quickSort(List<Integer> targetArr, int start, int end) {
        if(start>=end){
            return;
        }
        int i = start, j = end;
        Integer key = targetArr.get(start);
        while (i < j) {
            while (j > i && targetArr.get(j).compareTo(key) >= 0) {
                j--;
            }
            if (i < j) {
                targetArr.set(i,targetArr.get(j));
                i++;
            }
            while (i < j && targetArr.get(i).compareTo(key) <= 0){
                i++;
            }
            if (i < j) {
                targetArr.set(j,targetArr.get(i));
                j--;
            }
        }
        targetArr.set(i,key);
        this.quickSort(targetArr, start, i - 1);
        this.quickSort(targetArr, j + 1, end);
    }
    public void sort(Integer arr[],int low,int high)
    {
        int l=low;
        int h=high;
        int povit=arr[low];

        while(l<h)
        {
            while(l<h&&arr[h]>=povit)
                h--;
            if(l<h){
                int temp=arr[h];
                arr[h]=arr[l];
                arr[l]=temp;
                l++;
            }

            while(l<h&&arr[l]<=povit)
                l++;

            if(l<h){
                int temp=arr[h];
                arr[h]=arr[l];
                arr[l]=temp;
                h--;
            }
        }
        if(l>low)sort(arr,low,l-1);
        if(h<high)sort(arr,l+1,high);
    }
}
