package com.bob.leetcode;

public class _6ZigZag {
	public String convert(String s, int numRows) {
        int len=s.length();
        //�������
        if(len==0 || numRows<2)return s;
        String res="";
        int lag=2*numRows-2;//ÿһ�еļ����������
        for(int i=0;i<numRows;i++){
        	for(int j=i;j<len;j+=lag){
        		res+=s.charAt(j);
        		if(i>0 && i<numRows-1){
        			int t=j+lag-2*i;//�������к�ĩ��֮����У���������ظ�һ�Σ��ظ�����һ�ξ��뱾������ʼ�ַ��ľ����� 2 * nRows - 2 - 2 * i
        			if(t<len){
        				res+=s.charAt(t);
        			}
        		}
        	}
        }
        return res;
    }
}
