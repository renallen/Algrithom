package com.bob.leetcode;

public class _3LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
			
	}
	public int lengthOfLongestSubstring(String s) {
        if(s==null){
        	return 0;
        }
        if(s.length()==0 || s.length()==1)return s.length();
        char[] c=s.toCharArray();
        int barrier=0;//第一个不重复字符位置
        int maxLen=1;
        for(int i=0;i<c.length;i++){
        	for(int j=i-1;j>=barrier;j--){
        		if(c[i]==c[j]){
        			barrier=j+1;
        			break;
        		}
        	}
        	maxLen=Math.max(maxLen, i-barrier+1);
        }
        return maxLen;
    }
}
