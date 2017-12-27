package com.bob.Offer;

public class VerifySquenceOfBST {
	 public boolean VerifySquenceOfBST(int [] sequence) {
	        if(sequence==null || sequence.length==0)return false;
	        return IsTreeBST(sequence,0,sequence.length-1);
	        
	    }

	private boolean IsTreeBST(int[] sequence, int start, int end) {
			if(end<=start)return true;
			int i=start;
			for(;i<end;i++){
				if(sequence[i]>sequence[end])break;
			}
			for(int j=i;j<end;j++){
				if(sequence[j]<sequence[end])return false;
			}
			return IsTreeBST(sequence, start, i-1)&&IsTreeBST(sequence, i, end-1);
			
	}
}
