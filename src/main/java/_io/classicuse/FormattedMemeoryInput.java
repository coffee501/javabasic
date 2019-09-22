package _io.classicuse;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

public class FormattedMemeoryInput {
	@Test
	public void read() throws FileNotFoundException {
		DataInputStream input = new DataInputStream(
				new BufferedInputStream(new FileInputStream("C:\\Users\\Administrator\\Desktop\\Î¢·þÎñ¸ÅÊö.txt")));
		try {
			byte[] b = new byte[1024];
			input.read(b);
			System.out.println(new String(b));
		} catch (IOException e) {
			System.err.println("end of stream");
		}

	}
}
