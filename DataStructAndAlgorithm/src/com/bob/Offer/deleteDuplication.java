package com.bob.Offer;

public class deleteDuplication {
	public ListNode deleteDuplication(ListNode pHead)
    {		if(pHead==null)return null;
		    ListNode p=pHead;
		    ListNode n=new ListNode(0);
		    n.next=pHead;
		    ListNode pre=n;
		    boolean flag=false;
		   while(p!=null){
			   ListNode q=p.next;
			   if(p.val==q.val){
				   while(q!=null && p.val==q.val){
					   q=q.next;
				   }
				   pre.next=q;
				   p=q;
			   }else{
				   //设置头结点，返回
				   if(!flag){
					   n.next=p;
					   flag=true;
				   }
				   pre=p;
				   p=q;
				   
			   }
			   
		   }
		    return n.next;
    }
}
