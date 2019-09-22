package _io.inputStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringBufferInputStream;

import org.junit.Test;

/**
 * StringBufferInputStream介质流，从StringBuffer读取数据
 * @author Administrator
 *
 */
@SuppressWarnings("deprecation")
public class StringBufferInputStreamTest {

	String str = new String(
			"通常而言，微服务架构是一种架构模式或者说是一种架构风格，它提倡将单一应用程序划分成一组小的服务，每个服务之间运行在其独立的自己的进程中，服务之间相互协调、相互配合，为用户提供最终的价值。服务之间采用轻量级的通信机制相互沟通（通常基于HTTP的RESTFUI API）。每个服务都围绕具体业务进行构建，并且能够被独立部署到生产环境，类生产环境等。另外，应尽量避免统一的、集中式的服务管理机制，对具体的服务而言，根据业务上下文，选择合适的语言、工具对其进行构建。可以有一个非常轻量级的集中式的管理来协调这些服务。可以使用不同存现言来编写服务。也可以使用不同的数据进行存储");

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
