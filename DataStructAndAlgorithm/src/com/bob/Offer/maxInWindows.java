package com.bob.Offer;

import java.util.ArrayList;

public class maxInWindows {
	public ArrayList<Integer> maxInWindows(int [] num, int size)
    {	ArrayList<Integer>res=new ArrayList<>();
    if(num==null||size<0){
        return null;
    }
    if(size==0){
        return res;
    }
 	if(num.length<size){
        return res;
    }
  int[] window=new int[size];
  for(int i=0;i<=num.length-size;i++) {
      int index=0;
    	for(int j=i;j<i+size;j++){
    		window[index++]=num[j];
    	}
       int max=max1(window);
       res.add(max);
    }
  return res;
}
private  int max1(int[] window) {
	int max=window[0];
		for(int i=1;i<window.length;i++){
			if(max<window[i])max=window[i];
		}
		return max;
}
}
