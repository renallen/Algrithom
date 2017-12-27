package com.bob.Search;

public class SequelSearch {
	public int sequenceSearch(int[] arr,int num){
		for(int i=0;i<arr.length;i++){
			if(arr[i]==num)return i;
		}
		return -1;
	}
}
