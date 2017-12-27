package com.bob.Offer;

import java.util.ArrayList;

public class FindContinuousSequence {
	public static void main(String[] args) {
		System.out.println(FindContinuousSequence(150).toString());
	}
	public static ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
	       ArrayList<ArrayList<Integer>>result=new ArrayList<ArrayList<Integer>>();
	       if(sum==1)return result;
	       //?最多项如何得出来的；
	       int n=(int)Math.ceil((Math.sqrt(8*sum+1)-1)/2);
	       int tmp=0;
	       int num=0;
	       for(int i=n;i>1;i--){
	    	   tmp=(i+1)*i/2;
	    	   if((sum-tmp)%i==0){
	    		   ArrayList<Integer>list=new ArrayList<>();
	    		   num=(sum-tmp)/i;
	    		   for(int a=1;a<=i;a++){
	    			   list.add(num+a);
	    		   }
	    		   result.add(list);
	    	   }
	       }
	       return result;
	}
}
