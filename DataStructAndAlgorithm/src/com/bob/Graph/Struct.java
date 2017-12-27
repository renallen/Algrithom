package com.bob.Graph;

import java.util.ArrayList;

public class Struct {
	/**
	 * 
	 * 邻接矩阵
	 */
	public class AMWGraph{
		private ArrayList vertexList;//点集
		private int[][] edges;//边集矩阵
		private int numOfEdges;//边数
		
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
		 //返回v1,v2的权值
	    public int getWeight(int v1,int v2) {
	        return edges[v1][v2];
	    }

	    //插入结点
	    public void insertVertex(Object vertex) {
	        vertexList.add(vertexList.size(),vertex);
	    }

	    //插入结点
	    public void insertEdge(int v1,int v2,int weight) {
	        edges[v1][v2]=weight;
	        numOfEdges++;
	    }

	    //删除结点
	    public void deleteEdge(int v1,int v2) {
	        edges[v1][v2]=0;
	        numOfEdges--;
	    }

	    //得到第一个邻接结点的下标
	    public int getFirstNeighbor(int index) {
	        for(int j=0;j<vertexList.size();j++) {
	            if (edges[index][j]>0) {
	                return j;
	            }
	        }
	        return -1;
	    }

	    //根据前一个邻接结点的下标来取得下一个邻接结点
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
	 * 邻接表
	 */
	public class Graph_List{
		
	}
	
}
