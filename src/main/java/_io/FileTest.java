package _io;

import java.io.File;
import java.io.IOException;
import java.net.URI;

import org.junit.Test;

public class FileTest {
	private File file = new File("C:\\Users\\Administrator\\Desktop\\΢�������.txt");

	@Test
	public void testFile() {
		// ��ȡ�ļ���
		String fileName = file.getName();
		System.out.println(fileName);

		// ���ش˳���·����ָ���ķ�����С
		long totalSpace = file.getTotalSpace();
		System.out.println(totalSpace);

		// ��ȡ�ļ���·��
		String path = file.getPath();
		System.out.println(path);

		// ��ȡ�ļ���·��
		String parentName = file.getParent();
		System.out.println(parentName);

		// file��toString��ӡ�����ļ���·��
		File parentFile = file.getParentFile();
		System.out.println(parentFile);

		// ��ȡ�ļ��ľ���·��
		String absolutePath = file.getAbsolutePath();
		System.out.println(absolutePath);

		try {
			// ���ش˳���·�����Ĺ淶·�����ַ���,��Ψһ��
			File canonicalFile = file.getCanonicalFile();
			System.out.println(canonicalFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// ��ȡ�ļ����ڷ�����ʣ���С
		long freeSpace = file.getFreeSpace();
		System.out.println(freeSpace);

		// �ж��ļ��Ƿ��ִ��
		boolean canExecute = file.canExecute();
		System.out.println(canExecute);

		// �ɶ�
		boolean canRead = file.canRead();
		System.out.println(canRead);

		// ��д
		boolean canWrite = file.canWrite();
		System.out.println(canWrite);

		URI uri = file.toURI();
		System.out.println(uri);
	}

	@Test
	public void testFileStatic() {
		// ��ȡϵͳ·���ָ��
		String pathseparator = File.pathSeparator;
		System.out.println(pathseparator);

		// ��ȡϵͳ·���ָ��
		char pathseparatorchar = File.pathSeparatorChar;
		System.out.println(pathseparatorchar);

		// ��ȡϵͳ�ָ��
		String separator = File.separator;
		System.out.println(separator);

		// ��ȡϵͳ�ָ��
		char separatorchar = File.separatorChar;
		System.out.println(separatorchar);
	}
}
