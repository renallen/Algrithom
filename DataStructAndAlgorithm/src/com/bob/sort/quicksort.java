package com.bob.sort;

import java.util.Arrays;
import java.util.Stack;

public class quicksort {
	private static Stack<Integer> stack=new Stack<Integer>();
	public static void main(String[] args) {
		int[] arr={534,22,1,212,12,121,2121,212,2112,102,152,185,56,54,21,23,83,69,56,23,21};
		long t1=System.currentTimeMillis();
		sort(arr, 0, arr.length-1);
		System.out.println(System.currentTimeMillis()-t1);
		System.out.println(Arrays.toString(arr));
		int[] arr1={534,22,1,212,12,121,2121,212,2112,102,152,185,56,54,21,23,83,69,56,23,21};
		long t2=System.currentTimeMillis();
		sort_stack(arr1, 0, arr1.length-1);
		System.out.println(System.currentTimeMillis()-t2);
		System.out.println(Arrays.toString(arr1));
		
	}
	public void quick_sort(int s[], int l, int r)  
	{  
	    if (l < r)  
	    {  
	        //Swap(s[l], s[(l + r) / 2]); //���м��������͵�һ�������� �μ�ע1  
	        int i = l, j = r, x = s[l];  
	        while (i < j)  
	        {  
	            while(i < j && s[j] >= x) // ���������ҵ�һ��С��x����  
	                j--;    
	            if(i < j)   
	                s[i++] = s[j];  
	              
	            while(i < j && s[i] < x) // ���������ҵ�һ�����ڵ���x����  
	                i++;    
	            if(i < j)   
	                s[j--] = s[i];  
	        }  
	        s[i] = x;  
	        quick_sort(s, l, i - 1); // �ݹ����   
	        quick_sort(s, i + 1, r);  
	    }  
	}  
	//��Ϊ�ݹ�ͷǵݹ飨ջ��
	//�ݹ鷽ʽ
	public static void sort(int[] arr,int l,int r){
		if(r<=l)return ;
		int i=partiton(arr,l,r);
		sort(arr, l, i-1);
		sort(arr, i+1, r);
	}

	private static int partiton(int[] arr, int l, int r) {
		int key=arr[l];
		while(l<r){
			while(arr[r]>=key && r>l)r--;	
			if(l<r)arr[l++]=arr[r];
			while(arr[l]<=key && l<r)l++;
			if(l<r)arr[r--]=arr[l];
		}
		arr[l]=key;
		System.out.println(l);
		return l;
	}

	private static void exchange(int[] arr, int i, int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	//�ǵݹ鷽ʽ
	public static void sort_stack(int[] arr,int l,int r){
		int i;
		push2(r,l);
		while(!stackempty()){
			l=pop();r=pop();
			if(r<=1)continue;
			i=partiton(arr, l, r);
			if(i-1>r-i){//�ϴ󲿷�����ջ����֤������ΪLgN
				push2(i-1, 1);push2(r, i+1);
			}else {
				push2(r, i+1);push2(i-1, l);
			}
		}
		
	}
	private static int pop() {
		return stack.pop();
	}
	private static boolean stackempty() {
		return stack.isEmpty();
	}
	private  static void push2(int r, int l) {
		stack.push(r);
		stack.push(l);
	} 
}
