package com.bob.sort;

public class RadixSort {
	public static void main(String[] args) {
		int[] a = { 49, 38, 65, 197, 76, 213, 27, 50 };
        radixsort(a, getMaxWeishu(a));
        for (int i : a)System.out.print(i + " ");
	}
	public static int getMaxWeishu(int[] a){
		int max=a[0];
		for(int i=0;i<a.length;i++){
			if(a[i]>max)max=a[i];
		}
		int tmp=1,d=1;
		while(true){
			tmp*=10;
			if(max/tmp != 0){
				d++;
			}else break;
		}
		return d;
	}
	//d��ʾ���λ��,���ΰ��յ�λ����λ���з�������
	public static void radixsort(int[] arr,int d){
		int[][]array=new int[10][arr.length+1];
		for(int i=0;i<10;i++){
			array[i][0]=0;//��¼ÿһ�е����ݸ���
		}
		for(int pos=1;pos<=d;pos++){
			for(int i=0;i<arr.length;i++){//�������
				int row=getnumInPos(arr[i],pos);
				int col=++array[row][0];
				array[row][col]=arr[i];
			}
			for(int row=0,i=0;row<10;row++){//�ռ�����Ͱ�������
				for(int col=1;col<=array[row][0];col++){
					arr[i++]=array[row][col];
				}
				array[row][0]=0;
			}
		}
	}

	private static int getnumInPos(int num, int pos) {
		int temp=1;
		for(int i=0;i<pos-1;i++){
			temp*=10;
		}
		return (num*temp)%10;
	}
}
