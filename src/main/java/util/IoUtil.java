package util;

public class IoUtil {
	public static String getPath(String filePath) {
		String path = IoUtil.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		return path + filePath;
	}
}
