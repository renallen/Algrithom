package com.bob.Offer;
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
public class HasSubtree {
	public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root2==null)return false;
        if(root1==null&&root2!=null)return false;
        boolean flag=false;
        if(root1.val==root2.val){
        	flag=isSubtree(root1,root2);
        }
        if(!flag){
        	flag=HasSubtree(root1.left, root2);
        	if(!flag){
        		flag=HasSubtree(root1.right, root2);
        	}
        }
        return flag;
    }

	private boolean isSubtree(TreeNode root1, TreeNode root2) {
		if(root2==null)return true;
		if(root1==null && root2!=null)return false;
		if(root1.val==root2.val){
			return isSubtree(root1.left, root2.left)&&isSubtree(root1.right, root2.right);
			
		}else {
			return false;
		}
	}
}
