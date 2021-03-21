package test;

public class intSring {
	public static void main(String[] args) {
		String[] str = new String[50000];
		String str2 = "100000";
		String str3 = "90000";
		String str4 = "95000";
		
		
		
		System.out.println(Integer.parseInt(str2) > Integer.parseInt(str3));
		System.out.println(Integer.parseInt(str2) > Integer.parseInt(str4));
		System.out.println(Integer.parseInt(str3) > Integer.parseInt(str4));
	}
}
