package _nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.junit.Test;

public class ChannelCopy {
	@SuppressWarnings("resource")
	@Test
	public void copy() throws IOException {
		FileChannel input = new FileInputStream("C:\\Users\\Administrator\\Desktop\\微服务概述.txt").getChannel();
		FileChannel output = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\微服务概述 - 副本.txt").getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		input.read(buffer);

		buffer.flip();

		output.write(buffer);
		buffer.clear();
		output.close();
		input.close();
	}

	@SuppressWarnings("resource")
	@Test
	public void copyByTansFrom() throws IOException {
		FileChannel input = new FileInputStream("C:\\Users\\Administrator\\Desktop\\微服务概述.txt").getChannel();
		FileChannel output = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\微服务概述 - 副本.txt").getChannel();
		input.transferTo(0, input.size(), output);
		output.close();
		input.close();
	}
}
