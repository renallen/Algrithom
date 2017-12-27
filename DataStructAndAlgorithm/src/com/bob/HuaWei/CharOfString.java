package com.bob.HuaWei;

import java.util.Scanner;

public class CharOfString {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String s="";
		while(scanner.hasNextLine()){
			s=scanner.nextLine();
			char c=(char) s.lastIndexOf(" ");
			s=s.substring(0, s.lastIndexOf(" "));
			char[] chars=s.toCharArray();
			int res=0;
			for(int i=0;i<chars.length;i++){
				if(chars[i]==c)res++;
			}
			System.out.println(res);
		}
	}
}
