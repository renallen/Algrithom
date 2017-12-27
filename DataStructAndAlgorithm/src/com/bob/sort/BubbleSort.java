package com.bob.sort;

import java.util.Comparator;

public class BubbleSort implements Sorter{
	
	public static void bubblesort1(int[] arr){
		int i,j,temp;
		for(i=0;i<arr.length-1;i++){
			for(j=arr.length-1;j>i;j--){
				if(arr[j]<arr[j-1]){
					temp=arr[j];
					arr[j]=arr[j-1];
					arr[j-1]=arr[j];
				}
			}
		}
	}
	public static void bubblesort2(int[]arr){
		int i,j,temp;
		boolean flag;
		for(i=0;i<arr.length-1;i++){
			flag=false;
			for(j=arr.length-1;j>i;j--){
				if(arr[j]<arr[j-1]){
					temp=arr[j];
					arr[j]=arr[j-1];
					arr[j-1]=arr[j];
					flag=true;
				}
			}
			if(!flag)break;
		}
	}
	@Override
	public <T extends Comparable<T>> void sort(T[] list) {
		boolean swapped=true;
		for(int i=1,len=list.length;i<len&&swapped;++i){
			swapped=false;
			for(int j=0;j<len-i;++j){
					if(list[j].compareTo(list[j+1])>0){
						T temp=list[j];
						list[j]=list[j+1];
						list[j+1]=temp;
						swapped=true;
					}
				
			}
			
		}
		
		
	}
	@Override
	public <T> void sort(T[] list, Comparator<T> com) {
		boolean swapped=true;
		for(int i=1,len=list.length;i<len&&swapped;++i){
			swapped=false;
			for(int j=0;j<len-i;++j){
				if(com.compare(list[j], list[j+1])>0){
					T temp=list[j];
					list[j]=list[j+1];
					list[j+1]=temp;
					swapped=true;
				}
			}
		}
		
		
		
	}
}
