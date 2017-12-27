package com.bob.Offer;

import java.util.ArrayList;
import java.util.TreeSet;

public class Permutation {
	public ArrayList<String> Permutation(String str) {
		
	       ArrayList<String> res=new ArrayList<>();
	       if(str==null || str.length()==0)return res;
	       char[] chars=str.toCharArray();
	       TreeSet< String>tmp=new TreeSet<>();
	       Permutation(chars,0,tmp);
	       res.addAll(tmp);
	       return res;
	       
    }

	private void Permutation(char[] chars, int begin, TreeSet<String> result) {
		if(chars==null || chars.length==0 || begin<0||begin>chars.length-1)return ;
		if(begin==chars.length-1){
			result.add(String.valueOf(chars));
		}
		else {
			for(int i=begin;i<=chars.length-1;i++){
				swap(chars,begin,i);
				Permutation(chars, begin+1, result);
				swap(chars, begin, i) ;
			}
		}
	}

	private void swap(char[] x, int a, int b) {
		// TODO Auto-generated method stub
		char t = x[a];
        x[a] = x[b];
        x[b] = t;
	}
}
