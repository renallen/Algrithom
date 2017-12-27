package com.bob.sort;

public class shellsort {
	public static void shell_sort(int[] arr){
		int temp,incre=arr.length;
		while(true){
			incre=incre/2;
			for(int k=0;k<incre;k++){
				for(int i=k+incre;i<arr.length;i+=incre){
					for(int j=i;j>k;j-=incre){
						if(arr[j]<arr[j-incre]){
							temp=arr[j-incre];
							arr[j-incre]=arr[j];
							arr[j]=temp;
						}else {
							break;
						}
					}
				}
			}
			if(incre==1)break;
		}
	}
}
