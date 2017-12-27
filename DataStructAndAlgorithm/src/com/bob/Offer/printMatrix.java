package com.bob.Offer;

import java.util.ArrayList;

public class printMatrix {
	public ArrayList<Integer> printMatrix(int [][] matrix) {
	     ArrayList<Integer>result=new ArrayList<>();
	     if(matrix==null || matrix.length==0)return result;
	     printMatrix(matrix,0,0,matrix.length-1,matrix[0].length-1,result);
	     return result;
	       
    }

	private void printMatrix(int[][] matrix, int startRow, int startCol, int endRow, int endCol, ArrayList<Integer> result) {
		if(startRow<endRow && startCol<endCol){
			for(int j=startCol;j<=endCol;j++)result.add(matrix[startRow][j]);
			for(int i=startRow+1;i<=endRow-1;i++)result.add(matrix[i][endCol]);
			for(int i=endCol;i>=startCol;i--)result.add(matrix[endRow][i]);
			for(int i=endRow-1;i>=startRow+1;i--)result.add(matrix[i][startCol]);
			printMatrix(matrix, startRow+1, startCol+1, endRow-1, endCol-1, result);
		}else if (startRow==endRow && startCol<endCol) {
			for(int i=startCol;i<=endCol;i++)result.add(matrix[startRow][i]);
		}else if (startCol==endCol && startRow<endRow) {
			for(int i=startRow;i<=endRow;i++)result.add(matrix[i][endCol]);
		}else if (startCol==endCol && startRow==endRow) {
			result.add(matrix[startRow][startCol]);
		}else {
			return ;
		}
		
	}
}
