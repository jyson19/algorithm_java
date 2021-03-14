package sort;

import java.util.Arrays;

public class StringSort {
	public static String[] solution(String[] strings, int n) {
		Arrays.sort(strings, (str1, str2) -> {
			char c1 = str1.charAt(n);
			char c2 = str2.charAt(n);
			if (c1 == c2) {
				System.out.println("str1 : " + str1);
				System.out.println("str2 : " + str2);
				return str1.compareTo(str2);
			} else {
				System.out.println("c1 : " + c1);
				System.out.println("c2 : " + c2);
				return c1 - c2;
			}
		});
		return strings;
	}

	public static void main(String[] args) {
		String[] strings = { "sun", "bed", "bee", "car" };
		System.out.println(solution(strings, 1));
	}
}
