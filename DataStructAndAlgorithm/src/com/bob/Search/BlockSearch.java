package com.bob.Search;

public class BlockSearch {
	/**
	 * ���裺
	1.��ȡ�����е����ؼ��ֹ���һ��������
	2.���ҷ�Ϊ�����֣��ȶ���������ж��ֲ��һ���˳����ң���ȷ�������¼����һ���С�
	3.Ȼ�����Ѿ�ȷ���Ŀ�����˳�򷨽��в��ҡ� 
	 */
	public static int blocksearch(int[] index,int[] data,int key,int m){
		int i=partSearch(index,key);
		if(i >= 0){ 
            int j = i > 0 ? i * m : i; 
            int len = (i + 1) * m; 
            // ��ȷ���Ŀ�����˳����ҷ�������key 
            for(int k = j; k < len; k++){ 
                if(key == data[k]){ 
                    System.out.println("��ѯ�ɹ�"); 
                    return k; 
                } 
            } 
         } 
        System.out.println("����ʧ��"); 
        return -1; 
	}

	private static int partSearch(int[] index, int key) {
		int mid; 
        int low = 0; 
        int high = index.length - 1; 
        while(low <= high) 
        { 
            mid = (low + high) / 2;     // �м�λ�� 
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
        return -1;                // û�в��ҵ� 

	}
	

}
