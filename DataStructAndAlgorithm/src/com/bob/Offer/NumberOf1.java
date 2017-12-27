package com.bob.Offer;

import java.awt.List;
import java.util.ArrayList;

public class NumberOf1 {
	public int NumberOf1(int n) {
			int res=0;
			char[] array=Integer.toBinaryString(n).toCharArray();
			for(int i=0;i<array.length;i++){
				if(array[i]=='1')res++;
			}
			return res;

	}
}
