package com.bob.Offer;

import java.util.Stack;

public class Mirror {
	public void Mirror(TreeNode root) {
	     if(root==null) return;
	     Stack<TreeNode>stack=new Stack<>();
	     stack.push(root);
	     while(!stack.empty()){
	    	 TreeNode node=stack.pop();
	    	 if(node.left!=null || node.right!=null){
	    		 TreeNode left=node.left;
	    		 TreeNode right=node.right;
	    		 node.left=right;
	    		 node.right=left;
	    	 }
	    	 if(node.left!=null)stack.push(node.left);
	    	 if(node.right!=null)stack.push(node.right);
	     }
	}
}
