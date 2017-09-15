package test;

import java.security.MessageDigest;

/**
 * 功能描述:MD5加密工具类
 */
public class Md5EncryptUtil {

	/*
	 * ===================================================================
	 * 使用范围:密码加密盐值 原内容： ZTEICT全域旅游网SALT 经过Base64编码为
	 * WlRFSUNU5YWo5Z+f5peF5ri4572RU0FMVA==
	 * ===================================================================
	 */
	/** MD5 ZTEICT全域旅游网SALT : MD5_SALT_VALUE **/
	private static final String MD5_SALT_VALUE = "WlRFSUNU5YWo5Z+f5peF5ri4572RU0FMVA==";
	private static final ThreadLocal<Md5EncryptUtil> local = new ThreadLocal<Md5EncryptUtil>();
	private static final String hexDigits[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
			"e", "f" };

	private Md5EncryptUtil() {
		super();
	}

	public static Md5EncryptUtil getEncrypt() {
		Md5EncryptUtil encrypt = local.get();
		if (encrypt == null) {
			encrypt = new Md5EncryptUtil();
			local.set(encrypt);
		}
		return encrypt;
	}

	private static String byteArrayToHexString(byte b[]) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++)
			resultSb.append(byteToHexString(b[i]));

		return resultSb.toString();
	}

	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n += 256;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	/**
	 * MD5Encode md5加密常用方法 Md5Encrypt.MD5Encode("明文", "utf-8");
	 * 
	 * @param origin
	 * @param charsetname
	 * @return
	 */
	public static String MD5Encode(String origin, String charsetname) {
		String resultString = null;
		try {
			resultString = new String(origin);
			MessageDigest md = MessageDigest.getInstance("MD5");
			if (charsetname == null || "".equals(charsetname))
				resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
			else
				resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetname)));
		} catch (Exception exception) {
		}
		return resultString;
	}

	/**
	 * md5加密 无盐值 简单密码可破解，不建议使用
	 *
	 * @param key
	 * @return
	 */
//	public static String encode(String key) {
//		return encode(key, false);
//	}

	/**
	 * md5加密 旅游项目使用此方法
	 *
	 * @param key
	 *            需要加密的字符串
	 * @param saltValueFlag
	 *            加密的盐值标识位 true 加盐值 |false 不加盐值
	 * @return
	 */
//	public static String encode(String key, boolean saltValueFlag) {
//		if (key == null) {
//			return null;
//		}
//		// true 加盐值
//		if (saltValueFlag) {
//			key = MD5_SALT_VALUE + key;
//		}
//		return DigestUtils.md5Hex(key);
//	}

	// public static void main(String[] args) {
	// // 加盐值 正确的调用方式
	// System.out.println(Md5EncryptUtil.encode("123456", true));
	// }
}
