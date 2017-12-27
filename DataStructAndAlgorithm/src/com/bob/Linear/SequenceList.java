package com.bob.Linear;

public class SequenceList {
	private int LIST_INIT_SIZE=5;
	private int INCREMENT=1;
	private Object [] list=null;
	private int currentIndex=0;
	
	public SequenceList() {
		list=new Object[LIST_INIT_SIZE];
	}
	
	public void insert(Object c){
		if(currentIndex>LIST_INIT_SIZE-1){
			LIST_INIT_SIZE+=INCREMENT;
			Object[] temp=new Object[LIST_INIT_SIZE];
			for(int i=0;i<currentIndex;i++){
				temp[i]=list[i];
			}
			list=null;
			list=temp;
			/*if(isContain(c)){}*/
		}
		list[currentIndex++]=c;
	}
	public void delete(Object o){
		for(int i=0;i<currentIndex;i++){
			if(list[i].equals(o)){
				for(int j=i;j<currentIndex;j++){
					list[j]=list[j++];
				}
				currentIndex--;
				continue;
			}
			if(i==currentIndex-1){
			}
		}
	}
	public Object get(int i){
		if(i<=0 || i>currentIndex)return null;
		return list[i-1];
	}
	
	
	
	
	
/*	public void clear(){}
	public boolean isEmpy(){}
	public int length(){}
	public int get(int element){}
	public void inset(int element){}
	public void remove(int element){}
	public void IndexOf(int element){}
	public void display(){}*/
}
