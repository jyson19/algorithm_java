package basic;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class JadenCase {
	public String solution(String s) {
        String answer = "";
        // step
        // lowercase
        s = s.toLowerCase();

        // step 
        // split " "
        // List에 담음
        List<String> list = new ArrayList<>();
        for(String str : s.split(" ")) {
            list.add(str);
        }

        // step
        // if 첫문자열 = [a-z]
        // ^[a-zA-Z]*$
        // then 대문자로 변경

        String pattern = "^[a-zA-Z]*$"; 

        for(int i = 0; i < list.size(); i++) {
            String tmp = list.get(i).substring(0, 1);
            boolean regex = Pattern.matches(pattern, tmp);
            if(regex == true) {
                String tmp2 = tmp.toUpperCase() + list.get(i).substring(1, list.get(i).length());
                list.set(i, tmp2);
            }
        }
        for(int i = 0; i < list.size(); i++) {
            answer += list.get(i) + " ";
        }




        // step
        // list객체를 string에 담음

        return answer.trim();
    }
}
