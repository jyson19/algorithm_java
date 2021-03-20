// https://programmers.co.kr/learn/courses/30/lessons/12947
package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Test3 {

	public static int Solution(int N, List<String> list) throws Exception {
		int count = 0;
		return count;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int N = Integer.parseInt(br.readLine());
			String str;
			List<String> list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				str = br.readLine();
				list.add(str);
			}
			System.out.println(Solution(N, list));
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
