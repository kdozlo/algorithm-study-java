package programmers;

/**
 * 프로그래머스 - 피보나치 수
 * Lv 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/12945
 */
public class 피보나치수 {
    public static void main(String[] args) {
        int n = 3;
        int[] answer = new int[n + 1];

        answer[0] = 0;
        answer[1] = 1;
        for(int i = 2; i < n + 1; i++) {
            answer[i] = (answer[i -1] + answer[i - 2]) % 1234567;
        }

        //result : 2
        System.out.println(answer[n]);

    }
}
