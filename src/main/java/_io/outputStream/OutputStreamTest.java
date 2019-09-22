package _io.outputStream;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.junit.Test;

public class OutputStreamTest {
	private String str = "΢����ܹ���һ�ּܹ�ģʽ����˵��һ�ּܹ����";

	@Test
	public void testOutputStream() {
		OutputStream output = null;
		try {
			output = new BufferedOutputStream(new FileOutputStream("C:\\Users\\Administrator\\Desktop\\΢�������.txt",true));
			output.write(str.getBytes());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
