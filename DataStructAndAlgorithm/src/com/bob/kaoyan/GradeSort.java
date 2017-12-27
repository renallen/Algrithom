package com.bob.kaoyan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GradeSort {
	/**
	 * ��Ŀ���������⣨�û����ɼ������У����Ի�óɼ��Ӹߵ��ͻ�ӵ͵��ߵ�����,��ͬ�ɼ�
      ������¼��������ǰ�Ĺ�����
	 * @throws IOException 
	 * @throws  
	 */
	public static void main(String[] args) throws  IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str;
		while((str=reader.readLine())!=null){
			int N=Integer.parseInt(str);
			int flag=Integer.parseInt(reader.readLine());
			String[] users=new String[N];
			int[] scores=new int[N];
			for(int i=0;i<N;i++){
				String[] info=reader.readLine().split(" ");
				String user=info[0];
				int score=Integer.parseInt(info[1]);
				if(flag==1){
					int j=0;
					for( j=i-1;j>=0;j--){
						if(score<scores[j]){
							scores[j+1]=scores[j];
							users[j+1]=users[j];
						}else {
							break;
						}
					}
					scores[j+1]=score;
					users[j+1]=user;
				}else{
					int j=0;
					for(j=i-1;j>=0;j--){
						if(score>scores[j]){
							scores[j+1]=scores[j];
							users[j+1]=users[j];
						}else {
							break;
						}
					}
					scores[j+1]=score;
					users[j+1]=user;
				}
			}
			for(int i=0;i<N;i++){
				System.out.println(users[i]+" "+scores[i]);
			}
		}
		}
	}
		


