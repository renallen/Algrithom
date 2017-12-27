package com.bob.sort;

import java.util.Arrays;

public class Count_sort {
	//O(n+k)
	public static void main(String[] args) {
		int arr[]={2,1,3,8,6,0};
		int crr[]=new int[9];
		count_sort(arr, crr);
		System.out.println(Arrays.toString(arr));
	}
	public static void count_sort(int[]arr,int[]crr){
		int i,j=0;
		for(i=0;i<=crr.length;i++){
			crr[i]=0;
		}
		for(i=0;i<arr.length;i++){
			crr[arr[i]]++;
		}
		for(i=0;i<=crr.length;i++){
			while((crr[i]--)>0)arr[j++]=i;
		}
		
	}
}
