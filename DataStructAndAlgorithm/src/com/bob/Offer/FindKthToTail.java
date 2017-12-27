package com.bob.Offer;

import com.bob.Offer.printListFromTailToHead.ListNode;

public class FindKthToTail {
	public ListNode FindKthToTail(ListNode head,int k) {
		if(head==null || k<=0)return null;
		ListNode  head1=head;
		ListNode  head2=head;
		for(int i=1;i<k;i++){
			if(head1.next!=null)
			head1=head1.next;
			else {
				return null;
			}
		}
		while(head1.next!=null){
			head1=head1.next;
			head2=head2.next;
		}
		return head2;
    }
}
