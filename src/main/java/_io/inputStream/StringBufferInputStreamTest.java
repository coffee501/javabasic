package _io.inputStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringBufferInputStream;

import org.junit.Test;

/**
 * StringBufferInputStream����������StringBuffer��ȡ����
 * @author Administrator
 *
 */
@SuppressWarnings("deprecation")
public class StringBufferInputStreamTest {

	String str = new String(
			"ͨ�����ԣ�΢����ܹ���һ�ּܹ�ģʽ����˵��һ�ּܹ�������ᳫ����һӦ�ó��򻮷ֳ�һ��С�ķ���ÿ������֮����������������Լ��Ľ����У�����֮���໥Э�����໥��ϣ�Ϊ�û��ṩ���յļ�ֵ������֮�������������ͨ�Ż����໥��ͨ��ͨ������HTTP��RESTFUI API����ÿ������Χ�ƾ���ҵ����й����������ܹ��������������������������������ȡ����⣬Ӧ��������ͳһ�ġ�����ʽ�ķ��������ƣ��Ծ���ķ�����ԣ�����ҵ�������ģ�ѡ����ʵ����ԡ����߶�����й�����������һ���ǳ��������ļ���ʽ�Ĺ�����Э����Щ���񡣿���ʹ�ò�ͬ����������д����Ҳ����ʹ�ò�ͬ�����ݽ��д洢");

	@Test
	public void stringBufferInputStreamRead() {
		InputStream input = new StringBufferInputStream(str);
		byte[] b = new byte[str.length()];
		try {
			input.read(b);
			input.close();
			System.out.println(new String(b));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
