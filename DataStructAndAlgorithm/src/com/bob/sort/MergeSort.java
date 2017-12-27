package com.bob.sort;

public class MergeSort {
	public static void Merge_Sort(int[] arr){
		int[] brr=new int[arr.length];
		MSort(arr,brr,0,arr.length-1);
	}

	private static void MSort(int[] arr, int[] brr, int start, int end) {
		if(start<end){
			int mid=(start+end)/2;
			MSort(arr, brr, start, mid);
			MSort(arr, brr, mid+1, end);
			Merge(arr, brr, start, mid,end);
		}
	}

	private static void Merge(int[] arr, int[] brr, int start, int mid, int end) {
		int i=start;
		int j=mid+1;
		int k=0;
		
		while (i<mid && j<end) {
			if(arr[i]<arr[j])brr[k++]=arr[i++];
			else
				brr[k++]=arr[j++];
		}
		while(i<=mid)brr[k++]=arr[i++];
		while(j<=end)brr[k++]=arr[j++];
		for(i=0;i<k;i++){
			arr[i+start]=brr[i];
		}
	}
}
