package com.algorithm;

/**
 * Created by Levy on 2017/1/13.
 */
public class SortUtil {
    public void quickSort(int[] li){
        this.quickSort(li,0,li.length-1);
    }
    private void quickSort(int[] li,int start,int end){
        if(start>=end){
            return;
        }
        int i = start, j = end;
        Integer key = li[start];
        while (i < j) {
            while (j > i && li[j]>key) {
                j--;
            }
            if (i < j) {
                li[i] = li[j];
                i++;
            }
            while (i < j && key>li[i]){
                i++;
            }
            if (i < j) {
                li[j] = li[i];
                j--;
            }
        }
        li[i] = key;
        this.quickSort(li, start, i - 1);
        this.quickSort(li, j + 1, end);
    }
}
