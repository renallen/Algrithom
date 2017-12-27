package com.bob.Offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FindNumbersWithSum {
	public static void main(String[] args) {
		int[] array={1, 2,3,4,5,6,7};
		System.out.println(FindNumbersWithSum(array,5).toString());
	}
public static ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
		ArrayList<ArrayList<Integer>>result=new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<array.length;i++){
			ArrayList<Integer>list=new ArrayList<>();
			for(int j=i+1;j<array.length;j++){
				if(array[i]+array[j]==sum){
					list.add(array[i]);
					list.add(array[j]);
					list.add(array[i]*array[j]);
				}
			}
			if(!list.isEmpty()){
				result.add(list);
			}
		}
		if(result.size()==0)return new ArrayList<Integer>();
		Collections.sort(result, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                    return o1.get(2).compareTo(o2.get(2));
            }
        });
		ArrayList<Integer>res=new ArrayList<>();
		ArrayList<Integer>tmp=result.get(0);
		for(int i=0;i<tmp.size()-1;i++){
			res.add(tmp.get(i));
		}
		return res;
    }
}
