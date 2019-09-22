package _io.inputStream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

/**
 * 	��������ByteArrayInputStream����
 * @author Administrator
 *
 */
public class ByteArrayInputStreamTest {
	private String str = "΢����ܹ���һ�ּܹ�ģʽ����˵��һ�ּܹ����";

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
