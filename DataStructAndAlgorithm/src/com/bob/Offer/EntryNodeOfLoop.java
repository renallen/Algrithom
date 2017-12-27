package com.bob.Offer;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class EntryNodeOfLoop {
	//��������ָ�룬һ���죬һ��������
	 public ListNode EntryNodeOfLoop(ListNode pHead)
	    {	if(pHead==null || pHead.next==null)return null;
	        ListNode slow=pHead;
	        ListNode fast=pHead;
	        while(fast!=null || fast.next!=null){
	        	slow=slow.next;
	        	fast=fast.next.next;
	        	if(slow==fast){
	        		slow=pHead;
	        		while(slow!=fast){
	        			slow=slow.next;
		        		fast=fast.next;
	        		}
	        		if(slow==fast)return slow;
	        		
	        	}
	        	
	        }
	        return null;
	        
	    }
}
