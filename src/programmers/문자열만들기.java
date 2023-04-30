package programmers;

/**
 * 프로그래머스 - 문자열 만들기
 * Lv 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/12951
 */
public class 문자열만들기 {

    public static void main(String[] args) {
        String s = "3people unFollowed me";

        StringBuilder answer = new StringBuilder();

        answer.append(Character.toUpperCase(s.charAt(0)));
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i - 1) == ' ') {
                answer.append(Character.toUpperCase(s.charAt(i)));
            } else {
                answer.append(Character.toLowerCase(s.charAt(i)));
            }
        }

        System.out.println(answer);
    }
}
