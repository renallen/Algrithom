package com.bob.Offer;


public class MoreThanHalfNum_Solution {
	/**
	 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
	 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
	 * @param array
	 * @return
	 */
	 public int MoreThanHalfNum_Solution(int [] array) {
	        int len=array.length;
	        if(array==null || len<=0)return 0;
	        int result=array[0];
	        int times=1;
	        for(int i=1;i<len;i++){
	        	if(times==0){
	        		result=array[i];
	        		times=1;
	        	}else{
	        		if(array[i]==result){
	        			times++;
	        		}else {
						times--;
					}
	        	}
	        }
	        times=0;
	        for(int i=0;i<len;i++){
	        	if(result==array[i])times++;
	        }
	        if(times*2<=len)result=0;
	        return result;
	  }
}
