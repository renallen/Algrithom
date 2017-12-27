package com.bob.Offer;

public class Add {
	 public int Add(int num1,int num2) {
		 int sum = num1^num2;
	        int carry = (num1&num2)<<1;
	        int temp;
	        while (carry!=0){
	            temp = sum;
	            sum = sum^carry;
	            carry = (carry&temp)<<1;
	        }
	        return sum;
	    }
}
