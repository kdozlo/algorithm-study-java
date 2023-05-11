package programmers;

/**
 * 프로그래머스 - 예상 대진표
 * Lv 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/12985
 */
public class 예상대진표 {

    public static void main(String[] args) {
        int N = 8;
        int a = 4;
        int b = 7;

        int answer = 0;

        while (a != b) {
            a = a / 2 + a % 2;
            b = b / 2 + b % 2;
            answer += 1;
        }

        //answer : 3
        System.out.println(answer);
    }
}
