package com.bob.Offer;

public class duplicate {
	
	public boolean duplicate(int numbers[],int length,int [] duplication) {
		
	    StringBuffer sBuffer=new StringBuffer();
	    for(int i=0;i<length;i++){
	    	sBuffer.append(numbers[i]+"");
	    }
	    for(int j=0;j<length;j++){
	    	if(sBuffer.indexOf(numbers[j]+"")!=sBuffer.lastIndexOf(numbers[j]+"")){
	    		duplication[0]=numbers[j];
	    		return true;
	    	}
	    }
	    return false;
	    
    }
}
