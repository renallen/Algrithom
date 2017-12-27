package com.bob.Offer;

public class Serialize {
	 String Serialize(TreeNode root) {
			if(root==null)return "";
			StringBuilder sb=new StringBuilder();
			Serialize2(root,sb);
			return sb.toString();
	 }
	  private void Serialize2(TreeNode root, StringBuilder sb) {
		   if(root==null){
			   sb.append("#,");
			   return ;
		   }
		   sb.append(root.val);
		   sb.append(',');
		   Serialize2(root.left, sb);
		   Serialize2(root.right, sb);
	}
	  int index=-1;
	TreeNode Deserialize(String str) {
			if(str.length()==0)return null;
			String[] strings=str.split(",");
			return Deserialize2(strings);
			
	 }
	private TreeNode Deserialize2(String[] strings) {
		index++;
        if(!strings[index].equals("#")) {
            TreeNode root = new TreeNode(0);     
            root.val = Integer.parseInt(strings[index]);
            root.left = Deserialize2(strings);
            root.right = Deserialize2(strings);
            return root;
        }
		return null;
	}
}
