package com.bob.Search;

public class BlockSearch {
	/**
	 * 步骤：
	1.先取各块中的最大关键字构成一个索引表。
	2.查找分为两部分，先对索引表进行二分查找或是顺序查找，以确定待查记录在哪一块中。
	3.然后，在已经确定的块中用顺序法进行查找。 
	 */
	public static int blocksearch(int[] index,int[] data,int key,int m){
		int i=partSearch(index,key);
		if(i >= 0){ 
            int j = i > 0 ? i * m : i; 
            int len = (i + 1) * m; 
            // 在确定的块中用顺序查找方法查找key 
            for(int k = j; k < len; k++){ 
                if(key == data[k]){ 
                    System.out.println("查询成功"); 
                    return k; 
                } 
            } 
         } 
        System.out.println("查找失败"); 
        return -1; 
	}

	private static int partSearch(int[] index, int key) {
		int mid; 
        int low = 0; 
        int high = index.length - 1; 
        while(low <= high) 
        { 
            mid = (low + high) / 2;     // 中间位置 
            if(key == index[mid]) 
            { 
                return mid;             
            } 
            else if(key < index[mid])     
                high = mid - 1; 
            else {
                low = mid + 1; 
                return low; 
                }
        } 
        return -1;                // 没有查找到 

	}
	

}
