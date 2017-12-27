package com.bob.Offer;

import java.util.Iterator;
import java.util.Stack;

public class MinStack {
	/**
	 * ����ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ��СԪ�ص�min������
	 */
	Stack<Integer>stack=new Stack<>();
	public void push(int node) {
        stack.push(node);
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int min() {
        int min=stack.peek();
        int tmp=0;
        Iterator<Integer>iterable=stack.iterator();
        while(iterable.hasNext()){
        	tmp=iterable.next();
        	if(tmp<min)min=tmp;
        }
        return min;
    }
}
