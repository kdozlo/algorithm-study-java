package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * 백준 15989
 * 1, 2, 3 더하기 4
 * 실버1
 * https://www.acmicpc.net/problem/15989
 */
public class Boj15989 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        int[][] dp = new int[10001][4];

        dp[1][1] = 1; //1
        dp[2][1] = 1; //1+1
        dp[2][2] = 1; //2
        dp[3][1] = 1; //1+1+1
        dp[3][2] = 1; //1+2
        dp[3][3] = 1; //1+3

        for(int i = 4; i <= 10000; i++) {
            dp[i][1] = dp[i-1][1];
            dp[i][2] = dp[i-2][1] + dp[i-2][2];
            dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
        }

        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            sb.append(dp[n][1] + dp[n][2] + dp[n][3]);
            sb.append("\n");
        }

        System.out.println(sb);


    }
}
