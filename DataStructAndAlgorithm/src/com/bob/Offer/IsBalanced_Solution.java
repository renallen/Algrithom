package com.bob.Offer;

public class IsBalanced_Solution {
public boolean IsBalanced_Solution(TreeNode root) {
        if(root==null)return true;
        int leftDepth=TreeDepth(root.left);
        int rightDepth=TreeDepth(root.right);
        int diff=rightDepth-leftDepth;
        if(diff>1 || diff<-1)return false;
        return IsBalanced_Solution(root.left)&&IsBalanced_Solution(root.right);
        
        
    }

private int TreeDepth(TreeNode node) {
	if(node==null)return 0;
	int left=TreeDepth(node.left);
	int rigt=TreeDepth(node.right);
	
	return left>rigt?(left+1):(rigt+1);
}
}
