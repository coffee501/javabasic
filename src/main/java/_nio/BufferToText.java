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
		FileChannel fc = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\΢�������.txt").getChannel();
		fc.write(ByteBuffer.wrap("some text".getBytes()));
		fc.close();

		fc = new FileInputStream("C:\\Users\\Administrator\\Desktop\\΢�������.txt").getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		fc.read(buffer);
		buffer.flip();
		System.out.println(buffer.asCharBuffer());
		buffer.rewind();
		fc.close();

		// ��ȡϵͳ�ı����ʽ:���ý��뷽ʽ
		String coding = System.getProperty("file.encoding");
		System.out.println(coding);
		CharBuffer decode = Charset.forName(coding).decode(buffer);
		System.out.println(decode);

		//���ñ��뷽ʽ�����ַ�
		fc = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\΢�������.txt").getChannel();
		fc.write(ByteBuffer.wrap("some text".getBytes("UTF-16BE")));
		buffer.clear();
		fc.close();

		fc = new FileInputStream("C:\\Users\\Administrator\\Desktop\\΢�������.txt").getChannel();

		fc.read(buffer);
		buffer.flip();
		System.out.println(buffer.asCharBuffer());
		buffer.rewind();
		fc.close();
	}
}
