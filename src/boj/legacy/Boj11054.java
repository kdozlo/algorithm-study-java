package boj.legacy;

import java.util.*;
import java.io.*;

/**
* 백준 11054
* 가장 긴 바이토닉 부분 수열
* 골드4
* https://www.acmicpc.net/problem/11054
*/
public class Boj11054 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] ary = new int[N];
        for(int i = 0; i < N; i++)
            ary[i] = Integer.parseInt(st.nextToken());

        int[] dpASC = new int[N];
        int[] dpDESC = new int[N];
        int[] dp = new int[N];

        for(int i = N - 1; i >= 0; i--) {
            dpDESC[i] = 1;

            for(int j = N - 1; j > i; j--) {
                if(ary[i] > ary[j])
                    dpDESC[i] = Math.max(dpDESC[j] + 1, dpDESC[i]);
            }
        }

        for(int i = 0; i < N; i++) {
            dpASC[i] = 1;

            for(int j = 0; j < i; j++) {
                if(ary[i] > ary[j])
                    dpASC[i] = Math.max(dpASC[j] + 1, dpASC[i]);
            }

            dp[i] = dpASC[i] + dpDESC[i] - 1;
        }

        int max = dp[0];
        for(int i = 1; i < N; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
