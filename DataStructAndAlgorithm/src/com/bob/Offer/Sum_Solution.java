package com.bob.Offer;

public class Sum_Solution {
	public int Sum_Solution(int n) {
        return (n>0?(n+Sum_Solution(n-1)):0);
    }
}
