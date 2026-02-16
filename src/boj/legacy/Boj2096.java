package boj.legacy;

import java.util.*;
import java.io.*;

/**
* 백준 2096
* 내려가기
* 골드5
* https://www.acmicpc.net/problem/2096
*/
public class Boj2096 {

    private static final int COL = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] ary = new int[N + 1][COL + 1];
        for(int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 1; j < COL + 1; j++) {
                ary[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp1 = new int[N + 1][COL + 2];
        for(int i = 1; i < N + 1; i++) {
            for(int j = 1; j < COL + 1; j++) {
                dp1[i][j] = ary[i][j] + Math.max(dp1[i - 1][j - 1], Math.max(dp1[i - 1][j], dp1[i - 1][j + 1]));
            }
        }

        int[][] dp2 = new int[N + 1][COL + 2];
        for(int i = 1; i < N + 1; i++) {
            dp2[i][0] = Integer.MAX_VALUE;
            dp2[i][4] = Integer.MAX_VALUE;
        }

        for(int i = 1; i < N + 1; i++) {
            for(int j = 1; j < COL + 1; j++) {
                dp2[i][j] = ary[i][j] + Math.min(dp2[i - 1][j - 1], Math.min(dp2[i - 1][j], dp2[i - 1][j + 1]));
            }
        }

        System.out.println(Math.max(dp1[N][1], Math.max(dp1[N][2], dp1[N][3])) +
                " " + Math.min(dp2[N][1], Math.min(dp2[N][2], dp2[N][3])));
    }
}
