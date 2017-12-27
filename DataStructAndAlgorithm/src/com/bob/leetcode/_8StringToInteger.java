package com.bob.leetcode;

public class _8StringToInteger {
	public static void main(String[] args) {
		String string=" -123";
		System.out.println(myAtoi(string));
	}
	public static int myAtoi(String str) {
        if(str==null)return 0;
        str=str.trim();
        if(str.length()==0)return 0;
        
        int sign=1;
        int index=0;
        //���ȶ�+��-�����ж�
        if(str.charAt(index)=='+'){
        	index++;
        }else if (str.charAt(index)=='-') {
			sign=-1;
			index++;
		}
        long num=0;
        for(;index<str.length();index++){
        	if(str.charAt(index)<'0' || str.charAt(index)>'9')break;
        	num=num*10+(str.charAt(index)-'0');
        	if(num>Integer.MAX_VALUE){
        		break;
        	}
        }
        
        //�����������ֵ��Χ���������Сֵ������ֱ��sign*num��
        if(num*sign>=Integer.MAX_VALUE){
        	return Integer.MAX_VALUE;
        }
        if(num*sign<=Integer.MIN_VALUE){
        	return Integer.MIN_VALUE;
        }
        return (int)num*sign;
    }
}
