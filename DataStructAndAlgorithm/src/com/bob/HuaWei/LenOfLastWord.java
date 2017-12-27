package com.bob.HuaWei;

import java.util.Scanner;

public class LenOfLastWord {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String string=scanner.next();
		String one=scanner.next();
		int i=getcount(string,one);
		System.out.println(i);
	}

	private static int getcount(String string, String one) {
		char[] chars=string.toCharArray();
		
		int count=0;
		if(string!=null && string.length()>0){
			for(int i=0;i<string.length();i++){
				if(one.equalsIgnoreCase(String.valueOf(chars[i])))count++;
			}
		}
		return count;
	}
}
