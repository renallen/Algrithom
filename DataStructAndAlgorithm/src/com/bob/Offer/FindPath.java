package com.bob.Offer;

import java.util.ArrayList;

public class FindPath {
	/**
	 * ����һ�Ŷ�������һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·����
	 * ·������Ϊ�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����
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
