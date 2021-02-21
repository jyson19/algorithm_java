//  문제 설명
//  Leo는 카펫을 사러 갔다가 아래 그림과 같이 중앙에는 노란색으로 칠해져 있고 
//  테두리 1줄은 갈색으로 칠해져 있는 격자 모양 카펫을 봤습니다.
//
//
//
//  Leo는 집으로 돌아와서 아까 본 카펫의 노란색과 갈색으로 색칠된 격자의 개수는 기억했지만, 전체 카펫의 크기는 기억하지 못했습니다.
//
//  Leo가 본 카펫에서 갈색 격자의 수 brown, 노란색 격자의 수 yellow가 매개변수로 주어질 때 카펫의 가로, 세로 크기를 순서대로 배열에 담아 return 하도록 solution 함수를 작성해주세요.
//
//  제한사항
//  갈색 격자의 수 brown은 8 이상 5,000 이하인 자연수입니다.
//  노란색 격자의 수 yellow는 1 이상 2,000,000 이하인 자연수입니다.
//  카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.
//  입출력 예
//  brown	yellow	return
//    10	  2  	[4, 3]
//    8	      1  	[3, 3]
//    24	  24	[8, 6]

package programmers.level2;

public class Carpet {

	// check point 1. answer[0] * answer[1] = brown + yellow
	
	// check point 2. answer[0] >= answer[1] ( 가로 >= 세로)
	
	// check point 3.
	// brown은 항상 모서리를 차지하고 있어(4개)
	// yellow의 가로(세로)축 개수 + 2 = brown의 가로(세로)축 개수
	// => brown = yellow.width*2 + yellow.height*2 + 4(모서리)

	public static int[] solution(int brown, int yellow) {

		// 가로 세로
		int width = 0, height = 0;

		// 카펫 전체 칸 수
		int carpetCnt = brown + yellow;

		for (int i = 1; i <= yellow; i++) {

			if (yellow % i == 0 && yellow != 1) {
				if (yellow / i >= i && (yellow / i + 2) * (i + 2) == carpetCnt) { // checkpoint 2
					if ((i * 2) + ((yellow / i) * 2) + 4 == brown) { // check point 3
						width = yellow / i + 2;
						height = i + 2;
					}
				}
			}
			if (yellow == 1) {
				width = 3;
				height = 3;
			}
		}
		int[] answer = { width, height };
		System.out.println("width : " + width);
		System.out.println("height : " + height);
		return answer;
	}

	public static void main(String[] args) {
		solution(24, 24); // [8, 6] 
//		solution(8, 1); // [3, 3]
	}
}
