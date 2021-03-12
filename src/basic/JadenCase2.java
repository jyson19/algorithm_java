package basic;

public class JadenCase2 {
	public static String solution(String s) {
		String answer ="";
		String[] arr = s.toLowerCase().split(""); 
		
//		for(String str : arr) {
//			System.out.println(str);
//		}
		
		boolean space = true;
		
		for ( String str : arr) {
			if(space == true) {
				answer += str.toUpperCase();
			} else {
				answer += str;
			}
			
			if(str.equals(" ")) {
				space = true;
			} else {
				space = false;
			}
			
		}
		return answer;	
	}
	
	public static void main(String[] args) {
//		String s = "3people       unFollowed me     ";
		String s = "people       unFollowed me     ";
		System.out.println(solution(s));
	}
}
