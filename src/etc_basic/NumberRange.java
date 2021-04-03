package etc_basic;

public class NumberRange {
//	static int cnt = 0;
	public static int solution(int mod1, int mod2, int max_range) {
		int cnt = 0;
//		IntStream.range(1, max_range + 1).forEach(i -> {
		for(int i = 1; i <= max_range; i++) {
			// mod1로 나눈 나머지가 0이고,
			// mod2로 나눈 나머지가 있을때
			if(i % mod1 == 0 && i % mod2 != 0) cnt++;
		};
		return cnt;
		
//		return (int) IntStream.range(1, max_range + 1).filter(i -> i % mod1 == 0 && i % mod2 != 0).count();
	}
	public static void main(String[] args) {
		int mod1 = 4;
		int mod2 = 3;
		int max_range = 20;
//		int mod1 = 3;
//		int mod2 = 4;
//		int max_range = 20;
		System.out.println(solution(mod1, mod2, max_range));
	}
}
