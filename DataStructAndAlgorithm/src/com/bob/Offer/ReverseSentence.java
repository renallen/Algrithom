package com.bob.Offer;

public class ReverseSentence {
	/**
	 * ��student. a am I��
	 * ��ȷ�ľ���Ӧ���ǡ�I am a student.��
	 * @param str
	 * @return
	 */
public String ReverseSentence(String str) {
        if(str==null)return null;
        if(str.trim().equals(""))return str;
        String[] strings=str.split(" ");
        StringBuilder builder=new StringBuilder();
        for(int i=strings.length-1;i>=0;i--){
        	if(i==0)builder.append(strings[i]);
        	else {
				builder.append(strings[i]);
				builder.append(" ");
			}
        }
       return builder.toString();
    }
}
