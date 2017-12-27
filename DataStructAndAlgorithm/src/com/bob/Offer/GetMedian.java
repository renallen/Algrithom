package com.bob.Offer;

import java.util.LinkedList;

public class GetMedian {
	LinkedList<Integer>list=new LinkedList<>();
	public void Insert(Integer num) {
	    if(list.size()==0 || num<list.getFirst())list.addFirst(num);
	    else {
			boolean insertflag=false;
			for(Integer e:list){
				if(num<e){
					int index=list.indexOf(e);
					list.add(index,num);
					insertflag=true;
					break;
				}
			}
			if(!insertflag)list.addLast(num);
		}
    }

    public Double GetMedian() {
        if(list.size()==0)return null;
        if(list.size()%2==0){
        	int i=list.size()/2;
        	return ((double) (list.get(i-1)+list.get(i)))/2;
        }
        return (double)list.get((list.size()+1)/2-1);	
    }
}
