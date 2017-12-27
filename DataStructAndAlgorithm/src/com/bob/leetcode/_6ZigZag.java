package com.bob.leetcode;

public class _6ZigZag {
	public String convert(String s, int numRows) {
        int len=s.length();
        //特殊情况
        if(len==0 || numRows<2)return s;
        String res="";
        int lag=2*numRows-2;//每一行的间隔都是这样
        for(int i=0;i<numRows;i++){
        	for(int j=i;j<len;j+=lag){
        		res+=s.charAt(j);
        		if(i>0 && i<numRows-1){
        			int t=j+lag-2*i;//对于首行和末行之间的行，还会额外重复一次，重复的这一次距离本周期起始字符的距离是 2 * nRows - 2 - 2 * i
        			if(t<len){
        				res+=s.charAt(t);
        			}
        		}
        	}
        }
        return res;
    }
}
