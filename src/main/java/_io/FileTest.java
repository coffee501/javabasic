package _io;

import java.io.File;
import java.io.IOException;
import java.net.URI;

import org.junit.Test;

public class FileTest {
	private File file = new File("C:\\Users\\Administrator\\Desktop\\微服务概述.txt");

	@Test
	public void testFile() {
		// 获取文件名
		String fileName = file.getName();
		System.out.println(fileName);

		// 返回此抽象路径名指定的分区大小
		long totalSpace = file.getTotalSpace();
		System.out.println(totalSpace);

		// 获取文件的路径
		String path = file.getPath();
		System.out.println(path);

		// 获取文件父路径
		String parentName = file.getParent();
		System.out.println(parentName);

		// file的toString打印的是文件的路径
		File parentFile = file.getParentFile();
		System.out.println(parentFile);

		// 获取文件的绝对路径
		String absolutePath = file.getAbsolutePath();
		System.out.println(absolutePath);

		try {
			// 返回此抽象路径名的规范路径名字符串,是唯一的
			File canonicalFile = file.getCanonicalFile();
			System.out.println(canonicalFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 获取文件所在分区的剩余大小
		long freeSpace = file.getFreeSpace();
		System.out.println(freeSpace);

		// 判断文件是否可执行
		boolean canExecute = file.canExecute();
		System.out.println(canExecute);

		// 可读
		boolean canRead = file.canRead();
		System.out.println(canRead);

		// 可写
		boolean canWrite = file.canWrite();
		System.out.println(canWrite);

		URI uri = file.toURI();
		System.out.println(uri);
	}

	@Test
	public void testFileStatic() {
		// 获取系统路径分割符
		String pathseparator = File.pathSeparator;
		System.out.println(pathseparator);

		// 获取系统路径分割符
		char pathseparatorchar = File.pathSeparatorChar;
		System.out.println(pathseparatorchar);

		// 获取系统分割符
		String separator = File.separator;
		System.out.println(separator);

		// 获取系统分割符
		char separatorchar = File.separatorChar;
		System.out.println(separatorchar);
	}
}
