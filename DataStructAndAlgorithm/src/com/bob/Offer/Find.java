package com.bob.Offer;

public class Find {
	public boolean Find(int target, int [][] array) {
	       int row=array.length;
	       int cols=array[0].length;
	       int i=row-1;
	       int j=0;
	       while(i>=0 && j<cols){
	    	   if(array[i][j]>target)i--;
	    	   else if (array[i][j]<target) {
				j++;
			}else {
				return true;
			}
	       }
	       return false;

    }
}
