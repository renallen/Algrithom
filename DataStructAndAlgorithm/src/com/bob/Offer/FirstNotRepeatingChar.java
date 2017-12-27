package com.bob.Offer;

public class FirstNotRepeatingChar {
	public int FirstNotRepeatingChar(String str) {
		StringBuffer sb=new StringBuffer();
        char[] strs=str.toCharArray();
        for(int i=0;i<strs.length;i++){
        	sb.append(strs[i]+"");
        }
        for(int i=0;i<strs.length;i++){
        	if(sb.indexOf(strs[i]+"")==sb.lastIndexOf(strs[i]+""))return i;
        }
        return 0;
    }
}
