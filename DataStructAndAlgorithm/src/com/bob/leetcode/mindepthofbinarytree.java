package com.bob.leetcode;
class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	  }
public class mindepthofbinarytree {
	public int get(TreeNode root){
		int depth=0;
		if(root==null)return depth;
		return min(root);
	}

	private int min(TreeNode root) {
		if(root==null)return 0;
		if(root.left==null || root.right==null)return 1;
		return Math.min(min(root.left),min(root.right))+1;
	}
}
