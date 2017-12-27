package com.bob.leetcode;

public class maxPoints {
	/**
	 * 找出在同一条线上点最多的数目
	 */
	class Point {
		      int x;
		      int y;
		      Point() { x = 0; y = 0; }
		      Point(int a, int b) { x = a; y = b; }
	}
	public int maxPoints(Point[] points) {
        if(points.length<=2)return points.length;
        int ABx;
        int ABy;
        int BCx;
        int BCy;
        int max=2;
        for(int i=0;i<points.length;i++){
        	int num=0;
        	int tmp=1;
        	for(int j=i+1;j<points.length;j++){
        		ABx=points[i].x-points[j].x;
        		ABy=points[i].y-points[j].y;
        		if(ABx==0 && ABy==0)num++;
        		else {
					tmp++;
					for(int k=j+1;k<points.length;k++){
						BCx=points[j].x-points[k].x;
						BCy=points[j].y-points[k].y;
						if(ABx*BCy==BCx*ABy)tmp++;
					}
				}
        		if(max<(num+tmp))max=num+tmp;
        		tmp=1;
        	}
        }
        return max;
    }

}
