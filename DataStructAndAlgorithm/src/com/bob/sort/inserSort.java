package com.bob.sort;

public class inserSort {
	public static void insersort(int[] arr){
		//����ǰN�����Ѿ��ź���n+1�������뵽��Ӧ��λ��
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
