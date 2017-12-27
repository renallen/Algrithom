package com.bob.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BucketSort {
	public static void main(String[] args) {
		int[] array={2,3,56,45,1,22,2,100,500,623,58};
		//Shell_Sort(array);
		Bucket_Sort(array);
		System.out.println(Arrays.toString(array));
	}

	private static void Bucket_Sort(int[] array) {
			//1、找出最大值最小值；
		int max=array[0],min=array[0];
		for(int i=1;i<array.length;i++){
			if(array[i]>max)max=array[i];
			else if(array[i]<min)min=array[i];
		}
		//建桶
		int Bucketnum=(max-min)/array.length+1;
		ArrayList<ArrayList<Integer>>bucketArr=new ArrayList<>(Bucketnum);
		for(int i=0;i<Bucketnum;i++){
			bucketArr.add(new ArrayList<Integer>());
		}
		//把数放入桶中
		for(int i=0;i<array.length;i++){
				int index=(array[i]-min)/array.length;
				bucketArr.get(index).add(array[i]);
		}
		//对桶分别排序
		int j=0;
		for(int i=0;i<bucketArr.size();i++){
			Collections.sort(bucketArr.get(i));
			if(bucketArr.get(i).size()!=0){
				for(int k=0;k<bucketArr.get(i).size();k++){
					array[j++]=bucketArr.get(i).get(k);
				}
			}
		}
	}

}
