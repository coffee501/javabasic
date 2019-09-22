package _io.outputStream;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.junit.Test;

public class OutputStreamTest {
	private String str = "微服务架构是一种架构模式或者说是一种架构风格";

	@Test
	public void testOutputStream() {
		OutputStream output = null;
		try {
			output = new BufferedOutputStream(new FileOutputStream("C:\\Users\\Administrator\\Desktop\\微服务概述.txt",true));
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
