package boj;

import java.io.*;

/**
 * 백준 1562
 * 계단 수
 * 골드 1
 * https://www.acmicpc.net/problem/1562
 */
public class Boj1562 {

    static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[][][] dp = new long[N + 1][10][1 << 10];

        for(int i = 1; i < 10; i++) {
            dp[1][i][1 << i] = 1;
        }

        for(int i = 2; i <= N; i++) {
            for(int j = 0; j < 10; j++) {
                for(int k = 0; k < (1 << 10); k++) {
                    if(j > 0) {
                        dp[i][j][k | (1 << j)] =
                                (dp[i][j][k | (1 << j)] +
                                        dp[i - 1][j - 1][k]) % MOD;
                    }

                    if(j < 9) {
                        dp[i][j][k | (1 << j)] =
                                (dp[i][j][k | (1 << j)] +
                                        dp[i - 1][j + 1][k]) % MOD;
                    }
                }
            }
        }

        long answer = 0;
        int full = (1 << 10) - 1;
        for(int i = 0; i < 10; i++) {
            answer = (answer + dp[N][i][full]) % MOD;
        }

        System.out.println(answer);
        
    }
}
