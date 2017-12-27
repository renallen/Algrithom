package com.bob.Offer;

public class GetNumberOfK {
	 public int GetNumberOfK(int [] array , int k) {
	      int count=0;
	      if(array==null || array.length==0)return 0;
	      for(int i=0;i<array.length;i++){
	    	  if(array[i]==k){
	    		  count++;
	    		  for(int j=i+1;j<array.length;j++){
	    			  if(array[i]==array[j])count++;
	    			  else break;
	    		  }
	    		  break;
	    	  }
	    	 
	      }
	      return count;
	    }
}
