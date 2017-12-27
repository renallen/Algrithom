package com.bob.Offer;

public class LongestSubstringWithoutDup {
	public static void main(String[] args) {
		System.out.println(LongestSubstringWithoutDup("amdhsdjgfdh"));
	}
	/**
	 * 最长子串不含重复字符
	 */
	public static int  LongestSubstringWithoutDup(String str){
		if(str==null || str.length()==0)return 0;
		int[] dp=new int[str.length()];
		dp[0]=1;
		int maxdp=1;
		for(int dpindex=1;dpindex<dp.length;dpindex++)
		{
			int i=dpindex-1;
			for(;i>=dpindex-dp[dpindex-1];i--){
				if(str.charAt(dpindex)==str.charAt(i))break;
			}
			dp[dpindex]=dpindex-i;
			if(dp[dpindex]>maxdp)maxdp=dp[dpindex];
		}	
		return maxdp;
	}
	
}
