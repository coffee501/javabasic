package _nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.junit.Test;

public class GetChannel {
	@SuppressWarnings("resource")
	@Test
	public void GetChannels() throws IOException {

		FileChannel fc = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\微服务概述.txt", true).getChannel();
		fc.write(ByteBuffer.wrap("test".getBytes()));
		fc.close();

		fc = new RandomAccessFile("C:\\Users\\Administrator\\Desktop\\微服务概述.txt", "rw").getChannel();
		fc.position(fc.size());
		fc.write(ByteBuffer.wrap("textChannel".getBytes()));
		fc.close();

		fc = new FileInputStream("C:\\Users\\Administrator\\Desktop\\微服务概述.txt").getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		fc.read(buffer);
		buffer.flip();
		while (buffer.hasRemaining()) {
			System.out.print((char) buffer.get());

		}
		fc.close();
	}
}
