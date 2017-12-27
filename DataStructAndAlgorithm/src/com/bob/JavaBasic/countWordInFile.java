package com.bob.JavaBasic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class countWordInFile {
	public countWordInFile() {
		throw new AssertionError();
	}
	public static int countWord(String filename,String word){
		int count=0;
		try {
			FileReader reader=new FileReader(new File(filename));
			BufferedReader br=new BufferedReader(reader);
			String line=null;
			while((line=br.readLine())!=null){
				int index=-1;
				while(line.length()>=word.length() && (index=line.indexOf(word))>=0){
					count++;
					line=line.substring(index+word.length());
				}
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
}
