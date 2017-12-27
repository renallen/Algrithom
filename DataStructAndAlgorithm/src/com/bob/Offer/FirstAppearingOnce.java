package com.bob.Offer;

public class FirstAppearingOnce {
	int count[]=new int[256];
	int index=1;
	public void Insert(char ch)
    {
        if(count[ch]==0)count[ch]=index++;
        else{
        	count[ch]=-1;
        }
    }
	public char FirstAppearingOnce()
    {
    	int tmp=Integer.MAX_VALUE; 
    	char ch='#';
    	for(int i=0;i<256;i++){
    		if(count[i]!=0 && count[i]!=-1 && count[i]<tmp){
    			tmp=count[i];
    			ch=(char)i;
    		}
    	}
    	return ch;
    }
}	
