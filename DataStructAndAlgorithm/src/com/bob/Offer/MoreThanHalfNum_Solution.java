package com.bob.Offer;


public class MoreThanHalfNum_Solution {
	/**
	 * ��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡�
	 * ��������һ������Ϊ9������{1,2,3,2,2,2,5,4,2}����������2�������г�����5�Σ��������鳤�ȵ�һ�룬������2����������������0��
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
