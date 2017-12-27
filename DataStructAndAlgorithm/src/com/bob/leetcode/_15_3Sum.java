package com.bob.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class _15_3Sum {
	public ArrayList<ArrayList<Integer>> threeSum(int[] nums){
		ArrayList<ArrayList<Integer>>result=new ArrayList<ArrayList<Integer>>();
		if(nums==null || nums.length<3)return result;
		Arrays.sort(nums);
		
		for(int i=0;i<nums.length-2;i++){
			if(i>0 && nums[i]==nums[i-1])continue;
			int left=i+1,right=nums.length-1;
			int target=-nums[i];
			twoSum(nums, left, right, target, result);
		}
		return result;
	}

	private void twoSum(int[] nums, int left, int right, int target, ArrayList<ArrayList<Integer>> result) {
			while(left<right){
				if(nums[left]+nums[right]==target){
					ArrayList<Integer>triple=new ArrayList<Integer>();
					triple.add(-target);
					triple.add(nums[left]);
					triple.add(nums[right]);
					result.add(triple);
					left++;
					right--;
					while (left < right && nums[left] == nums[left - 1]) {
	                    left++;
	                }
					while (left < right && nums[right] == nums[right + 1]) {
	                    right--;
	                }
				}else if (nums[left]+nums[right]<target) {
					left++;
				}else {
					right--;
				}
			}
	}
}
