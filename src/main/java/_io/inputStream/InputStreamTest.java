package _io.inputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

/**
 * FileInputStream�ǽ��������ӱ����ļ��ж�ȡ���ݡ�
 * 	���������ǵ����̳г���������
 * @author Administrator
 *
 */
public class InputStreamTest {
	private File file = new File("C:\\Users\\Administrator\\Desktop\\΢�������.txt");

	/*
	 * ��֪�ĵ���С
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
	 * 	δ֪��С���ļ���ȡ
	 */
	@Test
	public void TestInputStreamReadByNo() {
		try {
			InputStream input = new FileInputStream(file);

			byte[] b = new byte[1024];

			int len = 0;
			int temp = 0;
			// ���ж�ȡ�����ݶ�ʹ��temp����
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
