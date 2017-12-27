package com.bob.Offer;

public class match {
	 public boolean match(char[] str, char[] pattern)
	    {
	        return matchall(str,0,str.length,pattern,0,pattern.length);
	    }

	private boolean matchall(char[] str, int i, int length, char[] pattern, int j, int length2) {
		if(i==length&&j==length2)return true;
		if(i==length&&j!=length2){
			while(j!=length2){
				if(pattern[j]!='*'&&(j+1>=length2|| pattern[j+1]!='*')){
					return false;
				}j++;
				
			}
			return true;
		}
		if(i!=length&&j==length2){
			return false;
		}
		
		
		if(j+1==length2){
			if(str[i]==pattern[j]|| pattern[j]=='.')return matchall(str, i+1, length, pattern, j+1, length2);
			else {
				return false;
			}
		}
		 if((str[i]==pattern[j]||pattern[j]=='.')&&pattern[j+1]!='*')
	            return matchall(str, i, length, pattern, j+2, length2)||matchall(str, i+1, length, pattern, j, length2);
	      if(pattern[j+1]=='*')
	            return matchall(str, i, length, pattern, j+2, length2);
	     
		
		
		return false;
	}
}
