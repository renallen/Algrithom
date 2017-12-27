package com.bob.Offer;

public class swap {
public void swap(int a,int b){
	a=a^b;
	b=a^b;
	a=a^b;
}
public void swap1(int a,int b){
	a=a+b;
	b=a-b;
	a=a-b;
}
}
