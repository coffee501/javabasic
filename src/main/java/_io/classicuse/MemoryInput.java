package _io.classicuse;

import java.io.IOException;
import java.io.StringReader;

import org.junit.Test;

/**
 * ��ȡ�����е�����
 * @author Administrator
 *
 */
public class MemoryInput {

	@Test
	public void read() {
		StringReader input = new StringReader(BufferedInputFile.readStream());
		int c = 0;
		try {
			while ((c = input.read()) != -1) {
				System.out.print((char) c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
