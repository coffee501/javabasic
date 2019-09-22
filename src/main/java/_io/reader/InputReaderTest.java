package _io.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.junit.Test;

public class InputReaderTest {
	private File file = new File("C:\\Users\\Administrator\\Desktop\\Î¢·þÎñ¸ÅÊö.txt");

	@Test
	public void testReader() {
		Reader input = null;
		try {
			input = new FileReader(file);
			char[] c = new char[1024];
			input.read(c);

			System.out.println(new String(c));
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
