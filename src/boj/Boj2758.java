package boj;

import java.io.*;
import java.util.*;

/**
 * 백준 2758
 * 로또
 * 골드4
 * https://www.acmicpc.net/problem/2758
 */
public class Boj2758 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        long[][] dp = new long[11][2001];

        for(int i = 1; i < 2001; i++)
            dp[1][i] = i;

        for(int i = 2; i < 11; i++) {
            for(int j = 1; j < 2001; j++) {
                dp[i][j] += dp[i][j - 1] + dp[i - 1][j / 2];
            }
        }

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken()); // 뽑아야 하는 개수
            int m = Integer.parseInt(st.nextToken()); // 최대 수

            sb.append(dp[n][m]).append("\n");
        }

        System.out.print(sb);
    }
}
