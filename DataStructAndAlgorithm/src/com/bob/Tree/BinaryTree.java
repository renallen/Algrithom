package com.bob.Tree;

import java.util.Stack;

public class BinaryTree {
	private class TreeNode{
		private int key=0;
		private String data=null;
		private boolean isVisted=false;
		private TreeNode leftChild=null;
		private TreeNode rightChild=null;
		public TreeNode(int key,String data) {
			this.key=key;
			this.data=data;
			this.leftChild=null;
			this.rightChild=null;
		}
	}
	private TreeNode root=null;
	public BinaryTree() {
		root=new TreeNode(1,"A");
	}
	public boolean isEmpy(){
		return root==null;
	}
	public TreeNode getLeftChildNode(TreeNode element){  
        return (element!=null)?element.leftChild:null;  
    }  
      
    public TreeNode getRightChildNode(TreeNode element){  
        return (element!=null)?element.rightChild:null;  
    }  
      
    public TreeNode getRoot(){  
        return root;  
    }  
	public int height(){
		return height(root);
	}
	private int height(TreeNode subtree) {
		if(subtree==null)return 0;
		else {
			int i=height(subtree.leftChild);
			int j=height(subtree.rightChild);
			return (i<j)?(j+1):(i+1);
		}
	}
	public  int size(){
		return size(root);
	}
	private int size(TreeNode subtree) {
		if(subtree==null)return 0;
		else {
			return 1+size(subtree.leftChild)+size(subtree.rightChild);
		}
	}
	public TreeNode parent(TreeNode element){  
        return (root==null|| root==element)?null:parent(root, element);  
    }
	
	private TreeNode parent(TreeNode subtree, TreeNode element) {
		if(subtree==null)return null;
		if(subtree.leftChild==element|| subtree.rightChild==element){
			return subtree;
		}
		TreeNode p;
		if((p=parent(subtree.leftChild,element))!=null){
			return p;
		}
		else {
			return parent(subtree.rightChild, element);
		}
	}
	public void preOrder(TreeNode subtree){
		if(subtree!=null){
			visted(subtree);
			preOrder(subtree.leftChild);
			preOrder(subtree.rightChild);
		}
	}
	private void visted(TreeNode subtree) {
		subtree.isVisted=true;
		System.out.println(subtree.key+subtree.data);
	}
	public void midOrder(TreeNode subtree){
		if(subtree!=null){
			midOrder(subtree.leftChild);
			visted(subtree);
			midOrder(subtree.rightChild);
		}
	}
	public void postOrder(TreeNode subtree){
		if(subtree!=null){
			postOrder(subtree.leftChild);
			postOrder(subtree.rightChild);
			visted(subtree);
		}
	}
	
	public void nonRecPreOrder(TreeNode p){
		Stack<TreeNode>stack=new Stack<TreeNode>();
		TreeNode node=p;
		while(node!=null || stack.size()>0){
			while(node!=null){
				visted(node);
				stack.push(node);
				node=node.leftChild;
			}
			if(stack.size()>0){
				node=stack.pop();
				visted(node);
				node=node.rightChild;
			}
		}
	}
	public void nonRecMidOrder(TreeNode p){
		Stack<TreeNode>stack=new Stack<TreeNode>();
		TreeNode node=p;
		while(p!=null || stack.size()>0){
			while(node!=null){
				stack.push(node);
				node=node.leftChild;
			}
			if(stack.size()>0){
				node=stack.pop();
				visted(node);
				node=node.rightChild;
			}
		}
	}	
	public void nonRecPostOrder(TreeNode p){
		Stack<TreeNode>stack=new Stack<TreeNode>();
		TreeNode node=p;
		while(p!=null){
			for(;p.leftChild!=null;p=p.leftChild){
				stack.push(p);
			}
			while(p!=null&&(p.rightChild==null || p.rightChild==node)){
				visted(p);
				node=p;
				if(stack.empty())
					return;
				p=stack.pop();
			}
			stack.push(p);
			p=p.rightChild;
		}
	}
}
