package boj;

import java.io.*;

/**
* 백준 1947
* 선물 전달
* 골드 3
* https://www.acmicpc.net/problem/1947
*/
public class Boj1947 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] dp = new long[N + 1];

        if(N > 1)
            dp[2] = 1;
        for(int i = 3; i <= N; i++) {
            dp[i] = (i - 1) * (dp[i - 1] + dp[i - 2]) % 1_000_000_000;
        }

        System.out.println(dp[N]);
    }
}
