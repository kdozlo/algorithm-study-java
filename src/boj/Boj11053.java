package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 11053
 * 가장 긴 증가하는 부분 수열
 * 실버2
 * https://www.acmicpc.net/problem/11053
 */
public class Boj11053 {

    public static void main(String[] argc) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int ary[] = new int[n];
        int dp[] = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(ary[j] < ary[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }

        int max = 0;
        for (int i : dp) {
            max = Math.max(max, i);
        }

        System.out.println(max);
    }

}
