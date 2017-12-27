package com.bob.Recruit2016;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class getSplitNode {
/**
 * ���������������ڵ�����
 * �������ڵ�������ҵ�ͨ�����ڵ��·�ߣ�
 * Ȼ��Եõ����������н��б�������һ����ͬ����һ���ڵ�
 */
public int getSplitNode(String[] matrix, int indexA, int indexB) {
		if(indexA==indexB)return indexA;
		int len=matrix.length;
		int[] father=new int[len];
		int[] flag=new int[len];
		father[0]=-1;
		flag[0]=1;
		Queue<Integer>children=new ArrayDeque<>();
		children.offer(0);
		while(!children.isEmpty()){
			int parent=children.poll();
			char[] chars=matrix[parent].toCharArray();
			for(int i=0;i<chars.length;i++){
				if(flag[i]!=1 && chars[i]=='1'){
				father[i]=parent;
				children.offer(i);
				flag[i]=1;
				}
			}
		}
		int ia=indexA;
		int ib=indexB;
		Deque<Integer>queueA=new ArrayDeque<>();
		Deque<Integer>queueB=new ArrayDeque<>();
		while(ia!=-1){
			queueA.addFirst(ia);
			ia=father[ia];
		}
		while(ib!=-1){
			queueB.addFirst(ib);
			ib=father[ib];
		}
		int commonParent=0;
		while(queueA.peekFirst()==queueB.peekFirst()){
			commonParent=queueA.peekFirst();
			queueA.pollFirst();
			queueB.pollFirst();
		}
		return commonParent;
    }

}
