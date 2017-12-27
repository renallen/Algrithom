package com.bob.Offer;

public class replaceSpace {
public String replaceSpace(StringBuffer str) {
    	if(str==null  || str.length()<=0){
    		return "";
    	}
    	StringBuffer newstr=new StringBuffer();
    	for(int i=0;i<str.length();i++){
    		if(str.charAt(i)==' '){
    			newstr.append('%');
    			newstr.append('2');
    			newstr.append('0');
    		}
    		else {
				newstr.append(str.charAt(i));
			}
    	}
    	return newstr.toString();
    	
    }
}
