package boj.legacy;

import java.io.*;
import java.util.*;

/**
* 백준 10844
* 쉬운 계단 수
* 실버1
* https://www.acmicpc.net/problem/10844
*/
public class Boj10844 {

    private static int D = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][10];

        Arrays.fill(dp[1], 1);
        dp[1][0] = 0;

        for(int i = 2; i <= N; i++) {
           for(int j = 0; j < 10; j++) {
               if(j == 0)
                   dp[i][j] = dp[i - 1][j + 1] % D;
               else if(j == 9)
                   dp[i][j] = dp[i - 1][j - 1] % D;
               else
                   dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % D;
           }
        }

        int sum = 0;
        for(int i = 0; i < 10; i++)
            sum = (sum + dp[N][i]) % D;

        System.out.println(sum);
    }
}
