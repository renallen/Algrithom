package com.bob.sort;

import java.util.Arrays;

public class HeapSort {
	public static void main(String[] args) {
		int[] arr={5,6,56,2,2,62,6,25,2,32,32,33,25};
		Heap_Sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	public static void Heap_Sort(int[] arr){
		int len=arr.length,i;
		for(i=len/2-1;i>=0;i--){
			HeapAdjustDown(arr,i,len-1);
		}
		for(i=len-1;i>0;i--){
			int temp=arr[i];
			arr[i]=arr[0];
			arr[0]=temp;
			HeapAdjustDown(arr, 0, i-1);
		}
		
	}

	private static void HeapAdjustDown(int[] arr, int start, int end) {
			int temp=arr[start],i=2*start+1;
			while (i<=end) {
				if(i+1<end&&arr[i+1]>arr[i])i++;
				if(arr[i]<=temp)break;
				arr[start]=arr[i];
				start=i;
				i=2*start+1;
			}
			arr[start]=temp;
	}
}
