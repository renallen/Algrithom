package com.bob.leetcode;

public class _10REMatching {
	public boolean isMatch(String s, String p) {
        if(s.length()==0)return checkEmpy(p);
        if(p.length()==0)return false;
        int i=0,j=0;
        char c1=s.charAt(0);
        char d1=p.charAt(0),d2='0';//若有第二个字符则将其赋值给d2
        if(p.length()>1){
        	d2=p.charAt(1);
        }
        if(d2=='*'){
        	if(compare(c1,d1)){
        		return isMatch(s.substring(1), p) || isMatch(s, p.substring(2));
        	}
        	else{
        		return isMatch(s, p.substring(2));
        	}
        }
        else{
        	if(compare(c1, d1)){
        		return isMatch(s.substring(1), p.substring(1));
        	}else{
        		return false;
        	}
        }
    }

	private boolean compare(char c1, char d1) {
		return d1=='.' ||  c1==d1;
	}

	private boolean checkEmpy(String p) {
		if(p.length()%2==0){
			return false;
		}
		for(int i=0;i<p.length();	i+=2){
			if(p.charAt(i) != '*')return false;
		}
		return true;
	}
}
