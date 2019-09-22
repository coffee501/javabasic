package _nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

import org.junit.Test;

public class BufferToText {
	@Test
	public void changeType() throws IOException {
		FileChannel fc = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\微服务概述.txt").getChannel();
		fc.write(ByteBuffer.wrap("some text".getBytes()));
		fc.close();

		fc = new FileInputStream("C:\\Users\\Administrator\\Desktop\\微服务概述.txt").getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		fc.read(buffer);
		buffer.flip();
		System.out.println(buffer.asCharBuffer());
		buffer.rewind();
		fc.close();

		// 获取系统的编码格式:设置解码方式
		String coding = System.getProperty("file.encoding");
		System.out.println(coding);
		CharBuffer decode = Charset.forName(coding).decode(buffer);
		System.out.println(decode);

		//设置编码方式设置字符
		fc = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\微服务概述.txt").getChannel();
		fc.write(ByteBuffer.wrap("some text".getBytes("UTF-16BE")));
		buffer.clear();
		fc.close();

		fc = new FileInputStream("C:\\Users\\Administrator\\Desktop\\微服务概述.txt").getChannel();

		fc.read(buffer);
		buffer.flip();
		System.out.println(buffer.asCharBuffer());
		buffer.rewind();
		fc.close();
	}
}
