package com.bob.leetcode;

public class _7ReverseInteger {
	public int reverse(int x) {
		int sum=0;
		while(x!=0){
			int temp=sum*10+x%10;
			x=x/10;
			if(temp/10 != sum){
				sum=0;
				break;
			}
			sum=temp;
		}
        return sum;
    }
}
