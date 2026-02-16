package boj.legacy;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 2293
 * 동전1
 * 골드5
 * https://www.acmicpc.net/problem/2293
 */
public class Boj2293 {

    public static void main(String[] argc) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] ary = new int[n + 1];
        int[] dp = new int[k + 1];

        dp[0] = 1;
        for(int i = 1; i < n + 1; i++) {
            ary[i] = Integer.parseInt(br.readLine());
            for(int j = 1; j < k + 1; j++) {
                if (ary[i] <= j) {
                    dp[j] = dp[j] + dp[j - ary[i]];
                }
            }
        }

        System.out.println(dp[k]);
    }
}
