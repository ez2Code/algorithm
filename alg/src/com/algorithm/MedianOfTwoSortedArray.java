package com.algorithm;

/**
 * Created by Levy on 2017/1/22.
 */
public class MedianOfTwoSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length+nums2.length;
        if(len%2==1){
            return findKth(nums1,nums1.length,nums2,nums2.length,len/2+1);
        }else {
            return (findKth(nums1,nums1.length,nums2,nums2.length,len/2)+findKth(nums1,nums1.length,nums2,nums2.length,len/2+1))/2;
        }
    }
    double findKth(int[] a,int a_left,int[] b,int b_left,int k){
        if(a_left>b_left){
            return findKth(b,b_left,a,a_left,k);
        }if(a_left==0){
            return b[b.length-b_left+k-1];
        }if(k==1){
            return a[a.length-a_left]<b[b.length-b_left]?a[a.length-a_left]:b[b.length-b_left];
        }
        else{
            int pa = (k/2>a_left)?a_left:k/2,pb = k-pa;
            if(a[a.length-a_left+pa-1]>b[b.length-b_left+pb-1]){
                return findKth(a,a_left,b,b_left-pb,k-pb);
            }else if (a[a.length-a_left+pa-1]<b[b.length-b_left+pb-1]){
                return findKth(a,a_left-pa,b,b_left,k-pa);
            }else {
                return a[a.length-a_left+pa-1];
            }
        }
    }
    public static void main(String args[]){
        int[] i1 = new int[]{1,3};
        int[] i2 = new int[]{2};
        System.out.println(new MedianOfTwoSortedArray().findMedianSortedArrays(i1,i2));
    }
}
