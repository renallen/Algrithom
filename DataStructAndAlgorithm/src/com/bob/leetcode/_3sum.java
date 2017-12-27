package com.bob.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _3sum {
	 public List<List<Integer>> threeSum(int[] nums) {
	        List<List<Integer>> res=new ArrayList<List<Integer>>();
	        for(int i=0;i<nums.length-3;i++){
	        	for(int j=i+1;j<nums.length-2;j++){
	        		for(int k=j+1;k<nums.length-1;k++){
	        			if(nums[i]+nums[j]+nums[k]==0)res.add(Arrays.asList(nums[i],nums[j],nums[k]));
	        		}
	        	}
	        }
	        return res;
	    }
}
