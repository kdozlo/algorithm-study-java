package boj;

import java.io.*;
import java.util.*;

/**
* 백준 17845
* 수강 과목
* 골드5
* https://www.acmicpc.net/problem/17845
*/
public class Boj17845 {

    private static int N;
    private static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] dp = new int[N + 1];

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            for(int j = N; j >= t; j--)
                dp[j] = Math.max(dp[j], dp[j - t] + l);
        }

        System.out.println(dp[N]);

    }
}
