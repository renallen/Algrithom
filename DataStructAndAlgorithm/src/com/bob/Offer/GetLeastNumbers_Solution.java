package com.bob.Offer;

import java.util.ArrayList;

public class GetLeastNumbers_Solution {
	 public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
	       ArrayList<Integer>result=new ArrayList<>();
	       if(input.length<k || k==0)return result;
	       for(int i=0;i<k;i++){
	    	   result.add(input[i]);
	       }
	       for(int i=k;i<input.length;i++){
	    	   int j=this.getMax(result);
	    	   int tmp=(Integer)result.get(j);
	    	   if(input[k]<tmp)result.set(j, input[i]);
	       }
	       return result;
	    }

	private int getMax(ArrayList<Integer> result) {
		int max=result.get(0);
		int j=0;
		for(int i=0;i<result.size();i++){
			if(result.get(i)>max){
				max=result.get(i);
				j=i;
			}
		}
		return j;
	}
}
