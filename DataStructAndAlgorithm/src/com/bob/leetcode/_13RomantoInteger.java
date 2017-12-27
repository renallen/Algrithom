package com.bob.leetcode;


public class _13RomantoInteger {
	public int romanToInt(String s) {
        char [] str=s.toCharArray();
        int res;
        res=toint(str[0]);
        for(int i=1;i<str.length;i++){
        	res+=toint(str[i]);
        	if(toint(str[i-1])<toint(str[i]))res-=toint(str[i-1])*2;//如果某一位是DC这样的值就需要减半
        }
        return res;
    }

	private int toint(char c) {
		switch (c) {
		case 'I':return 1;
        case 'V':return 5;
        case 'X':return 10;
        case 'L':return 50;
        case 'C':return 100;
        case 'D':return 500;
        case 'M':return 1000;
		default:
			break;
		}
		return 0;
	}
}
