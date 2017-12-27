package com.bob.sort;

public class inserSort {
	public static void insersort(int[] arr){
		//假设前N个数已经排好序将n+1个数插入到相应的位置
		int temp;
		for(int i=0;i<arr.length-1;i++){
			for(int j=i+1;j>0;j--){
				if(arr[j]<arr[j-1]){
					temp=arr[j-1];
					arr[j-1]=arr[j];
					arr[j]=temp;
				}else {
					break;
				}
			}
		}
	}
}
