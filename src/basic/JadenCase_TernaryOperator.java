package basic;

public class JadenCase_TernaryOperator {

	public static String solution(String s) {
		String[] arr = s.toLowerCase().split(""); 
		String answer = "";
		boolean space = true;
		for ( String str : arr) {
			answer += (space==true) ?  str.toUpperCase() : str;
			space = str.equals(" ") ? true : false;
		}
		return answer;	
	}

	public static void main(String[] args) {
//		String s = "3people       unFollowed me     ";
		String s = "people       unFollowed me     ";
		System.out.println(solution(s));
	}
}
