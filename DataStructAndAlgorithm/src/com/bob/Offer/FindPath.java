package com.bob.Offer;

import java.util.ArrayList;

public class FindPath {
	/**
	 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
	 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
	 * @param root
	 * @param target
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
		ArrayList<ArrayList<Integer>>res=new ArrayList<ArrayList<Integer>>();
		if(root==null)return res;
		ArrayList<Integer>a1=new ArrayList<>();
		int sum=0;
		pa(root,target,res,a1,sum);
		return res;
		
    }

	private void pa(TreeNode root, int target, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> a1, int sum) {
		if(root==null)return ;
		sum+=root.val;
		if(root.left==null && root.right==null){
			if(sum==target){
				a1.add(root.val);
				res.add(new ArrayList<>(a1));
				a1.remove(a1.size()-1);
			}
			return ;
		}
		a1.add(root.val);
		pa(root.left, target, res, a1, sum);
		pa(root.right, target, res, a1, sum);
		a1.remove(a1.size()-1);
		
	}
}
