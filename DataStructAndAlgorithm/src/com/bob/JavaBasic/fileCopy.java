package com.bob.JavaBasic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class fileCopy {
	 // 工具类中的方法都是静态方式访问的因此将构造器私有不允许创建对象(绝对好习惯)
	public fileCopy() {
		throw new AssertionError();
	}
	public static void FileCopy(String source,String target) throws IOException{
		InputStream inputStream=new FileInputStream(source);
		OutputStream outputStream=new FileOutputStream(target);
		byte[] buffer=new byte[4096];
		int bytesToRead;
		while((bytesToRead=inputStream.read(buffer))!=-1)outputStream.write(buffer, 0, bytesToRead);
	}
	public static void fileCopyNIO(String source, String target) throws IOException {
        try (FileInputStream in = new FileInputStream(source)) {
            try (FileOutputStream out = new FileOutputStream(target)) {
                FileChannel inChannel = in.getChannel();
                FileChannel outChannel = out.getChannel();
                ByteBuffer buffer = ByteBuffer.allocate(4096);
                while(inChannel.read(buffer) != -1) {
                    buffer.flip();
                    outChannel.write(buffer);
                    buffer.clear();
                }
            }
        }
    }
}
