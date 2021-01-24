package practice.st;

public class randomChoice {

	static String[] str = { //
			"진영", //
			"강민", //
//			"동우", //
//			"보라", //
//			"재완", //
//			"재범", //
			"지섭", //
			"동철", //
			"현웅" //
//			"우근" //
	};
	static int index = 10;
	static String[] arr = new String[2];

	// 중복체크
	public static boolean checkArr() {
		if (arr[0].equals(arr[1])) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		while (true) {
			for (int i = 0; i < 2; i++) {
				double choiceNum = Math.random();
				int selectNum = (int) Math.floor(choiceNum * 5); // 인원수 5
				arr[i] = str[selectNum];
			}
			if (checkArr() == true) {
				System.out.println(arr[0]);
				System.out.println(arr[1]);
				break;
			}
		}
	}
}








