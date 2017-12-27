package com.bob.Offer;

public class minNumberInRotateArray {
	public int minNumberInRotateArray(int [] array) {
    	int temp=array[0];
		for(int i=0;i<array.length;i++){
			if(array[i]>array[i+1]){
				temp=array[i+1];
				break;
			}
			
		}
		return temp;
    }
	public int minNumberInRotateArray1(int[] array){
		if(array==null || array.length==0)return -1;
		int left=0;
		int right=array.length-1;
		int mid;
		while(left<right){
			mid=left+(right-left)/2; 
			if(array[left]<array[right])return array[left];
			else if (array[left]>=array[right]) {
				if(array[mid]>=array[left])left=mid+1;
				else {
					right=mid;
				}
			}else {
				if(array[left]<array[mid])left=mid+1;
				else if (array[left]>array[mid]) {
					right=mid;
				}else {
					left=left+1;
					right=right-1;
				}
			}
		}
		return array[right];
	}
}
