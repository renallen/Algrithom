package com.bob.Offer;

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
public class Clone {
	 public RandomListNode Clone(RandomListNode pHead)
	 {
	       /**
	        *  1)cloneNodes
	        *  2)connectRandomNode
	        *  3)reconnectNodes
	        */
		 if(pHead==null)return null;
		 cloneNodes(pHead);
		 connectRandomNode(pHead);
		 return reconnectNodes(pHead);
		 
	 }

	private RandomListNode reconnectNodes(RandomListNode pHead) {
		// TODO Auto-generated method stub
		RandomListNode newhead=pHead.next;
		RandomListNode cur=pHead;
		RandomListNode newCur=newhead;
		while(true){
			cur.next=cur.next.next;
			cur=cur.next;
			if(cur==null){
				newhead.next=null;break;
			}
			newhead.next=newCur.next.next;
			newCur=newCur.next;
		}
		return newhead;
	}

	private void connectRandomNode(RandomListNode pHead) {
		// TODO Auto-generated method stub
		RandomListNode cur=pHead;
		RandomListNode curNext=pHead.next;
		while(true){
			if(cur.random!=null){
				curNext.random=cur.random.next;
			}
			cur=cur.next.next;
			if(cur==null)break;
			curNext=curNext.next.next;
		}
	}

	private void cloneNodes(RandomListNode pHead) {
		// TODO Auto-generated method stub
		RandomListNode cur=pHead;
		RandomListNode tmp=null;
		while(cur!=null){
				tmp=new RandomListNode(cur.label);
				tmp.next=cur.next;
				cur.next=tmp;
				cur=cur.next.next;
		}
	}
}
