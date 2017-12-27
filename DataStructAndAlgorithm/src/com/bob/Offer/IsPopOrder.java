package com.bob.Offer;

import java.util.Stack;

public class IsPopOrder {
	 public boolean IsPopOrder(int [] pushA,int [] popA) {
		 if(pushA == null || popA == null || pushA.length == 0 || popA.length == 0 || pushA.length != popA.length) return false;
	      Stack<Integer>stack=new Stack<>();
	      int i=0,j=0;
	      stack.push(pushA[i++]);
	      while(j<=popA.length-1){
	    	  while(popA[j]!=stack.peek()){
	    		  if(i==pushA.length)return false;
	    		  stack.push(pushA[i++]);	
	    	  }
	    	  j++;
	    	  stack.pop();
	    	  
	      }
	      return true;
	    }
}
