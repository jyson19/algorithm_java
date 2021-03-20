// https://programmers.co.kr/learn/courses/30/lessons/12947
package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Test {

	public static String Solution(List<String> list) throws Exception {
		String minTime = "00:00";
		String maxTime = "23:59";
		String[] time = new String[2];
		String fail = "-1";

		for (int i = 0; i < list.size(); i++) {
			time = list.get(i).split(" ~ ");
			if (Integer.parseInt(time[0].substring(0, 2)) > Integer.parseInt(minTime.substring(0, 2))) {
				minTime = time[0];
			} else if (Integer.parseInt(time[0].substring(0, 2)) == Integer.parseInt(minTime.substring(0, 2))) {
				if (Integer.parseInt(time[0].substring(3)) > Integer.parseInt(minTime.substring(3)))
					minTime = time[0];
			}

			if (Integer.parseInt(time[1].substring(0, 2)) < Integer.parseInt(maxTime.substring(0, 2))) {
				maxTime = time[1];
			} else if (Integer.parseInt(time[1].substring(0, 2)) == Integer.parseInt(maxTime.substring(0, 2))) {
				if (Integer.parseInt(time[1].substring(3)) < Integer.parseInt(maxTime.substring(3)))
					maxTime = time[1];
			}

		}
		if (Integer.parseInt(minTime.substring(0, 2)) > Integer.parseInt(maxTime.substring(0, 2))) {
			return fail;
		} else if (Integer.parseInt(minTime.substring(0, 2)) == Integer.parseInt(maxTime.substring(0, 2))) {
			if (Integer.parseInt(minTime.substring(3)) > Integer.parseInt(maxTime.substring(3))) {
				return fail;

			}
		}
		return (minTime + " ~ " + maxTime);
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
			System.out.println(Solution(list));
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
