package boj.legacy;

import java.util.*;
import java.io.*;

/**
* 백준 11052
* 카드 구매하기
* 실버1
* https://www.acmicpc.net/problem/11052
*/
public class Boj11052 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] P = new int[N + 1];
        int[] dp = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
            dp[i] = P[i];
        }

        for(int i = 2; i <= N; i++) {
            for(int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], P[j] + dp[i - j]);
            }
        }

        System.out.println(dp[N]);
    }
}
