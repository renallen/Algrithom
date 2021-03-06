package com.bob.Offer;

public class Merge {
	/**
	 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
	 * @param list1
	 * @param list2
	 * @return
	 */
public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1==null)return list2;
        if(list2==null)return list1;
        ListNode mergeHead=null;
        if(list1.val>list2.val){
        	mergeHead=list2;
        	mergeHead.next=Merge(list1, list2.next);
        }else {
			mergeHead=list1;
			mergeHead.next=Merge(list1.next, list2);
		}
        return mergeHead;
    }
}
