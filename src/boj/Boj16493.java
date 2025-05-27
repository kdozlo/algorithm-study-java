package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
* 백준 16493
* 최대 페이지 수
* 실버2
* https://www.acmicpc.net/problem/16493
*/
public class Boj16493 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] books = new int[M][2];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            books[i][0] = Integer.parseInt(st.nextToken());
            books[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1];

        for(int i = 0; i < M; i++) {
            for(int j = N; j >= books[i][0]; j--) {
                dp[j] = Math.max(dp[j - books[i][0]] + books[i][1], dp[j]);
            }
        }

        System.out.println(dp[N]);
    }
}
