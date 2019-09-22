package _io.inputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

/**
 * FileInputStream是介质流，从本地文件中读取数据。
 * 	介质流则是单纯继承抽象基类的流
 * @author Administrator
 *
 */
public class InputStreamTest {
	private File file = new File("C:\\Users\\Administrator\\Desktop\\微服务概述.txt");

	/*
	 * 已知文档大小
	 */
	@Test
	public void TestInputStreamRead() {
		try {
			InputStream input = new FileInputStream(file);
			byte[] b = new byte[(int) file.length()];
			input.read(b);
			input.close();
			System.out.println(new String(b));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 	未知大小的文件读取
	 */
	@Test
	public void TestInputStreamReadByNo() {
		try {
			InputStream input = new FileInputStream(file);

			byte[] b = new byte[1024];

			int len = 0;
			int temp = 0;
			// 所有读取的内容都使用temp接收
			while ((temp = input.read()) != -1) {
				b[len] = (byte) temp;
				len++;
			}
			input.close();
			System.out.println(new String(b));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
