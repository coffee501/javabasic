package _io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.junit.Test;

/**
 * ��ȡ��·���µ��ļ�
 * @author Administrator
 *
 */
public class ReadClassPathFile {
	@Test
	public void ByClassLoad() {
		InputStream input = ReadClassPathFile.class.getClassLoader().getResourceAsStream("outputStream.txt");
		try {
			byte[] b = new byte[input.available()];
			input.read(b);
			System.out.println(new String(b));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * ��ȡ��Ŀ��·������ȡ�ļ�
	 */
	@Test
	public void ByPath() {
		URL projectPath = ReadClassPathFile.class.getProtectionDomain().getCodeSource().getLocation();
		String pathFile = projectPath.getPath() + "outputStream.txt";
		pathFile.substring(1, pathFile.length());

		InputStream input = null;
		try {
			input = new FileInputStream(pathFile);
			byte[] b = new byte[input.available()];
			input.read(b);
			System.out.println(new String(b));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
