package com.bob.Linear;

public class LinkedList <E>{
	public static void main(String[] args) {
	}
	public class Node{
		private E e;
		private Node next;
		public Node() {
		}
		public Node(E e) {
				this.e=e;
			}
		public void addNext(Node node){
			next=node;
		}
	}
	
	private Node header=null;
	private int size;
	public LinkedList() {
		this.header=new Node();
	}
	public boolean add(E e){
		if(size==0){
			header.e=e;
		}else {
			Node newnode=new Node(e);
			Node last=getNode(size-1);
			last.addNext(newnode);
		}
		size++;
		return true;
	}
	public boolean insert(int index,E e){
		Node newnode=new Node(e);
		Node cNode=getNode(index);
		newnode.next=cNode.next;
		cNode.next=newnode;
		size++;
		return true;
	}
	private Node getNode(int index) {
		if(index>size || index<0)throw new RuntimeException("索引值错误"+index);
		Node tem=new Node();
		tem=header;
		int count=0;
		while (count!=index) {
			tem=tem.next;
			count++;
		}
		return tem;
	}
	public E get(int index){
		if(index>=size || index<0)throw new RuntimeException("索引值错误"+index);
		Node tem=new Node();
		tem=header;
		int count=0;
		while(count!=index){
			tem=tem.next;
			count++;
		}
		E e=tem.e;
		return e;
	}
	public boolean set(int index, E e) {  
        // 先判断索引正确性  
        if (index > size || index < 0) {  
            throw new RuntimeException("索引值有错：" + index);  
        }  
        Node newNode = new Node(e);  
        // 得到第x个结点  
        Node cNode = getNode(index);  
        cNode.e = e;  
        return true;  
    }  
	
}
