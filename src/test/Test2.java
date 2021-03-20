// https://programmers.co.kr/learn/courses/30/lessons/12947
package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test2 {

	public static long Solution(int N, String M) throws Exception {

		String[] arr = M.split("0");

		long count = 1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].length() >= 2) {
				long num1, num2, sum;
				num1 = 0;
				num2 = 1;
				sum = 1;
				for (int j = 0; j < arr[i].length() - 1; j++) {
					sum = num1 + num2;
					num1 = num2;
					num2 = sum;
				}
				count = count * sum;
			}
		}
		return count;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int N = Integer.parseInt(br.readLine());
			String M = br.readLine();

			System.out.println(Solution(N, M));
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
