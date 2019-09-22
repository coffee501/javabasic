package _io.classicuse;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import util.IoUtil;

/**
 * 利用缓冲流读取文件
 * @author Administrator
 *
 */
public class BufferedInputFile {
	@Test
	public static String readStream() {
		String result = null;
		String path = IoUtil.getPath("outputStream.txt");
		BufferedInputStream input = null;
		try {
			input = new BufferedInputStream(new FileInputStream(path));
			byte[] b = new byte[input.available()];
			input.read(b);
			result = new String(b);
			System.out.println(result);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {

				input.close();
				return result;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Test
	public void readReader() {
		String path = IoUtil.getPath("outputStream.txt");
		try (BufferedReader input = new BufferedReader(new FileReader(path));) {
			String s = null;
			StringBuffer buffer = new StringBuffer();
			while ((s = input.readLine()) != null) {
				buffer.append(s + "\n");
			}
			System.out.println(buffer);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void readTry() {
		String path = IoUtil.getPath("outputStream.txt");
		try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(path));) {
			byte[] b = new byte[input.available()];
			input.read(b);
			System.out.println(new String(b));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
