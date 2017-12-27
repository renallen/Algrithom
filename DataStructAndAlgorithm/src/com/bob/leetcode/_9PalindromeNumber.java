package com.bob.leetcode;

public class _9PalindromeNumber {
	public boolean isPalindrome(int x) {
        if(x<0)return false;
        if(x<10)return true;
        int t=x;
        int d=0;
        while(t!=0){
        	t/=10;
        	++d;//总共几位
        }
        int left=(int) Math.pow(10, d-1);
        int right=1;
        while(left>=right){
        	if(x/left%10 != x/right%10)return false;
        	left/=10;
        	right*=10;
        }
        return true;
    }
}
