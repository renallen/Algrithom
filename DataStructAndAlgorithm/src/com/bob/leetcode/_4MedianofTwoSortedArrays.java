package com.bob.leetcode;

public class _4MedianofTwoSortedArrays {
	public static void main(String[] args) {
		int[] nums1={1,3,8,9,15,26,56};
		int[] nums2={1,5,3,6,13,45,62,59,89};
		System.out.println(findMedianSortedArrays(nums1, nums1));
	}
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		/**
		 * 思路：转变寻找第K小数的问题（假设原序列升序排列），中位数是（m+n）/2小的数
		 */
        int len=nums1.length+nums2.length;
        if(len%2==1){
        	return findMedian(nums1,0,nums2,0,len/2+1);
        }
        return (findMedian(nums1, 0, nums2, 0, len/2)+findMedian(nums1, 0, nums2, 0, len/2+1))/2.0;
    }
	private static double findMedian(int[] nums1, int s1, int[] nums2, int s2, int k) {
		if(s1>=nums1.length)
	        return nums2[s2+k-1];
	    if(s2>=nums2.length)
	        return nums1[s1+k-1];
	    if(k==1)
	        return Math.min(nums1[s1], nums2[s2]);
	 
	    int m1 = s1+k/2-1;
	    int m2 = s2+k/2-1;
	 
	    int mid1 = m1<nums1.length?nums1[m1]:Integer.MAX_VALUE;    
	    int mid2 = m2<nums2.length?nums2[m2]:Integer.MAX_VALUE;
	 
	    if(mid1<mid2){
	        return findMedian(nums1, m1+1, nums2, s2, k-k/2);
	    }else{
	        return findMedian(nums1, s1, nums2, m2+1, k-k/2);
	    }
	}
}
