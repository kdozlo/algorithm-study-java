package boj;

import java.util.*;
import java.io.*;

/**
* 백준 14728
* 벼락치기
* 골드5
* https://www.acmicpc.net/problem/14728
*/
public class Boj14728 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[] dp = new int[T + 1];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int k = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            for(int j = T; j >= k; j--) {
                dp[j] = Math.max(dp[j], dp[j - k] + s);
            }
        }

        System.out.println(dp[T]);
    }
}
