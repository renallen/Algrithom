package com.bob.Offer;

import java.util.HashMap;
class TreeNode {
    int val;
    TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
public class reConstructBinaryTree {
	
	public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root=reConstructBinaryTree(pre,0,pre.length-1, in,0,in.length-1);
        return root;
    }
	private TreeNode reConstructBinaryTree(int[] pre, int i, int j, int[] in, int k, int l) {
		if(i>j || k>l)return null;
		TreeNode root=new TreeNode(pre[i]);
		for(int a=k;a<=l;a++){
			if(in[a]==pre[i]){
				root.left=reConstructBinaryTree(pre, i+1, i+a-k, in, k, a-1);
				root.right=reConstructBinaryTree(pre, i+a-k+1, j, in, a+1, l);
			}
		}
		return root;
	}
	
}
