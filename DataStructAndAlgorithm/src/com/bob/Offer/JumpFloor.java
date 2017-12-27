package com.bob.Offer;

public class JumpFloor {
	 public int JumpFloor(int target) {
			while(target>2){
				return JumpFloor(target-1)+JumpFloor(target-2);
			}
			return target;
			
	    }
	 public int JumpFloorII(int target) {
			if(target==0)return 0;
			int [] dp=new int[target+1];
			dp[0]=1;
			dp[1]=1;
			for(int i=2;i<=target;i++){
				dp[i]=0;
				for(int j=0;j<i;j++){
					dp[i]+=dp[j];
				}
			}
			return dp[target];
	    }
}
