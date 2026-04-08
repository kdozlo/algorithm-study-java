package boj.y2026;

import java.util.*;
import java.io.*;

/*
 * 백준 5557
 * 1학년
 * 골드5
 * https://www.acmicpc.net/problem/5557
 */
public class Boj5557 {

    private static int N;
    private static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        numbers = new int[N + 1];
        for(int i = 1; i < N + 1; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        long[][] dp = new long[N + 1][21];
        dp[1][numbers[1]] = 1;
        for(int i = 2; i < N + 1; i++) {
            int num = numbers[i];

            for(int j = 0; j < 21; j++) {
                if (checkingNumber(j + num)) {
                    dp[i][j + num] += dp[i - 1][j];
                }

                if (checkingNumber(j - num)) {
                    dp[i][j - num] += dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[N - 1][numbers[N]]);
    }

    private static boolean checkingNumber(int num) {
        if(num < 0 || num > 20)
            return false;

        return true;
    }
}
