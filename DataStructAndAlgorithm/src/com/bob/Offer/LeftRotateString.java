package com.bob.Offer;

public class LeftRotateString {
	/**
	 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
	 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
	 * @param str
	 * @param n
	 * @return
	 */
	public String LeftRotateString(String str,int n) {
      int len=str.length();
      if(len==0)return str;
      str+=str;
      return str.substring(n,len+n);
    }
}
