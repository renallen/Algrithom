package com.bob.Offer;

public class LeftRotateString {
	/**
	 * ����һ���������ַ�����S���������ѭ������Kλ������������
	 * ���磬�ַ�����S=��abcXYZdef��,Ҫ�����ѭ������3λ��Ľ��������XYZdefabc����
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
