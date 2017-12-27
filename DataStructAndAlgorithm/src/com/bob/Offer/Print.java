package com.bob.Offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Print {
	public static void main(String[] args) {
		
	}
	ArrayList<ArrayList<Integer> > PrintOfLevel(TreeNode pRoot) {
    	ArrayList<ArrayList<Integer> >result=new ArrayList<ArrayList<Integer>>();
    
    	return result;
    }
	 public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
		    ArrayList<ArrayList<Integer>>list=new ArrayList<ArrayList<Integer>>();
		    if(pRoot==null)return list;
		    ArrayList<Integer>tmp=new ArrayList<>();
		    LinkedList<TreeNode>q=new LinkedList<>();
		    q.add(pRoot);
		    int now=1,index=0;
		    while(!q.isEmpty()){
		    	TreeNode p=q.remove();
		    	now--;
		    	tmp.add(p.val);
		    	if(p.left!=null){
		    		q.add(p.left);
		    		index++;
		    	}
		    	if(p.right!=null){
		    		q.add(p.right);
		    		index++;
		    	}
		    	if(now==0){
		    		list.add(new ArrayList<Integer>(tmp));
		    		tmp.clear();
		    		now=index;
		    		index=0;
		    	}
		    }
		    //Queue<TreeNode>queue=new qu
		    return list;
		   
	   }
	public ArrayList<ArrayList<Integer>> ZPrint(TreeNode pRoot) {
			ArrayList<ArrayList<Integer>>list=new ArrayList<ArrayList<Integer>>();
			if(pRoot==null)return list;
			Stack<TreeNode>s1=new Stack<TreeNode>();
			s1.add(pRoot);
			Stack<TreeNode>s2=new Stack<TreeNode>();
			while(!s1.isEmpty()||!s2.isEmpty()){
				if(!s1.isEmpty()){
					ArrayList<Integer>list1=new ArrayList<Integer>();
					while(!s1.isEmpty()){
						TreeNode p=s1.pop();
						list1.add(p.val);
						if(p.left!=null)s2.add(p.left);
						if(p.right!=null)s2.add(p.right);
					}
					list.add(list1);
				}
				else{
					ArrayList<Integer>list1=new ArrayList<Integer>();
					while(!s2.isEmpty()){
						TreeNode p=s2.pop();
						if(p.right!=null)s1.add(p.right);
						if(p.left!=null)s1.add(p.left);
						list1.add(p.val);
					}
					list.add(list1);
				}
				
			}
			return list;
			
    }	
}
