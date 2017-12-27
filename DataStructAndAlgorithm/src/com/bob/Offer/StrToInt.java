package com.bob.Offer;

public class StrToInt {
	
public int StrToInt(String str) {
        int fuhao=0;
        char[] array=str.toCharArray();
        if(array[0]=='-')fuhao=1;
        int sum=0;
        for(int i=fuhao;i<array.length;i++){
        	if(array[i]=='+')continue;
        	if(array[i]<48 || array[i]>57)return 0;
        	sum=sum*10+array[i]-48;
        	
        }
        return fuhao==0?sum:sum*-1;
    }
}
