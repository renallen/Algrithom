package com.bob.Offer;

public class reOrderArray {
	public void reOrderArray(int [] array) {
        	if(array==null || array.length==0)return;
        	int i=0,j;
        	while(i<array.length){
        		while(i<array.length&& !isEven(array[i]))i++;
        		j=i+1;
        		while(j<array.length && isEven(array[j]))j++;
        		if(j<array.length){
        			int tmp=array[j];
        			for(int j2=j-1;j2>=i;j2--)array[j2+1]=array[j2];
        			array[i++]=tmp;
        			
        		}else {
					break;
				}
        	}
    }

	private boolean isEven(int i) {
		if(i%2==0)return true;
		return false;
	}	
}
