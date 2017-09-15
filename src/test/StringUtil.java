package test;

import java.util.Random;

public class StringUtil {
	public static boolean isEmpty(String string) {
		if((string == null) || ("".equals(string.trim()))) {
			return true;
		}
		return false;
	}
	
	public static boolean checkLength(String string, int min, int max) {
		if((string.length() < min) || (string.length() > max)) {
			return false;
		}
		return true;
	}
	
	public static String getRandomString(int length) {
		String base = "abcdefghijklmnopqrstuvwxyz"
				+ "ABCDEFGHIGKLMNOPQRSTUVWXYZ"
				+ "1234567890";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}
	
	public static String omitString(int length, String str) {
		String omitStr = str.substring(0, length) + "...";
		return omitStr;
	}
	
	public static boolean isInteger(String str) {
		try {
			Integer.parseInt(str);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	/*获取两字符串间的莱文斯坦距离*/
	public static int getLevenshteinDistance(String str, String target) {
		int strLen = str.length();
		int targetLen = target.length();
		char s[] = str.toCharArray();
		char t[] = target.toCharArray();
		int matrix[][] = new int[strLen + 1][targetLen + 1];
		//初始化矩阵
		for(int i = 0; i < strLen + 1; i++) {
			matrix[i][0] = i;
		}
		for(int j = 1; j < targetLen + 1; j++) {
			matrix[0][j] = j;
		}
		/*核心部分*/
		for(int j = 0; j < targetLen; j++) {
			for(int i = 0; i <strLen; i++) {
				if(s[i] == t[j]) {
					matrix[i + 1][j + 1] = matrix[i][j];
				} else {
					matrix[i + 1][j + 1] = min(matrix[i][j + 1], matrix[i + 1][j], matrix[i][j]) + 1;
				}
			}
		}
		for(int i[] : matrix) {
			for(int j : i) {
				System.out.print(j + ",");
			}
			System.out.println();
		}
		return matrix[strLen][targetLen];
	}
	private static int min(int x, int y, int z) {
		return (x = x <= y ? x : y) <= z ? x : z;
	}
	
	public static int getStringChangeValue(String original, String now) {
		int levenshtein = getLevenshteinDistance(original, now);
		int lengthChange = now.length() - original.length();
		return lengthChange < 0 ? levenshtein : levenshtein - lengthChange;
	}
}
