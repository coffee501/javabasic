package _io.inputStream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

/**
 * 	介质流：ByteArrayInputStream测试
 * @author Administrator
 *
 */
public class ByteArrayInputStreamTest {
	private String str = "微服务架构是一种架构模式或者说是一种架构风格";

	@Test
	public void testByteArrayInputStream() {
		InputStream input = new ByteArrayInputStream(str.getBytes());
		byte[] b = new byte[1024];
		int temp = 0;
		int len = 0;
		try {
			while((temp = input.read()) != -1) {
				b[len] = (byte)temp;
				len ++;
			}
			input.close();
			System.out.println(new String(b));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
