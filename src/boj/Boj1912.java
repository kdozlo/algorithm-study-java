package boj;


import java.util.Arrays;
import java.util.Scanner;

/**
 * 백준 1912
 * 연속합
 * 실버2
 * https://www.acmicpc.net/problem/1912
 */
public class Boj1912 {

    public static void main(String[] argc) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] ary = new int[n];

        for (int i = 0; i < n; i++) {
            ary[i] = sc.nextInt();
        }

        int[] dp = new int[n];

        dp[0] = ary[0];

        for(int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + ary[i], ary[i]);
        }

        Arrays.sort(dp);
        System.out.println(dp[n-1]);
    }
}
