package boj.legacy;

import java.util.*;
import java.io.*;

/**
* 백준 2225
* 합분해
* 골드5
* https://www.acmicpc.net/problem/2225
*/
public class Boj2225 {

    private static final int MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[K + 1][N + 1];
        Arrays.fill(dp[1], 1);

        for(int i = 2; i <= K; i++) {
            for(int j = 0; j <= N; j++) {
                if(j == 0)
                    dp[i][j] = 1;
                else
                    dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % MOD;
            }
        }

        System.out.println(dp[K][N]);
    }
}
