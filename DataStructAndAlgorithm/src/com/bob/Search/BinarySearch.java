package com.bob.Search;

import java.util.Comparator;

public class BinarySearch {
	public static void main(String[] args) {
		System.out.println();
	}
	//ѭ��ʵ��
	public static <T> int  BinarySearch1(T[]x,T key,Comparator<T>com) {
		int low=0;
		int high=x.length-1;
		while(low<high){
			int mid=(low+high)>>>1;
			int cmp=com.compare(x[mid], key);
			if(cmp<0)low=mid+1;
			else if (cmp>0) {
				high=mid-1;
			}else {
				return mid;
			}
			
		}
		return -1;
	}
	//�ݹ�
	public static <T extends Comparable<T>>int BinarySearch2(T[]x,int low,int high,T key){
		if(low<high){
			int mid=low+((high-low)>>1);
			if(key.compareTo(x[mid])==0)return mid;
			else if (key.compareTo(x[mid])<0)return BinarySearch2(x, low, mid-1, key);
			else {
				return BinarySearch2(x, mid+1, high, key);
			}
		}
		return -1;
	}
	public static int binarysearch(int[] arr,int num){
		int low=0,upper=arr.length-1;
		while(low<upper){
			int mid=(low+upper)/2;//�˴���Ҫ�ã��ӷ���Խ�磬low + (high �C low) / 2��low + (high �C low) >> 1��(low + high) >>> 1
			if(arr[mid]<num)low=mid+1;
			else if (arr[mid]>num) {
				upper=mid-1;
			}else {
				return mid;
			}
		}
		return -1;
	}
}
