package com.bob.Offer;

import java.util.Stack;


public class FindFirstCommonNode {
	public ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
		 for(ListNode node1=pHead1;node1!=null;node1=node1.next){
			 for(ListNode node2=pHead2;node2!=null;node2=node2.next){
				 if(node1==node2)return node1;
			 }
		 }
		 return null;
    }
	public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
		Stack<ListNode>stack1=new Stack<>();
		Stack<ListNode>stack2=new Stack<>();
		for(ListNode node1=pHead1;node1!=null;node1=node1.next){
			stack1.push(node1);
		}
		for(ListNode node2=pHead2;node2!=null;node2=node2.next){
			stack2.push(node2);
		}
		ListNode commonnode=null;
		while(!stack1.isEmpty() && !stack2.isEmpty()){
			if(stack1.peek()==stack2.peek()){
				commonnode=stack1.pop();
				stack2.pop();
			}
			else {
				break;
			}
		}
		return commonnode;
   }
	public ListNode FindFirstCommonNode3(ListNode pHead1, ListNode pHead2) {
		ListNode node1=pHead1;ListNode node2=pHead2;
		int size1=0,size2=0;
		for(;node1!=null;node1=node1.next)size1++;
		for(;node2!=null;node2=node2.next)size2++;
		node1=pHead1;node2=pHead2;
		while(size1>size2){
			node1=node1.next;
			size1--;
		}
		while(size2>size1){
			node2=node2.next;
			size2--;
		}
		while(node1!=null){
			if(node1!=node2){
				node1=node1.next;
				node2=node2.next;
			}else {
				break;
			}
		}
		return node1;
	}
}
