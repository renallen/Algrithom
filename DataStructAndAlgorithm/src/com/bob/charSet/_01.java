package com.bob.charSet;

import java.util.HashMap;
import java.util.Map;

public class _01 {
	public static void main(String[] args) {
		String str="aabbaaffddphpaffa";
//		System.out.println(inverse(str));
//		System.out.println(findSymmetry(str));
//		System.out.println(findNumSymmetry(str));
		System.out.println(findhighratechar(str));
	}
private static char findhighratechar(String str) {
		int max=0;
		char c=' ';
		Map<Character, Integer>map=new HashMap<Character, Integer>();
		char[] chars=str.toCharArray();
		for(int i=0;i<chars.length;i++){
			if(map.containsKey(chars[i])){
				map.put(chars[i], map.get(chars[i])+1);
				if(map.get(chars[i])>max){
					max=map.get(chars[i]);
					c=chars[i];
				}
			}else {
				map.put(chars[i], 1);
			}
		}
		return c;
	}
private static int findNumSymmetry(String str) {
		int num=0;
		String symmetry;
		for(int i=1;i<str.length();i++){
			for(int j=0;j<str.length() && (j+i)<str.length();j++){
				symmetry=str.substring(j,i+j+1);
				char[] chars=symmetry.toCharArray();
				int k;
				for(k=0;k<chars.length/2;k++){
					if(chars[k]!=chars[chars.length-k-1])break;
				}
				if(k==chars.length/2)num++;
			}
		}
		return num;
		
	}
/**
 * 最长对称子串
 */
	private static String findSymmetry(String str) {
		for(int i=str.length()-1;i>0;i--){
			for(int j=0;j<str.length() && j+i<str.length();j++){
				String symmetry=str.substring(j,j+i+1);
				char[] chars=symmetry.toCharArray();
				int k;
				for(k=0;k<chars.length/2;k++){
					if(chars[k]!=chars[chars.length-k-1])break;
				}
				if(k==chars.length/2)return symmetry;
			}
		}
		return "";
		
	}

	private static String inverse(String str) {
		char[] chars=str.toCharArray();
		for(int i=0;i<chars.length/2;i++){
			char temp=chars[i];
			chars[i]=chars[chars.length-i-1];
			chars[chars.length-i-1]=temp;
		}
//		return String.valueOf(chars);
		return String.copyValueOf(chars);
	}
	
	
}
