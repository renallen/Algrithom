package com.bob.Offer;

import java.util.ArrayList;
import java.util.Stack;

public class printListFromTailToHead {
	public class ListNode{
		int val;
		ListNode next = null;
		ListNode(int val) {
		   this.val = val;
		 }
	}
	 public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
	        Stack< Integer> nodes=new Stack<>();
	        while(listNode!=null){
	        	nodes.push(listNode.val);
	        	listNode=listNode.next;
	        }
	        ArrayList<Integer>list=new ArrayList<>();
	        while(!nodes.isEmpty()){
	        	list.add(nodes.pop());
	        }
	        return list;
	        
	        
	  }
}
