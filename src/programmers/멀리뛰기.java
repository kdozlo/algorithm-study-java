package programmers;

/**
 * 프로그래머스 - 멀리뛰기
 * Lv 2
 * https://school.programmers.co.kr/learn/courses/30/lessons/12914
 */
public class 멀리뛰기 {

    public static void main(String[] args) {
        int n = 4;
        long answer = 0;

        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        if(n >1)
            dp[2] = 2;

        for(int i = 3; i < n + 1; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 1234567;
        }

        answer = dp[n];

        System.out.println(answer);
    }
}
