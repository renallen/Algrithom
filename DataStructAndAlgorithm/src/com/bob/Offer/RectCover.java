package com.bob.Offer;

public class RectCover {
	public int RectCover(int target) {
		while(target>2){
			return RectCover(target-1)+RectCover(target-2);
		}
		return target;
    }
}
