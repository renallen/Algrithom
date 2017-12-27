package com.bob.leetcode;

import java.util.Stack;

public class evalRPN {
	/**
	 * Äæ²¨À¼Ê½
	 * @param tokens
	 * @return
	 */
public int evalRPN(String[] tokens) {
        if(tokens.length==0)return 0;
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<tokens.length;i++){
        	if(isOperator(tokens[i])){
        		if(tokens[i].equals("+")){
        			int tmp;
        			int a=stack.pop();
        			int b=stack.pop();
        			tmp=a+b;
        			stack.push(tmp);
        		}
        		if(tokens[i].equals("-")){
        			int tmp;
        			int a=stack.pop();
        			int b=stack.pop();
        			tmp=a-b;
        			stack.push(tmp);
        		}
        		if(tokens[i].equals("*")){
        			int tmp;
        			int a=stack.pop();
        			int b=stack.pop();
        			tmp=a*b;
        			stack.push(tmp);
        		}
        		if(tokens[i].equals("/")){
        			int tmp;
        			int a=stack.pop();
        			int b=stack.pop();
        			tmp=a/b;
        			stack.push(tmp);
        		}
        	}
        	else {
				stack.push(Integer.parseInt(tokens[i]));
			}
        }
        return stack.peek();
    }

private boolean isOperator(String string) {
	if(string.equals("+") || string.equals("-") || string.equals("*") || string.equals("/") )return true;
	return false;
}
}
