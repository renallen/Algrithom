package com.bob.Graph;

import java.util.ArrayList;

public class Struct {
	/**
	 * 
	 * �ڽӾ���
	 */
	public class AMWGraph{
		private ArrayList vertexList;//�㼯
		private int[][] edges;//�߼�����
		private int numOfEdges;//����
		
		public AMWGraph(int n) {
			edges=new int[n][n];
			vertexList=new ArrayList(n);
			numOfEdges=0;
		}
		public int getNumOfEdges() {
			return numOfEdges;
		}
		public int getNumVertex() {
			return vertexList.size();
		}
		public Object getValueByIndex(int i){
			return vertexList.get(i);
		}
		 //����v1,v2��Ȩֵ
	    public int getWeight(int v1,int v2) {
	        return edges[v1][v2];
	    }

	    //������
	    public void insertVertex(Object vertex) {
	        vertexList.add(vertexList.size(),vertex);
	    }

	    //������
	    public void insertEdge(int v1,int v2,int weight) {
	        edges[v1][v2]=weight;
	        numOfEdges++;
	    }

	    //ɾ�����
	    public void deleteEdge(int v1,int v2) {
	        edges[v1][v2]=0;
	        numOfEdges--;
	    }

	    //�õ���һ���ڽӽ����±�
	    public int getFirstNeighbor(int index) {
	        for(int j=0;j<vertexList.size();j++) {
	            if (edges[index][j]>0) {
	                return j;
	            }
	        }
	        return -1;
	    }

	    //����ǰһ���ڽӽ����±���ȡ����һ���ڽӽ��
	    public int getNextNeighbor(int v1,int v2) {
	        for (int j=v2+1;j<vertexList.size();j++) {
	            if (edges[v1][j]>0) {
	                return j;
	            }
	        }
	        return -1;
	    }
	}
	
	/**
	 * �ڽӱ�
	 */
	public class Graph_List{
		
	}
	
}
